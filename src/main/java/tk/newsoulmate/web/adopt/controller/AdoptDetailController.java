package tk.newsoulmate.web.adopt.controller;

import tk.newsoulmate.domain.vo.Board;
import tk.newsoulmate.web.adopt.sevice.AdoptService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdoptDetailController", value = "/adoptDetail.bo")
public class AdoptDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int boardNo = Integer.parseInt(request.getParameter("bno"));

        AdoptService bService = new AdoptService();
        
        int result = bService.readCount(boardNo);
      
        if(result > 0) {

            Board b = bService.selectAdoptDetail(boardNo);

            request.setAttribute("b", b);

            request.getRequestDispatcher("views/adopt/adoptDetail.jsp").forward(request, response);
        } else {

        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
