/**************************************************************************
 * Filename    : ConsoleApplication
 * Created By  : farnaz
 * Date Created: 03 Aug 2018
 ****************************************************************************/
package com.report.trade;

import java.util.Collections;
import java.util.Scanner;

import com.report.trade.exception.DailyTradeReportException;
import com.report.trade.model.SortTrade;

/**
 * *****************************************************************************
 * Entry point for the Daily Trading Report engine application.
 * 
 * @author fkhan
 *****************************************************************************
 */
public class ConsoleApplication
{

    private static Scanner scanner;
    
    /**
     * ***********************************************************************
     * Main method.
     * 
     * @param args
     * @throws Exception
     ***********************************************************************
     */
    public static void main(String[] args) throws Exception
    {

        try{
        InitializeCacheDAO.init();
        
        DailyTradeDAO trade;
        
        System.out.println(
                "Enter the numeric value of action to be performed for the below list (for example: type 1 if you want to Perform Buy/Sell trasaction):");
        System.out.println("Action 1: Perform Buy/Sell transaction");
        System.out.println(
                "Action 2: Generate Amount in USD settled incoming everyday");
        System.out.println(
                "Action 3: Generate Amount in USD settled outgoing everyday");
        System.out.println("Action 4: Rank by incoming");
        System.out.println("Action 5: Rank by outgoing");
        System.out.println("Action 6: Exit");

        scanner = new Scanner(System.in);

        while (true)
        {
            int action = scanner.nextInt();

            System.out.println("Action choosen by you:" + action);

            switch (action)
            {
                case 1:
                    Transaction.readTransaction();
                    break;

                case 2:
                    trade = new DailyTradeDAOSellImpl();
                    System.out.println(trade.getReport());
                    break;
                case 3:
                    trade = new DailyTradeDAOBuyImpl();
                    System.out.println(trade.getReport());
                    
                    break;
                case 4:
                    Collections.sort(DailyTrade.financialEntitySellCache,
                            new SortTrade());
                    System.out.println(DailyTrade.financialEntitySellCache);
                    break;
                    
                case 5:
                    Collections.sort(DailyTrade.financialEntityBuyCache,
                            new SortTrade());
                    System.out.println(DailyTrade.financialEntityBuyCache);
                    break;
                
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid action number.");
                    break;
            }
        }

    }   catch (DailyTradeReportException exception)
        {
        System.out.println(exception.getMessage());
        System.exit(0);
        }
    }
    

}