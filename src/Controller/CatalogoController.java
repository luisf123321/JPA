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
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import models.Catalogo;
import models.Producto;


@Path("/Categorias")
public class CatalogoController {
	
	public void ListaCatalogo() {
		final List<Catalogo> resultList = extracted();
		for (Catalogo cl : resultList) {
			System.out.println(cl.getNombre() + "-" + cl.getIdCatalogo());
		}

	}
	private List<Catalogo> extracted() {
		final EntityManager eM = Persistence.createEntityManagerFactory("JPAProfundizacion").createEntityManager();
		final Query query = eM.createNamedQuery("Catalogo.findAll");
		List resultList = query.getResultList();
		return resultList;
	}
	

	@POST
	@Path("/Nuevo")
	@Produces("application/json")
	public boolean crear(Catalogo catalogo)  {
				
		boolean flag = true;
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPAProfundizacion" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );

	    Catalogo ca = new Catalogo( ); 
	    ca.setNombre(catalogo.getNombre());
	      
	    entitymanager.persist( ca );
	    entitymanager.getTransaction( ).commit( );

	    entitymanager.close( );
	    emfactory.close( );
		
		return flag;		
	}
	
	
	@GET
	@Path("/list")
	@Produces("application/json")
	public List<Catalogo> buscar(@Context HttpServletRequest request) {
		
		List<Catalogo> catalogos =  new ArrayList<>();		
		List<Catalogo> pro = extracted();
		for(Catalogo c : pro ) {
			Catalogo ca = new Catalogo();
			ca.setIdCatalogo(c.getIdCatalogo());;
			ca.setNombre(c.getNombre());
			catalogos.add(ca);
		}
		System.out.print(catalogos);
		
		return catalogos;		
	}
	
	@DELETE
	@Path("/Delete/{id}")
	@Produces("application/json")
	public boolean eliminar(@PathParam(value = "id")int id)  {
		
		boolean flag = false;
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPAProfundizacion" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );
	      
	    Catalogo employee=entitymanager.find(Catalogo.class, id );
	    entitymanager.remove( employee );
	    entitymanager.getTransaction( ).commit( );
	    entitymanager.close( );
	    emfactory.close( );
		
		return flag;
		
		
	}
	
	
	@PUT
	@Path("/UPDATE")
	@Produces("application/json")
	public boolean actualizar(Catalogo catalogo) {
		// TODO Auto-generated method stub
		boolean flag = false;
		
		return flag;
		
	}

}
