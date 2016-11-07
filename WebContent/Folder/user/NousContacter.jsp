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