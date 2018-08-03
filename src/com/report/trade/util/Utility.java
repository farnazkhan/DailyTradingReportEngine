/**************************************************************************
 * Filename    : Utility
 * Created By  : farnaz
 * Date Created: 03 Aug 2018
 ****************************************************************************/
package com.report.trade.util;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.report.trade.model.FinancialEntity;

/**
 * *****************************************************************************
 * Utility class to provide static methods for easy conversion or calculations
 * 
 * @author fkhan
 *****************************************************************************
 */
public class Utility
{

    /**
     * ***********************************************************************
     * Get Local date from String 
     * @param dateString
     * @return
     * @throws DateTimeException
     ***********************************************************************
     */
    public static LocalDate getDate(String dateString) throws DateTimeException
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.dateFormat);

        LocalDate localDate = LocalDate.parse(dateString, formatter);
        return localDate;
    }
    
    /**
     * ***********************************************************************
     * Get a report for each day
     * @param financialEntityCache
     * @return
     ***********************************************************************
     */
    public static Map<LocalDate,Double> generateDatewiseReport(List<FinancialEntity> financialEntityCache)
    {
        Iterator<FinancialEntity> it=financialEntityCache.iterator();
        Map<LocalDate,Double> datewise=new HashMap<LocalDate,Double>();
        double totalAmount = 0;
        while(it.hasNext())
        {
            FinancialEntity entity=  it.next();
            
            if(entity.getAgreedFx().name().equalsIgnoreCase(Constants.AED)||entity.getAgreedFx().name().equalsIgnoreCase(Constants.SAR))
            {
                if(entity.getSettlementDate().getDayOfWeek().name().equalsIgnoreCase(Constants.THURSDAY))
                {
                    entity.setSettlementDate(entity.getSettlementDate().plusDays(2));
                }else if(entity.getSettlementDate().getDayOfWeek().name().equalsIgnoreCase(Constants.FRIDAY))
                {
                    entity.setSettlementDate(entity.getSettlementDate().plusDays(1));
                }
            }else
            {
                if(entity.getSettlementDate().getDayOfWeek().name().equalsIgnoreCase(Constants.SATURDAY))
                {
                    entity.setSettlementDate(entity.getSettlementDate().plusDays(2));
                }else if(entity.getSettlementDate().getDayOfWeek().name().equalsIgnoreCase(Constants.SUNDAY))
                {
                    entity.setSettlementDate(entity.getSettlementDate().plusDays(1));
                }
            }
           if(datewise.get(entity.getSettlementDate())==null){
               
               datewise.put(entity.getSettlementDate(), calculateTrade(entity));
            
           }
           else {
               
               totalAmount=datewise.get(entity.getSettlementDate());
               datewise.put(entity.getSettlementDate(),totalAmount+calculateTrade(entity));
           }
        } 
            
        
         return datewise;
    }

   

    /**
     * ***********************************************************************
     * Calculate USD amount of a trade
     * @param entity
     * @return
     ***********************************************************************
     */
    public static double calculateTrade(FinancialEntity entity)
    {
        
   
        return (entity.getPricePerUnit()*entity.getUnits()*entity.getAgreedFx().value);
    } 
    
   

}
