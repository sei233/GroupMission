package com.market.controller;

import com.market.bean.po.Product;
import com.market.service.Impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProductController")
public class ProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        ArrayList<Product> product_list = null;
        ProductService ps = new ProductService();
        ArrayList<String> color_list = ps.getColor_list();
//        for (String s:color_list) System.out.println(s);
        ArrayList<String> brand_list = ps.getBrand_list();
        ArrayList<String> model_list = ps.getModel_list();
        ArrayList<String> type_list = ps.getType_list();
        request.setAttribute("color_list",color_list);
        request.setAttribute("brand_list",brand_list);
        request.setAttribute("type_list",type_list);
        request.setAttribute("model_list",model_list);
        if (type==null){
            type="";
        }
        switch (type){
            case "find":{
                String id =request.getParameter("id");
//                product_list = null;
                product_list = (ArrayList<Product> )ps.findObjByName(id);
//                System.out.println(product_list.size());
//                System.out.println(product_list.isEmpty());
                if (product_list!=null) {
                    try {
                        Product product = ps.findObjById(Integer.parseInt(id));
                        if (product != null)
                            product_list.add(product);
                    } catch (NumberFormatException e) {
                        System.out.println("当前输入不是数字，不能查找编号");
                        e.printStackTrace();
                    } finally {
                        System.out.println(product_list.size());
                        if (product_list.size()>0) {
                            request.setAttribute("product_list", product_list);
                            request.getRequestDispatcher("/WEB-INF/jsp/product_out.jsp").forward(request, response);
                        }else {
                            request.setAttribute("msg", "kk");
                            request.getRequestDispatcher("/WEB-INF/jsp/product_out.jsp").forward(request, response);
                        }
                    }
                }else {
                    String color = request.getParameter("pro_color");
                    String brand = request.getParameter("pro_brand");
                    String model = request.getParameter("pro_model");
                    String type1 = request.getParameter("pro_type");
                    product_list = (ArrayList<Product>)ps.findObjByMultiCondition(color,model,brand,type1);//按顺序传入 color model brand type
                    System.out.println(product_list.size());
                    if (product_list.size()>0) {
                        request.setAttribute("product_list", product_list);
                        request.getRequestDispatcher("/WEB-INF/jsp/product_out.jsp").forward(request, response);
                    }else {
                        request.setAttribute("msg", "kk");
                        request.getRequestDispatcher("/WEB-INF/jsp/product_out.jsp").forward(request, response);
                    }
                }
                break;
            }
            default:{
//                System.out.println("1");

                product_list = ps.showAllPro();
//                 product_list = ps.showAllPro();
//                for (Product p:product_list) System.out.println(p.getProductName());
//                System.out.println("2");
                request.setAttribute("product_list",product_list);
                request.getRequestDispatcher("/WEB-INF/jsp/product_out.jsp").forward(request,response);
                break;
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
