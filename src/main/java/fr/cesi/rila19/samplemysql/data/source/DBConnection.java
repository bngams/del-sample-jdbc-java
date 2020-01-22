package fr.cesi.rila19.samplemysql.data.source;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static final String DB_HOST = "";
    private static final String DB_PORT = "";
    private static final String DB_NAME = "";
    private static final String DB_USER = "";
    private static final String DB_PWD = "";

    /**
     * Static ref to itself (singleton pattern)
     */
    private static DBConnection instance = null;

    private Connection conn = null;

    /**
     * Private constructor (singleton pattern)
     */
    private DBConnection() {
        try {
            Properties appProperties = this.loadProperties();

            String url = "jdbc:mysql://"
                    + appProperties.getProperty("db.host")
                    + ":" + appProperties.getProperty("db.port")
                    + "/" + appProperties.getProperty("db.database")
                    + "?user=" + appProperties.getProperty("db.user")
                    + "&password=" + appProperties.getProperty("db.password")
                    + "&serverTimezone=UTC";
            this.conn = DriverManager.getConnection(url);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private Properties loadProperties() throws IOException {
        // load app.properties
        // getResourceAsStream() => load a resource file
        InputStream is = DBConnection.class.getClassLoader()
                .getResourceAsStream("app.properties");

        // create a properties object in JAVA
        // load properties from app.properties ("is" variable)
        Properties appProperties = new Properties();
         appProperties.load(is);

        return appProperties;

    }

    /**
     * Get Connection Method
     */
    public static Connection getConnection() {
        if(instance == null) {
            instance = new DBConnection();
        }
        return instance.conn;
    }

}
