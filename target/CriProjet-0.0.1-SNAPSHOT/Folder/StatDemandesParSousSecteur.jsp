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
						<li class="active"><a  style="color:#113769" href="Statistique.aspx">Statistique</a></li>
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
						<a href="#" style="color:green"> <%= request.getSession().getAttribute("login") %> </a> vous �tes connect�
					</li>
								  
					<li class="divider"></li> 
		   </ul>
		   <ul class="moncompte nav nav-list">
		   
	        
	         <li><a href="StatDemandesParPays.aspx" style=""> R�partition des demandes de partenariat par Nationalit� de l'entreprise </a></li>	
	         <li><a href="StatDemandesParSecteur.aspx" style=""> R�partition des demandes de partenariat par Secteurs objets de partenariat </a></li>	
	         <li  class="active"><a href="StatDemandesParSousSecteur.aspx?SurSecteur=a">R�partition des demandes de partenariat par Sous-Secteurs objets de partenariat</a></li> 
	          <li><a href="StatDemandesParAnnee.aspx">Nombre des Demandes de partenariat selon les ann�es </a></li>
	         <li><a href="inscription.html"><span style="color:red">0 </span>Nouveaux message</a></li>
	         <li class="divider"></li> 
	         <li><a href="index.aspx"><button style="position:relative;left:2px;"type="submit" class="btn btn-inverse">Se d�connecter</button></a></li>   
	
		     </ul>		  
		</div>
					
		<div class="span9" >
		<div class="well">
				
				
				 <form id="form1" action="StatDemandesParSousSecteur.aspx">
				  <div class="control-group">
				     <label class="control-label" for="inputPassword">Secteur d'activit�</label>
				         <div class="controls">
				          
							<select class="form-control" id="Secteur"  onChange ="fct()" name="SurSecteur" >
								 <o:forEach items="${SurSecteurs}" var="ob">
								 	<option value="${ob.idSecteur }">${ob.designiation}</option>
							     </o:forEach>
							</select>
						
						</div>
				  </div>
				  
			 	
				  <br><br>
				  <center><img  src="StatDemandesParSousSecteur<%=request.getAttribute("param") %>" width="900" height="400" border="0"/>
				 </center>
				 
				</form> 
				
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
  
			function fct()
			{
				document.forms.form1.submit(); 
				
			}
			
			
			
			 $('img.submitableimage').click(function(){
				      $('#myform').submit();
			 });
			
	 
			 
    </script>

</body>
</html>