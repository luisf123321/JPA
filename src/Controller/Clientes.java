package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import models.Catalogo;
import models.Cliente;
import models.TipoIdentificacion;
import models.Usuario;

@Path("/Clientes")
public class Clientes  {
	
	@POST
	@Path("/Nuevo")
	@Produces("application/json")
	public String crearCliente(Cliente cliente) throws SQLException {
		
	
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );

	    Cliente ca = new Cliente( ); 
	    ca.setNombre(cliente.getNombre());
	    ca.setApellido(cliente.getApellido());
	    ca.setCelular(cliente.getCelular());
	    ca.setDirecion(cliente.getDirecion());
	    ca.setNumero_Identificacion(cliente.getNumero_Identificacion());
	    TipoIdentificacion tp = new TipoIdentificacion(); 
	    tp.setIdtipoIdentificacion(1);
	    ca.setTipoIdentificacion(tp);
	      
	    entitymanager.persist( ca );
	    entitymanager.getTransaction( ).commit( );

	    entitymanager.close( );
	    emfactory.close( );
		
		return "ok resgistro cliente";
		
	}
	
	@GET
	@Path("/list/{cedula}")
	@Produces("application/json")
	public List<Cliente> buscarDocumento(@Context HttpServletRequest request,@PathParam(value = "cedula") int cedula) {
		
		HttpSession session = request.getSession(false);
		if(session.getAttribute("IdCliente") != null) {
			session.removeAttribute("IdCliente");
		}
		List<Cliente> clientes = null;
		
		try {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPAProfundizacion" );
	        EntityManager entitymanager = emfactory.createEntityManager();
	        
	        //Between
	        Query query = entitymanager.createQuery( "Select cl " + "from Cliente cl " + "WHERE cl.numero_Identificacion = "+cedula );
	        List<Cliente> list=(List<Cliente>)query.getResultList( );
	        if(list!=null) {
	        	clientes = new ArrayList<>();
	        	for( Cliente cl:list )
		        {
	        		Cliente cliente = new Cliente();
					cliente.setIdCliente(cl.getIdCliente());
					cliente.setNombre(cl.getNombre());
					cliente.setApellido(cl.getApellido());
					cliente.setDirecion(cl.getDirecion());
					cliente.setCelular(cl.getCelular());
					clientes.add(cliente);
					session.setAttribute("IdCliente", cliente.getIdCliente());
					System.out.println("id cliente  : "+session.getAttribute("IdCliente"));
		        }
	        }				
			
		}catch (Exception e){
			System.out.println(e.getMessage());
			
		}
		System.out.println(clientes);
		
		return clientes;
	}
	
	@GET
	@Path("/Delete/{numero_identificacion}")
	@Produces("application/json")
	public boolean eliminar(@PathParam(value = "numero_identificacion")int numero_identificacion) {
		
		boolean flag = false;
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPAProfundizacion" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );
	    Cliente cl = entitymanager.find(Cliente.class, numero_identificacion );
	    entitymanager.remove( cl );
	    entitymanager.getTransaction( ).commit( );
	    entitymanager.close( );
	    emfactory.close( );
		return flag;
		
		
	}

	public List buscar(HttpServletRequest request)  {
		// TODO Auto-generated method stub
		return null;
	}
	public Cliente buscarCliente(int cedula) {
		
		//List<Cliente> clientes = null;
		Cliente cliente = new Cliente();
		try {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPAProfundizacion" );
	        EntityManager entitymanager = emfactory.createEntityManager();
	        
	        //Between
	        Query query = entitymanager.createQuery( "Select cl " + "from Cliente cl " + "WHERE cl.idCliente = "+cedula );
	        List<Cliente> list=(List<Cliente>)query.getResultList( );
	        if(list!=null) {
	        	//clientes = new ArrayList<>();
	        	for( Cliente cl:list )
		        {
					cliente.setIdCliente(cl.getIdCliente());
					cliente.setNombre(cl.getNombre());
					cliente.setApellido(cl.getApellido());
					cliente.setDirecion(cl.getDirecion());
					cliente.setCelular(cl.getCelular());
					//clientes.add(cliente);
					//session.setAttribute("IdCliente", cliente.getIdCliente());
		        }
	        }
		}catch (Exception e){
			System.out.println(e.getMessage());
			
		}
		System.out.println(cliente);
		
		
		return cliente;
	}
	
	

}
