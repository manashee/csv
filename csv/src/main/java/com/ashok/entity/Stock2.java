package com.ashok.entity;

public class Stock2 {
    private String Name;
    private String DisplayDate;
    private double Open;
    private double High;
    private double Low;
    private double Close;

    public Stock2() {

    }

    public Stock2(String Name, String DisplayDate, double Open, double High, double Low, double Close) {
        this.Name = Name;
        this.DisplayDate = DisplayDate;
        this.Open = Open;
        this.High = High;
        this.Low = Low;
        this.Close = Close ;
    }

    @Override
    public String toString() {
        return "Stock2{" +
                "Name='" + Name + '\'' +
                ", DisplayDate='" + DisplayDate + '\'' +
                ", Open=" + Open +
                ", High=" + High +
                ", Low=" + Low +
                ", Close=" + Close +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock2)) return false;

        Stock2 stock2 = (Stock2) o;

        if (Double.compare(stock2.getOpen(), getOpen()) != 0) return false;
        if (Double.compare(stock2.getHigh(), getHigh()) != 0) return false;
        if (Double.compare(stock2.getLow(), getLow()) != 0) return false;
        if (Double.compare(stock2.getClose(), getClose()) != 0) return false;
        if (!getName().equals(stock2.getName())) return false;
        return getDisplayDate().equals(stock2.getDisplayDate());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getName().hashCode();
        result = 31 * result + getDisplayDate().hashCode();
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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setHigh(double high) {
        High = high;
    }

    public void setLow(double low) {
        Low = low;
    }

    public void setClose(double close) {
        Close = close;
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

}
