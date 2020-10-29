/**
 * Modifica el ejercicio anterior para que aparezcan primero los directorios y luego los archivos.
 */
package es.studium.ClaseFile;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Alvca
 *
 */
public class Ejercicio03_MostarElementosDirectorio_V3_Stream {

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
		AtomicInteger numberOfFiles = new AtomicInteger(0);
		AtomicInteger numberOfDirectories = new AtomicInteger(0);
		System.out.println(" Contenido de la carpeta " + filePathname.getAbsolutePath() + "\n");
		Arrays.stream(files).filter(file -> file.isDirectory()).forEach(file -> {
			System.out.println("<DIR>\t" + file.getName());
			numberOfDirectories.incrementAndGet();
		});
		Arrays.stream(files).filter(file -> file.isFile()).forEach(file -> {
			System.out.println("\t" + file.getName());
			numberOfFiles.incrementAndGet();
		});
		System.out.println("\t\tHay " + numberOfFiles + " archivos");
		System.out.println("\t\tHay " + numberOfDirectories + " carpetas");
	}
}
