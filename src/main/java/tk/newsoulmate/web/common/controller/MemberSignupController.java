package tk.newsoulmate.web.common.controller;

import tk.newsoulmate.domain.vo.Member;
import tk.newsoulmate.web.common.service.MemberService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MemberSignup", urlPatterns = {"/signup.do"})
public class MemberSignupController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String memberId = request.getParameter("memberId");
        String memberPwd = request.getParameter("memberPwd");
        String memberName = request.getParameter("memberName");
        String nickName = request.getParameter("nickName");
        String Phone = request.getParameter("Phone");
        String Email = request.getParameter("Email");

        Member m = new Member();

        m.setMemberId(memberId);
        m.setMemberPwd(memberPwd);
        m.setMemberName(memberName);
        m.setNickName(nickName);
        m.setPhone(Phone);
        m.setEmail(Email);

        MemberService service = new MemberService();
        int result = service.insertMember(m);

        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/signupFin.jsp");
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
