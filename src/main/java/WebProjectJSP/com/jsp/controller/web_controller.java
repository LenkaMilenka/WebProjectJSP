package WebProjectJSP.com.jsp.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebProjectJSP.com.jsp.session.ArticlesFacade;

@WebServlet(name = "web_controller", loadOnStartup=1, urlPatterns = {"/article", "/registration"})
public class web_controller extends HttpServlet{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	 ArticlesFacade articlesFacade;
	
	 @Override
	 public void init() throws ServletException{
		 getServletContext().setAttribute("articles", articlesFacade.findAll());
	 }
	 
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	 		throws ServletException, IOException{
		 response.setContentType("text/html;charset=UTF-8");
		 String userPath=request.getServletPath();
		 if("/article".equals(userPath)){
			 
		 }else
			 if("/registration".equals(userPath)){
				 
			 }
		 request.getRequestDispatcher("/WEB-INF/views"+userPath+".jsp").forward(request, response);
	 }
	 
	 @Override
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	 		throws ServletException, IOException{
		 processRequest(request, response);
	 }
	 
	 @Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	 		throws ServletException, IOException{
		 processRequest(request, response);
	 }
	 
	 @Override
	 public String getServletInfo(){
		 return "Short description";
	 }
}
