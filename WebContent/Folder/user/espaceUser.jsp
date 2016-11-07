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
						<li class="active"><a href="#" style="color:#113769">Accueil</a></li>
						<li class="divider-vertical"></li>
						<li><a  style="color:#113769"href="#">Statistique</a></li>
						<li class="divider-vertical"></li>
						<li><a style="color:#113769" href="#">Devenir Partenaire</a></li>
						<li class="divider-vertical"></li>
					    <li class="dropdown"><a  style="color:#113769;"href="    #" class="dropdown-toggle" data-toggle="dropdown"    >Informations<b class="caret"></b>
					        </a>
					           <ul class="dropdown-menu">
								<li><a href="#">Nous-Contacter</a></li >
								<li><a href="#">Devenir Partenaire</a></li>
								<li><a href="#">Center Régional d'Investissement</a></li>
					           </ul>
						        </li>
						        <li class="divider-vertical"></li>
					 </ul>
                          <form action="" class='navbar-form'>
						  <input type="text" class='search-query span2'  placeholder='Votre recherche...'  x-webkit-speech />
						  <input type="button" value="Chercher" class='btn btn-info' >
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
				     <li><a href="MonProfile.aspx">Mon profile</a></li> 
			         <li class="active"><a href="Authentification.aspx" style="">Mes demandes de partenariat</a></li>	
			         <li><a href="PosterDemande.aspx">Poster une nouvelle demande</a></li>
			         <li><a href="NousContacter.aspx">Contacter l'administrateur</a></li>
			         <li><a href="parametre.html">Mes Paramètres</a></li>
			         <li class="divider"></li> 
			         <li><a href="index.aspx"><button style="position:relative;left:2px;"type="submit" class="btn btn-inverse">Se déconnecter</button></a></li>   
			  </ul>		  
					</div>
					
					<div class="span9 well" >
						<span><h2 style="color:#113769;">Bourse Régionale de Partenariat</h2>

						</span>
                   <!-- Tableau au user public  -->
			  <div >		
					<table class="table table-striped">
							
							   <tr>
                                
                                     
									 <th></th>
									 <th>Date de la demande</th>
                                     <th>Secteur objet de partenariat</th>
                                     <th>Partenaire recherché</th>
                                     <th>Description de la demande</th>
									 <th>Engagement</th>
                              
                               </tr>
                                    
                              <o:forEach items="${demandes}" var="ob">
                       
                              <tr class="success"> <!-- error  / warning / info  --> 
                               	  
                               	   <td>
                               	    	<form action="SupprimerUserDemande.aspx">
				                               <input type="hidden" name="idEntreprise" value="${ob.id.idEntreprise}">
				                               <input type="hidden" name="idSecteur" value="${ob.id.idSecteur}">
				                               <input type="hidden" name="idPartenariat" value="${ob.id.idPartenariat}">
				                               <button type="submit"  class='btn btn-danger'>
						                               <i class="icon-remove"></i>
						                       </button> 
	                               	    </form>
                               	   </td>
                               	   <td>${ob.date}</td>
                               	   <td>${ob.secteur.designiation}</td>
                               	   <td>${ob.partenariat.designiation}</td>
                               	   <td>${ob.description}</td>
                               	   <td>${ob.engagement}</td>
                               	 
							   </tr>
                       
                              </o:forEach>  
                              
                               
                       </table>
                   </div> <!-- fin du tableau -->
							
		
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
</body>
</html>