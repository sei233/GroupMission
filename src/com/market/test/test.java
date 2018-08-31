package com.market.test;

import com.market.bean.po.Brand;
import com.market.bean.po.Product;
import com.market.service.Impl.BrandService;
import com.market.service.Impl.ProductService;

import java.util.ArrayList;
import java.util.Date;

public class test {
    public static void main(String[] args) {

        System.out.println(true && ( !false || !true));

//        String s1 = "100";
//        String s2 = "90";//降价幅度
//
//        Float s3 = 1-(Float.parseFloat(s2)/100);
//        System.out.println(Float.parseFloat(s2)/100);
//        Float s = Float.parseFloat(s1)*(1-(Float.parseFloat(s2)/100));
//        System.out.println(s);
//        System.out.println(23.6*0.115);





//        ==================================================================================
//        System.out.println(new Date());
//        ProductService ps = new ProductService();
//        ArrayList<Product> product_list = (ArrayList<Product>)ps.showAllPro();
//        for (Product p:product_list)
//            System.out.println(p.getProductName());
//        test1(1,"string",null,"sb");

//        int[] a={1,2,3,null};
//        String[] s = {"a","b","c",null};
//        System.out.println(s.length);
//        System.out.println(s[3]);
        /*ArrayList<Brand> brand_list = (ArrayList<Brand>) new BrandService().findObj();
        for (Brand b: brand_list) {
            System.out.println(b.getBrandId());
            System.out.println(b.getBrandName());
        }*/
    }
    public static void test1(Object...objects){
        for (int i  =0;i<objects.length;i++){
            System.out.println(objects[i]);
        }
    }
}
