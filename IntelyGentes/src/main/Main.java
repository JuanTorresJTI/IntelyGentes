package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import modelo.Productos;

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
