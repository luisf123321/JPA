package login;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Usuario;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("username");
        String password = request.getParameter("password");		
        HttpSession session;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPAProfundizacion" );
        EntityManager entitymanager = emfactory.createEntityManager();
        
        //Between
        Query query = entitymanager.createQuery( "Select us " + "from Usuario us " + "WHERE us.user ='"+userName+"' AND us.password = '"+password+"'" );
        List<Usuario> list=(List<Usuario>)query.getResultList( );
        if(list!=null) {
        	for( Usuario e:list )
	        {
	           System.out.print("Employee ID :" + e.getIdusuarios());
	           System.out.println("\t Employee Name :" + e.getNombre());
	           session = request.getSession();	
	           session.setAttribute("user", e.getIdusuarios());
	           session.setAttribute("username", e.getNombre());
	           System.out.println("id usuario "+e.getIdusuarios());
	           System.out.println("usuario "+ e.getNombre());
	        }
        	response.sendRedirect("index.jsp");
        }else {
        	response.sendRedirect("login.jsp");
        }
		
	}

}
