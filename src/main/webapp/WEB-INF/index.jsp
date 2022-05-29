
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="java.sql.*" %>
<%@ page import ="com.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>database</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel = "stylesheet" href="index.css"  type="text/css" >

</head>
<body>
    
    


<div class="contenir">
      <div class="entete">
         <h3 data-text ="PAVILLONS">PAVILLONS</h3>

      </div>
            <div class = "rien">
               <div class="etudiant">
                  Bienvenu(e) <c:out value="${ etudiant.prenom }" /> <c:out value="${ etudiant.nom }" /><br><br>
                  Numcarte : <c:out value="${ etudiant.numcarte }" /> <br><br>
                  Niveau :<c:out value="${ etudiant.niveau }" />  <br><br>
                  Departement :<c:out value="${ etudiant.departement }" />
                  
                  
                    <c:if test="${chreserver}" var="siCheservation" >
                         	 vous avez reserver dfg.
                         </c:if>
                  
               </div>

               
                 
                         <c:if test="${reserver}" var="siReservation" >
                         	 <div class ="annulerreservation" >
                         	 	 <a href="AnnulerReservation"  >
    			            	<button type="button" class="btn btn-danger">Annuler Reservation</button>
    			            	 </a>
    			             </div>	 
                         </c:if>
                 
               


            </div>
        
<br> <br>
         

      <div class="pavillon">   

              <c:forEach var="pavillon" items="${ pavillons }">
                  
                  <div class="pave">
                                 <img src="pavillon-ucad.jpg" width="100%">              				
                                 <a  href="ChambreServlet?id_pavillon=<c:out value="${ pavillon.id_pavillon }" />"> 
                                    Pavillon <c:out value="${ pavillon.nompavillon }" />
                                 </a>
                   </div>
                  
              </c:forEach>
                              

                              
                           
          </div>

         


</div>
</body>
</html>