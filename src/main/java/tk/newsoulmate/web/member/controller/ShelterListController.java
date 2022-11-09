package tk.newsoulmate.web.common.controller;

import tk.newsoulmate.domain.vo.City;
import tk.newsoulmate.domain.vo.Shelter;
import tk.newsoulmate.domain.vo.Village;
import tk.newsoulmate.web.common.sevice.ShelterService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "shelterList", value = "/shelter/list")
public class ShelterListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Shelter> sList = new ShelterService().selectList();
        ArrayList<City> cList = new ShelterService().selectCity();
        ArrayList<Village> vList = new ShelterService().selectVillage();
        request.setAttribute("sList",sList);
        request.setAttribute("cList",cList);
        request.setAttribute("vList",vList);
        request.getRequestDispatcher("/views/shelter/shelterList.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
