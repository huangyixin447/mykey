package myDAO;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class jdbcutils {
    private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
    private static DataSource dataSource=null;
    static {
        Properties properties = new Properties();
        InputStream resourceAsStream = jdbcutils.class.getClassLoader().getResourceAsStream("peizhi/peizhi.properties");
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static Connection getConnection() throws SQLException {
        Connection connection=tl.get();
        if(connection==null){
             connection = dataSource.getConnection();
            tl.set(connection);
        }
        return  connection;
    }
    public static void freeConnect() throws SQLException {
        Connection connection=tl.get();
        if(connection!=null){
            tl.remove();
            connection.setAutoCommit(true);
            connection.close();
        }
    }
}
