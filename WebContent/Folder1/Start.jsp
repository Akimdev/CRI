<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="o" uri="http://java.sun.com/jsp/jstl/core" %>
<% int i; %>

<!DOCTYPE>


<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Login and Registration Form with HTML5 and CSS3</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style3.css" />
		<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
		
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script>
		function choix();
		{
			i=1;
		}
		</script>
		
		
    </head>
    <body>
        <div class="container">
            <!-- Codrops top bar -->
            <div class="codrops-top">
                <a href="http://www.cri-agadir.ma/">
                    <img src="images/cri_logo.jpg" alt="Acceuil" height="100" width="400"/>
                </a>
                
                <div class="clr"></div>
            </div><!--/ Codrops top bar -->
            <header>
                <h1>Authentification et  Inscription </h1>
			
            </header>
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form  action="Authentification.aspx" autocomplete="on" method="post"> 
							
                                <h1>Authentification</h1> 
                                <p> 
                                    <label for="username" class="uname" data-icon="u" > Votre nom d'utilisateur  </label>
                                    <input id="username" name="login" required="required" type="text" placeholder="mon_email@mail.com"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> Votre mot de passe </label>
                                    <input id="password" name="password" required="required" type="password" placeholder="ex. X8df!90EO" /> 
                                </p>
                                
                                 ${msg}
                                
                                <p class="keeplogin"> 
									<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
									<label for="loginkeeping">Rester connecté</label>
								</p>
                                <p class="login button"> 
                                    <input type="submit" value="Login" /> 
								</p>
                                <p class="change_link">
									Pas encore inscrit ?
									<a href="#toregister" class="to_register">Inscrivez-vous</a>
								</p>
                            </form>
                        </div>

                        <div id="register" class="animate form">
                            <form  action="AjoutUtilisateur.aspx" autocomplete="on"  method="post"> 
							
								<p class="change_link1">  
									   Déjà member ?
									<a href="#tologin" class="to_register"> Connentez-vous  </a>
								</p>
								
								<br/><br/>
								
                                <h1> Inscription </h1> 
								
								<br/>
								Informations sur l'entreprise :
								<hr>
                                <br/>
								
                                <p> 
                                    <label for="usernamesignup" class="uname" >Nom </label>
                                    <input id="nomEntreprise" name="nomEntreprise" required="required" type="text" placeholder="Centre Régionale d'Investissement Souss Massa Darâa" />
                                </p>
								 <p> 
                                    <label for="emailsignup" class="youmail"  > Secteur d'activité</label>
                                    <select id="designiation" name="idSecteur" required="required" onChange='Choix()'>
										
										<o:forEach items="${secteurs}" var="ob" >
					
											<o:if test="${ob.secteur == null }" >
											
												<optgroup label="${ob.designiation }">  
												
													<o:forEach items="${secteurs}" var="obb" >
								
														<o:if test="${ob.idSecteur == obb.secteur.idSecteur }" >
														
														<option value="${obb.idSecteur }"> ${obb.designiation } </option>
														   
													    </o:if>
													
													</o:forEach>												 
													
		
												</optgroup>
											   
										    </o:if>
										
										</o:forEach>
										
										<o:if test="<o:out i=1 /> == 1">
										<h1>Sa marche bien</h1>
										</o:if>
										
									<%-- 	
										<% List<Secteur> s = (List<Secteur>) request.getAttribute("secteurs");
										  
											for(int i=0; i<s.size() ; i++) 
											{ %>
											<optgroup label="<%= s.get(i).getDesigniation()%>">
											
											<% for(int j=0; j<s.get(i).getSecteurs().size() ; j++ )
											   {
											     if( s.get(i).getSecteurs()== s.get(i).getIdSecteur())
											     {%>
											     <option name="idSecteur" value="<%=s.get(i).getIdSecteur()%>"><%=Ss.get(j).getDesigniation() %></option>
											     <%}} %>
											
											</optgroup>
											
										 <%}%> --%> 
											
									</select> 
                                </p>
                                
                                
                                
                                <p> 
                                    <label for="emailsignup" class="youmail"  > Pays</label> <br/>
                                    <select id="nomPays" name="idPays" required="required"  >
										<o:forEach items="${pays}" var="ob">
										<option value="${ob.idPays }" > ${ob.nomPays } </option>
										</o:forEach>	
									</select>									
                                </p>
                                
								 <p> 
                                    <label for="emailsignup" class="youmail"  > Adresse </label><br/>
                                    <textarea id="adresseEntreprise" name="adresseEntreprise" required="required"  placeholder="Cité Founty B.P : 31.333 Agadir | Maroc"></textarea> 
                                </p>
                                <p> 
                                    <label for="passwordsignup" class="youpasswd" >Ville </label>
                                    <input id="villeEntreprise" name="villeEntreprise" required="required" type="text" placeholder="Agadir"/>
                                </p>
                                <p> 
                                    <label for="passwordsignup_confirm" class="youpasswd" >Site web  </label>
                                    <input id="webEntreprise" name="webEntreprise" required="required" type="url" placeholder="http://www.cri-agadir.ma/"/>
                                </p>
								
								 <p> 
                                    <label for="usernamesignup" class="uname" >Le Registre de Commerce</label>
									<!--<input type="file" id="files" name="files[]" multiple /> -->
                                    <input id="registreCommerce" name="registreCommerce" required="required" type="file" placeholder="mysuperusername690" />
                                </p>
								
								<br/>
								Informations sur la personne de contact
								<hr>
                                <br/>
								
								<p> 
                                    <label for="emailsignup" class="youmail" data-icon="u" > Nom </label>
                                    <input id="nomContact" name="nomContact" required="required" type="text" placeholder="Nom de la personne de contact"/> 
                                </p>
                                <p> 
                                    <label for="passwordsignup" class="youpasswd" >Prénom  </label>
                                    <input id="prenomContact" name="prenomContact" required="required" type="text" placeholder="Prenom de la personne de contact"/>
                                </p>
								
								
								
							   <!--  <label for="male">Male</label>  -->
								Male :<input type="radio" name="civilite" value="male"><br>
							   <!-- 	<label for="female">Female</label>  -->
								Female :<input type="radio" name="civilite"  value="female"><br>
                                <br>
								
                                <p> 
                                    <label for="passwordsignup_confirm" class="youpasswd" >Fonction </label>
                                    <input id="fonctionContact" name="fonctionContact" required="required" type="text" placeholder="Au sein de l'entreprise"/>
                                </p>
								
								 <p> 
                                    <label for="usernamesignup" class="uname" >e-Mail</label>
                                    <input id="emailContact" name="emailContact" required="required" type="text" placeholder="mon_email@mail.com" />
                                </p>
								
								 <p> 
                                    <label for="usernamesignup" class="uname" >Tél</label>
                                    <input id="telContact" name="telContact" required="required" type="tel" placeholder="Le numéro du téléphone" />
                                </p>
								
								 <p> 
                                    <label for="usernamesignup" class="uname" >Fax</label>
                                    <input id="faxContact" name="faxContact" required="required" type="text" placeholder="Le numéro du Fax" />
                                </p>
								
								
								
								
								
                                <p class="signin button"> 
									<input type="submit" value="Sign up"/> 
								</p>
                                <p class="change_link">  
									
									
								</p>
                            </form>
                        </div>
						
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>