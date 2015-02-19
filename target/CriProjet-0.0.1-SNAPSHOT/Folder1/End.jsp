<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      
<!DOCTYPE html>
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
        <link rel="stylesheet" type="text/css" href="css/style2.css" />
		<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
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
			 <article>
                <div id="container_demo" >
                   
                    <div id="wrapper">
                        <div id="login" class="animate form">
                             
							 
                                <p> 
                                  
								   Votre profil est en cours de validation par nos    
                                   équipes. Vous recevrez sur l'adresse électronique <a href="" ><%= request.getAttribute("mail")%></a> un mail dès sa validation avec votre identifiant et votre mot de  
                                   passe.

                                    
								</p>
                                <br>
                                   <a href="http://www.cri-agadir.ma/">Acceuil</a>
								

							  
							  
                           
                        </div>
                        
           	            
                    </div>


					
                </div> 
				</article>
            </section>
			
        </div>
		
    </body>
</html>