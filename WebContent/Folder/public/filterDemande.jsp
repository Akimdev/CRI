<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="o" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	
</head>
<body>

<table  class="table table-striped">
								<tr>
                                     <form action="FilterDemandesValides.aspx" id="myform" method="get" >   
                                    	                             
                                    		 <th></th>
		                                     <th><div id="input_container"><input type='text' id="date" name="date"  Placeholder='Date de la demande' style="max-width:150px;"><img src="img/loope.png" class="submitableimage" id="input_img"></input></div></th>
		                                     <th><input type='text' id="nomPays" name="nomPays"   Placeholder="Pays de l'entreprise"  style="max-width:150px;" ><img src="img/loope.png" class="submitableimage" id="input_img"></input></th>
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
</body>
</html>