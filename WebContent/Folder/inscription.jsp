<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dao.Secteur" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="o" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>CRI - Inscription  </title>
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
						<li class="active"><a style="color:#113769" href="#">Devenir membre</a></li>
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
         
    

					</div>

		
					<!-- Bloc Principal  -->

			<div class="span9">	
			<div class="well">
 
<form id="myform" class="form-horizontal" action="AjouterEntreprise.aspx" method="post"> 
		    <fieldset>
		                
		        <legend>Informations sur l'entreprise</legend>
			                  
				<div class="control-group">
				    <label class="control-label" for="inputName">Nom</label>
				    <div class="controls">
				      <input type="text" name="nomEntreprise" placeHolder="Nom de l'entreprise" required/>
				    </div>
				</div>
			  
				<div class="control-group">
				     <label class="control-label" for="inputPassword">Secteur d'activité</label>
				          <div class="controls">
				          
					<select class="form-control" id="Secteur"  onChange ="fct()" name="SurSecteur" >
						 <o:forEach items="${SurSecteurs}" var="ob">
						 	<option value="${ob.idSecteur }">${ob.designiation}</option>
					     </o:forEach>
					</select>
				
				</div>
			</div>
			   
		   <div class="control-group">
		     <label class="control-label" for="inputPassword">Sous Secteur</label>
		          <div id="SousSecteurs" class="controls">
		          
					 <select class="form-control"  name="idSecteur">
						 <o:forEach items="${SousSecteurs}" var="ob">
						 	<option value="${ob.idSecteur }">${ob.designiation}</option>
					     </o:forEach>
					</select>
				  
				  </div>
		 
		   </div>
		   
		     <div class="control-group">
							<label class="control-label" for="inputPhone">Description</label>
							<div class="controls">
								<textarea rows="4" cols="50" name="description" required></textarea> 
							</div>
			 </div>
		   
		   
		   
		   <div class="control-group">
		     <label class="control-label" for="inputPassword">Pays</label>
		          <div class="controls">
					 <select class="form-control" name="idPays">
					   <o:forEach items="${Pays}" var="ob">
						 	<option value="${ob.idPays }">${ob.nomPays}</option>
					     </o:forEach>
					</select>
		          </div>
		   </div>
		   
			<div class="control-group">
			    <label class="control-label" for="inputName">Ville</label>
			    <div class="controls">
			      <input type="text" placeHolder="Ville" name="villeEntreprise" >
			    </div>
			</div>
		
			<div class="control-group">   
			    <label class="control-label" for="exampleInputFile">Le Registre de commerce</label>
			    <input style="margin-left:14px;" type="file" id="exampleInputFile" name="registreCommerce" required>   
		    </div>
		  
		  
			  <div class="control-group">
				    <label class="control-label" for="inputDate">Adresse</label>
				    <div class="controls">
				      <textarea rows="3" name="adresseEntreprise" ></textarea>
				    </div>
			  </div>
		  
		  	
			  <div class="control-group">
			    <label class="control-label" for="inputName">Site web</label>
			    <div class="controls">
			      <input type="text" placeHolder="www.monsite.com" name="webEntreprise" required>
			    </div>
			  </div>
			  							
		 </fieldset>
		 
		
		  <fieldset>
		    <legend>Information sur la personne de contact</legend>
			  <div class="control-group">
				    <label class="control-label" for="inputPassword">Nom</label>
				    <div class="controls">
				         <input type="text" id="inputName" placeholder="Nom" name="nomContact" required>
				    </div>
			  </div>
		  
			  <div class="control-group">
				    <label class="control-label" for="inputPassword">Prénom</label>
				    <div class="controls">
				      	<input type="text" id="inputName" placeholder="Prénom" name="prenomContact" required>
				    </div>
			  </div>
			  
		  <div class="control-group">
			    <label class="control-label" for="inputPassword">Sexe</label>
			    <div class="controls">
				     <label class="checkbox inline" >
				        <input type="radio" id="inlineCheckbox1" name="civilité" value="Male">Masculin
				     </label>
				     
				     <label class="checkbox inline">
				         <input type="radio" id="inlineCheckbox2" name="civilité" value="Female">Féminin
				     </label>
				     
			    </div>
		  </div>
		  
		  <div class="control-group">
		    <label class="control-label" for="inputName">Fonction occupée</label>
		    <div class="controls">
		      <input type="text" id="inputName" name="fonctionContact" placeholder="Fonction" required>
		    </div>
		  </div>
		
		     <div class="control-group">
		    <label class="control-label" for="inputEmail">Email</label>
		    <div class="controls">
		      <input type="text" id="inputEmail" name="emailContact" placeholder="monemail@gmail.com" required>
		    </div>
		  </div>
		  
		   
		  <div class="control-group">
		    <label class="control-label" for="inputPhone">Téléphone</label>
		    <div class="controls">
		      <input type="tel" id="inputPhone" name="telContact" placeholder="06...." >
		    </div>
		  </div>
		
		  <div class="control-group">
		    <label class="control-label" >Fax</label>
		    <div class="controls">
		      <input type="tel" id="inputFaxl" name="faxContact" placeholder="05...." >
		    </div>
		  </div>
		   
		  
		    <div id="ValiderPart" class="control-group">
			    <div class="controls">
			      <button  class="btn btn-success"  style="margin:7px;">Valider les informations saisies</button>
			    </div>
		    </div>
		  
		  
		   <div class="control-group">
			 <div class="controls">
			 	<input type="button" id="btnDemande"  class="btn btn-info" onClick="bascule('boite');" value="Poster une demande de partenariat"/> 
			 </div>
		   </div>
		
		</fieldset>
		
		<div  id="boite" style="visibility: hidden" > 
		
		   	    
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
					          
								 <select class="form-control"  name="idSecteurDemande">
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
								<textarea rows="4" cols="50" name="descriptionDemande" value="ok" ></textarea> 
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
						
						  
				</div>
		
		  		<div id="ValiderAll" class="control-group" visible="false">
		             
		        </div>
		        
