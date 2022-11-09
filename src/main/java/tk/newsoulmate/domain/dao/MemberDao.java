package tk.newsoulmate.domain.dao;

import tk.newsoulmate.domain.vo.Member;
import tk.newsoulmate.web.common.JDBCTemplet;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

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

        boolean result = false;

        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {

            int flag = r.nextInt(3);
            if (flag == 0) {

                int randomNum = r.nextInt(10);
                sb.append(randomNum);

            } else if (flag == 1) {

                char randomChar = (char) (r.nextInt(26) + 65);
                sb.append(randomChar);
            } else if (flag == 2) {
                char randomChar = (char) (r.nextInt(26) + 97);
                sb.append(randomChar);
            }
        }

        Properties prop = System.getProperties();

        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", 123);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", true);
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");

        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                PasswordAuthentication pa = new PasswordAuthentication("newsoulmate", "newsoulmate");
                return pa;
            }
        });

        MimeMessage msg = new MimeMessage(session);



        try {

            msg.setSentDate(new Date());
            msg.setFrom(new InternetAddress("newsoulmate@gamil.com", "환승주인"));

            // 받는사람 정보
            InternetAddress to = new InternetAddress(email);
            msg.setRecipient(Message.RecipientType.TO, to);

            msg.setSubject("환승주인 회원가입 인증번호 입니다.", "UTF-8");

            msg.setContent(
                    "인증번호는 " + sb.toString() + " 입니다.",
                    "text/html;charset=utf-8");

            Transport.send(msg);

            result = true;
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        if (result) {
            return sb.toString();
        } else {
            return null;
        }

    }

}
