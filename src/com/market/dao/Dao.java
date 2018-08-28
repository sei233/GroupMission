package com.market.dao;


import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class Dao<T> {
    private String driver;
    private String url;
    private String user;
    private String password;

    /**
     * 初始化，读取配置文件信息
     */
    public Dao(){
        Properties pro = new Properties();

            //C:\Users\spades\IdeaProjects\SuperMarket\mysql.properties
        try {
            pro.load(getClass().getClassLoader().getResourceAsStream("mysql.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = pro.getProperty("driver");
//        System.out.println(driver);
        url = pro.getProperty("url");
//        System.out.println(url);
        user = pro.getProperty("user");
//        System.out.println(user);
        password = pro.getProperty("password");
//        System.out.println(password);
    }

    /**
     * 建立数据库连接
     * @return
     */
    public Connection getConnection(){
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 增删改
     * @param sql
     * @param objects
     * @return
     */
    public int AddDeleteChange(String sql,Object... objects){
        Connection connection = getConnection();
        try {
            int j=1;
            PreparedStatement smt = connection.prepareStatement(sql);
            if (objects != null && objects.length > 0) {
                for (int i = 0; i < objects.length; i++) {
                    { smt.setObject(j++,objects[i]);
                       }
                }
            }
            return smt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    /**
     * 根据主键查询
     * @param cls
     * @param sql
     * @param objects
     * @return
     */
    public T loadObjextById(Class<T> cls,String sql,Object... objects){
        Connection connection = getConnection();
        try {
            PreparedStatement smt = connection.prepareStatement(sql);
            if (objects != null && objects.length != 0) {
                for (int i = 0; i < objects.length; i++) {
                    smt.setObject(i+1,objects[i]);
                }
            }
            ResultSet rs = smt.executeQuery();
            if (rs != null) {
                rs.next();
                return resolveData(cls,rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 查询满足条件的所有信息
     * @param cls
     * @param sql
     * @param objects
     * @return
     */
    public ArrayList<T> loadAllObjects(Class<T> cls,String sql,Object... objects){
        Connection connection = getConnection();
        try {
            int j = 1;
            PreparedStatement smt = connection.prepareStatement(sql);
            if (objects != null && objects.length > 0) {
                for (int i = 0; i < objects.length; i++) {
                    if (objects[i]!=""&&objects[i]!=null)
                        smt.setObject(j++,objects[i]);
                }
            }
            ResultSet rs = smt.executeQuery();
            if (rs != null) {
                ArrayList<T> data = new ArrayList<T>();
                while (rs.next()) {
                    data.add(resolveData(cls,rs));
                }
                return data;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    /**
     * 解析数据库查询结果，并实例化
     * @param cls
     * @param rs
     * @return
     */
    private T resolveData(Class<T> cls, ResultSet rs) {
        try {
            T t = cls.getConstructor().newInstance();//获取类的实例
            ResultSetMetaData rsmd =  rs.getMetaData();//获取rs的相关信息
            Field[] fields = cls.getDeclaredFields();//获取类的字段信息
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                String name = rsmd.getColumnName(i);
                for (Field field:fields){
                    if (field.getName().equalsIgnoreCase(name)){
                        field.setAccessible(true);
                        field.set(t,rs.getObject(i));
                    }
                }
            }
            return t;
        } catch (InstantiationException |SQLException |IllegalAccessException |InvocationTargetException |NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

}
