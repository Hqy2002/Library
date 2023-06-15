package com.library.servlet;

import java.sql.*;

public class executeSQL {
    Connection conn;
    String sqlString;
    Statement stmt;

    executeSQL() throws ClassNotFoundException, SQLException {

           Class.forName("com.mysql.cj.jdbc.Driver");
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "");
           stmt = conn.createStatement();

       }


       public String getResult(String sqlString) throws SQLException {
        String result = "";
        ResultSet rs ;
           try {
               rs = stmt.executeQuery(sqlString);
               ResultSetMetaData rsmd = rs.getMetaData();
               int columnCount = rsmd.getColumnCount();
               while (rs.next()) {
                   for (int i = 1; i <= columnCount; i++) {
                       Object value = rs.getObject(i);
                       result += value.toString();
                       result +="\t";
                   }
                   result +="\n";

               }

           } catch (Exception e) {
               result ="error,语句错误";
           }


        return result;
       }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        executeSQL executeSQL = new executeSQL();
        System.out.println(executeSQL.getResult("select * from boo"));

    }


}
