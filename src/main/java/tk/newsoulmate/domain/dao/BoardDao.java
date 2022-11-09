package tk.newsoulmate.domain.dao;

import tk.newsoulmate.domain.vo.Board;
import tk.newsoulmate.domain.vo.PageInfo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import static tk.newsoulmate.web.common.JDBCTemplet.*;

public class BoardDao {
    private Properties prop = new Properties();

    public BoardDao(){
        try {
            prop.loadFromXML(new FileInputStream(BoardDao.class.getResource("/sql/board/board-mapper.xml").getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Board> selectQnAList(Connection conn, PageInfo pi) {

        ArrayList<Board> list = new ArrayList<>();

        PreparedStatement psmt = null;

        ResultSet rset = null;

        String sql = prop.getProperty("selectQnAList");

        try {
            psmt = conn.prepareStatement(sql);

            int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
            int endRow = startRow + pi.getBoardLimit() - 1;

            psmt.setInt(1, startRow);
            psmt.setInt(2, endRow);

            rset = psmt.executeQuery();

            while (rset.next()) {
                list.add(Board.selectQnAList(rset.getString("RESULTSTATUS")
                        , rset.getInt("BOARD_NO")
                        , rset.getString("BOARD_TITLE")
                        , rset.getDate("CREATE_DATE")
                        , rset.getString("MEMBER_NAME")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(psmt);
        }
        return list;

    }


    public int selectListCount(Connection conn, String categoryName){

        int listCount = 0;

        PreparedStatement psmt = null;

        ResultSet rset = null;

        String sql = prop.getProperty("selectListCount");

        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, categoryName);

            rset = psmt.executeQuery();

            if(rset.next()){
                listCount = rset.getInt("cnt");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(psmt);
        }
        return listCount;
    }
}
