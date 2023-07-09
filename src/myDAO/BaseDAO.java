package myDAO;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO {
    public int executrUpdate(String sql,Object ...params) throws SQLException {
        Connection connection=jdbcutils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i+1,params[i]);
        }
        int i = preparedStatement.executeUpdate();
        boolean autoCommit = connection.getAutoCommit();
        preparedStatement.close();
        if (autoCommit) {
            jdbcutils.freeConnect();
        }
        return i;
    }
    public <T> List<T> executeQuery(Class<T> clazz, String sql,Object ...params) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Connection connection = jdbcutils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i+1,params[i]);
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        List<T> ts = new ArrayList<>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        while (resultSet.next()){
//            新键一个对象
            T t = clazz.newInstance();
            int columnCount = metaData.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                String columnLabel = metaData.getColumnLabel(i+1);
                Object object = resultSet.getObject(i+1);
//                开始使用反射进行赋值
                Field declaredField = clazz.getDeclaredField(columnLabel);
                declaredField.setAccessible(true);
                declaredField.set(t,object);
            }
            ts.add(t);
        }
        resultSet.close();
        preparedStatement.close();
        if(connection.getAutoCommit()) {
            jdbcutils.freeConnect();
        }
        return ts;
    }
}
