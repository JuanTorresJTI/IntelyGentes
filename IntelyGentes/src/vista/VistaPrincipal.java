package vista;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VistaPrincipal {

	public void menu() {
		Scanner in = new Scanner(System.in);
		String opcion = "";
		
		System.out.println("---------------------------------------------------------");
		System.out.println("Escoge una opcion (1-4): ");
		System.out.println("1) Mostrar Productos");
		System.out.println("2) Meter Producto");
		System.out.println("3) Eliminar Producto");
		System.out.println("4) Salir");
		System.out.println("---------------------------------------------------------/n");
		opcion = in.nextLine();
		
		switch (Integer.parseInt(opcion)) {
		case 1:
			mostrarProductos();
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		default:
			break;
		}
	}

	private void mostrarProductos() {
		List<String[]> productos = leer(",", "productos");
	}
	
	public static List<String[]> leer(String separator, String fileName){
	    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
	        List<String[]> list = new ArrayList<>();
	        String line = "";
	        while((line = reader.readLine()) != null){
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
