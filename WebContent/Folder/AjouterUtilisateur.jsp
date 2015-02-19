<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="o" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>CRI - Bourse R�gionale </title>
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
						<a href="#" style="color:green"> <%= request.getSession().getAttribute("login") %> </a> vous �tes connect�
					</li>
								  
					<li class="divider"></li> 
		   </ul>
		   <ul class="moncompte nav nav-list">
	        
	         <li style="font-weight:bold;"><a href="" style=""> Ajouter utilisateur</a> </li>	
	         <li><a href="AjouterSecteur.aspx">Ajouter Secteur</a></li> 
	         <li><a href=""><span style="color:red">0 </span>Demandes de modification</a></li>
	         <li><a href="inscription.html"><span style="color:red">0 </span>Nouveaux message</a></li>
	         <li class="divider"></li> 
	         <li><a href="index.aspx"><button style="position:relative;left:2px;"type="submit" class="btn btn-inverse">Se d�connecter</button></a></li>   
	
		     </ul>		  
		</div>
					
					<div class="span9 well" >
						


                  
               <form class="form-horizontal" action="ValiderUtilisateur.aspx" method="get">				
		
				<div class="control-group">
				    <label class="control-label" for="inputName">Login</label>
				    <div class="controls">
				      <input type="text" name="login" placeHolder="Login" required/>
				    </div>
				</div>

				<div class="control-group">
				    <label class="control-label" for="inputName">Mot de passe</label>
				    <div class="controls">
				      <input type="text" name="password" placeHolder="Mot de passe" required/>
				    </div>
				</div>

		 		<div class="control-group">
		    		 <label class="control-label" for="inputPassword">Profile</label>
			          <div class="controls">
			          
						<select class="form-control" name="profile" >
							 
							 <option value="Utilisateur">Utilisateur</option>
							 <option value="Directeur">Directeur</option>
							 <option value="Administrateur">Administrateur</option>
						 
						</select>
					
			         </div>
		        </div>
	
	  			<div class="control-group">
				    <label class="control-label" for="inputName">Organisme</label>
				    <div class="controls">
				      <input type="text" name="organisme" placeHolder="l'Organisme" required/>
				    </div>
				</div>
	  	
			    <div class="control-group">
		    		 <label class="control-label" for="inputPassword">Type</label>
			          <div class="controls">
			          
						<select class="form-control" name="type"  >
							 
							 <option value="Representation diplomatique �trang�re au maroc">Representation diplomatique �trang�re au maroc</option>
							 <option value="Representation diplomatique marocaine � l'�trang�re">Representation diplomatique marocaine � l'�trang�re</option>
							 <option value="Chambre professionnel">Chambre professionnel</option>
							 <option value="Association professionnelle">Association professionnelle</option>
							 <option value="Administration">Administration</option>
						 
						</select>
					
			         </div>
		        </div>

				
				<div class="control-group">
				    <label class="control-label" for="inputName">Fonction</label>
				    <div class="controls">
				      <input type="text" name="fonction" placeHolder="Fonction" required/>
				    </div>
				</div>
				
				<div id="ValiderPart" class="control-group">
				    <div class="controls">
				      <button type="submit" class="btn btn-success"  style="margin:7px;">Valider l'ajout</button>
				    </div>
			    </div>
       </form>        	
		
                  
                  
                  
							
		<p>
<p style="color:#113769;"> *nb : vous pouvez contacter les entreprise via leur adresses email disponible sur le tableau </p>
		</p>

       </div>
       
      </div>
    </div>
  </div>
</div>
   






					<div class="footer well well-small">
			Copyright &copy; CRI 2015 . Tout droits r�serv�s  
		</div>
        






	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
    <script language="Javascript"> 
  
			function ValiderDemande(elem) 
			{ 
					// Quel est l'�tat actuel ? 
					document.getElementById(elem).action = "ValiderDemande.aspx"; 
					
			} 
			
			
			
			function SupprimerDemande(elem) 
			{ 
					// Quel est l'�tat actuel ? 
					document.getElementById(elem).action = "SupprimerDemande.aspx"; 	
					
			} 
			
			 $('img.submitableimage').click(function(){
				      $('#myform').submit();
			 });
			
			function DonnerPassword(val)
			{ 
				var pass = document.getElementById(val+'password');
				//var passtd = document.getElementById(val+'passwordtd');
				
				if( pass.disabled )
					//passtd.innerHTML = '<input type="text" id="'+val+'password"  name="passwordpassword" placeholder="Mot de passe" required/>';
					pass.disabled = false;
				else
					//passtd.innerHTML = '<input type="text" id="'+val+'password"  placeholder="Mot de passe"  disabled />';
				    pass.disabled = true;
				    
				var prof = document.getElementById(val+'profile');
				//var proftd = document.getElementById(val+'profiletd');
				
				if( prof.disabled )
					//proftd.innerHTML = '<select id="'+val+'profile" name="profile" ><option selected>Utilisateur Privil�gi�</option> <option>Directeur</option> <option>Administrateur</option> </select>';
				    prof.disabled = false;
				else
					//proftd.innerHTML = '<select id="'+val+'profile"  disabled ><option>Utilisateur Privil�gi�</option> <option>Directeur</option> <option>Administrateur</option> </select>';
					prof.disabled = true;
			}
			 
			 
    </script>

</body>
</html>