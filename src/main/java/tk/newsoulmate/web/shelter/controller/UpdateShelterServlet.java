package tk.newsoulmate.web.shelter.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateShelterServlet", value = "/shelter/updateShelter")
public class UpdateShelterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int CityNo = Integer.parseInt(request.getParameter("subCategory"));
        System.out.println(CityNo);
        request.getRequestDispatcher("/views/shelter/updateShelter.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
