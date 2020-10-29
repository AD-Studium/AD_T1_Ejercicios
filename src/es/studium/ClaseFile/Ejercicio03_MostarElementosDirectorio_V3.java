/**
 * Modifica el ejercicio anterior para que aparezcan primero los directorios y luego los archivos.
 */
package es.studium.ClaseFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alvca
 *
 */
public class Ejercicio03_MostarElementosDirectorio_V3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dir ("C:/Users/Alvca/OneDrive/2 DAM/Aceso a Datos");
	}
	public static void dir(String pathname) {
		File filePathname = new File(pathname);
		File[] files = filePathname.listFiles();
		List<File> listTotal = Arrays.asList(files);
		List<File> listFiles = new ArrayList<File>();
		List<File> listDirectories = new ArrayList<File>();
		for (File element : listTotal) {
			if (element.isDirectory()) {
				listDirectories.add(element);
			} else {
				listFiles.add(element);
			}
		}
		System.out.println(" Contenido de la carpeta " + filePathname.getAbsolutePath() + "\n");
		for (File element : listDirectories) {
			String name = element.getName();
			System.out.print("<DIR>\t");
			System.out.println(name);
		}
		for (File element : listFiles) {
			String name = element.getName();
			System.out.print("\t");
			System.out.println(name);
		}
		System.out.println("\t\tHay " + listFiles.size() + " archivos");
		System.out.println("\t\tHay " + listDirectories.size() + " carpetas");
	}
}
