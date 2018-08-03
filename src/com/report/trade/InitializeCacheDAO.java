/**************************************************************************
 * Filename    : InitializeCacheDAO
 * Created By  : farnaz
 * Date Created: 03 Aug 2018
 ****************************************************************************/
package com.report.trade;

import java.time.DateTimeException;

import com.report.trade.model.Currency;
import com.report.trade.model.FinancialEntity;
import com.report.trade.model.FinancialEntity.BuyOrSell;
import com.report.trade.util.Utility;

/**
 * *****************************************************************************
 * This class is used to initialize the cache with the data provided in the Problem.
 * 
 * @author farnaz
 *****************************************************************************
 */
public class InitializeCacheDAO implements DailyTrade
{
    
    
    /**
     * ***********************************************************************
     * Static method invoked at the beginning, 
     * that initializes the cache from the test problem data provided
     * 
     * @throws DateTimeException
     ***********************************************************************
     */
    public static void init() throws DateTimeException
    {
     
        FinancialEntity foo_B=new FinancialEntity("foo",BuyOrSell.B,Currency.SGP,Utility.getDate("1/01/2016"),Utility.getDate("2/01/2016"),200,100.25); 
        
        FinancialEntity bar_S=new FinancialEntity("bar",BuyOrSell.S,Currency.AED,Utility.getDate("5/01/2016"),Utility.getDate("7/01/2016"),450,150.5); 
        
        financialEntityBuyCache.add(foo_B);
        
        financialEntitySellCache.add(bar_S);
       
        
    }

}