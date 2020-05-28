package controlador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import modelo.Usuario;

public class herramientaJson {

	public static ArrayList<Usuario> lectorUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			FileReader fr = new FileReader("usuario.json");
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

	public static void guardarUsuarios(Usuario usuarioNuevo) {
		ArrayList<Usuario> usuarios = lectorUsuarios();
		usuarios.add(usuarioNuevo);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (FileWriter writer = new FileWriter("usuario.json")) {
			gson.toJson(usuarios, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void escribirFicherCSV(String usuario) {
		String nombreProducto, descripcion, tipoPrenda, marca, precio;
		int id = (int)(Math.round(Math.random() * 1000000));

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

		File tmpDir = new File("./productos.csv");
		String fileName = "productos.csv";
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

		//String [][] matriz= leer(",", "productos");
		List<String[]> productos = leer(",", "productos");
		int encolumnado=15;
		int n=(productos.get(0).length+1)*encolumnado-3;
		System.out.println("+" + pinta_caracter("-",  n) +"+");
		for(int fila = 0;fila<productos.size();fila++)
		{
			String [] item=productos.get(fila);
			for(int columna=0;columna<item.length;columna++) {
				
				int numero_blancos = encolumnado - item[columna].length();

				System.out.print("|" + item[columna] + pinta_caracter(" ", numero_blancos));

			}
			System.out.println("|");
			System.out.println("+" + pinta_caracter("-", n) + "+");
		   
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
}
