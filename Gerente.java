import java.io.*;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.LinkedList;

//StringTokenizer tokens = new StringTokenizer(br.readLine(),"\n");//br.readLine(); : Una sola inea de texto
		
public class Gerente{
	private String contrasena;
	private String nombreGerente = "Andres";
	private String archContrasena = "Contrasena.txt";
	private String rutaRegistro = "Registro.txt";
	
	public Gerente()throws IOException{
		System.out.println("Creando gerente");
		obtenerContrasena();
	}

	private void obtenerContrasena() throws IOException{ 
		FileReader fr = new FileReader(this.archContrasena);
		BufferedReader br = new BufferedReader(fr);		
		this.contrasena = br.readLine();
		System.out.println("La contrasena es:  "+this.contrasena);
	}

	/** Metodo encargado de crear un nuevo producto mediante la creacion de un archivo .txt*/
	public void agregarProducto()throws IOException{
		Scanner scan = new Scanner(System.in);
		System.out.println("¿Como deceas que se llame el producto?");
		String nombre = scan.nextLine();
		//Instancia una onjeto de tipo Producto y acontinuacion, le asigna un nombre.
		Producto nuevoProducto = new Producto();
		nuevoProducto.setNombreProducto(nombre);//Se le da el atributo nombre a la clase producto

		String archProducto =  nombre + (".txt");
		System.out.println("El archivo del producto: " + archProducto);
		//Se crea el .txt que almacenara al nuevo producto
		File newPro = new File(archProducto);
		if (!newPro.exists()){
			newPro.createNewFile();
			actualizarRegistro(nombre, 0);//Agrefara el product al registro
			editarProducto(archProducto, nuevoProducto);//Escribir los datos del archivo en su archivo
		}else{
			System.out.println("El producto ya existe");
		}
		
	}

	/** Metodo encargado de editar el archivo .txt de un producto*/
	public void editarProducto(String archProducto, Producto nuevoProducto)throws IOException{
		//Metodos para escribir en el archivo
		nuevoProducto.datosProductoEntrada();//Para el precio y la descripcion del producto

		FileWriter fw = new FileWriter(archProducto);
		BufferedWriter bw = new BufferedWriter(fw);
		System.out.println(nuevoProducto.toString());
		bw.write(nuevoProducto.toStringDatos());
		bw.close();
		fw.close();
	}

	/** Elimina un producto desaciendoce de su archivo .txt*/
	public void eliminarProducto()throws IOException{
		Scanner scan = new Scanner(System.in);
		LinkedList<String> listRegistro = new LinkedList();
		System.out.println("Estos son los productos existentes:");
		leturaDeRegistro();

		System.out.println("Introduce el nombre del producto que deceas eliminar");
		String proELi = scan.nextLine();

		boolean existe = consulta(proELi);

		if (existe){
			File proELiArch = new File(proELi +".txt");
			proELiArch.delete();
			actualizarRegistro(proELi, 1);
		}else{
			System.out.println("Producto no existente");
		}

	}

	/** Nos permite ingresar conocer el valor de la contraseña*/
	public String getContrasena(){
		return this.contrasena;
	}

	private void actualizarRegistro(String nombre, int nuevo)throws IOException{
		if (nuevo == 0){
			FileWriter fw = new FileWriter("Registro.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			System.out.println(nombre);
			bw.write(nombre);
			bw.newLine();
			bw.close();
			fw.close();
		}else{
			FileWriter fw = new FileWriter("Registro.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			LinkedList<String> nuevaList = new LinkedList();
			LinkedList<String> listRegistro = new LinkedList();

			listRegistro = lista();

			for (int i = 0; i<listRegistro.size(); i++){
				if (nombre.equals(listRegistro.get(i))){
					System.out.println("Eliminado");
				}else{
					nuevaList.add(listRegistro.get(i));
				}
			}

			for(int ii =0; ii<nuevaList.size(); ii++){
				System.out.println(nuevaList.get(ii));
			}
			for(int ii =0; ii<nuevaList.size(); ii++){
				bw.write(nuevaList.get(ii));
				bw.newLine();
			}

			bw.close();
			fw.close();

		}

	}
/**Metodo encargado de hacer una lectura al achivo en donde se guardan los nombres de los productos*/
	public void leturaDeRegistro()throws IOException{
		//Metodos de escritura
		FileReader fr = new FileReader("Registro.txt");
		BufferedReader br = new BufferedReader(fr);

		LinkedList<String> listRegistro = new LinkedList();
		String line ="";
		while ((line = br.readLine()) != null){
			listRegistro.add(line);
		}

		br.close();
		fr.close();

		for (int i=0; i<listRegistro.size();i++){
			System.out.println(listRegistro.get(i));
		}
	}
	/*Verifica si un producto se encuentra en el registro*/
	public boolean consulta(String proELi)throws IOException{
		FileReader fr = new FileReader("Registro.txt");
		BufferedReader br = new BufferedReader(fr);

		LinkedList<String> listRegistro = new LinkedList();
		String line ="";
		while ((line = br.readLine()) != null){
			listRegistro.add(line);
		}

		br.close();
		fr.close();

		boolean existe = false;
		for (int i = 0; i < listRegistro.size(); i++){
			if (proELi.equals(listRegistro.get(i))){
				existe = true;
			}
		}

		return existe;
	}
  /*Metodo que regresa la lista de los productos*/
	public LinkedList<String> lista()throws IOException{
		FileReader fr = new FileReader("Registro.txt");
		BufferedReader br = new BufferedReader(fr);

		LinkedList<String> listRegistro = new LinkedList();
		String line ="";
		while ((line = br.readLine()) != null){
			listRegistro.add(line);
		}

		br.close();
		fr.close();

		return listRegistro;
	}

}