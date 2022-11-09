package tk.newsoulmate.web.common.service;

import tk.newsoulmate.domain.dao.MemberDao;
import tk.newsoulmate.domain.vo.Member;
import tk.newsoulmate.web.common.JDBCTemplet;

import java.sql.Connection;

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

    public String sendMail(String email) {

        String result = MemberDao.sendMail(email);
        return result;

    }

    public Member selectOneMember(String memberId) {

        return null;

    }

    public Member selectNickMember(String nickName) {

        return null;
    }
}
