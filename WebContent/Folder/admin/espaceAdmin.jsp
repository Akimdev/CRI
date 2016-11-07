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
						<li class="active"><a href="Authentification.aspx" style="color:#113769">Accueil</a></li>
						<li class="divider-vertical"></li>
						<li><a  style="color:#113769" href="Statistique.aspx">Statistique</a></li>
						<li class="divider-vertical"></li>
						
					
						<li class="divider-vertical"></li>
					    <li  >
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
	         <li class="active"><a href="DemandesDePartenariat.aspx" style=""> <span style="color:red">${nb_DemandesPartenariat} </span>  Demandes de partenariat</a> </li>	
	         <li><a href="DemandesEntreprises.aspx"><span style="color:red">${nb_DemandesEntreprise} </span>Demandes de détails </a></li> 
	         <li><a href=""><span style="color:red">0 </span>Demandes de modification</a></li>
	         <li><a href=""><span style="color:red">0 </span>Nouveaux message</a></li>
	         <li class="divider"></li> 
	         <li><a href="index.aspx"><button style="position:relative;left:2px;"type="submit" class="btn btn-inverse">Se déconnecter</button></a></li>   
	
		     </ul>		  
		</div>
					
		<div class="span9" >
		<div class="well">
				<div style="margin:7px;"><h2 style="color:#113769;">Table de bord</h2>
		              <h3>Gestion des demandes reçus</h3>
			
				</div>
                   <!-- Tableau au user public  -->
			  <div style="overflow:scroll">		
					<table class="table table-striped">
								<tr>
								     <form id="myform" action="FilterDemandesInv.aspx">
		                                     <th>Valider</th>
		                                     <td>Mot de Passe</td>
		                                     <td>Profile</td>
		                                     <th><input type='text' id="date" name="date"  Placeholder='Date de la demande'  style="max-width:155px;"><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
		                                     <th><input type='text' id="nomEntreprise" name="nomEntreprise"  Placeholder="Nom de l'entreprise"  style="max-width:205px;" ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
											 <th><input type='text' id="nomPays" name="nomPays" Placeholder="Pays de l'entreprise"  style="max-width:205px;" ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
											 <th><input type='text' id="designiationSecteurE" name="designiationSecteurE" Placeholder="Secteur d'activité" style="max-width:140px" ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
		                                     <th><input type='text' id="descriptionEntreprise" name="descriptionEntreprise" Placeholder="Présentation de l'entreprise" style="max-width:205px;"><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
		                                     <th><input type='text' id="siteWeb" name="siteWeb" Placeholder="Site web de l'entreprise"  style="max-width:205px;" ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
		                                     <th><input type='text' id="nomContact" name="nomContact" Placeholder="Nom de contact"  style="max-width:205px;" ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
											 <th><input type='text' id="prenomContact" name="prenomContact" Placeholder="Prenom de contact"  style="max-width:205px;" ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
											 <th><input type='text' id="emailContact" name="emailContact" Placeholder="Email"  style="max-width:205px;" ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
		                                     <th><input type='text' id="designiationSecteurD" name="designiationSecteurD" Placeholder='Secteur objet de partenariat' style="max-width:210px" ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
		                                     <th><input type='text' id="designiationPartenariat" name="designiationPartenariat" Placeholder='Partenaire recherché'  style="max-width:155px;"><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
		                                     <th><input type='text' id="descriptionDemande" name="descriptionDemande" Placeholder='Description de la demande'  style="max-width:205px;"><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
											 <th><input type='text' id="engagement" name="engagement" Placeholder="Engagement" style="max-width:100px" ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
                                     </form>
                               </tr>
                              
                              <% int i = 1;
							      String varClass ;
							      String pass;
							  %>
							  
                              <o:forEach items="${demandes}" var="ob">
			                      <% if(i%2==0)
			                    	{
			                    	   varClass = "error";
			                        }else{
			                        	varClass = "success";
			                        }
			                    i++;
			                    pass = "Mot de passe";
			                    %>       
			                   
			                    <tr class="<%=varClass%>">
			                    <form id="boite" action="" method="get">
			                             <td style="min-width:100px;">
			                             
				                               <o:if test="${ob.valide == false}">
				                             	
						                               	    <button type="submit" style="margin-left:30px;"  class='btn btn-success' onClick="ValiderDemande('boite');">
					                               	             <i class="icon-ok"></i>
					                               	       </button>
					                               	     
					                               	       <br><br><br>
					                               	    <o:if test="${ob.entreprise.valide == false}">   
						                               	   <a  onClick="DonnerPassword('${ob.entreprise.idEntreprise}${ob.secteur.idSecteur}');" >Donner Mot de passe et profile </a>
						                             	 </o:if>
						                             	 
						                             	 <o:if test="${ob.entreprise.valide == true}">
							                             	 <input type="hidden" name="password" value=""> 
							                             	 <input type="hidden" name="profile" value=""> 
						                             	 </o:if>
						                             	     
				                             </o:if>
				                             	      <br><br><br>
				                             <o:if test="${ob.entreprise.valide == true}"></o:if>        
				                              	           <input type="hidden" name="idEntreprise" value="${ob.entreprise.idEntreprise}">
				                               	           <input type="hidden" name="idSecteur" value="${ob.secteur.idSecteur}">
				                               	           <input type="hidden" name="idPartenariat" value="${ob.partenariat.idPartenariat}">
					                               	      
					                               	       <button type="submit" style="margin-left:30px;" onClick="SupprimerDemande('boite');" class='btn btn-danger'>
					                               	      		 <i class="icon-remove"></i>
					                               	       </button>  
				                                	  
				                                	     
			                              </td>     
			                              
			                              
			                          	       <td id="${ob.entreprise.idEntreprise}${ob.secteur.idSecteur}passwordtd">
			                                        <input name="password" type="text" id="${ob.entreprise.idEntreprise}${ob.secteur.idSecteur}password" value="Mot de passe" placeholder="<%=pass %>"  disabled/>
			                          	       </td>
			                          	       
			                          	       <td  id="${ob.entreprise.idEntreprise}${ob.secteur.idSecteur}profiletd">
				                          	       <select name="profile" id="${ob.entreprise.idEntreprise}${ob.secteur.idSecteur}profile" disabled  >
					                          	       <option value="Utilisateur" >Utilisateur Privilègié</option> 
					                          	       <option value="Directeur">Directeur</option> 
					                          	       <option value="Administrateur">Administrateur</option> 
				                          	       </select>
			                          	       </td>
			                          	       
			                               	   <td>${ob.date}</td>                       	   
			                               	   <td><textarea cols="40" rows="10" name="nomEntreprise" >${ob.entreprise.nomEntreprise}</textarea> </td>
			                               	   <td>${ob.entreprise.pays.nomPays}</td>
			                               	   <td>${ob.entreprise.secteur.designiation}</td>
			                               	   <td><textarea cols="40" rows="10" name="descriptionEntreprise">${ob.entreprise.description}</textarea></td>
			                               	   <td><textarea cols="40" rows="10" name="webEntreprise">${ob.entreprise.webEntreprise}</textarea></td>
			                               	   <td><textarea cols="40" rows="10" name="nomContact">${ob.entreprise.nomContact}</textarea></td>
			                               	   <td><textarea cols="40" rows="10" name="prenomContact">${ob.entreprise.prenomContact}</textarea></td>
			                               	   <td><textarea cols="40" rows="10" name="emailContact">${ob.entreprise.emailContact}</textarea></td>
			                               	   <td>${ob.secteur.designiation}</td>
			                               	   <td>${ob.partenariat.designiation}</td>
			                               	   <td><textarea cols="40" rows="10" name="descriptionDemande">${ob.description}</textarea></td>
			                               	   <td>${ob.engagement}</td>
			                               	 
										   
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
  
			function ValiderDemande(elem) 
			{ 
					// Quel est l'état actuel ? 
					document.getElementById(elem).action = "ValiderDemande.aspx"; 
					
			} 
			
			
			
			function SupprimerDemande(elem) 
			{ 
					// Quel est l'état actuel ? 
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
					//proftd.innerHTML = '<select id="'+val+'profile" name="profile" ><option selected>Utilisateur Privilègié</option> <option>Directeur</option> <option>Administrateur</option> </select>';
				    prof.disabled = false;
				else
					//proftd.innerHTML = '<select id="'+val+'profile"  disabled ><option>Utilisateur Privilègié</option> <option>Directeur</option> <option>Administrateur</option> </select>';
					prof.disabled = true;
			}
			 
			 
    </script>

</body>
</html>