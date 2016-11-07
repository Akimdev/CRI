<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>


<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>CRI - Inscription  </title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/style.css">
	

</head>
<body>
	
		<div class="header">

			<div class="logo pull-left">

				 
			</div>
			<div class="banner">

				<img src="img/banner.png" alt="">

			</div>

			<div class="navbar">
				<div class="navbar-inner">
					<a class="brand" href="#">CRI</a>
					<ul class="nav">
						<li ><a href="index.aspx">Accueil</a></li>
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
             <br> <br> 
						
						Votre opération est en cours de validation par notre  équipe<br><br>
						Vous receverez un mail sur l'adresse <a style="color:blue"> ${mail}</a> dés sa validation	

              <br> <br> <br>  <br> <br> 
              
  <div class="footer well well-small">
			Copyright &copy; CRI 2015 . Tout droits réservés  
 </div>
</div>



	</body>
</html>