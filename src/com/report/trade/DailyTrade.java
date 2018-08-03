/**************************************************************************
 * Filename    : DailyTrade
 * Created By  : farnaz
 * Date Created: 03 Aug 2018
 ****************************************************************************/
package com.report.trade;

import java.util.ArrayList;
import java.util.List;

import com.report.trade.model.FinancialEntity;

/**
 * *****************************************************************************
 * Interface to maintain daily trade transaction records in a cache.
 * 
 * @author farnaz
 *****************************************************************************
 */
public interface DailyTrade
{
    
    /**
     * List that maintain all the outgoing entity information.
     */
    List<FinancialEntity> financialEntityBuyCache = new ArrayList<FinancialEntity>();
    
    /**
     * List that maintain all the incoming entity information.
     */
    List<FinancialEntity> financialEntitySellCache = new ArrayList<FinancialEntity>();

}
