package tk.newsoulmate.web.common.controller;

import tk.newsoulmate.web.common.service.MemberService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EmailVerification", urlPatterns = {"/sendMail.do"})
public class EmailVerificationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String email = request.getParameter("memberMail");

        MemberService service = new MemberService();
        String randomCode = service.sendMail(email);

        PrintWriter out = response.getWriter();
        out.print(randomCode);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
