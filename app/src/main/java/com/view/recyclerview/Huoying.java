package com.view.recyclerview;

public class Huoying
{
    private int number;
    private String name;
    private String trump;

    public Huoying(int number, String name, String trump)
    {
        this.number = number;
        this.name = name;
        this.trump = trump;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getTrump()
    {
        return trump;
    }

    public void setTrump(String trump)
    {
        this.trump = trump;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    @Override
    public String toString()
    {
        return "Huoying{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", trump='" + trump + '\'' +
                '}';
    }
}
