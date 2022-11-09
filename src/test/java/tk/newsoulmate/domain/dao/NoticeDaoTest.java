package tk.newsoulmate.domain.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tk.newsoulmate.web.common.JDBCTemplet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class NoticeDaoTest {

    @Test
    void getNoticeSubNail() {
    }

    @Test
    void scrapNotice() {
        Connection conn=null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","NEWSOULMATE","NEWSOULMATE");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        int result=0;
        NoticeDao nd=new NoticeDao();
        result=nd.scrapNotice(conn,1);
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotEquals(0,result);
    }
}