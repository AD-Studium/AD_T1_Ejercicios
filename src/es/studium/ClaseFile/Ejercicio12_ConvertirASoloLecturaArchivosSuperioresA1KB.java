/**
 * Escribe un método que convierta en archivos de sólo lectura todos los archivos mayores de 1 KB del directorio que se pase por parámetro.
 */
package es.studium.ClaseFile;

import java.io.File;
import java.util.Scanner;

/**
 * @author Alvca
 *
 */
public class Ejercicio12_ConvertirASoloLecturaArchivosSuperioresA1KB {
	static Scanner teclado = new Scanner(System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Indique la ruta donde quiere renombrar los directorios");
		String directorio = teclado.nextLine();
		teclado.close();
		ejercicio12(directorio);
	}
	public static void ejercicio12(String pathname) {
		File filePathname = new File(pathname);
		File[] files = filePathname.listFiles();
		for (File file : files) {
			if (file.length() > 1024) {
				file.setReadOnly();
			}
		}
	}
}
