/**************************************************************************
 * Filename    : Currency
 * Created By  : farnaz
 * Date Created: 03 Aug 2018
 ****************************************************************************/
package com.report.trade.model;

import java.util.HashMap;
import java.util.Map;

/**
 * *****************************************************************************
 * Enum having list of currency and its values
 * 
 * @author farnaz
 *****************************************************************************
 */
public enum Currency
{

    SGP(0.50),
    
    INR(0.01),
    
    SAR(0.22),
    
    GBP(0.90),

    AED(0.22);
    
    private static final Map<String, Currency> currencyMap = new HashMap<String, Currency>();
    static {
      for (Currency myEnum : values()) {
        currencyMap.put(myEnum.toString(), myEnum);
      }
    }

    public double value;

    Currency(double value)
    {
        this.value = value;
    }
    
    /**
     * ***********************************************************************
     * Get Currency by thier name
     * @param name
     * @return
     ***********************************************************************
     */
    public static Currency getByName(String name) {
        return currencyMap.get(name);
      }


}
