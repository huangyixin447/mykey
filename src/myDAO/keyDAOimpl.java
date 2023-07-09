package myDAO;

import java.sql.SQLException;
import java.util.List;

public class keyDAOimpl extends BaseDAO{
    public void addkey(keybean keybean){
        String sql="insert into key1 values(0,?,?)";
        try {
            executrUpdate(sql,keybean.getKey1(),keybean.getSession1());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("成功");
    }
    public keybean getkey(String session1)  {
        String sql="select * from key1 where session1=?";
        try {
            List<keybean> keybeans = executeQuery(keybean.class, sql, session1);
            if(keybeans.size()==0){
          throw new RuntimeException("session错误");
            }else{
                return keybeans.get(0);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
    public  void deletekey(String session1){
        try {
            executrUpdate("delete from key1 where session1=?",session1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("成功");
    }
}
