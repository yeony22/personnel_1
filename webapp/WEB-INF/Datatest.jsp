<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 
        <%!
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/practice1";
        String uid = "root";
        String upw = "1234";
        String query = "select * from personnel";
        %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
 
    <%
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, uid, upw);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
 
            while(resultSet.next()){
                String id = resultSet.getString("ID");
                String pw = resultSet.getString("NAME");
                String phone = resultSet.getString("DEPT");
                out.println("ID : " + id + ", PW : " + pw + ", PHONE : " + phone + "<br/>");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{ //모든 자원 해제
            try{
                if(resultSet != null) resultSet.close();
                if(statement != null) statement.close();
                if(connection != null) connection.close();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    %>
</body>
</html>

