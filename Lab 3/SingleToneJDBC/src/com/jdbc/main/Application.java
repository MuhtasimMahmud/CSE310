package com.jdbc.main;

import java.sql.SQLException;
import java.util.List;

import com.jdbc.dao.playerDaoImplementation;
import com.jdbc.model.player;

public class Application {

    public static void main(String[] args)
            throws SQLException
    {

        player pl = new player();
        pl.setP_name("Haider");
        pl.setP_address("Mars");
        playerDaoImplementation plDao
                = new playerDaoImplementation();

        // add
        plDao.add(pl);

        // read
        player e = plDao.getplayer(1);
        System.out.println(e.getP_id() + " "
                + e.getP_name() + " "
                + e.getP_address());

        // read All
        List<player> ls = plDao.getplayers();
        for (player allpl : ls) {
            System.out.println(allpl);
        }

        // update
        player tplplayer = plDao.getplayer(1);
        tplplayer.setP_address("Asgard");
        plDao.update(tplplayer);

        // delete
        plDao.delete(1);
    }
}
