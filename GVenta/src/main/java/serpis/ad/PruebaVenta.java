package serpis.ad;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PruebaVenta {

	private static EntityManagerFactory entityManagerFactory; 
 
	public static void main(String[] args) {
		entityManagerFactory = Persistence.createEntityManagerFactory("serpis.ad.gventa");
		
		Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
 
        while (!salir) {
 
        	System.out.println("0. Salir");
            System.out.println("1. Mostrar todo");
            System.out.println("2. Mostrar articulos");
            System.out.println("3. Mostrar categoria");
            System.out.println("4. Mostrar clientes");
            System.out.println("5. Mostrar pedidos");
            System.out.println("6. Mostrar los pedidos de las lineas");
 
            try {
 
                System.out.println("¿Que desea hacer?");
                opcion = sn.nextInt();
 
                switch (opcion) {
                	case 0:
                		salir = true;
                		break;     
                	case 1:
                        showAll();
                        break;
                    case 2:
                    	showArticulo();
                        break;
                    case 3:
                    	showCategoria();
                        break;
                    case 4:
                        showCliente();
                        break;
                    case 5:
                    	showPedido();
                        break;
                    case 6:
                    	showPedidoLinea();
                        break;
                    default:
                        System.out.println("No ha introducido un numero del menú");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
		
		entityManagerFactory.close();
	}
	
	private static void showAll() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Categoria> categorias = entityManager.createQuery("from Categoria order by id", Categoria.class).getResultList();
		for (Categoria categoria : categorias)
			System.out.println(categoria);
		entityManager.getTransaction().commit();
	}
	
	private static void showArticulo() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Articulo> articulos = entityManager.createQuery("from Articulo order by id", Articulo.class).getResultList();
		for (Articulo articulo : articulos)
			System.out.println(articulo);
		entityManager.getTransaction().commit();
	}
	
	private static void showCategoria() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Categoria> categorias = entityManager.createQuery("from Categoria order by id", Categoria.class).getResultList();
		for (Categoria categoria : categorias)
			System.out.println(categoria);
		entityManager.getTransaction().commit();
	}
	
	private static void showCliente() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Cliente> clientes = entityManager.createQuery("from Cliente order by id", Cliente.class).getResultList();
		for (Cliente cliente : clientes)
			System.out.println(cliente);
		entityManager.getTransaction().commit();
	}
	
	private static void showPedido() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Pedido> pedidos = entityManager.createQuery("from Pedido order by id", Pedido.class).getResultList();
		for (Pedido pedido : pedidos)
			System.out.println(pedido);
		entityManager.getTransaction().commit();
	}
	
	private static void showPedidoLinea() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<PedidoLinea> pedidoLineas = entityManager.createQuery("from Pedidolinea order by id", PedidoLinea.class).getResultList();
		for (PedidoLinea pedidoLinea : pedidoLineas)
			System.out.println(pedidoLinea);
		entityManager.getTransaction().commit();
	}
	
}
