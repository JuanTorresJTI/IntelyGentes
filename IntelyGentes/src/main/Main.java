package main;

import java.util.Scanner;

import modelo.Usuario;

public class Main {

	public static void main(String[] args) {
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



	

}
