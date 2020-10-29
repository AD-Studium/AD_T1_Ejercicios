/*
 * Implementa un método que dado una ruta, imprima por pantalla todos los elementos que contiene la carpeta.
 */
package es.studium.ClaseFile;

import java.io.File;

public class Ejercicio01_MostrarElementosDirectorio_IO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ejercicio1 ("C:/Users/Alvca/OneDrive/2 DAM/Aceso a Datos");
	}
	public static void ejercicio1(String pathname) {
		File filePathname = new File(pathname);
		File[] files = filePathname.listFiles();
		System.out.println(" Contenido de la carpeta " + filePathname.getAbsolutePath() + "\n");
		for (File element : files) {
			String name = element.getName();
			System.out.println(name);
		}
	}
}
