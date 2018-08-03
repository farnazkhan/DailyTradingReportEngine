/**************************************************************************
 * Filename    : DailyTradeDAOSellImpl
 * Created By  : farnaz
 * Date Created: 03 Aug 2018
 ****************************************************************************/
package com.report.trade;

import java.time.LocalDate;
import java.util.Map;

import com.report.trade.model.FinancialEntity;
import com.report.trade.util.Utility;

/**
 * *****************************************************************************
 * This class perform incoming daily trade transaction in order to generate report.
 * 
 * @author farnaz
 *****************************************************************************
 */
public class DailyTradeDAOSellImpl implements DailyTradeDAO
{


    /**
     * ************************************************************************
     * The Default Constructor
     *
     *************************************************************************
     */
    public DailyTradeDAOSellImpl()
    {
       
    }

    /**
     * ***********************************************************************
     * Add incoming trade to the list, so that the information remains in cached memory.
     * 
     * @param entity
     ***********************************************************************
     */  
    @Override
    public void performTransaction(FinancialEntity entity)
    {
        
        financialEntityBuyCache.add(entity);

    }
    
    /**
     * ***********************************************************************
     * Amount in USD settled for incoming everyday.
     * @return
     ***********************************************************************
     */
    @Override
    public Map<LocalDate,Double> getReport()
    {
        // Incoming everyday:  USD amount of a trade = Price per unit * Units * Agreed Fx
       
        return Utility.generateDatewiseReport(financialEntitySellCache);         
            
    }
    
    


}
