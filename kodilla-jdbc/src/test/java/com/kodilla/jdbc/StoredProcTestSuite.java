package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StoredProcTestSuite {
    @Test
    public void testUpdateVipLevels() throws SQLException {
        //given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "update READERS set VIP_LEVEL=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

        //when
        String sqlProcedureCall = "call UpdateVipLevels()";
        statement.execute(sqlProcedureCall);

        //then
        String sqlCheckTable = "select count(*) as HOW_MANY from READERS where VIP_LEVEL=\"Not set\"";
        ResultSet resultSet = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if (resultSet.next()) {
            howMany = resultSet.getInt("HOW_MANY");
        }
        Assert.assertEquals(0, howMany);
    }

    @Test
    public void testUpdateBestsellers() throws SQLException{
        //given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdateQuery = "update BOOKS set BESTSELLER = 0";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdateQuery);

        //when
        String sqlStoredProcedure = "call UpdateBestsellers()";
        statement.execute(sqlStoredProcedure);

        //then
        String sqlCheckQuery = "select count(*) as NO_OF_RECORDS from BOOKS where BESTSELLER <> 0 and BESTSELLER <> 1";
        ResultSet resultSet = statement.executeQuery(sqlCheckQuery);
        int noOfRecords = -1;
        if (resultSet.next()) {
            noOfRecords = resultSet.getInt("NO_OF_RECORDS");
        }
        Assert.assertEquals(0, noOfRecords);
    }
}
