<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="o" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>CRI - Bourse Régionale </title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="container">
		<div class="header">

			<div class="logo pull-left">

				 <img src="img/" alt="">
			</div>
			<div class="banner">

				<img src="img/banner.png" alt="">

			</div>
            
			<div class="navbar">
				<div class="navbar-inner">
					<a class="brand" href="#">CRI</a>
					<ul class="nav">
						<li class="active"><a href="#">Accueil</a></li>
						<li class="divider-vertical"></li>
						<li><a href="#">Statistique</a></li>
						<li class="divider-vertical"></li>
						<li><a href="#">Devenir Partenaire</a></li>
						<li class="divider-vertical"></li>
					<li class="dropdown">
				     <a href="#" class="dropdown-toggle" data-toggle="dropdown">
							Informations
						  <b class="caret"></b>
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
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span3">
						<!--Sidebar content-->

						<ul class="nav nav-list well">
							<li class="nav-header" class="navheader">Authentification</li>
							<form action="Authentification.aspx"  method="post" >    
							   <p>Quel est votre e-mail ?</p>
							   <input type="email" name="login" id="email" class="span14" />
							   <p>Votre mot de passe :</p>
							   <input type="password" name="password" id="pass" class="span14" />
							   <div class="checkbox">
								  <label>
								    <input type="checkbox" style="">se souvenir de moi 
								  </label>
								</div>
               
               
							  <button type="submit" style="text-align:right;margin:7px;" class='btn btn-primary'>Valider</button>
							</form>
     
      <form method="post" action="inscription.html">
     <div class="inscrire"> <p>pas encore inscrit? </p></div><button style="position:relative;left:2px;"type="submit" class="btn btn-success">S'inscrire</button>
     </form>
         
    

        
         

						</ul>
						<br>
						<ul class="nav nav-list well">
							<li class="nav-header">Partenaires</li>

							<li><a href="#"><i class='icon-chevron-right'></i>Partenaires nationaux</a></li>
							<li><a href="#"><i class='icon-chevron-right'></i>Partenaires internationaux</a></li>
							<li><a href="#"><i class='icon-chevron-right'></i>Rencontres BtoB</a></li>


						</ul>
					</div>

		<div class="span9">
						<!-- 1er partie -->
			<div class="well">

				<h2 style="color:#061739;">Bourse Régionale de Partenariat</h2>
							
					<table class="table table-striped">
								<tr>
                                     <th>Nationalité</th>
                                     <th>Présentation de l'organisme</th>
                                     <th>Secteur d'activité</th>
                                    
                               </tr>
                               
                          
                       <o:forEach items="${entreprises}" var="ob">
                       
                              <tr class="success"> <!-- error  / info  --> 
                               	  
                               	   <td>${ob.pays.nomPays}</td>
                               	   <td>${ob.description}</td>
                               	   <td>${ob.secteur.designiation}</td>
                               	 
							   </tr>
                       
                       </o:forEach>        
                              
                         
 
                   </table>
							
		<a href="inscription.html"><input type="button" value="Devenir membre> " class='btn btn-primary'></a>

 </div>

 <!--  deuxieme partie-->

						<div class="row-fluid">
							<div class="span4 well well-small">
								
								<h3>Titre 1</h3>
								<p style='text-align:justify'>
									Lorem ipsum dolor sit amet, consectetur adipisicing elit. Id, voluptate, ipsum dolore natus earum sit accusamus facilis .
								</p>
								<input type="button" value="Lire la suite > " class='btn btn-primary'>
							</div>
							<div class="span4 well well-small">
								
								<h3>Titre 2</h3>
								<p style='text-align:justify'>
									Lorem ipsum dolor sit amet, consectetur adipisicing elit. Id, voluptate, ipsum dolore natus earum sit accusamus facilis .
								</p>
								<input type="button" value="Lire la suite > " class='btn btn-danger'>
							</div>
							<div class="span4 well well-small">
								
								<h3>Titre 3</h3>
								<p style='text-align:justify'>
									Lorem ipsum dolor sit amet, consectetur adipisicing elit. Id, voluptate, ipsum dolore natus earum sit accusamus facilis .
								</p>
								<input type="button" value="Lire la suite > " class='btn btn-primary'>
							</div>
						</div>

					</div>
				</div>
			</div>	

		</div>

		<div class="footer well well-small">
			Copyright &copy; CRI 2015 . Tout droits réservés  

		</div>


	</div>






	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>