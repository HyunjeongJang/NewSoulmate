package tk.newsoulmate.web.common.controller;

import tk.newsoulmate.domain.vo.Member;
import tk.newsoulmate.web.common.service.MemberService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AjaxCheckId", urlPatterns = { "/ajaxCheckId.do" })
public class AjaxCheckIdController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String memberId = request.getParameter("memberId");

        MemberService service = new MemberService();
        Member m = service.selectOneMember(memberId);

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
