package modelo;

public class Productos {
	private String nombreProducto, descripcion, tipoPrenda, marca, nombreVendedor;
	private int id;
	private double precio;

	public Productos(String nombreProducto, String descripcion, String tipoPrenda, String marca, String nombreVendedor,
			int id, double precio) {
		super();
		this.nombreProducto = nombreProducto;
		this.descripcion = descripcion;
		this.tipoPrenda = tipoPrenda;
		this.marca = marca;
		this.nombreVendedor = nombreVendedor;
		this.id = id;
		this.precio = precio;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoPrenda() {
		return tipoPrenda;
	}

	public void setTipoPrenda(String tipoPrenda) {
		this.tipoPrenda = tipoPrenda;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNombreVendedor() {
		return nombreVendedor;
	}

	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