</form>
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
    <script language="Javascript"> 
  
 function bascule(elem) 
{ 
// Quel est l'état actuel ? 
	etat=document.getElementById(elem).style.visibility; 
	
	if(etat=="hidden"){
		
		document.getElementById('btnDemande').value = 'Ne pas poster la demande de partenariat';
		document.getElementById('ValiderPart').innerHTML = '';
		document.getElementById(elem).style.visibility="visible";
		document.getElementById("myform").action = "AjoutpublicDemande.aspx";
		//document.getElementById('visible').value="false";
		document.getElementById('ValiderAll').innerHTML = '<div class="controls"><button type="submit" class="btn btn-success"  style="margin:7px;">Valider les informations saisies</button></div>';
	
	}else{
		
		document.getElementById('btnDemande').value = 'Poster la demande de partenariat';
		document.getElementById('ValiderPart').innerHTML = '<div class="controls"><button type="submit" class="btn btn-success"  style="margin:7px;">Valider les informations saisies</button></div>';
		document.getElementById(elem).style.visibility="hidden";
		//document.getElementById('visible').value="true";
		document.getElementById("myform").action = "AjouterEntreprise.aspx";
		document.getElementById('ValiderAll').innerHTML = '';
		
	} 
	
}  


function fct()
{
	var xmlhttp;
	var elt =  document.getElementById("Secteur");
	
	xmlhttp = new XMLHttpRequest;
	
	xmlhttp.onreadystatechange = function (){
		
		if( xmlhttp.readyState == 4  & xmlhttp.status == 200 )
		{
			document.getElementById("SousSecteurs").innerHTML = xmlhttp.responseText;
		}
		
	}
	
	
	xmlhttp.open("GET", "SousSecteurs.aspx?idSecteur="+elt.value, true);
	xmlhttp.send();
	
	
}



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
	
	
	xmlhttp.open("GET", "SousSecteursDemande.aspx?idSecteur="+elt.value, true);
	xmlhttp.send();
	
	


}




</script>

	</body>
</html>