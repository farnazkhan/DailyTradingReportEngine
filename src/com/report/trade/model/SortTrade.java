/**************************************************************************
 * Filename    : SortTrade
 * Created By  : farnaz
 * Date Created: 03 Aug 2018
 ****************************************************************************/
package com.report.trade.model;

import java.util.Comparator;

import com.report.trade.util.Utility;

/**
 * *****************************************************************************
 * This class create ranking based on incoming and outgoing amount.
 * 
 * @author fkhan
 *****************************************************************************
 */
public class SortTrade implements Comparator<FinancialEntity>
{
    
   /**
    * ***********************************************************************
    * Compare to sort based on amount
    * @param a
    * @param b
    * @return
    ***********************************************************************
    */
    public int compare(FinancialEntity a, FinancialEntity b)
    {
        return (int)Utility.calculateTrade(a) - (int)Utility.calculateTrade(b);
    }
}
 