/**
 *Añade un nuevo parámetro de tipo String al método. Si recibe una cadena vacía funciona como hasta ahora, pero en caso contrario mostrará sólo los elementos cuyo nombre comiencen por la cadena dada.
 */
package es.studium.ClaseFile;

import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alvca
 *
 */
public class Ejercicio05_MostarElementosDirectorio_V5 {
	static Scanner teclado = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Indique el parametro a buscar o dejelo en blanco y pulse enter");
		String parametro = teclado.nextLine();
		dir ("C:/Users/Alvca/OneDrive/2 DAM/Aceso a Datos", parametro);
		teclado.close();
	}
	public static void dir(String pathname, String filter) {
		File filePathname = new File(pathname);
		File[] files = null;
		if (filter != "") {
			files = filePathname.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.startsWith(filter);
				}
			});
		} else {
			files = filePathname.listFiles();
		}
		List<File> listTotal = Arrays.asList(files);
		List<File> listFiles = new ArrayList<File>();
		List<File> listDirectories = new ArrayList<File>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		for (File element : listTotal) {
			if (element.isDirectory()) {
				listDirectories.add(element);
			} else {
				listFiles.add(element);
			}
		}
		System.out.println(" Contenido de la carpeta " + filePathname.getAbsolutePath() + "\n");
		for (File element : listDirectories) {
			String lastModified = sdf.format(element.lastModified());
			String name = element.getName();
			System.out.print(lastModified + "\t<DIR>\t");
			System.out.println(name);
		}
		for (File element : listFiles) {
			String lastModified = sdf.format(element.lastModified());
			String name = element.getName();
			System.out.print(lastModified + "\t\t");
			System.out.println(name);
		}
		System.out.println("\t\tHay " + listFiles.size() + " archivos");
		System.out.println("\t\tHay " + listDirectories.size() + " carpetas");
	}
}
