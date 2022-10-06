package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.model.player;
import com.jdbc.util.DatabaseConnection;

public class playerDaoImplementation implements playerDao {

    static Connection con = DatabaseConnection.getConnection();

    @Override
    public int add(player p) throws SQLException
    {

        String query
                = "insert into player(name, " + "address) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, p.getP_name());
        ps.setString(2, p.getP_address());
        int n = ps.executeUpdate();
        return n;
    }

    @Override
    public void delete(int id) throws SQLException
    {
        String query = "delete from player where pid =?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public player getplayer(int id) throws SQLException
    {

        String query = "select * from player where pid= ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);
        player p = new player();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            p.setP_id(rs.getInt("pid"));
            p.setP_name(rs.getString("name"));
            p.setP_address(rs.getString("address"));
        }

        if (check == true) {
            return p;
        }
        else
            return null;
    }

    @Override
    public List<player> getplayers()
            throws SQLException
    {
        String query = "select * from player";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<player> ls = new ArrayList();

        while (rs.next()) {
            player p = new player();
            p.setP_id(rs.getInt("pid"));
            p.setP_name(rs.getString("name"));
            p.setP_address(rs.getString("address"));
            ls.add(p);
        }
        return ls;
    }

    @Override
    public void update(player pl)
            throws SQLException
    {

        String query = "update player set name=?, " + " address= ? where pid = ?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setString(1, pl.getP_name());
        ps.setString(2, pl.getP_address());
        ps.setInt(3, pl.getP_id());
        ps.executeUpdate();
    }
}
