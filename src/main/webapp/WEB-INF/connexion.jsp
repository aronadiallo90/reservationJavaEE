
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import ="java.sql.*" %>
<%@ page import ="com.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel = "stylesheet" href="connexion.css"  type="text/css" >
</head>
 <body>
<h1>CODIFICATION 2021</h1>
        <div id="container">
            <!-- zone de connexion -->
            
            <form action="index">
                <h2>S'authentifier</h2>
                
               

                <label><b>ID-CARTE</b></label>
               
                <input type="text" placeholder="exp:0000T5M" name="numcarte" required>

                <input type="submit" id='submit' value='LOGIN' >
                
            </form>
        </div>

</body>
</html>
