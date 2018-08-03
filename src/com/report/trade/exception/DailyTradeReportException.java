/**************************************************************************
 * Filename    : DailyTradeReportException
 * Created By  : farnaz
 * Date Created: 03 Aug 2018
 ****************************************************************************/
package com.report.trade.exception;

/**
 * *****************************************************************************
 * Exception class Daily Trade Report Exception
 * 
 * @author farnaz
 *****************************************************************************
 */
public class DailyTradeReportException extends Exception
{
    /**
     * serial version id
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * ************************************************************************
     * Constructor
     *
     * @param message
     *************************************************************************
     */
    public DailyTradeReportException(String message)
    {
       super(message);
    }
}