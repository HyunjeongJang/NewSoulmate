package tk.newsoulmate.domain.dao;

import tk.newsoulmate.domain.vo.Attachment;
import tk.newsoulmate.domain.vo.Board;
import tk.newsoulmate.domain.vo.Reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static tk.newsoulmate.domain.vo.Board.*;
import static tk.newsoulmate.web.common.APIKeys.prop;
import static tk.newsoulmate.web.common.JDBCTemplet.close;

public class BoardDao {
    public int readCount(Connection conn, int boardNo) {

        int result = 0;

        PreparedStatement psmt = null;

        String sql = prop.getProperty("readCount");

        try {
            psmt = conn.prepareStatement(sql);

            psmt.setInt(1, boardNo);

            result = psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(psmt);
        }

        return result;
    }

    public Board selectAdoptDetail(Connection conn, int boardNo) {

        Board b = null;

        PreparedStatement psmt = null;

        ResultSet rset = null;

        String sql = prop.getProperty("selectBoard");

        try {
            psmt = conn.prepareStatement(sql);

            psmt.setInt(1, boardNo);

            rset = psmt.executeQuery();

            if(rset.next()) {
                b =  Board.selectAdoptDetail(
                        rset.getString("BOARD_TITLE"),
                        rset.getString("MEMBER_NO"),
                        rset.getDate("ISSUE_DATE"),
                        rset.getDate("CREATE_DATE"),
                        rset.getInt("READ_COUNT"),
                        rset.getString("BOARD_CONTENT")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(psmt);
        }

        return b;

    }

    public int insertReply(Connection conn , Reply r) {

        int result = 0;

        PreparedStatement psmt = null;

        String sql = prop.getProperty("insertReply");

        try {
            psmt = conn.prepareStatement(sql);

            psmt.setInt(1, r.getReplyNo());
            psmt.setInt(2, r.getBoardNo());
            psmt.setInt(3, Integer.parseInt(String.valueOf(r.getMemberNo())));
            psmt.setString(4, r.getReplyContent());

            result = psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(psmt);
        }
        return result;
    }

    public ArrayList<Reply> selectReplyList(Connection conn , int boardNo){

        ArrayList<Reply> list = new ArrayList<>();

        PreparedStatement psmt = null;

        ResultSet rset = null;

        String sql = prop.getProperty("selectReplyList");

        try {
            psmt = conn.prepareStatement(sql);

            psmt.setInt(1, boardNo);

            rset = psmt.executeQuery();

            while(rset.next()) {

                list.add(new Reply(
                        rset.getInt(1),
                        rset.getInt(2),
                        rset.getString(3),
                        rset.getDate(4)
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(psmt);
        }
        return list;
    }



}
