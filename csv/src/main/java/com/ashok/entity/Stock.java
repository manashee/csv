package com.ashok.entity;

import java.math.BigDecimal;

public class Stock {
    private String DisplayDate;
    private double Open;
    private double High;
    private double Low;
    private double Close;

    public Stock() {

    }

    public Stock(String DisplayDate, double Open, double High, double Low, double Close) {
        this.DisplayDate = DisplayDate;
        this.Open = Open;
        this.High = High;
        this.Low = Low;
        this.Close = Close ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock)) return false;

        Stock stock = (Stock) o;

        if (Double.compare(stock.getOpen(), getOpen()) != 0) return false;
        if (Double.compare(stock.getHigh(), getHigh()) != 0) return false;
        if (Double.compare(stock.getLow(), getLow()) != 0) return false;
        if (Double.compare(stock.getClose(), getClose()) != 0) return false;
        return getDisplayDate().equals(stock.getDisplayDate());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getDisplayDate().hashCode();
        temp = Double.doubleToLongBits(getOpen());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getHigh());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getLow());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getClose());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String getDisplayDate() {
        return DisplayDate;
    }

    public void setDisplayDate(String displayDate) {
        DisplayDate = displayDate;
    }

    public double getOpen() {
        return Open;
    }

    public void setOpen(double open) {
        Open = open;
    }

    public Double getHigh() {
        return High;
    }

    public void setHigh(Double high) {
        High = high;
    }

    public Double getLow() {
        return Low;
    }

    public void setLow(Double low) {
        Low = low;
    }

    public Double getClose() {
        return Close;
    }

    public void setClose(Double close) {
        Close = close;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "DisplayDate='" + DisplayDate + '\'' +
                ", Open=" + Open +
                ", High=" + High +
                ", Low=" + Low +
                ", Close=" + Close +
                '}';
    }
}
