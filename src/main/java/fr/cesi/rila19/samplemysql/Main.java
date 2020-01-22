package fr.cesi.rila19.samplemysql;

import fr.cesi.rila19.samplemysql.data.source.DBConnection;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        try {
            // store Connection in var
            Connection conn = DBConnection.getConnection();
            // create statement
            Statement statement = conn.createStatement();
            // define query
            String query = "SELECT * FROM CONTACTS;";
            // exec query
            ResultSet rset = statement.executeQuery(query);
            while(rset.next()){
                System.out.println(rset.getInt("id") + " - " + rset.getString("lastname"));
            }

            // preparedStatement
            String preparedQuery = "SELECT * FROM CONTACTS WHERE id = ?;";
            PreparedStatement pStatement = conn.prepareStatement(preparedQuery);
            // replace ? (first paramater:1 ) with 1
            pStatement.setObject(1, 1);
            ResultSet rset2 = pStatement.executeQuery();
            if(rset2.first()) {
                System.out.println(rset2.getInt("id") + " - " + rset2.getString("lastname"));
            }

            // insert request
            String insertQuery = "INSERT INTO CONTACTS (lastname, firstname, tel, email, website) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
            insertStatement.setString(1, "Begh");
            insertStatement.setString(2, "Eddz");
            insertStatement.setString(3, "");
            insertStatement.setString(4, "b.eddy@devidia.net");
            insertStatement.setString(5, "");
            insertStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
