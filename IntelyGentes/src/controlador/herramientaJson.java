package controlador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import modelo.Usuario;

public class herramientaJson {

	public static ArrayList<Usuario> lectorUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			FileReader fr = new FileReader("usuarios.json");
			Gson gson = new Gson();
			Type tipoListaUsuarios = new TypeToken<ArrayList<Usuario>>(){}.getType();
			usuarios = gson.fromJson(fr, tipoListaUsuarios);
		} catch (Exception e) {
			System.out.println("Fallo en: " + e);

		}
		return usuarios;
	}
	
	public static Usuario getUsuario (String email) {
		ArrayList<Usuario> usuarios = lectorUsuarios();
		Usuario u = new Usuario();
		for (int i = 0 ; i < usuarios.size(); i++) {
			u = usuarios.get(i);
			if (u.getEmail().equalsIgnoreCase(email)) {
				return u ;
			}
		}
		return null;
	}

	public static void guardarUsuarios(Usuario usuarioNuevo) {
		ArrayList<Usuario> usuarios = lectorUsuarios();
		usuarios.add(usuarioNuevo);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (FileWriter writer = new FileWriter("usuarios.json")){
			gson.toJson(usuarios, writer);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
