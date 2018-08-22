package com.market.controller;

import com.market.bean.po.Brand;
import com.market.service.Impl.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "BrandController")
public class BrandController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        BrandService bs = new BrandService();
        if (type==null){
            type="";
        }
        switch (type){
            case "add":{

                break;
            }
            case "delete":{

                break;
            }
            case "update":{
                break;
            }
            default:{
                ArrayList<Brand> brand_list = (ArrayList<Brand>)bs.findObj();
                request.setAttribute("brand_list",brand_list);
                request.getRequestDispatcher("/WEB-INF/jsp/brand_out.jsp").forward(request,response);
                break;
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
