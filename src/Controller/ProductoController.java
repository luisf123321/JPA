package Controller;

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
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import models.Catalogo;
import models.Catalogo_Producto;
import models.Cliente;
import models.Producto;
import models.Productos;

@Path("/Productos")
public class ProductoController {
	
	private List<Producto> extracted() {
		final EntityManager eM = Persistence.createEntityManagerFactory("JPAProfundizacion").createEntityManager();
		final Query query = eM.createNamedQuery("Producto.findAll");
		List resultList = query.getResultList();
		return resultList;
	}
	
	public void ListaProducto() {
		final List<Producto> resultList = extracted();
		List<Producto> productos = new ArrayList<>();
		for (Producto pro : resultList) {
			System.out.println(pro.getNombre());
			productos.add(pro);
		}
		System.out.println(productos);

	}
		
	@GET
	@Path("/list")
	@Produces("application/json")
	public List<Producto> buscar(@Context HttpServletRequest request) {
		List<Producto> productos = new ArrayList<>();		
		List<Producto> pro = extracted();
		for(Producto p : pro ) {
			Producto pr = new Producto();
			pr.setIdProducto(p.getIdProducto());
			pr.setNombre(p.getNombre());
			pr.setDescripcion(p.getDescripcion());
			productos.add(pr);
		}
		System.out.print(productos);
		return productos;
	}
	@GET
	@Path("/lista/{category_id}")
	@Produces("application/json")
	public List<Productos> buscarId(@PathParam(value = "category_id")int categoria) {
		
		System.out.println(categoria);
		
		List<Productos> productos = new ArrayList<>();
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPAProfundizacion" );
        EntityManager entitymanager = emfactory.createEntityManager();
        Query query = entitymanager.createQuery( "Select cp  FROM Catalogo_Producto cp JOIN cp.catalogo cpp WHERE cpp.idCatalogo = "+categoria);
        List<Catalogo_Producto> list=(List<Catalogo_Producto>)query.getResultList( );
        if(list!=null) {
        	System.out.println("no null");
        	for( Catalogo_Producto us:list )
	        {
        		System.out.println(us.getPrecio());       		
        		Productos pros = new Productos();
        		pros.setIdProducto(us.getProducto().getIdProducto());
        		pros.setDescripcion(us.getProducto().getDescripcion());
        		pros.setNombre(us.getProducto().getNombre());
        		pros.setPrecio(us.getPrecio());
        		System.out.println(us.getProducto().getIdProducto());   
        		System.out.println(us.getProducto().getDescripcion());   
        		System.out.println(us.getProducto().getNombre());   
        		System.out.println(us.getPrecio());   
        		//dtf.setCatalogoProducto(us.getCatalogoProducto());
        		productos.add(pros);
	        }
        }else {
        	System.out.println("null");
        }
        System.out.println(productos);
        
		System.out.println(productos);
		return productos;
	}
	@GET
	@Path("/lista/id/{id}")
	@Produces("application/json")
	public List<Producto> buscarPr(@PathParam(value = "id")int id) {
		List<Producto> productos = null;	
		try {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPAProfundizacion" );
	        EntityManager entitymanager = emfactory.createEntityManager();
	        
	        //Between
	        Query query = entitymanager.createQuery( "Select pr " + "from Producto pr" + "WHERE pr.idProducto = "+id );
	        List<Producto> list=(List<Producto>)query.getResultList( );
	        Query query2 = entitymanager.createQuery( "Select cp " + "from Catalogo_Producto cp" + "WHERE cp.producto = " +id );
	        List<Catalogo_Producto> list2=(List<Catalogo_Producto>)query2.getResultList( );
	        if(list!=null) {
	        	productos = new ArrayList<>();
	        	for( Producto pr:list )
		        {
	        		Producto producto = new Producto();
					producto.setIdProducto(pr.getIdProducto());
					producto.setNombre(pr.getNombre());;
					//producto.setCatalogoProductos(pr.getCatalogoProductos());		        
					productos.add(producto);
		        }
	        }
			
	
			
		}catch (Exception e){
			System.out.println(e.getMessage());
			
		}
		System.out.println(productos);
		
		return productos;
	}
	@DELETE
	@Path("/Delete/{id}")
	@Produces("application/json")
	public boolean eliminar(@PathParam(value = "id")int id)  {
		
		boolean flag = false;
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPAProfundizacion" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );
	      
	    Producto pro=entitymanager.find(Producto.class, id );
	    entitymanager.remove( pro );
	    entitymanager.getTransaction( ).commit( );
	    entitymanager.close( );
	    emfactory.close( );
		
		return flag;
		
		
	}
	
	

}
