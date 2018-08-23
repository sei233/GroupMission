package com.market.service.Impl;

import com.market.bean.po.Product;
import com.market.dao.Dao;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private Dao<Product> d = null;
    private ArrayList<Product> pro_list = null;
    private ArrayList<String> color_list=null;
    private ArrayList<String> brand_list=null;
    private ArrayList<String> model_list=null;
    private ArrayList<String> type_list=null;
    public ProductService(){
        d = new Dao<Product>();
        color_list = new ArrayList<String>();
        brand_list = new ArrayList<String>();
        model_list = new ArrayList<String>();
        type_list = new ArrayList<String>();
        pro_list = (ArrayList<Product>)d.loadAllObjects(Product.class,SqlSmt.FINDALL_PRODUCT);
        for (Product p:pro_list){
            if (!color_list.contains(p.getProductColor())){
                color_list.add(p.getProductColor());
            }
            if (!brand_list.contains((p.getProductBrand()))){
                brand_list.add(p.getProductBrand());
            }
            if (!model_list.contains(p.getProductModel())){
                model_list.add(p.getProductModel());
            }
            if (!type_list.contains(p.getProductType())){
                type_list.add(p.getProductType());
            }
        }
    }

    /**
     * 获取颜色列表
     * @return
     */
    public ArrayList<String> getColor_list(){
        return color_list;
    }

    /**
     * 获取品牌列表
     * @return
     */
    public ArrayList<String> getBrand_list(){
        return brand_list;
    }

    /**
     * 获取型号列表
     * @return
     */
    public ArrayList<String> getModel_list(){
        return model_list;
    }

    /**
     * 获取类型列表
     * @return
     */
    public ArrayList<String> getType_list(){
        return type_list;
    }


    public ArrayList<Product> showAllPro(){
        return pro_list;
    }
    public List<Product> showByCondition(Object...objects){
        StringBuilder sb = new StringBuilder(SqlSmt.FINDALL_PRODUCT);
//        if ()
        return null;
    }
    public Product findObjById(Integer id) {
        return d.loadObjextById(Product.class, SqlSmt.FINDID_PRODUCT,id);
    }
    public List<Product> findObjByName(String id) {
        if (!id.equals("")) {
            StringBuilder sb = new StringBuilder(SqlSmt.FINDALL_PRODUCT);
            sb.append(" and productName like ?");
            id = "%" + id + "%";
            return d.loadAllObjects(Product.class, sb.toString(), id);
        }
        return null;
//        return d.loadObjextById(Product.class,);
    }

    /**
     *
     * @param objects  按顺序传入 color model brand type，没有的传null
     * @return
     */

    public List<Product> findObjByMultiCondition(Object...objects) {
        StringBuilder sb = new StringBuilder(SqlSmt.FINDALL_PRODUCT);
        if (objects[0]!=""&&objects[0]!=null){//color
            sb.append(" and productColor = ?");
        }
        if (objects[1]!=""&&objects[0]!=null){//model
            sb.append(" and productModel = ?");
        }
        if (objects[2]!=""&&objects[0]!=null){//brand
            sb.append(" and productbrand = ?");
        }
        if (objects[3]!=""&&objects[0]!=null){//type
            sb.append(" and productType = ?");
        }
        return d.loadAllObjects(Product.class,sb.toString(),objects);
    }
}
