package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import models.Catalogo_Producto;
import models.Item;
import models.Producto;


@Path("/item")
public class ItemController {
	
	
	@GET
	@Path("/add/{product_id}/{cantidad}")
	@Produces("application/json")
	public String guardar(@Context HttpServletRequest request,@PathParam(value = "product_id") int product_id, @PathParam(value = "cantidad") int cantidad) throws SQLException {
		HttpSession session = request.getSession(false);
		ArrayList cart = (ArrayList) session.getAttribute("cart");
		
		if (cart == null) {
			cart = new ArrayList();
		}
		
		for (int i = 0; i < cart.size(); i = i + 1) {
			Item item = (Item) cart.get(i);
			long id = item.getId();

			if (id == product_id) {
				long items = cart.size();
				String result = "{\"items\":" + items + "}";
				return "ok";
			}
		}

		Item item = new Item();
		item.setId(product_id);
		item.setQuantity(1);
		
		try {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPAProfundizacion" );
	        EntityManager entitymanager = emfactory.createEntityManager();
	        EntityManager entitymanager2 = emfactory.createEntityManager();
	        List<Producto> productos;
	        //Between
	        Query query = entitymanager.createQuery( "Select pr FROM Producto pr WHERE pr.idProducto = "+product_id );
	        List<Producto> list=(List<Producto>)query.getResultList( );
	        Query query2 = entitymanager2.createQuery( "Select cp FROM Catalogo_Producto cp JOIN cp.producto d WHERE d.idProducto = "+product_id);
	        		//+ "Select pr FROM Producto pr INNER JOIN Catalogo_Producto cp ON pr.idProducto = cp.producto WHERE pr.idProducto =" +product_id );
	        List<Catalogo_Producto> list2=(List<Catalogo_Producto>)query2.getResultList( );
	        if(list!=null) {
	        	System.out.println("list producto no null");
	        	productos = new ArrayList<>();
	        	for( Producto pr:list )
		        {	
	        		int pricing = 10000;
	        		for(Catalogo_Producto cpr:list2) {
	        			pricing = cpr.getPrecio();
	        			System.out.println("precio "+pricing);
	        		}
	        		item.setNombre(pr.getNombre());
					item.setPrecio(pricing);
					item.setId(pr.getIdProducto());
					item.setCantidad(cantidad);
					double valor = pricing*cantidad;
					item.setValor(valor);
					System.out.println(valor);
	        		//pricing = cpro.getPrecio();
		        }
	        	for(Catalogo_Producto cpr:list2) {
	        		System.out.println("precio can "+cpr.getCantidadDisponible());
	        		System.out.println("precio id "+cpr.getIdCatalogo_Productos());
        			System.out.println("precio "+cpr.getPrecio());
        		}
	        }else {
	        	System.out.println("list pro null");
	        }
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}		
		cart.add(item);
		System.out.println(cart.size());
		System.out.println(cart);
		
		session.setAttribute("cart", cart);

		long items = cart.size();
		String result = "{\"items\":" + items + "}";
		System.out.println(result);
	
		
		return "ok";
	}
	
	@GET
	@Path("/list")
	@Produces("application/json")
	public List getItems(@Context HttpServletRequest request) {
		ArrayList<Item> cart = new ArrayList<Item>();
		HttpSession session = request.getSession(false);

		cart = (ArrayList<Item>) session.getAttribute("cart");

		if (cart == null) {
			cart = new ArrayList<Item>();
		}

		return cart;
	}
	
	@GET
	@Path("/Cancelar")
	@Produces("application/json")
	public void cancelar(@Context HttpServletRequest request, HttpServletResponse response) throws IOException {
		ArrayList<Item> cart = new ArrayList<Item>();
		HttpSession session = request.getSession(false);
		session.removeAttribute("cart");
		session.removeAttribute("IdCliente");
	}
	
	
	

}
