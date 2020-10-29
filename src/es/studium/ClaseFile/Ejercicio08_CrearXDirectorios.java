/**
 * Escribe un método estático que reciba una ruta y un número entero por parámetros. El método creará una carpeta en el directorio llamada "Oposiciones", y dentro de esta, tantas carpetas como indique el número con nombres "Tema 1", "Tema 2", etc.
 */
package es.studium.ClaseFile;

import java.io.File;
import java.util.Scanner;

/**
 * @author Alvca
 *
 */
public class Ejercicio08_CrearXDirectorios {
	static Scanner teclado = new Scanner(System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Indique la ruta donde quiere crear el directorio Oposiciones");
		String directorio = teclado.nextLine();
		System.out.println("Indique cantidad dirtectorios a crear para los temas");
		int numero = teclado.nextInt();
		ejercicio8 (directorio, numero);
		teclado.close();
	}
	public static void ejercicio8(String pathname, int chapters) {
		File filePathname = new File(pathname, "Oposiciones");
		filePathname.mkdir();
		for (int i = 1; i <= chapters; i++) {
			File newFolder = new File(filePathname, "Tema " + i);
			newFolder.mkdir();
		}
		System.out.println("Directorios Creados");
	}
}
