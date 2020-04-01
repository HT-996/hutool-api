package com.demo.config;

import org.testng.annotations.DataProvider;

import java.sql.*;
import java.util.*;

/**
 * @Author HuTing
 * @Date 2020-04-01 16:33
 */
public class DbDataHeleper {

    static Connection conn = null;

    public static String driverClassName = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/wxmall";
    public static String username = "root";
    public static String password = "123456";


    /**
     * 执行sql
     *
     * @param jdbcUrl 数据库配置连接
     * @param sql     sql语句
     * @return
     */
    public static List<Map<String, Object>> getDataList(String jdbcUrl, String sql) {
        List<Map<String, Object>> paramList = new ArrayList<Map<String, Object>>();
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(driverClassName);
            // 打开链接
            conn = DriverManager.getConnection(jdbcUrl, username, password);
            // 执行查询
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
//            String columns[] = {"id", "title"};
            // 展开结果集数据库
//            while (rs.next()) {
//                Map<String, Object> map = new LinkedHashMap<String, Object>();
//                for (int i = 0; i < columns.length; i++) {
//                    String cellData = rs.getString(columns[i]);
//                    map.put(columns[i], cellData);
//                }
//                paramList.add(map);
//            }
            paramList = convertList(rs);
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            System.out.println("处理 JDBC 错误!");
        } catch (Exception e) {
            // 处理 Class.forName 错误
            System.out.println("处理 Class.forName 错误");
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return paramList;
    }

    @DataProvider
    public Object[][] dbDataMethod() {
        String sql = "SELECT * FROM `coupons`;";
        List<Map<String, Object>> result = getDataList(url, sql);
        Object[][] files = new Object[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            files[i] = new Object[]{result.get(i)};
        }
        return files;
    }

    /**
     * ResultSet转map
     *
     * @param rs
     * @return
     */
    public static Map<String, Object> convertMap(ResultSet rs) {
        Map<String, Object> map = new TreeMap<String, Object>();
        try {
            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    map.put(md.getColumnName(i), rs.getObject(i));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                rs = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return map;
        }
    }

    public static List<Map<String, Object>> convertList(ResultSet rs) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {
            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();
            while (rs.next()) {
                Map<String, Object> rowData = new HashMap<String, Object>();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(md.getColumnName(i), rs.getObject(i));
                }
                list.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                rs = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
