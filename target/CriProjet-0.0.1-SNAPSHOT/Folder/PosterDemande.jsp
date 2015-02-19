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
			         <li><a href="Authentification.aspx" style="">Mes demandes de partenariat</a></li>	
			         <li class="active"><a href="PosterDemande.aspx">Poster une nouvelle demande</a></li>
			         <li><a href="">Contacter l'administrateur</a></li>
			         <li><a href="parametre.html">Mes Paramètres</a></li>
			         <li class="divider"></li> 
			         <li><a href="index.aspx"><button style="position:relative;left:2px;"type="submit" class="btn btn-inverse">Se déconnecter</button></a></li>   
			  </ul>		  
	  </div>
<div class="span9 well" >	
	<form class="form-horizontal" action="ValiderDemandeUtilisateur.aspx" method="get">				
		

		 		<div class="control-group">
		     <label class="control-label" for="inputPassword">Secteur d'activité</label>
		          <div class="controls">
		          
					<select class="form-control" id="Secteur2"  onChange ="fct2()" >
						 <o:forEach items="${SurSecteurs}" var="ob">
						 	<option value="${ob.idSecteur }">${ob.designiation}</option>
					     </o:forEach>
					</select>
				
		         </div>
	
	   </div>
			   <div class="control-group">
			     <label class="control-label" for="inputPassword">Sous Secteur</label>
			          <div id="SousSecteurs2" class="controls">
			          
						 <select class="form-control"  name="idSecteur">
							 <o:forEach items="${SousSecteurs}" var="ob">
							 	<option value="${ob.idSecteur }">${ob.designiation}</option>
						     </o:forEach>
						</select>
					  
					  </div>
			 
			   </div>


			   <div class="control-group">
			   
			     <label class="control-label" for="inputPassword">Type de partenariat</label>
			          
			          <div class="controls">
			             
						 <select class="form-control"  name="idPartenariat" >
							 <o:forEach items="${Partenariats}" var="ob">
							 	<option value="${ob.idPartenariat }">${ob.designiation}</option>
						     </o:forEach>
						</select>
					  
					 </div>
			   
			    </div>


			    <div class="control-group">
					<label class="control-label" for="inputPhone">Votre demande</label>
					<div class="controls">
						<label style="vertical-align: top;">Formuler votre demande de partenariat</label> 
						<textarea rows="4" cols="50" name="description" required></textarea> 
					</div>
			    </div>
			  
			   <div class="control-group">
				   <label class="control-label" for="inputPassword">Engagement</label>
					     <div class="controls">
							 <select class="form-control" name="engagement">
								  <option value="Longue terme">Longue terme</option>
								  <option value="Moyen terme">Moyen terme</option>
								  <option value="Court terme">court terme</option>
							</select>
					     </div>
				</div>
				
				<div id="ValiderPart" class="control-group">
				    <div class="controls">
				      <button type="submit" class="btn btn-success"  style="margin:7px;">Poster votre demande au public</button>
				    </div>
			    </div>
       </form>        	
		
       </div>
      </div>
    </div>
 


  <div class="footer well well-small">
			Copyright &copy; CRI 2015 . Tout droits réservés  
  </div>
  
 </div>
 
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
	<script>
	
	function fct2()
	{
		var xmlhttp;
		var elt =  document.getElementById("Secteur2");
		
		xmlhttp = new XMLHttpRequest;
		
		xmlhttp.onreadystatechange = function (){
			
			if( xmlhttp.readyState == 4  & xmlhttp.status == 200 )
			{
				document.getElementById("SousSecteurs2").innerHTML = xmlhttp.responseText;
			}
			
		}
		
		
		xmlhttp.open("GET", "SousSecteurs.aspx?idSecteur="+elt.value, true);
		xmlhttp.send();
		
		


	}

	
	</script>
</body>
</html>