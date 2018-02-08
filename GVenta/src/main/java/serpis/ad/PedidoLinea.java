package serpis.ad;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PedidoLinea {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn (name = "Pedido")
	private Pedido pedido;
	//Muchos pedidos linea componen un pedido
	private BigDecimal precio;
	@ManyToOne
	@JoinColumn (name = "Articulo")
	private Articulo articulo;
	private BigDecimal unidades;
	private BigDecimal importe;
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public BigDecimal getPrecio() {
		return precio;
	}
	
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
	public Articulo getArticulo() {
		return articulo;
	}
	
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	
	public BigDecimal getUnidades() {
		return unidades;
	}
	
	public void setUnidades(BigDecimal unidades) {
		this.unidades = unidades;
	}
	
	public BigDecimal getImporte() {
		return importe;
	}
	
	@Override
	public String toString() {
		return String.format("[%s] %s %s %s€ %s %s€", id, pedido, articulo, precio, unidades,  importe);
	}
}
