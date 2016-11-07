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

<div>

        <div  class="container-fluid">
			<div class="row-fluid">
					
	   <div class="span3 well">
		    <ul class="moncompte nav nav-list">
					<li class="nav-header" class="navheader" style="font-family: Helvetica, Arial, 'lucida grande',tahoma,verdana,arial,sans-serif;font-weight:bold;text-align:center;color:#9197a3;">
						<a href="#" style="color:green"> <%= request.getSession().getAttribute("login") %> </a> vous êtes connecté
					</li>
								  
					<li class="divider"></li> 
		   </ul>
		   <ul class="moncompte nav nav-list">
	        
	         <li ><a href="AjouterUtilisateur.aspx" style=""> Ajouter utilisateur</a> </li>	
	         <li style="font-weight:bold;"><a href="AjouterSecteur.aspx">Ajouter Secteur</a></li> 
	         <li><a href=""><span style="color:red">0 </span>Demandes de modification</a></li>
	         <li><a href="inscription.html"><span style="color:red">0 </span>Nouveaux message</a></li>
	         <li class="divider"></li> 
	         <li><a href="index.aspx"><button style="position:relative;left:2px;"type="submit" class="btn btn-inverse">Se déconnecter</button></a></li>   
	
		     </ul>		  
		</div>
					
					<div class="span9 well" >
					
					<table style="width:100%;border:1px solid red">
							<tr>
								<td>		
										<br>	
							     		<ul class="moncompte nav nav-list">
												<li class="nav-header" class="navheader" style="font-family: Helvetica, Arial, 'lucida grande',tahoma,verdana,arial,sans-serif;font-weight:bold;text-align:left;color:#9197a3;">
												 Ajout d'un nouveau secteur <span style="color:green"> ${msgAjSect}</span>
												</li>
															  
												<li class="divider"></li> 
									   </ul>
							
							                  <br>
							                  
							               <form class="form-horizontal" action="ValiderSecteur.aspx" method="get">				
									
													<div class="control-group">
													    <label class="control-label" for="inputName">Secteur</label>
													    <div class="controls">
													      <input type="text" name="designiation" placeHolder="Designiation du secteur" required/>
													    </div>
													</div>
													
													<div id="ValiderPart" class="control-group">
													    <div class="controls">
													      <button type="submit" class="btn btn-success"  style="margin:7px;">Ajouter le secteur</button> 
													    </div>
												    </div>
												    
											</form>
								</td>
									
								<td>
								
								<br>
										<ul class="moncompte nav nav-list">
										<li class="nav-header" class="navheader" style="font-family: Helvetica, Arial, 'lucida grande',tahoma,verdana,arial,sans-serif;font-weight:bold;text-align:left;color:#9197a3;">
										 Suppression d'un secteur <span style="color:red"> ${msgSupSect}</span>
										</li>
													  
										<li class="divider"></li> 
							  		 </ul>
					
					                  <br>
					                  
						               <form class="form-horizontal" action="SupprimerSecteur.aspx" method="get">				
								
											    <div class="control-group">
												     <label class="control-label" for="inputPassword">Secteur d'activité</label>
												     
												        <div class="controls">
												          
																<select class="form-control"   name="idSecteur" >
																	 <o:forEach items="${SurSecteurs}" var="ob">
																	 	<option value="${ob.idSecteur }">${ob.designiation}</option>
																     </o:forEach>
																</select>
															
														</div>
												</div>
												
												<div id="ValiderPart" class="control-group">
												    <div class="controls">
												      <button type="submit" class="btn btn-success"  style="margin:7px;">Supprimer le secteur</button> 
												    </div>
											    </div>
											    
										</form>
								</td>
						</tr>
			
			
			
				<tr>
			
					<td>
			
						<br>
							    <ul class="moncompte nav nav-list">
										<li class="nav-header" class="navheader" style="font-family: Helvetica, Arial, 'lucida grande',tahoma,verdana,arial,sans-serif;font-weight:bold;text-align:left;color:#9197a3;">
										 Ajout d'un nouveau sous-secteur <span style="color:green">${msgAjSousSect}</span>
										</li>
													  
										<li class="divider"></li> 
							   </ul>
							  	
							<br>
							<form class="form-horizontal" action="ValiderSousSecteur.aspx" method="get">
							
					 		<div class="control-group">
							     <label class="control-label" for="inputPassword">Secteur d'activité</label>
							     
							        <div class="controls">
							          
											<select class="form-control" name="idSurSecteur" >
												 <o:forEach items="${SurSecteurs}" var="ob">
												 	<option value="${ob.idSecteur }">${ob.designiation}</option>
											     </o:forEach>
											</select>
										
									</div>
							</div>
				
				  			<div class="control-group">
							    <label class="control-label" for="inputName">Sous-Secteur</label>
							    <div class="controls">
							      <input type="text" name="designiation" placeHolder="Designiation du sous-secteur" required/>
							    </div>
							</div>
				  			
			
							<div id="ValiderPart" class="control-group">
							    <div class="controls">
							      <button type="submit" class="btn btn-success"  style="margin:7px;">Ajouter le sous-secteur</button> 
							    </div>
						    </div>
			       </form>        	
		
             </td>
             
             <td>
             			<br>
								    <ul class="moncompte nav nav-list">
										  <li class="nav-header" class="navheader" style="font-family: Helvetica, Arial, 'lucida grande',tahoma,verdana,arial,sans-serif;font-weight:bold;text-align:left;color:#9197a3;">
												 Suppression d'un sous-secteur <span style="color:red">${msgSupSousSect}</span>
										  </li>
															  
										  <li class="divider"></li> 
								    </ul>
									  	
									<br>
						 <form class="form-horizontal" action="SupprimerSousSecteur.aspx" method="get">
									
									 <div class="control-group">
												     <label class="control-label" for="inputPassword">Secteur d'activité</label>
												          <div class="controls">
												          
													<select class="form-control" id="Secteur"  onChange ="fct()" name="SurSecteur" >
														 <o:forEach items="${SurSecteurs}" var="ob">
														 	<option value="${ob.idSecteur }">${ob.designiation}</option>
													     </o:forEach>
													</select>
												
												</div>
									</div>
											   
									<div class="control-group">
										     <label class="control-label" for="inputPassword">Sous Secteur</label>
										          <div id="SousSecteurs" class="controls">
										          
													 <select class="form-control"  name="idSecteur">
														 <o:forEach items="${SousSecteurs}" var="ob">
														 	<option value="${ob.idSecteur }">${ob.designiation}</option>
													     </o:forEach>
													</select>
												  
												  </div>
										 
									</div>
								  			
					
									<div id="ValiderPart" class="control-group">
									    <div class="controls">
									      <button type="submit" class="btn btn-success"  style="margin:7px;">Supprimer le sous-secteur</button> <span style="color:green">${msgSousSect}</span>
									    </div>
								    </div>
					       </form>  
		             
             
             		</td>
              
        	  </tr>
          
       </table>        
                  


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
  
		
			function fct()
			{
				var xmlhttp;
				var elt =  document.getElementById("Secteur");
				
				xmlhttp = new XMLHttpRequest;
				
				xmlhttp.onreadystatechange = function (){
					
					if( xmlhttp.readyState == 4  & xmlhttp.status == 200 )
					{
						document.getElementById("SousSecteurs").innerHTML = xmlhttp.responseText;
					}
					
				}
				
				
				xmlhttp.open("GET", "SousSecteurs.aspx?idSecteur="+elt.value, true);
				xmlhttp.send();
				
				
			}

			 
    </script>

</body>
</html>