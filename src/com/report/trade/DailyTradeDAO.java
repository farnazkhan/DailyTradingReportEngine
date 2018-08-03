/**************************************************************************
 * Filename    : DailyTradeDAO
 * Created By  : farnaz
 * Date Created: 03 Aug 2018
 ****************************************************************************/
package com.report.trade;

import java.time.LocalDate;
import java.util.Map;

import com.report.trade.model.FinancialEntity;

/**
 * *****************************************************************************
 * Interface to perform daily trade transaction in order to generate report.
 * 
 * @author farnaz
 *****************************************************************************
 */
public interface DailyTradeDAO extends DailyTrade
{
    /**
     * ***********************************************************************
     * Add a new trade by passing new entity's information.
     * 
     * @param entity
     ***********************************************************************
     */
     void performTransaction(FinancialEntity entity);
     
     /**
      * ***********************************************************************
      * Amount in USD settled incoming or outgoing everyday.
      * @return
      ***********************************************************************
      */
     Map<LocalDate,Double> getReport();
}
