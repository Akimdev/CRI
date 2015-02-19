<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="o" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>CRI - Bourse Régionale </title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	
	<link rel="stylesheet" href="css/membr.css">

</head>
<body>
	<div class="container">
		<div class="header">
             <div class="logo pull-left"> </div>
             <div class="banner"><img src="img/banner.png" alt=""></div>
              <!-- Header  -->
              <div class="navbar">
				<div class="navbar-inner">
					<a class="brand" href="http://www.cri-agadir.ma/" style="color:#113769">CRI</a>
					<ul class="nav">
						<li><a href="Authentification.aspx" style="color:#113769">Accueil</a></li>
						<li class="divider-vertical"></li>
						<li><a  style="color:#113769"href="Statistique.aspx">Statistique</a></li>
						<li class="divider-vertical"></li>
						
					
						<li class="divider-vertical"></li>
					  
					     <li class="active" >
					        <a  style="color:#113769;" href="GestionUtilisateurs.aspx">Gestion des utilisateurs</a>
						</li>
						        <li class="divider-vertical"></li>
					 </ul>
                          <form action="" class='navbar-form'>
						  <input type="text" class='search-query span2'  placeholder='Votre recherche...'  x-webkit-speech />
						  <input type="button" onclick="DonnerPassword('ok');" value="Chercher" class='btn btn-info' >
                          </form>
                  </div>
			  </div>
			  </div><!-- fin du header -->
			</div><!-- fin du container -->

<div class="conteneur">

        <div class="container-fluid">
			<div class="row-fluid">
					
	   <div class="span3 well">
		    <ul class="moncompte nav nav-list">
					<li class="nav-header" class="navheader" style="font-family: Helvetica, Arial, 'lucida grande',tahoma,verdana,arial,sans-serif;font-weight:bold;text-align:center;color:#9197a3;">
						<a href="#" style="color:green"> <%= request.getSession().getAttribute("login") %> </a> vous êtes connecté
					</li>
								  
					<li class="divider"></li> 
		   </ul>
		   <ul class="moncompte nav nav-list">
	        
	         <li style="font-weight:bold;"><a href="AjouterUtilisateur.aspx" style=""> Ajouter utilisateur</a> </li>	
	         <li><a href="AjouterSecteur.aspx">Ajouter Secteur</a></li> 
	         <li><a href=""><span style="color:red">0 </span>Demandes de modification</a></li>
	         <li><a href="inscription.html"><span style="color:red">0 </span>Nouveaux message</a></li>
	         <li class="divider"></li> 
	         <li><a href="index.aspx"><button style="position:relative;left:2px;"type="submit" class="btn btn-inverse">Se déconnecter</button></a></li>   
	
		     </ul>		  
		</div>
					
					<div class="span9 well" >
						


    <!-- Tableau au user public  -->
					<div style="overflow:scroll">		
					<table class="table table-striped">
								<tr>
                                     <form action="" id="myform" method="get" >   
                                    	                             
                                    		 <th></th>
		                                     <th><input type='text' id="login" name="login"  Placeholder="Login"  style="max-width:150px;" ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
											 <th><input type='text' id="password" name="password"  Placeholder="Password" style="max-width:130px" ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
		                                     <th><input type='text' id="organisme" name="organisme"  Placeholder="l'Organisme" style="max-width:220px;"><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
		                                     <th><input type='text' id="type" name="type"  Placeholder='Type' style="max-width:205px" ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
		                                     <th><input type='text' id="profile" name="profile"  Placeholder='Profile'  style="max-width:155px;"><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>                                    
		                                     <th><input type='text' id="fonction" name="fonction"  Placeholder='Fonction'  style="max-width:210px;"><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
											 <th>La source</th>
		                            </form>  
		                            
                               </tr>
							  <% int i = 1;
							      String varClass ;
							  %>
							  
                              <o:forEach items="${utilisateurs}" var="ob">
			                    <% if(i%2==0)
			                    	{
			                    	   varClass = "error";
			                        }else{
			                        	varClass = "success";
			                        }
			                    i++;
			                    %>
			                              <tr class="<%=varClass%>"> <!-- error  / warning / info  --> 
			                               	   <td> 
				                               	   <form action="SupprimerUtilisateur.aspx">
				                               	         <input type="hidden" name="idUtilisateur" value="${ob.idUtilisateur}">
				                               	   		 <button type="submit"  class='btn btn-danger'>
						                               	      		 <i class="icon-remove"></i>
						                               	  </button> 
	                               	               </form>
                               	               </td>
 			                               	   <td>${ob.login}</td>
			                               	   <td>${ob.password}</td>
			                               	   <td>${ob.organisme}</td>
			                               	   <td>${ob.type}</td>
				                               <td>${ob.profile}</td>
			                               	   <td>${ob.fonction}</td>
			                               	   <td>
				                               	     <form action="SourceUtilisateur.aspx">
				                               	        <input type="hidden" name="idUtilisateur" value="${ob.utilisateur.idUtilisateur}">
				                               	   		<button type="submit" style="text-align:right;margin:7px;" class='btn btn-info'>+</button>
	                               	              	 </form>
			                               	   </td>
			                               	 
										   </tr>
			                   
                              </o:forEach>        
                              
                              
                       </table>
                   </div>
                  
                  
                  
                  
                  
                  
                  
                  
							
		<p>
<p style="color:#113769;"> *nb : vous pouvez contacter les entreprise via leur adresses email disponible sur le tableau </p>
		</p>

       </div>
       
      </div>
    </div>
  </div>
</div>
   






					<div class="footer well well-small">
			Copyright &copy; CRI 2015 . Tout droits réservés  
		</div>
        






	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
    <script language="Javascript"> 
  
	
			
			 $('img.submitableimage').click(function(){
				      $('#myform').submit();
			 });
			
		
			 
			 
    </script>

</body>
</html>