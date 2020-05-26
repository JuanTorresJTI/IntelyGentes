package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Scanner;

import controlador.herramientaJson;
import modelo.Productos;
import modelo.Usuario;

public class Main {
	public static void main(String[] args) {
		login();
	}

	private static void login() {
		Scanner in = new Scanner(System.in);
		System.out.println("***************************************");
		System.out.println("Bienvenido a la aplicación IntelYGentes");
		System.out.println("***************************************");

		boolean repetir = true;
		while (repetir) {
			
			System.out.println(
					"Qué operación desea realizar? " + "\n\t1.Iniciar sesión" + "\n\t2.Registrarse" + "\n\t3.Salir");
			String respuesta = in.nextLine();
			switch (respuesta) {
			case "1":
				validarUsuario();
				repetir = false;
				break;
			case "2":
				preguntas();
				break;
			case "3":
				System.out.println("Has solicitado salir. ¡Hasta pronto!");
				repetir = false;
				break;
			default:
				System.out.println("Has introducido algo incorrecto");
				System.out.println("Vuelva a introducir una opción:");
				break;
			}
		}
	}

	public static void preguntas() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ha solicitado registrarse. ");
		System.out.print("\nIntroduzca su nombre: ");
		String nombre = teclado.nextLine();
		System.out.print("\nIntroduzca su apellido: ");
		String apellido = teclado.nextLine();
		System.out.print("\nIntroduzca su DNI: ");
		String dni = teclado.nextLine();
		System.out.print("\nIntroduzca su número de teléfono: ");
		String telefono = teclado.nextLine();
		System.out.print("\nIntroduzca su correo electrónico: ");
		String mail = teclado.nextLine();
		System.out.print("\nIntroduzca una constraseña para su cuenta: ");
		String contrasena = teclado.nextLine();
		System.out.println("Ha creado una cuenta correctamente.");

		Usuario usuario1 = new Usuario(dni, nombre, apellido, telefono, contrasena, mail, false);
		herramientaJson.guardarUsuarios(usuario1);
	}
	
	


	public static void validarUsuario() {
		Usuario user;
		Scanner in = new Scanner(System.in);
		boolean salir = true;
		System.out.println("Ha solicitado iniciar sesión");

		do {
			System.out.println("Introduzca su correo electrónico: ");
			String correoUsuario = in.nextLine();

			System.out.println("Introduzca su contraseña: ");
			String contrasenaUsuario = in.nextLine();

			user = herramientaJson.getUsuario(correoUsuario);
			if (user.getContrasena().equals(contrasenaUsuario) && user != null) {
				System.out.println("Bienvenido");
				if (user.isSuperuser()) {
					ventanaSuperUser(user.getNombre(), user.getApellidos());
				} else {
					ventanaUser(user.getNombre(), user.getApellidos());
				}
				salir = false;
			} else {
				System.out.println("Usuario o contraseña incorrecta");
			}
		} while (salir);

	}

	private static void ventanaSuperUser(String nombre, String apellidos) {
		Scanner in = new Scanner(System.in);
		ArrayList<Usuario> usuarios;
		//Productos[][] productos=new Productos(apellidos, apellidos, apellidos, apellidos, apellidos, 0, 0);
		boolean salir = true;
		System.out.println("¡Bienvenido " + nombre + " " + apellidos + "!");
		do {
			System.out.println("---------------------------------------------------------");
			System.out.println("Escoge una opcion (1-3): ");
			System.out.println("\t1) Mostrar Productos");
			System.out.println("\t2) Mostrar Usuarios");
			System.out.println("\t3) Salir");
			System.out.println("---------------------------------------------------------");

			String respuesta = in.nextLine();
			switch (respuesta) {
			case "1":
				herramientaJson.mostrarProductos();
				break;
			case "2":
				usuarios = herramientaJson.lectorUsuarios();
				mostarUsers(usuarios);
				break;
			case "3":
				System.out.println("¡Hasta pronto!");
				salir = false;
				break;
			default:
				System.out.println("Has introducido algo incorrecto");
				System.out.println("Vuelva a introducir una opción:");
				break;
			}
		} while (salir);
	}

	private static void mostarUsers(ArrayList<Usuario> usuarios) {
		System.out.println("Lista de vendedores");
		for (Usuario usuario : usuarios) {
			if (!usuario.isSuperuser()) {
				System.out.println("---------------------------------------------------------");
				System.out.println("Nombre: " + usuario.getNombre());
				System.out.println("Apellidos: " + usuario.getApellidos());
				System.out.println("Email: " + usuario.getEmail());
				System.out.println("Teléfono: " + usuario.getTelefono());
				System.out.println("---------------------------------------------------------");
			}
		}
	}

	private static void ventanaUser(String nombre, String apellidos) {
		Scanner in = new Scanner(System.in);
		boolean salir = true;
		System.out.println("¡Bienvenido " + nombre + " " + apellidos + "!");
		do {
			System.out.println("---------------------------------------------------------");
			System.out.println("Escoge una opcion (1-3): ");
			System.out.println("\t1) Mostrar Productos");
			System.out.println("\t2) Meter Producto");
			System.out.println("\t3) Salir");
			System.out.println("---------------------------------------------------------");

			String respuesta = in.nextLine();
			switch (respuesta) {
			case "1":
				herramientaJson.mostrarProductos();
				break;
			case "2":
				herramientaJson.escribirFicherCSV(nombre + " " + apellidos);
				break;
			case "3":
				System.out.println("¡Hasta pronto!");
				salir = false;
				break;
			default:
				System.out.println("Has introducido algo incorrecto");
				System.out.println("Vuelva a introducir una opción:");
				break;
			}
		} while (salir);
	}

}
