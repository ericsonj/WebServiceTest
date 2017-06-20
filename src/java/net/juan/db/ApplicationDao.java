package net.juan.db;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author ejoseph
 */
public class ApplicationDao {

    private static ApplicationDao instance = null;
    private BasicDataSource bc;

    private ApplicationDao() {
        bc = new BasicDataSource();
        bc.setDriverClassName("com.mysql.jdbc.Driver");
        bc.setUsername("juan");
        bc.setPassword("juan123");
        bc.setUrl("jdbc:mysql://127.0.0.1/juandb");
    }

    public static ApplicationDao getInstance() {
        if (instance == null) {
            instance = new ApplicationDao();
        }
        return instance;
    }

    public BasicDataSource getBasicDataSource() {
        return bc;
    }
    
    public Connection getConnection() throws SQLException{
        return bc.getConnection();
    }

}
