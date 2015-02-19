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
			<div class="navbar" style="text-align: center">
			
				<div class="navbar-inner" style="text-align: center" >
				
					<a class="brand"  href="http://www.cri-agadir.ma/" style="color:#113769">CRI</a>
					
					<ul class="nav" >
						<li class="active"><a href="" style="color:#113769">Accueil</a></li>
						<li class="divider-vertical"></li>
						<li><a  style="color:#113769"href="">Statistique</a></li>
						<li class="divider-vertical"></li>
						<li><a style="color:#113769" href="inscription.aspx?idEntreprise=1">Devenir menmbre</a></li>
						<li class="divider-vertical"></li>
					    <li class="dropdown"><a  style="color:#113769;"href="NousContacter.aspx" >Nous-Contacter</a></li>
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
            <input type="hidden" name="idEntreprise" value="1">
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
			<div class="well">
                     <!-- Titre et selection  -->
					<h2 style="color:#113769;">Bourse Régionale de Partenariat</h2>
	

                   <!-- Tableau au user public  -->
					<div style="overflow:scroll">		
					<table class="table table-striped">
								<tr>
                                     <form action="FilterDemandesValides.aspx" id="myform" method="get" >   
                                    	                             
                                    		 <th></th>
		                                     <th><div id="input_container"><input type='text' id="date" name="date"  Placeholder='Date de la demande' style="max-width:150px;" ><img src="img/loope.png" class="submitableimage" id="input_img"></input></div></th>
		                                     <th><input type='text' id="nomPays" name="nomPays"  Placeholder="Pays de l'entreprise"  style="max-width:150px;" ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
											 <th><input type='text' id="designiationSecteurE" name="designiationSecteurE"  Placeholder="Secteur d'activité" style="max-width:130px" ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
		                                     <th><input type='text' id="descriptionEntreprise" name="descriptionEntreprise"  Placeholder="Présentation de l'entreprise" style="max-width:220px;"><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
		                                     <th><input type='text' id="designiationSecteurD" name="designiationSecteurD"  Placeholder='Secteur objet de partenariat' style="max-width:205px" ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
		                                     <th><input type='text' id="designiationPartenariat" name="designiationPartenariat"  Placeholder='Partenaires recherché'  style="max-width:155px;"><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>                                    
		                                     <th><input type='text' id="descriptionDemande" name="descriptionDemande"  Placeholder='Description de la demande'  style="max-width:210px;"><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
											 <th><input type='text' id="engagement" name="engagement"  Placeholder="Engagement" style="max-width:110px" ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
		                            </form>  
		                            
                               </tr>
							  <% int i = 1;
							      String varClass ;
							  %>
							  
                              <o:forEach items="${demandes}" var="ob">
			                    <% if(i%2==0)
			                    	{
			                    	   varClass = "error";
			                        }else{
			                        	varClass = "success";
			                        }
			                    i++;
			                    %>
			                              <tr class="<%=varClass%>"> <!-- error  / warning / info  --> 
			                               	   <form action="inscription.aspx">
			                               	        <input type="hidden" name="idEntreprise" value="${ob.entreprise.idEntreprise}">
			                               	   		<td><button type="submit" style="text-align:right;margin:7px;" class='btn btn-info'>+</button></td>
                               	               </form>
                               	               <td>${ob.date}</td>
 			                               	   <td>${ob.entreprise.pays.nomPays}</td>
			                               	   <td>${ob.entreprise.secteur.designiation}</td>
			                               	   <td>${ob.entreprise.description}</td>
			                               	   <td>${ob.secteur.designiation}</td>
				                               <td>${ob.partenariat.designiation}</td>
			                               	   <td>${ob.description}</td>
			                               	   <td>${ob.engagement}</td>
			                               	 
										   </tr>
			                   
                              </o:forEach>        
                              
                              
                       </table>
                   </div>
							
	

 </div>

 <!--  deuxieme partie-->

						<div class="row-fluid">

						  <div class="span4 well well-small">
							<h3>Titre 1</h3>
							  <p style='text-align:justify'>
									Lorem ipsum dolor sit amet, consectetur adipisicing elit. Id, voluptate, ipsum dolore natus earum sit accusamus facilis . </p>
	<input type="button" value="Lire la suite >"class='btn btn-primary'>
                          </div>

						  <div class="span4 well well-small">
							 <h3>Titre 2</h3>
								<p style='text-align:justify'>
									Lorem ipsum dolor sit amet, consectetur adipisicing elit. Id, voluptate, ipsum dolore natus earum sit accusamus facilis .</p>
     <input type="button" value="Lire la suite > " class='btn btn-danger'>
						 </div>

							<div class="span4 well well-small">
							  <h3>Titre 3</h3>
								<p style='text-align:justify'>
									Lorem ipsum dolor sit amet, consectetur adipisicing elit. Id, voluptate, ipsum dolore natus earum sit accusamus facilis . </p>
<input type="button" value="Lire la suite > " class='btn btn-primary'>
						  </div>

						</div>
					</div>
				</div>
			</div>	
       
                       <!-- Footer  -->

		<div class="footer well well-small">
			Copyright &copy; CRI 2015 . Tout droits réservés  
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