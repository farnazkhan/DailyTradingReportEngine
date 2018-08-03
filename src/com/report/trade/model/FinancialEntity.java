/**************************************************************************
 * Filename    : FinancialEntity
 * Created By  : farnaz
 * Date Created: 03 Aug 2018
 ****************************************************************************/
package com.report.trade.model;

import java.time.LocalDate;

/**
 * *****************************************************************************
 * This class is the financial entity model
 * 
 * @author fkhan
 *****************************************************************************
 */
public class FinancialEntity
{

    private String name;
    private Currency agreedFx;
    private LocalDate instrauctionDate;
    private LocalDate settlementDate;
    private int units;
    private double pricePerUnit;
    
    
    
    
    public FinancialEntity(String name,BuyOrSell buyOrSell, Currency agreedFx, 
            LocalDate instrauctionDate, LocalDate settlementDate, int units,
            double pricePerUnit)
    {
        super();
        this.name = name;
        this.agreedFx = agreedFx;
        this.instrauctionDate = instrauctionDate;
        this.settlementDate = settlementDate;
        this.units = units;
        this.pricePerUnit = pricePerUnit;
    }




    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
        
    public Currency getAgreedFx()
    {
        return agreedFx;
    }
    
    public void setAgreedFx(Currency agreedFx)
    {
        this.agreedFx = agreedFx;
    }
    

    public LocalDate getInstrauctionDate()
    {
        return instrauctionDate;
    }
    
    public void setInstrauctionDate(LocalDate instrauctionDate)
    {
        this.instrauctionDate = instrauctionDate;
    }
    
    public LocalDate getSettlementDate()
    {
        return settlementDate;
    }
    
    public void setSettlementDate(LocalDate settlementDate)
    {
        this.settlementDate = settlementDate;
    }
    
    public int getUnits()
    {
        return units;
    }
    
    public void setUnits(int units)
    {
        this.units = units;
    }
    
    public double getPricePerUnit()
    {
        return pricePerUnit;
    }
    
    public void setPricePerUnit(float pricePerUnit)
    {
        this.pricePerUnit = pricePerUnit;
    }
    
    public enum BuyOrSell
    {
      B,S;     
     
    }

    @Override
    public String toString()
    {
        return "FinancialEntity [name=" + name + ", agreedFx=" + agreedFx
                + ", instrauctionDate=" + instrauctionDate + ", settlementDate="
                + settlementDate + ", units=" + units + ", pricePerUnit="
                + pricePerUnit + "]";
    }
    
    
}
