package tk.newsoulmate.web.member.sevice;

import tk.newsoulmate.domain.dao.MemberDao;
import tk.newsoulmate.domain.vo.Member;
import tk.newsoulmate.web.common.JDBCTemplet;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class MemberService {

    public Member loginMember(String memberId, String memberPwd) {

        Connection conn = JDBCTemplet.getConnection();
        Member m = new MemberDao().loginMember(memberId, memberPwd, conn);

        JDBCTemplet.close();

        return m;

    }

    public int insertMember(Member m) {
        Connection conn = JDBCTemplet.getConnection();

        int result = new MemberDao().insertMember(m, conn);

        if(result > 0) {
            JDBCTemplet.commit();
        }else {
            JDBCTemplet.rollback(conn);
        }

        JDBCTemplet.close();

        return result;

    }

    public Member selectOneMember(String memberId) {

        return null;

    }

    public Member selectNickMember(String nickName) {

        return null;
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

            // 받는사람
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
