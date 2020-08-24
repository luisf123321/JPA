package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;
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

import models.Catalogo_Producto;
import models.Cliente;
import models.Detalle_Factura;
import models.Factura;
import models.Facturas;
import models.Impuesto;
import models.Item;
import models.Tienda;
import models.Usuario;



@Path("/Factura")
public class FacturaController {
	
	@GET
	@Path("/Nuevo")
	@Produces("application/json")
	public String crear(@Context HttpServletRequest request) throws SQLException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		ArrayList cart = (ArrayList) session.getAttribute("cart");
		
		double valor_total = 0;
		for (int i = 0; i < cart.size(); i = i + 1) {
			Item item = (Item) cart.get(i);
			valor_total = valor_total + item.getValor();
		}
		System.out.println(session.getAttribute("user"));
		System.out.println(session.getAttribute("IdCliente"));
		
		int user =  (int) session.getAttribute("user");
		int idcliente =  (int) session.getAttribute("IdCliente");
		
		System.out.println(idcliente);
		
		Date date = new Date();
		LocalDate fecha = LocalDate.now();
		int fechaD= fecha.getDayOfMonth();
		int fechaM= fecha.getMonthValue();
		int fechaY= fecha.getYear();
		int fechaHH= fecha.getDayOfMonth();
		LocalTime hora = LocalTime.now();
		int horaH = hora.getHour();
		int horaM = hora.getMinute();
		int idventa=0;				
		try {
			Clientes cliente = new Clientes();
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPAProfundizacion" );
		    EntityManager entitymanager = emfactory.createEntityManager( );
		    entitymanager.getTransaction( ).begin( );
		    Factura factura = new Factura();
		    factura.setFecha(fechaD+"/"+fechaM+"/"+fechaY);
		    factura.setHora(horaH+":"+horaM);
		    factura.setValor_Total(""+valor_total);
		    factura.setCliente(cliente.buscarCliente(idcliente));
		    factura.setUsuario(buscarUsuario(user));
		    factura.setImpuesto(buscarImp(1));
		    factura.setTienda(buscartienda(1));		    
		    entitymanager.persist( factura );
		    entitymanager.flush();
		    System.out.print(factura.getIdVenta());
		    idventa =factura.getIdVenta();
		    session.setAttribute("venta", idventa);
		    entitymanager.getTransaction().commit( );
		    entitymanager.close( );
		    
		    emfactory.close( );	
			
		}catch(Exception e) {
			System.out.println(e);
			//con.rollback();			
		}
		try {
			for (int i = 0; i < cart.size(); i = i + 1) {
				Item item = (Item) cart.get(i);
				int cantidad = item.getCantidad();
				int id = item.getId();
				int idCP=0;
				
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPAProfundizacion" );
		        EntityManager entitymanager = emfactory.createEntityManager();
		        Query query = entitymanager.createQuery( "Select cp FROM Catalogo_Producto cp JOIN cp.producto d WHERE d.idProducto = "+id );
		        List<Catalogo_Producto> list=(List<Catalogo_Producto>)query.getResultList( );
		        if(list!=null) {
		        	for( Catalogo_Producto us:list )
			        {
						idCP = us.getIdCatalogo_Productos();
						venta(idCP,idventa,cantidad);
			        }
		        }							
			}
			
		}catch(Exception e) {
			System.out.println(e);
			//con.rollback();			
		}		
		return "ok";	
	}
	
	
	public void venta(int id, int venta,int cantidad) throws SQLException {
		
		System.out.println(id);
		System.out.println(venta);
		System.out.println(cantidad);
		
		try {	
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPAProfundizacion" );
		    EntityManager entitymanager = emfactory.createEntityManager( );
		    entitymanager.getTransaction( ).begin( );
		    Detalle_Factura detalle = new Detalle_Factura();
		    detalle.setCantidadCompra(cantidad);
		    Factura f = new Factura();
		    f.setIdVenta(venta);
		    detalle.setFactura(f);
		    Catalogo_Producto cp = new Catalogo_Producto();
		    cp.setIdCatalogo_Productos(id);
		    detalle.setCatalogoProducto(cp);
		    entitymanager.persist( detalle );
		    entitymanager.flush();
		    System.out.print(detalle.getId());
		    int iddetalle = detalle.getId();
		    entitymanager.getTransaction().commit( );
		    entitymanager.close( );	    
		}catch(Exception e) {
					
		}
	}	
	public Usuario buscarUsuario(int id) {
		
		
		Usuario user = new Usuario();
		try {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPAProfundizacion" );
	        EntityManager entitymanager = emfactory.createEntityManager();
	        Query query = entitymanager.createQuery( "Select us " + "from Usuario us " + "WHERE us.idusuarios = "+id );
	        List<Usuario> list=(List<Usuario>)query.getResultList( );
	        if(list!=null) {
	        	
	        	for( Usuario us:list )
		        {
					user = us;
	        		
		        }
	        }
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println(user);
		return user;
	}
	
	public Impuesto buscarImp(int id) {
		
		Impuesto imp = new Impuesto();
		try {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPAProfundizacion" );
	        EntityManager entitymanager = emfactory.createEntityManager();
	        Query query = entitymanager.createQuery( "Select mp " + "from Impuesto mp " + "WHERE mp.idImpuesto = "+id );
	        List<Impuesto> list=(List<Impuesto>)query.getResultList( );
	        if(list!=null) {    	
	        	for( Impuesto us:list )
		        {
					imp = us;	        		
		        }
	        }
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println(imp);
		return imp;
	}
	public Tienda buscartienda(int id) {
		
		Tienda ti = new Tienda();
		try {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPAProfundizacion" );
	        EntityManager entitymanager = emfactory.createEntityManager();
	        Query query = entitymanager.createQuery( "Select t " + "from Tienda t " + "WHERE t.idTienda = "+id );
	        List<Tienda> list=(List<Tienda>)query.getResultList( );
	        if(list!=null) {    	
	        	for( Tienda us:list )
		        {
					ti = us;	        		
		        }
	        }
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println(ti);
		return ti;
	}
	@GET
	@Path("/list")
	@Produces("application/json")
	public List<Facturas> buscar(@Context HttpServletRequest request) throws SQLException {
		
		HttpSession session = request.getSession(false);
		int venta =  (int) session.getAttribute("venta");
		System.out.println("venta " +venta);
		List<Facturas> facturas = new ArrayList<>();
		List fass= new ArrayList<>();
		try {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPAProfundizacion" );
	        EntityManager entitymanager = emfactory.createEntityManager();
	        Query query = entitymanager.createQuery( "Select f FROM Factura f WHERE f.idVenta = "+venta );
	        List<Factura> list=(List<Factura>)query.getResultList( );
	        if(list!=null) {    	
	        	for( Factura us:list )
		        {
					Facturas fac= new Facturas();
					fac.setFecha(us.getFecha());
					fac.setHora(us.getHora());
					fac.setNombreUsuario(us.getUsuario().getNombre());
					fac.setNombreCliente(us.getCliente().getNombre());;
					fac.setValor_Total(us.getValor_Total());
					facturas.add(fac);
		        }
	        }
			
		}catch (Exception e){
			System.out.println(e.getMessage());
			
		}
		
		System.out.println(facturas);
		
		return facturas;
	}
	
	@GET
	@Path("/Fin")
	public void fin(@Context HttpServletRequest request) throws IOException {
		ArrayList<Item> cart = new ArrayList<Item>();
		HttpSession session = request.getSession(false);
		session.removeAttribute("cart");
		session.removeAttribute("IdCliente");
		session.removeAttribute("venta");
	}

	

}
