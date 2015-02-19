<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
					<a class="brand" href="#" style="color:#113769">CRI</a>
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
		<li class="nav-header" class="navheader" style="font-family: Helvetica, Arial, 'lucida grande',tahoma,verdana,arial,sans-serif;font-weight:bold;text-align:center;color:#9197a3;">
			  Mon compte</li>
			  <ul class="moncompte nav nav-list">
			  <li class="divider"></li> 
	   <ul class="moncompte nav nav-list">
         <li style="font-weight:bold;"><a href="#" style="">Notification</a></li>	
         <li><a href="">Mes Partenaires</a></li> 
         <li><a href="">Nouveautés</a></li>
         <li><a href="">Contacter l'administrateur</a></li>
         <li><a href="parametre.html">Mes Paramétres</a></li>
         <li class="divider"></li> 
         <li><a href="index.html"><button style="position:relative;left:2px;"type="submit" class="btn btn-inverse">Se dÃ©connecter</button></a></li>   

	     </ul>		  
					</div>
					
					<div class="span9 well" >
						<span><h3 style="color:#113769;">Mes Paramètres générals</h2>
							<table class="table">
                                 <tr>
                                     
                                     <th><a href="#">Paramètres</a></th>
                                     <th><a href="#">Contenu</a></th>
                                     <th><a href="#">Modifier</a></th>
                                </tr>
                                  
                              <tr class="info" >
                               	   <td>Nom</td>
                               	   <td style="min-width:200px" ></td>
                               	   <td><button type="submit" style="text-align:right;margin:7px;" class='btn btn-success'>Modifier</button></td>
                              </tr>
                              <tr class="info" >
                               	   <td>Email</td>
                               	   <td style="min-width:200px" ></td>
                               	   <td><button type="submit" style="text-align:right;margin:7px;" class='btn btn-success'>Modifier</button></td>
                              </tr>
                              <tr class="info" >
                               	   <td>Demande</td>
                               	   <td style="min-width:200px" ></td>
                               	   <td><button type="submit" style="text-align:right;margin:7px;" class='btn btn-success'>Modifier</button></td>
                              </tr>
                              <tr class="info" >
                               	   <td>Secteur</td>
                               	   <td style="min-width:200px" ></td>
                               	   <td><button type="submit" style="text-align:right;margin:7px;" class='btn btn-success'>Modifier</button></td>
                              </tr>
                              <tr class="info" >
                               	   <td>Sous-secteur</td>
                               	   <td style="min-width:200px" ></td>
                               	   <td><button type="submit" style="text-align:right;margin:7px;" class='btn btn-success'>Modifier</button></td>
                              </tr>
                          </table>

						</div>
						</div>


					<div class="footer well well-small">
			Copyright &copy; CRI 2015 . Tout droits réservés  
		</div>
        






	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>