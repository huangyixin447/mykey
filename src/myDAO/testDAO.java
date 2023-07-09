package myDAO;

import org.junit.Test;

public class testDAO {
    @Test
    public void testDAO() {
        keyDAOimpl keyDAOimpl = new keyDAOimpl();
        keyDAOimpl.deletekey("1CBC6C803DBCFF1E025D0DFEEDC6185A");
    }
}
