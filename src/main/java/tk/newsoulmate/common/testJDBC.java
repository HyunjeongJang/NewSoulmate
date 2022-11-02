package tk.newsoulmate.common;

import tk.newsoulmate.member.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "test", value = "/test.do")
public class testJDBC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection=JDBCTemplet.getConnection();
        String sql="SELECT * FROM MEMBER";
        ArrayList<Member> list=new ArrayList<>();
        ResultSet rset=null;
        PreparedStatement psmt=null;
        try {
            psmt=connection.prepareStatement(sql);
            rset=psmt.executeQuery();
            while(rset.next()) {
                Member m = new Member();
                m.setUserName(rset.getString("USER_NAME"));
                list.add(m);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(list);
        request.setAttribute("list",list);
        request.getRequestDispatcher("/views/test/testJDBC.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
