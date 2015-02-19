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
						<li><a href="Authentification.aspx" style="color:#113769">Accueil</a></li>
						<li class="divider-vertical"></li>
						<li><a  style="color:#113769"href="Statistique.aspx">Statistique</a></li>
						<li class="divider-vertical"></li>
						
					
						<li class="divider-vertical"></li>
					    <li class="dropdown"><a  style="color:#113769;"href="    #" class="dropdown-toggle" data-toggle="dropdown"    >Gestion<b class="caret"></b>
					        </a>
					           <ul class="dropdown-menu">
									<li><a href="#">Gestion des demandes reçu</a></li >
									<li><a href="#">Gestion des utilisateures</a></li>
									<li><a href="#">Ajouter un utilisateur</a></li>
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
         
	         <li><a href="DemandesDePartenariat.aspx" style=""> <span style="color:red">${nb_DemandesPartenariat} </span>  Demandes de partenariat</a> </li>	
	         <li class="active"><a href="DemandesEntreprises.aspx"><span style="color:red">${nb_DemandesEntreprise} </span>Demandes de détails </a></li> 
	         <li><a href=""><span style="color:red">0 </span>Demandes de modification</a></li>
	         <li><a href="inscription.html"><span style="color:red">0 </span>Nouveaux message</a></li>
	         <li class="divider"></li> 
	         <li><a href="index.aspx"><button style="position:relative;left:2px;"type="submit" class="btn btn-inverse">Se déconnecter</button></a></li>   

	    </ul> 		  
					</div>
					
	<div class="span9">				
			<div class="well" >
			
		<span style="margin:7px;">
		<h2 style="color:#113769;">Gestion des Transactions</h2>
              <h4>Les entreprise demandant du détails sur les demandes de partenariat publics</h4>
	
        </span>
                   <!-- Tableau au user public  -->
			  <div style="overflow:scroll">		
					<table class="table table-striped">
					
								<form id="myform" action="FilterEntreprisesInv.aspx">
									<tr>
	                                     <th>Valider</th>
	                                     <td>Mot de Passe</td>
		                                 <td>Profile</td>
	                                     <th><input type='text' id="nomEntreprise" name="nomEntreprise" Placeholder="Nom de l'entreprise"  style="max-width:205px;"  ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
										 <th><input type='text' id="nomPays" name="nomPays" Placeholder="Pays de l'entreprise"  style="max-width:205px;"  ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
										 <th><input type='text' id="villeEntreprise" name="villeEntreprise" Placeholder="Ville de l'entreprise"  style="max-width:205px;"  ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
										 <th><input type='text' id="adresseEntreprise" name="adresseEntreprise" Placeholder="Adresse de l'entreprise"  style="max-width:205px;"  ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
										 <th><input type='text' id="secteur" name="secteur" Placeholder="Secteur d'activité" style="max-width:200px" ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
	                                     <th><input type='text' id="desccription" name="description" Placeholder="Présentation de l'entreprise" style="max-width:205px;" ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
	                                     <th><input type='text' id="siteWeb" name="siteWeb" Placeholder="Site web de l'entreprise"  style="max-width:205px;"  ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
	                                     <th><input type='text' id="registre" name="registre" Placeholder="Registre de Commerce"  style="max-width:205px;"  ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
	                                     <th><input type='text' id="nomContact" name="nomContact" Placeholder="Nom de contact"  style="max-width:205px;"  ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
										 <th><input type='text' id="prenomContact" name="prenomContact" Placeholder="Prenom de contact"  style="max-width:205px;"  ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
										 <th><input type='text' id="civilite" name="civilite" Placeholder="Civilité"  style="max-width:205px;"  ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
										 <th><input type='text' id="fonction" name="fonction" Placeholder="Fonction"  style="max-width:205px;"  ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
	                                     <th><input type='text' id="emailContact" name="emailContact" Placeholder="Email"  style="max-width:205px;"  ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
	                                     <th><input type='text' id="fix" name="fix" Placeholder="Fix"  style="max-width:205px;"  ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
	                                     <th><input type='text' id="fax" name="fax" Placeholder="Fax"  style="max-width:205px;"  ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
	                               </tr>
                              </form>
                              
                              <% int i = 1;
							      String varClass ;
							  %>
							  
                              <o:forEach items="${entreprises}" var="ob">
			                      <% if(i%2==0)
			                    	{
			                    	   varClass = "error";
			                        }else{
			                        	varClass = "success";
			                        }
			                    i++;
			                    %>       
			                   
			                    <tr class="<%=varClass%>">
			                       <form id="boite" action="" method="get">
			                             <td style="min-width:100px;">
				                             <o:if test="${ob.valide == false}">
				                             		
				                             		  <button type="submit" style="margin-left:30px;" onClick="ValiderEntreprise('boite');" class='btn btn-success'>
					                               	          <i class="icon-ok"></i>
					                               	  </button> 
					                               	     <br><br><br>
					                               	    <o:if test="${ob.valide == false}">   
						                               	   <a  onClick="DonnerPassword('${ob.idEntreprise}');" >Donner Mot de passe et profile </a>
						                             	 </o:if>             
				                               	     
				                             </o:if>
				                               	       <br><br><br>
				                                     <input type="hidden" name="idEntreprise" value="${ob.idEntreprise}">
				                               	     <button type="submit" style="margin-left:30px;" onClick="SupprimerEntreprise('boite');" style="margin-left:10px;" class='btn btn-danger'>
					                               	      	<i class="icon-remove"></i>
					                               	 </button>  
				                                 
			                              </td>     
			                              
			                               <td id="${ob.idEntreprise}passwordtd">
			                                        <input name="password" type="text" id="${ob.idEntreprise}password" value="Mot de passe" placeholder="Mot de Passe"  disabled/>
			                          	       </td>
			                          	       
			                          	       <td  id="${ob.idEntreprise}profiletd">
				                          	       <select name="profile" id="${ob.idEntreprise}profile" disabled  >
					                          	       <option value="Utilisateur" >Utilisateur Privilègié</option> 
					                          	       <option value="Directeur">Directeur</option> 
					                          	       <option value="Administrateur">Administrateur</option> 
				                          	       </select>
			                          	       </td>
			                          	       
			                               	   <td><textarea cols="40" rows="10" name="nomEntreprise" >${ob.nomEntreprise}</textarea> </td>
			                               	   <td>${ob.pays.nomPays}</td>
			                               	   <td><textarea cols="40" rows="10" name="adresseEntreprise">${ob.adresseEntreprise}</textarea></td>
			                               	   <td><textarea cols="40" rows="10" name="villeEntreprise">${ob.villeEntreprise}</textarea></td>
			                               	   <td>${ob.secteur.designiation}</td>
			                               	   <td><textarea cols="40" rows="10" name="description">${ob.description}</textarea></td>
			                               	   <td><textarea cols="40" rows="10" name="webEntreprise">${ob.webEntreprise}</textarea></td>
			                               	   <td>${ob.registreCommerce}</td>
			                               	   <td><textarea cols="40" rows="10" name="nomContact">${ob.nomContact}</textarea></td>
			                               	   <td><textarea cols="40" rows="10" name="prenomContact">${ob.prenomContact}</textarea></td>
			                               	   <td>${ob.civilité}</td>
			                               	   <td><textarea cols="40" rows="10" name="fonctionContact">${ob.fonctionContact}</textarea></td>
			                               	   <td><textarea cols="40" rows="10" name="emailContact">${ob.emailContact}</textarea></td>
			                               	   <td><textarea cols="40" rows="10" name="telContact">${ob.telContact}</textarea></td>
			                               	   <td><textarea cols="40" rows="10" name="faxContact">${ob.faxContact}</textarea></td>
			                               	   
										   
			                    </form>      
			                 </tr>
			                
			            
                              </o:forEach>                               
                               
                           
                       </table>
                   </div> <!-- fin du tableau -->
							
		
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
  
			function ValiderEntreprise(elem) 
			{ 
					// Quel est l'état actuel ? 
					document.getElementById(elem).action = "ValiderEntreprise.aspx"; 
					
			} 
			
			
			
			function SupprimerEntreprise(elem) 
			{ 
					// Quel est l'état actuel ? 
					document.getElementById(elem).action = "SupprimerEntreprise.aspx"; 	
					
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
				//proftd.innerHTML = '<select id="'+val+'profile" name="profile" ><option selected>Utilisateur Privilègié</option> <option>Directeur</option> <option>Administrateur</option> </select>';
			    prof.disabled = false;
			else
				//proftd.innerHTML = '<select id="'+val+'profile"  disabled ><option>Utilisateur Privilègié</option> <option>Directeur</option> <option>Administrateur</option> </select>';
				prof.disabled = true;
		}
			 
			 
			 
			 
    </script>	
	
</body>
</html>