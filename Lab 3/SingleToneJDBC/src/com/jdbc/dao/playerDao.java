package com.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import com.jdbc.model.player;

public interface playerDao {

    public int add(player pl)
            throws SQLException;
    public void delete(int id)
            throws SQLException;
    public player getplayer(int id)
            throws SQLException;
    public List<player> getplayers()
            throws SQLException;
    public void update(player pl)
            throws SQLException;
}
