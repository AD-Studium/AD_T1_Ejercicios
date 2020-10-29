/**
 * Modifica el ejercicio anterior para que aparezcan primero los directorios y luego los archivos.
 */
package es.studium.ClaseFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Alvca
 *
 */
public class Ejercicio02_MostarElementosDirectorioOrdenado_NIO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ejercicio2 ("C:/Users/Alvca/OneDrive/2 DAM/Aceso a Datos");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void ejercicio2(String pathname) throws IOException {
		Path path = Paths.get(pathname);
		Stream<Path> files = Files.list(path).filter(file -> Files.isDirectory(file));
		Stream<Path> directories = Files.list(path).filter(file -> Files.isRegularFile(file));
	 
		files.forEach(file -> {
			System.out.println("<DIR>\t" + file.getFileName());
		});
	 
		directories.forEach(file -> {
			System.out.println("\t" + file.getFileName());
		});
	}
}
