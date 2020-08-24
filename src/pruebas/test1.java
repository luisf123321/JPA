package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.jupiter.api.Test;

import Controller.CatalogoController;
import Controller.Clientes;
import Controller.FacturaController;
import Controller.ProductoController;
import models.Catalogo;
import models.Catalogo_Producto;
import models.Cliente;
import models.Detalle;
import models.Detalle_Factura;
import models.Factura;
import models.Producto;
import models.Productos;
import models.Usuario;

class test1 {

	@Test
	void test() {
		List<Productos> productos = new ArrayList<>();
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPAProfundizacion" );
        EntityManager entitymanager = emfactory.createEntityManager();
        Query query = entitymanager.createQuery( "Select cp  FROM Catalogo_Producto cp JOIN cp.catalogo cpp WHERE cpp.idCatalogo = 2");
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
        
        
	}

}
