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
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import models.Detalle;
import models.Detalle_Factura;
import models.Usuario;

@Path("/Detalle")
public class DetalleController {
	
	@GET
	@Path("/list")
	@Produces("application/json")
	public List<Detalle> buscar(@Context HttpServletRequest request) {
		
		
		HttpSession session = request.getSession(false);
		int venta = (int) session.getAttribute("venta");
	
		
		//List<Detalle_Factura> detalle = new ArrayList<>();
		List<Detalle> detalle = new ArrayList<>();
		try {
			//List<Detalle> detalle = new ArrayList<>();
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPAProfundizacion" );
	        EntityManager entitymanager = emfactory.createEntityManager();
	        Query query = entitymanager.createQuery( "Select df  FROM Detalle_Factura df JOIN df.factura dff where dff.idVenta = "+venta);
	        List<Detalle_Factura> list=(List<Detalle_Factura>)query.getResultList( );
	        if(list!=null) {
	        	System.out.println("no null");
	        	for( Detalle_Factura us:list )
		        {
	        		System.out.println(us.getCantidadCompra());       		
	        		Detalle dtf=  new Detalle();
	        		dtf.setCantidad(us.getCantidadCompra());
	        		dtf.setIdProducto(us.getCatalogoProducto().getProducto().getIdProducto());
	        		dtf.setNombre(us.getCatalogoProducto().getProducto().getNombre());
	        		dtf.setPrecio(us.getCatalogoProducto().getPrecio());
	        		System.out.println(us.getCatalogoProducto().getProducto().getIdProducto());   
	        		System.out.println(us.getCatalogoProducto().getProducto().getNombre());   
	        		System.out.println(us.getCantidadCompra());   
	        		System.out.println(us.getCatalogoProducto().getPrecio());   
	        		//dtf.setCatalogoProducto(us.getCatalogoProducto());
	        		detalle.add(dtf);
		        }
	        }else {
	        	System.out.println("null");
	        }
	        System.out.println(list);
			
			
		}catch(Exception e) {
			System.out.println(e);
			//con.rollback();			
		}		
		// TODO Auto-generated method stub
		return detalle;
	}

	public boolean eliminar(int id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}	

}
