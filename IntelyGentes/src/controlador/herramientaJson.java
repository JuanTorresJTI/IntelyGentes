package controlador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Usuario;

public class herramientaJson {

	public static ArrayList<Usuario> lectorUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			FileReader fr = new FileReader("IntelyGentes/usuario.json");
			Gson gson = new Gson();
			Type tipoListaUsuarios = new TypeToken<ArrayList<Usuario>>() {
			}.getType();
			usuarios = gson.fromJson(fr, tipoListaUsuarios);
		} catch (Exception e) {
			System.out.println("Fallo en: " + e);

		}
		return usuarios;
	}

	public static Usuario getUsuario(String email) {
		ArrayList<Usuario> usuarios = lectorUsuarios();
		Usuario u = new Usuario();
		for (int i = 0; i < usuarios.size(); i++) {
			u = usuarios.get(i);
			if (u.getEmail().equalsIgnoreCase(email)) {
				return u;
			}
		}
		return u;
	}
	
	public static int contarUsuarios() {
		int cantUsuarios = 0;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = lectorUsuarios();
		
		for (int i = 0; i < usuarios.size(); i++) {
			cantUsuarios++;
		}
		return cantUsuarios;
	} 
	
	public static void guardarUsuarios(Usuario usuarioNuevo) {
		ArrayList<Usuario> usuarios = lectorUsuarios();
		usuarios.add(usuarioNuevo);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (FileWriter writer = new FileWriter("IntelyGentes/usuario.json")) {
			gson.toJson(usuarios, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static void escribirFicherCSV(String usuario) {
		String nombreProducto, descripcion, tipoPrenda, marca, precio;
		int id = (int) (Math.round(Math.random() * 1000000));

		Scanner in = new Scanner(System.in);
		System.out.println("Introduce los valores de tu producto");

		System.out.println("------------------------------------");
		System.out.print("Nombre del Producto: ");
		nombreProducto = in.nextLine();

		System.out.print("Marca: ");
		marca = in.nextLine();

		System.out.print("Tipo de Prenda: ");
		tipoPrenda = in.nextLine();

		System.out.println("Descripción del producto: ");
		descripcion = in.nextLine();

		System.out.print("Precio del producto: ");
		precio = in.nextLine();
		System.out.println("------------------------------------");

		File tmpDir = new File("IntelyGentes/productos.csv");
		String fileName = "IntelyGentes/productos.csv";
		if (tmpDir.exists()) {
			try (FileWriter writer = new FileWriter(fileName, true)) {
				writer.append(Integer.toString(id) + ", " + nombreProducto + ", " + descripcion + ", " + tipoPrenda
						+ ", " + marca + ", " + usuario + ", " + precio);
				writer.append(System.lineSeparator());
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try (FileWriter writer = new FileWriter(fileName, true)) {
				writer.append("ID, NombreProducto, Descripción, TipoPrenda, Marca, NombreVendedor, Precio");
				writer.append(System.lineSeparator());
				System.out.println("+" + pinta_caracter("-", 126) + "+");
				writer.append(Integer.toString(id) + ", " + nombreProducto + ", " + descripcion + ", " + tipoPrenda
						+ ", " + marca + ", " + usuario + ", " + precio);
				writer.append(System.lineSeparator());

				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String pinta_caracter(String ch, int n) {
		String caracter = ch;
		for (int i = 0; i < n; i++) {
			caracter += ch;
		}
		return caracter;
	}

	public static void mostrarProductos() {
		List<String[]> prod = leer(",", "IntelyGentes/productos.csv");
		int encolumnado = 15;
		int n = (prod.get(0).length + 1) * encolumnado - 3;
		System.out.println("+" + pinta_caracter("-", n) + "+");
		for (int fila = 0; fila < prod.size(); fila++) {
			String[] item = prod.get(fila);
			for (int columna = 0; columna < item.length; columna++) {
				int numero_blancos = encolumnado - item[columna].length();
				System.out.print("|" + item[columna] + pinta_caracter(" ", numero_blancos));
			}
			System.out.println("\n+" + pinta_caracter("-", n) + "+");

		}

	}

	public static List<String[]> leer(String separator, String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			List<String[]> list = new ArrayList<>();
			String line = "";
			while ((line = reader.readLine()) != null) {
				String[] array = line.split(separator);
				list.add(array);
			}
			return list;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static int contarProductos() {
		int cantProd = 0;
		List<String[]> prod = leer(",", "IntelyGentes/productos.csv");
		for (int i = 0; i < prod.size(); i++) {
			cantProd++;
		}
		return cantProd;
	}

	public static double mediaProductos() {
		double precioMedio = 0;
		List<String[]> prod = leer(",", "IntelyGentes/productos.csv");
		
		for (int fila = 0; fila < prod.size(); fila++) {
			String[] item = prod.get(fila);
			for (int columna = 0; columna < item.length; columna++) {
				if (columna == item.length - 1 && !(item[columna].toUpperCase().equals("PRECIO"))) {
					precioMedio += Double.parseDouble(item[columna]);
				}
			}

		}
		precioMedio = precioMedio/prod.size();
		return precioMedio;
	}
}
