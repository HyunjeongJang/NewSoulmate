package tk.newsoulmate.web.manger.site.service;

import tk.newsoulmate.domain.dao.MemberDao;
import tk.newsoulmate.domain.vo.Member;


import java.sql.Connection;
import java.util.ArrayList;

import static tk.newsoulmate.web.common.JDBCTemplet.*;

public class ManageService {

    private MemberDao memberDao = new MemberDao();

    public ArrayList<Member> selectManageMember() {
        Connection conn = getConnection();
        ArrayList<Member> mList = memberDao.selectManageMember(conn);
        close();
        return mList;
    }

    public ArrayList<GradeUp> selectGradeUp() {
        Connection conn = getConnection();
        ArrayList<GradeUp> gList = new GradeUpDao().selectAllGrade(conn);
        close();
        return gList;
    }
    }
    public int selectCountMember() {
        Connection conn = getConnection();
        int countMember = memberDao.selectCountMember(conn);
        close();
        return countMember;
    }


}
