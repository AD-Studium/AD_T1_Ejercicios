/**
 * Crea un m�todo que renombre s�lo las carpetas de un directorio. Pon los nombres "Sin t�tulo 1", "Sin t�tulo 2", etc.
 */
package es.studium.ClaseFile;

import java.io.File;
import java.util.Scanner;

/**
 * @author Alvca
 *
 */
public class Ejercicio10_RenombrarDirectorios {
	static Scanner teclado = new Scanner(System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Indique la ruta donde quiere renombrar los directorios");
		String directorio = teclado.nextLine();
		teclado.close();
		ejercicio10(directorio); 
	}
	public static void ejercicio10(String pathname) {
		File filePathname = new File(pathname);
		File[] files = filePathname.listFiles();
		int index = 1;
		for (File file : files) {
			if (file.isDirectory()) {
				File newFile = new File(filePathname, "Sin t�tulo " + index);
				file.renameTo(newFile);
				index++;
			}
		}
	}
}
