package pgm;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.BasicStroke;
import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.data.jdbc.JDBCPieDataset;



import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StatDemandesParSousSecteur extends HttpServlet {

private static final long serialVersionUID = 1L;
	
	public StatDemandesParSousSecteur() {
	// TODO Auto-generated constructor stub
	} 
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
			Connection connection = null;
			
			try {
				
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver");
					try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3333/cri_db?user=root&password=091992pgm$*");
					System.out.println("Connexion");
					} catch (SQLException e) {
					e.printStackTrace();
					}
					
			} 
			catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
			
			JDBCPieDataset dataset = new JDBCPieDataset(connection);
			
			try {
                 String SurSect = "and s.idSurSecteur=";
                 try{
                	 	SurSect += request.getParameter("SurSecteur").toString();
                	 	
                 }catch(NullPointerException e)
                 {
                	 System.out.println("okokokok  "+SurSect);
                	 SurSect = ""; 
                 }
                 
				 dataset.executeQuery("select s.designiation,count(*) "
									+ "from demande d, secteur s "
									+ "where d.idSecteur=s.idSecteur "+SurSect+" and substr(d.date,-4)>='"+request.getParameter("AnneeInf")+"' and substr(d.date,-4)<= '"+request.getParameter("AnneeSup")+"' "
									+ " group by s.designiation;");
				
				System.out.println("Query");
					JFreeChart chart = ChartFactory.createPieChart("Répartition des demandes de partenariat selon le Sous-Secteur objet de la partenariat", dataset, true, true, false);
					
					chart.setBorderPaint(Color.black);
					chart.setBorderStroke(new BasicStroke(0.0f));
					chart.setBorderVisible(true);
					
					
					if (chart != null)
					{
						int width = 500;
						int height = 350;
						final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
						response.setContentType("image/png");
						OutputStream out=response.getOutputStream();
				
						ChartUtilities.writeChartAsPNG(out, chart, width, height,info);
						request.getServletContext().getRequestDispatcher("Folder/StatDemandesParSousSecteur.jsp").forward(request, response);
					}
					
			}catch (SQLException e)
				{
					e.printStackTrace();
				}
		} 

}