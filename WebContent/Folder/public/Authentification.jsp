<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	
					
		  <ul class="nav nav-list well">
							
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
						
	   
	   
</body>
</html>