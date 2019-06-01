/** Esta clase estara encargada de tener los atributos de los productos, asi como métodos que retornaran su valor. */

import java.util.Scanner;

public class Producto{

	private String nombreProducto = " ";
	private String descripcion;
	private double precio;
	Scanner scan = new Scanner(System.in);
	Scanner sc = new Scanner(System.in);


	public Producto(){}


	public void datosProductoEntrada(){
		System.out.println("Escribe el precio del producto y preciona ENTER para continuar:");
		this.precio = scan.nextDouble();
		System.out.println("Escribe una descripcion del producto y preciona ENTER para continuar");
		this.descripcion = sc.nextLine();
	}

	public String getNombreProducto(){
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto){
		this.nombreProducto = nombreProducto;	
	}

	public double getPrecioProducto(){
		return this.precio;
	}

	public String getDescripcionProducto(){
		return this.descripcion;
	}
	public String toStringDatos(){
		return (nombreProducto+","+precio+","+descripcion);
	}
}
