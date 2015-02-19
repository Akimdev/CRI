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


			<div class="logo pull-left">

				 
			</div>
			<div class="banner">

				<img src="img/banner.png" alt="">

			</div>
			
<div class="container">
		<div class="header">
			<div class="navbar">
				<div class="navbar-inner">
					<a class="brand" href="http://www.cri-agadir.ma/" style="color:#113769">CRI</a>
					<ul class="nav">
						<li><a href="index.aspx" style="color:#113769">Accueil</a></li>
						<li class="divider-vertical"></li>
						<li><a  style="color:#113769"href="">Statistique</a></li>
						<li class="divider-vertical"></li>
						<li><a style="color:#113769" href="inscription.aspx?idEntreprise=1">Devenir Partenaire</a></li>
						<li class="divider-vertical"></li>
					    <li class="active"><a  style="color:#113769;"href="NousContacter.aspx" >Nous-Contacter</a></li>
						<li class="divider-vertical"></li>
					 </ul>

					<form action="" class='navbar-form'>
						<input type="text" class='search-query span2'  placeholder='Votre recherche...'  x-webkit-speech />
						<input type="button" value="Chercher" onclick="load()" class='btn btn-info' >

					</form>


				</div>
			</div>
		</div>
</div>

			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span3">
						
						<!--Authentification-->

						<ul class="nav nav-list well">
							<li class="nav-header" class="navheader" style="font-family:OpenSansCondensed;text-align:center;color:#9197a3;">Authentification</li>
							 <li class="divider"></li> 
	  <form method="post" action="Authentification.aspx">    
           
               <p>Email :</p>
               <input type="text" name="login" id="email" class="span14" placeholder="email@email.com" />
               <p>Mot de passe :</p>             
               <input type="password" name="password" id="pass" class="span14" />
               <p style="color:red"> ${erreur_msg}</p>
		       <div class="checkbox">
		             <label>
		              <input type="checkbox" style="">se souvenir de moi 
		             </label>
               </div>
               
               
              <button type="submit" style="text-align:right;margin:7px;" class='btn btn-primary'>Connexion</button>
      </form>
      
      
      <li class="divider"></li> 
      <form method="post" action="inscription.aspx">
            <input type="hidden" name="idSurSecteur" value="1">
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

		
						<!-- Bloc Principal  -->

		<div class="span9">
			
			<div class="well" style="text-align:center">
                     <!-- Titre et selection  -->
      <form>  
			<table width="70%" >	
				  <tr>	
				      <td> Nom :</td> 
				      <td>
			                
							      <input type="text"  style="width:100%" name="nom" placeHolder="Votre Nom" required/>
							    
					  </td>
			      </tr>
			      
			      
			        <tr>	
				      <td> E-mail :</td> 
				      <td>
			                <div class="control-group">
							    <div class="controls">
							      <input type="text" style="width:100%" name="email" placeHolder="Votre E-mail" required/>
							    </div>
							</div>
					  </td>
			      </tr>
			      
			      
			      <tr>        
			            <td> Objet : </td>
			            <td>   
			               <div class="control-group">
							    <div class="controls">
							      <input type="text" style="width:100%" name="objet" placeHolder="L'objet du message" required/>
							    </div>
							</div>
			            </td>   
			       </tr>
			       
			       <tr>        
			            <td> Message : </td> 
			            <td >  
			               <div class="control-group">
							    <div class="controls">
							      <textarea rows="10" style="width:100%" name="message" placeholder="Votre message ici" required></textarea>
							    </div>
						   </div>
					    </td>
				   </tr>
			  
             </table>
                   
              <div id="ValiderPart" class="control-group">
			    <div class="controls">
			      <button  class="btn btn-success"  style="margin:7px;">Envoyer</button>
			    </div>
		      </div>    
        </form>                
                       <!-- Footer  -->
            </div>
		<div class="footer well well-small">
			Copyright &copy; CRI 2015 . Tout droits réservés  
		</div>
        </div>


</div>
</div>



	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
	<script>
	
	function load()
	{
		alert("1");
		var xmlHttp;
		alert("2");
		xmlHttp = new XMLHttpRequest();
		alert("3");
		
		xmlhttp.onreadystatechange = function (){
			alert("4");
			if( xmlhttp.readyState == 4  & xmlhttp.status == 200 )
			{
				document.getElementById("DemandesDiv").innerHTML = xmlhttp.responseText;
			}
			
		}
		
		
		
		
	 //xmlHttp.open("GET","FilterDemandes.aspx?date="+document.getElementById("date").value+"&nomPays="+document.getElementById("nomPays").value +"&designiationSecteurE="+document.getElementById("designiationSecteurE").value +"&descriptionEntreprise="+document.getElementById("descriptionEntreprise").value+"&designiationSecteurD="+document.getElementById("designiationSecteurD").value+"&designiationPartenariat="+document.getElementById("designiationPartenariat").value +"&descriptionDemande="+document.getElementById("descriptionDemande").value+"&engagement="+document.getElementById("engagement").value,true);	
	 xmlhttp.open("GET", "SousSecteurs.aspx?idSecteur=1", true);
	 xmlhttp.send();
	  
	}
	
	

	
	   $('img.submitableimage').click(function(){
	      $('#myform').submit();
	   });

	</script>
	
	
	
	
</body>
</html>