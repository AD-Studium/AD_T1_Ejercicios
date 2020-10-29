/*
 * Implementa un método que dado una ruta, imprima por pantalla todos los elementos que contiene la carpeta.
 */
package es.studium.ClaseFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio01_MostrarElementosDirectorio_NIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ejercicio1 ("C:/Users/Alvca/OneDrive/2 DAM/Aceso a Datos");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void ejercicio1(String pathname) throws IOException {
		Path path = Paths.get(pathname);
		Files.list(path).forEach(file -> {
			System.out.println(file.getFileName());
		});
	}
}
