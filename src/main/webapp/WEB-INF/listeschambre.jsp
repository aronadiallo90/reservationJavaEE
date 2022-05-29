
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
<link rel = "stylesheet" href="listeschambre.css"  type="text/css" >

</head>
<body>
    
    


<div class="contenir">
      <div class="entete">
         <h3 data-text ="PAVILLONS">CHAMBRES</h3>

      </div>
            <div class = "rien">
               <div class="etudiant">
                  Bienvenu(e) <c:out value="${ etudiant.prenom }" /> <c:out value="${ etudiant.nom }" /><br><br>
                  Numcarte : <c:out value="${ etudiant.numcarte }" /> <br><br>
                   <c:out value="${ etudiant.niveau }" /> <c:out value="${ etudiant.departement }" />
                  
               </div>

                          <c:if test="${reserver}" var="siReservation" >
                         	 <div class ="annulerreservation" >
                         	 	 <a href="AnnulerReservation"  >
    			            	<button type="button" class="btn btn-danger">Annuler Reservation</button>
    			            	 </a>
    			             </div>	 
                         </c:if>


            </div>
        

         

      <div class="pavillon">   

              <c:forEach var="chambre" items="${ chambres }">
                  
                  <div class="pave">
                  				 <img src="images.jpg" width="100%"> 
                                 <a href="EtudiantServlet?id_chambre=<c:out value="${ chambre.id_chambre }" />&maxplace=<c:out value="${ chambre.maxplace }" /> "> 
                                    Chambre <c:out value="${ chambre.nomchambre }" />
                                 </a>
                   </div>
                  
              </c:forEach>
                              

                              
                           
          </div>

         


</div>
</body>
</html>