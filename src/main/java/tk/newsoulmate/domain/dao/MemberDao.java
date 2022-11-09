package tk.newsoulmate.domain.dao;

import tk.newsoulmate.domain.vo.Member;
import tk.newsoulmate.web.common.JDBCTemplet;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class MemberDao {

    private Properties prop = new Properties();

    public MemberDao() {
        String fileName = MemberDao.class.getResource("resources/sql/table/member-mapper.xml").getPath();

        try {
            prop.loadFromXML(new FileInputStream(fileName));
        } catch (InvalidPropertiesFormatException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int insertMember(Member m, Connection conn) {

        int result = 0;

        PreparedStatement psmt = null;

        String sql = prop.getProperty("insertMember");

        try {
            psmt = conn.prepareStatement(sql); // 변수가 필요한 공간에 ?로 채워져 있는 미완성된 객체라 완성시켜줘야함

            psmt.setString(1, m.getMemberId());
            psmt.setString(2, m.getMemberPwd());
            psmt.setString(3, m.getMemberName());
            psmt.setString(4, m.getNickName());
            psmt.setString(5, m.getPhone());
            psmt.setString(6, m.getEmail());
            result = psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplet.close(psmt);
        }

        return result;

    }

    public Member loginMember(String memberId, String memberPwd, Connection conn) {

        Member m = null;

        PreparedStatement psmt = null;

        ResultSet rset = null;

        String sql = prop.getProperty("loginMember");

        try {
            psmt = conn.prepareStatement(sql);

            psmt.setString(1, memberId);
            psmt.setString(2, memberPwd);

            rset = psmt.executeQuery();

  /*          if(rset.next()) {
                m = new Member(rset.getInt("MEMBER_NO"),
                        rset.getString("MEMBER_ID"),
                        rset.getString("MEMBER_PWD"),
                        rset.getString("MEMBER_NAME"),
                        rset.getString("NICKNAME"),
                        rset.getString("PHONE"),
                        rset.getString("EMAIL"),
                        rset.getDate("ENROLL_DATE"),
                        rset.getDate("MODIFY_DATE"),
                        rset.getString("STATUS"));

            }*/

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplet.close(rset);
            JDBCTemplet.close(psmt);
        }

        return m;
    }

    public static String sendMail(String email) {





    }

}
