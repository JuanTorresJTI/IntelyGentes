package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import modelo.Productos;
import java.util.Scanner;

import modelo.Usuario;

public class Main {

	public static void main(String[] args) {

		List<String[]> productos = new ArrayList<String[]>();
		String[] producto = new String[7];
		for (int i = 0; i < producto.length; i++) {
			producto[i] = Integer.toString(i + 2);
		}
		productos.add(producto);
		escribir(productos, ",", "productos");

		List<String[]> productos1 = leer(",", "productos");

		for (String[] strings : productos1) {
			for (String strings2 : strings) {
				System.out.print(strings2 + " ");
			}
		}
		login();
	}
	private static void login() {
		//Constructor:
		Scanner teclado = new Scanner(System.in);
		System.out.println("Bienvenido a la aplicación IntelYGentes" ); 
		
		boolean repetir=true;
		while(repetir=true) {
			System.out.println("¿Qué operación desea realizar? " +"\n"+"\t" +
					"1.Iniciar sesión"+ "\n"+"\t"+
					"2.Registrarse" +"\n"+ "\t"+  
					"3.Salir"+ "\n"+"\t");
					String respuesta = teclado.nextLine();
		switch (respuesta){
			case "1":
				validarUsuario();
				repetir=false;
			break;
			case "2":
				preguntas();
				repetir=false;
			break;
			case "3":
				System.out.println("Has solicitado salir. ¡Hasta pronto!");
				repetir=false;
				//System.exit(0);
			default:
				System.out.println("Has introducido algo incorrecto");
				System.out.println("Vuelva a introducir una opción:");
				break;
		}
		}
		
		//dni telefono contraseña mail
}
	public static void escribir(List<String[]> thingsToWrite, String separator, String fileName) {
		try (FileWriter writer = new FileWriter(fileName, true)) {
			for (String[] strings : thingsToWrite) {
				for (int i = 0; i < strings.length; i++) {
					writer.append(strings[i]);
					if (i < (strings.length - 1))
						writer.append(separator);
				}
				writer.append(System.lineSeparator());


			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void preguntas() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ha solicitado registrarse. ");
		System.out.print("\nIntroduzca su nombre: ");
		String nombre=teclado.nextLine();
		System.out.print("\nIntroduzca su apellido: ");
		String apellido =teclado.nextLine();
		System.out.print("\nIntroduzca su DNI: ");
		String dni= teclado.nextLine();
		System.out.print("\nIntroduzca su número de teléfono: ");
		String telefono= teclado.nextLine();
		System.out.print("\nIntroduzca su correo electrónico: ");
		String mail= teclado.nextLine();
		System.out.print("\nIntroduzca una constraseña para su cuenta: ");
		String contrasena= teclado.nextLine();
		System.out.println("Ha creado una cuenta correctamente.");
		
		Usuario usuario1=new Usuario(dni, nombre, apellido, telefono, contrasena, mail, false);
		//guardarUsuarios(usuario1);
	}
	public static void validarUsuario() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ha solicitado iniciar sesión");
		System.out.print("\nIntroduzca su correo electrónico: ");
		String correoUsuario= teclado.nextLine();
		System.out.print("\nIntroduzca su contraseña: ");
		String contrasenaUsuario= teclado.nextLine();
		
	}


	public void escribirFicher(){
		try {
			// create a list of objects
			List<List<String>> records = Arrays.asList(Arrays.asList("1", "John Lee", "US"),
					Arrays.asList("2", "Jovan Roover", "DE"), Arrays.asList("3", "Emma Watson", "UK"));

			// create a writer
			BufferedWriter writer = Files.newBufferedWriter(Paths.get("productos.csv"));

			// write header record
			writer.write("ID,Name,Country");
			writer.newLine();

			// write all records
			for (List<String> record : records) {
				writer.write(String.join(",", record));
				writer.newLine();
			}

			// close the writer
			writer.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	// Allows to define custom separator
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
