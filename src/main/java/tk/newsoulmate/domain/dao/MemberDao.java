package tk.newsoulmate.domain.dao;

import tk.newsoulmate.domain.vo.Member;
import tk.newsoulmate.domain.vo.MemberGrade;
import tk.newsoulmate.web.common.JDBCTemplet;

import java.io.*;
import java.sql.*;
import java.util.*;

import static tk.newsoulmate.web.common.JDBCTemplet.close;

public class MemberDao {

    private Properties prop = new Properties();

    public MemberDao() {
        String fileName = MemberDao.class.getResource("/sql/member/Member-Mapper.xml").getPath();
        try {
            prop.loadFromXML(new FileInputStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public int insertMember(Member m, Connection conn) {

        int result = 0;
        PreparedStatement psmt = null;
        String sql = prop.getProperty("insertMember");
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, m.getMemberId());
            psmt.setString(2, m.getMemberPwd());
            psmt.setString(3, m.getMemberName());
            psmt.setString(4, m.getNickName());
            psmt.setString(5, m.getPhone());
            psmt.setString(6, m.getEmail());
            psmt.setInt(7, m.getMemberGrade().gradeNumber);
            result = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplet.close(psmt);
        }
        return result;

    }

    public Member loginMember(String memberId, String memberPwd, Connection conn) {
        PreparedStatement psmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("loginMember");
        Member m = null;
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, memberId);
            psmt.setString(2, memberPwd);
            rset = psmt.executeQuery();
            if (rset.next()) {
                m = mapToLoginMember(rset);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplet.close(rset);
            JDBCTemplet.close(psmt);
        }
        return m;
    }
    public Member loginMember(int memberNo, Connection conn) {
        PreparedStatement psmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("loginMemberByNo");
        Member m = null;
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, memberNo);
            rset = psmt.executeQuery();
            if (rset.next()) {
                m = mapToLoginMember(rset);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplet.close(rset);
            JDBCTemplet.close(psmt);
        }
        return m;
    }


    //ResultSet에서 데이터를 꺼내서 객체로 변경해주는 역할
    public Member mapToLoginMember(ResultSet resultSet) throws SQLException {
        int memberNo = resultSet.getInt("MEMBER_NO");
        String memberId = resultSet.getString("MEMBER_ID");
        String memberPwd = resultSet.getString("MEMBER_PWD");
        String memberName = resultSet.getString("MEMBER_NAME");
        String nickname = resultSet.getString("NICKNAME");
        String email = resultSet.getString("EMAIL");
        String phone = resultSet.getString("PHONE");
        MemberGrade mg = MemberGrade.valueOfNumber(resultSet.getInt("MEMBER_GRADE"));
            Member m = new Member(memberNo, memberId, memberName, phone, email,nickname, mg);
        if (m.getMemberGrade() == MemberGrade.SHELTER_MANAGER) {
            long shelterNo = resultSet.getLong("SHLETER_NO");
            m.setShelterNo(shelterNo);
        }
        System.out.println(m);
        return m;
    }


    public int idCheck(Connection conn, String checkId) {
        int count = 0;
        PreparedStatement psmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("idCheck");
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, checkId);
            rset = psmt.executeQuery();
            if (rset.next()) {
                count = rset.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplet.close(rset);
            JDBCTemplet.close(psmt);
        }
        return count;
    }


    public int nicknameCheck(Connection conn, String checkNickname) {
        int count = 0;
        PreparedStatement psmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("nicknameCheck");
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, checkNickname);

            rset = psmt.executeQuery();

            if (rset.next()) {
                count = rset.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplet.close(rset);
            JDBCTemplet.close(psmt);
        }
        return count;
    }


    public Member findId(Connection conn, String memberName, String Email) {
        PreparedStatement psmt = null;
        ResultSet rset = null;
        Member m = null;
        String sql = prop.getProperty("findId");
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, memberName);
            psmt.setString(2, Email);

            rset = psmt.executeQuery();

            if(rset.next()) {
                m = this.mapToMember(rset);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplet.close(rset);
            JDBCTemplet.close(psmt);
        }
        return m;
    }


    public Member findPwd(Connection conn, String memberId, String memberName, String email) {
        PreparedStatement psmt = null;
        ResultSet rset = null;
        Member m = null;
        String sql = prop.getProperty("findPwd");
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, memberId);
            psmt.setString(2, memberName);
            psmt.setString(3, email);
            rset = psmt.executeQuery();
            /*if(rset.next()) {
                m = this.mapToMember(rset);
            }*/
            if (rset.next()) {
                m = new Member();
                m.setMemberPwd(rset.getString("MEMBER_PWD"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplet.close(rset);
            JDBCTemplet.close(psmt);
        }
        return m;
    }


    private Member mapToMember(ResultSet resultSet) throws SQLException {
        String memberId = resultSet.getString("MEMBER_ID");
        String memberPwd = resultSet.getString("MEMBER_PWD");
        String memberName = resultSet.getString("MEMBER_NAME");
        String nickname = resultSet.getString("NICKNAME");
        MemberGrade mg = MemberGrade.valueOfNumber(resultSet.getInt("MEMBER_GRADE"));
        String email = resultSet.getString("EMAIL");
        String phone = resultSet.getString("PHONE");
        Member m = new Member(memberId, memberPwd, memberName, nickname, phone, email);
        return m;
    }


    public int updatePassword(Connection conn, String memberId, String password) {
        PreparedStatement psmt = null;
        int result = 0;
        String sql = prop.getProperty("pwdReset");

        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, password);
            psmt.setString(2, memberId);
            result = psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplet.close(psmt);
        }
        return result;
    }

    public int updateMember(Connection conn,Member m){
        int result = 0;

        PreparedStatement psmt = null;

        String sql=prop.getProperty("updateMember");

        try {
            psmt=conn.prepareStatement(sql);
            psmt.setString(1,m.getPhone());
            psmt.setString(2,m.getEmail());
            psmt.setString(3,m.getNickName());
            psmt.setInt(4,m.getMemberNo());

            result = psmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(psmt);
        }
        return result;
    }



}