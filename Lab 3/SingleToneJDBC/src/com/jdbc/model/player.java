package com.jdbc.model;

public class player {

    int p_id;
    String p_name;
    String p_address;

    public player() {}

    public player(String p_name, String p_address)
    {
        this.p_name = p_name;
        this.p_address = p_address;
    }

    public int getP_id()
    {
        return p_id;
    }

    public void setP_id(int pl_id)
    {
        this.p_id = pl_id;
    }

    public String getP_name()
    {
        return p_name;
    }

    public void setP_name(String pl_name)
    {
        this.p_name = pl_name;
    }

    public String getP_address()
    {
        return p_address;
    }

    public void setP_address(String p_address)
    {
        this.p_address = p_address;
    }

    @Override
    public String toString()
    {
        return "player [pl_id=" + p_id + ", p_name=" + p_name + ", p_address=" + p_address + "]";
    }
}
