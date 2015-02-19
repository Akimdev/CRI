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
import org.jfree.chart.plot.*;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.data.jdbc.JDBCPieDataset;





import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StatDemandesParAnnee extends HttpServlet {

private static final long serialVersionUID = 1L;
	
	public StatDemandesParAnnee() {
	// TODO Auto-generated constructor stub
	} 
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
			Connection connection = null;
			
			try {
				
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver");
					try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cri_db?user=root&password=091992pgm$*");
					System.out.println("Connexion");
					} catch (SQLException e) {
					e.printStackTrace();
					}
					
			} 
			catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
			
			JDBCCategoryDataset dataset = new JDBCCategoryDataset(connection);
			
			try {
				
				dataset.executeQuery("select substr(date,-4) annee,count(*) 'Nombre de partenariats' "
									+ "from demande "
									+ "where valide=true "
									+ "group by annee;");
									
							System.out.println("Query");
					//JFreeChart chart = ChartFactory.createPieChart("Répartition des demandes de partenariat selon la nationalité", dataset, true, true, false);
					
					JFreeChart chart = ChartFactory .createBarChart3D(
							"Nombre des demandes de partenariats",  
							"Années", 
							"Nombre des demandes de Partenariat",
							dataset, 
							PlotOrientation.VERTICAL,true, true, false);
					
					
					
					chart.setBorderPaint(Color.black);
					chart.setBorderStroke(new BasicStroke(0f));
					chart.setBorderVisible(true);
					
					
					if (chart != null)
					{
						int width = 500;
						int height = 350;
						final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
						response.setContentType("image/png");
						OutputStream out=response.getOutputStream();
				
						ChartUtilities.writeChartAsPNG(out, chart, width, height,info);
						
					}
					
			}catch (SQLException e)
				{
					e.printStackTrace();
				}
		} 

}