package com.report.trade;

import java.util.Arrays;
import java.util.Scanner;

import com.report.trade.exception.DailyTradeReportException;
import com.report.trade.model.Currency;
import com.report.trade.model.FinancialEntity;
import com.report.trade.model.FinancialEntity.BuyOrSell;
/**************************************************************************
 * Filename    : Transaction
 * Created By  : farnaz
 * Date Created: 03 Aug 2018
 ****************************************************************************/
import com.report.trade.util.Utility;

/**
 * *****************************************************************************
 * This class creates a trade record
 * 
 * @author farnaz
 *****************************************************************************
 */
public class Transaction
{

    /**
     * Scanner to read from system.in
     */
    private static java.util.Scanner sc;

    /**
     * ***********************************************************************
     * Read lines from the console, to create trade record and store in cache.
     * 
     * @throws DailyTradeReportException based on invalid input found
     ***********************************************************************
     */
    public static void readTransaction() throws DailyTradeReportException
    {
        System.out.println(
                "Enter incoming/outgoing details seperated each value by a space (for example: foo B SGP 1/01/2016 2/01/2016 200 100.25):");
        sc = new Scanner(System.in);
        while (true)
        {
            System.out.println("Enter entity name: ");
            String entityName = sc.next();
            System.out.println(
                    "Enter single character B:buy or S:Sell, for Buy or Sell option: ");
            String buyOrSell = sc.next();
            System.out.println(
                    "Enter foregin currency from these option {SGP|INR|SAR|GBP|AED}: ");
            String fx = sc.next();
            
            try {
                Arrays.stream(Currency.values()).anyMatch(Currency.valueOf(fx)::equals);
               
            } catch (IllegalArgumentException ex) {  
                throw new DailyTradeReportException("This is invalid currency value");
                
          }
            System.out.println(
                    "Enter instruction date in dd/mm/yyyy format: ");
            String instructionDate = sc.next();
            System.out.println(
                    "Enter settlement date in dd/mm/yyyy format: ");
            String settlementDate = sc.next();
            System.out.println("Enter number of units: ");
            int units = sc.nextInt();
            System.out.println("Enter price per unit:");
            double pricePerUnit = sc.nextDouble();

            System.out.println("Following is the trade information entered: ");

            if (buyOrSell.equalsIgnoreCase("B"))
            {
                FinancialEntity entity = new FinancialEntity(
                        entityName, BuyOrSell.B,
                        Currency.getByName(fx),
                        Utility.getDate(instructionDate),
                        Utility.getDate(settlementDate), units,
                        pricePerUnit);
                System.out.println(entity);
                new DailyTradeDAOBuyImpl()
                        .performTransaction(entity);
                System.out.println("Return to main menu type 0 and then choose option from main action between [1-6]");
            }
            else if (buyOrSell.equalsIgnoreCase("S"))
            {
                FinancialEntity entity = new FinancialEntity(
                        entityName, BuyOrSell.S,
                        Currency.getByName(fx),
                        Utility.getDate(instructionDate),
                        Utility.getDate(settlementDate), units,
                        pricePerUnit);
                System.out.println(entity);
                new DailyTradeDAOSellImpl()
                        .performTransaction(entity);
                System.out.println("Return to main menu type 0 and then choose option from main action between [1-6]");

            }
            else
            {
                throw new DailyTradeReportException("Value not equal to B|S");
            }
            if (sc.nextInt() != 0)
            {
                    continue;
            }
            else
            {
                break;
            }
        }
    }
}
