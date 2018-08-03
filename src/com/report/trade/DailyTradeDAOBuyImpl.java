/**************************************************************************
 * Filename    : DailyTradeDAOBuyImpl
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
 * This class perform outgoing daily trade transaction in order to generate report.
 * 
 * @author farnaz
 *****************************************************************************
 */
public class DailyTradeDAOBuyImpl implements DailyTradeDAO
{
    /**
     * ************************************************************************
     * The Default Constructor
     *
     *************************************************************************
     */
    public DailyTradeDAOBuyImpl()
    {
       
    }
    
    
    /**
     * ***********************************************************************
     * Add outgoing trade to the list, so that the information remains in cached memory.
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
     * Amount in USD settled for outgoing everyday.
     * @return
     ***********************************************************************
     */
    @Override
    public Map<LocalDate,Double> getReport()
    {
        
        return Utility.generateDatewiseReport(financialEntityBuyCache);         
            
    }

}
