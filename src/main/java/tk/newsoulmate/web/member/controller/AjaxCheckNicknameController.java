package tk.newsoulmate.web.member.controller;

import tk.newsoulmate.domain.vo.Member;
import tk.newsoulmate.web.member.sevice.MemberService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ajaxCheckNickname", urlPatterns = {"/CheckNickname.do"})
public class AjaxCheckNicknameController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nickName = request.getParameter("nickName");

        MemberService service = new MemberService();
        Member m = service.selectNickMember(nickName);

        PrintWriter out = response.getWriter();
        if(m!=null) {
            out.print(1);
        }else {
            out.print(0);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
