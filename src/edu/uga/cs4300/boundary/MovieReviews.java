package edu.uga.cs4300.boundary;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uga.cs4300.logiclayer.MovieLogicImpl;
import edu.uga.cs4300.objectlayer.Movie;
import freemarker.template.Configuration;

/**
 * Servlet implementation class MovieReviews
 */
@WebServlet("/MovieReviews")
public class MovieReviews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static  String         templateDir = "WEB-INF/templates";
    static  String         createTemplateName = "CreateBallot.ftl";
    static  String         resultTemplateName = "CreateBallot-Result.ftl";
    
    private Configuration cfg;
    
    public void init() 
    {
    	// Prepare the FreeMarker configuration;
        // - Load templates from the WEB-INF/templates directory of the Web app.
        //
        cfg = new Configuration();
        cfg.setServletContextForTemplateLoading(
                getServletContext(), 
                "WEB-INF/templates"
                );
}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//doGet(request, response);
		
		String view = request.getParameter("view");
		String enter = request.getParameter("enter");
		String edit = request.getParameter("edit");
		String delete = request.getParameter("delete");
		
		if(view != null){
			viewMovies(request,response);
		}
		else if(edit != null){
			editMovies(request,response);
		}
		else if(enter != null){
			submitMovies(request,response);
		}
		else if(delete != null){
			deleteMovies(request,response);
		}
		
	}
	
	public void viewMovies(HttpServletRequest request, HttpServletResponse response){
		MovieLogicImpl logicLayer = new MovieLogicImpl();
		List<Movie> movies = logicLayer.getMovies();
		logicLayer.disconnect();
	}
	
	public void editMovies(HttpServletRequest request, HttpServletResponse response){
		MovieLogicImpl logicLayer = new MovieLogicImpl();
		logicLayer.disconnect();
	}

	public void deleteMovies(HttpServletRequest request, HttpServletResponse response){
		MovieLogicImpl logicLayer = new MovieLogicImpl();
		logicLayer.disconnect();
	}

	public void submitMovies(HttpServletRequest request, HttpServletResponse response){
		MovieLogicImpl logicLayer = new MovieLogicImpl();
		logicLayer.disconnect();
	}

}
