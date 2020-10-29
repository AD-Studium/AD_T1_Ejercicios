/**
 * Escribe un método que crea una estructura de carpetas de la siguiente forma:
 *
 * En el directorio pasado por parámetro crea 5 carpetas con los nombres de las asignaturas.
 * Dentro de cada carpeta de asignatura, crea 3 carpetas, una por cada trimestre".
 * Dentro de cada trimestre crea 6 carpetas para temas, desde "Tema 1" a "Tema 6".
 */
package es.studium.ClaseFile;

import java.io.File;
import java.util.Scanner;

/**
 * @author Alvca
 *
 */
public class Ejercicio09_CrearDirectorios {
	static Scanner teclado = new Scanner(System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Indique la ruta donde quiere crear los directorios");
		String directorio = teclado.nextLine();
		teclado.close();
		ejercicio9(directorio);
	}
	public static void ejercicio9(String pathname) {
		File filePathname = new File(pathname);
		String[] subjects = {"PMDM", "PSP", "DI", "AD", "SGE"};
		for (int i = 0; i < subjects.length; i++) {
			String subject = subjects[i];
			File subjectFile = new File(filePathname, subject);
			subjectFile.mkdir();
			for (int j = 1; j <= 3; j++) {
				File trimester = new File(subjectFile, "Trimestre " + j);
				trimester.mkdir();
				for (int k = 1; k <= 6; k++) {
					File chapter = new File(trimester, "Tema " + k);
					chapter.mkdir();
				}
			}
		}
	}
}
