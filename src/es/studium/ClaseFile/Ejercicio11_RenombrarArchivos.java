/**
 * Escribe un método que renombre todos los archivos PDF de un directorio.
 * Modificar el método para que la extensión se pueda elegir por parámetro.
 */
package es.studium.ClaseFile;

import java.io.File;
import java.util.Scanner;

/**
 * @author Alvca
 *
 */
public class Ejercicio11_RenombrarArchivos {
	static Scanner teclado = new Scanner(System.in);
	static Scanner menus = new Scanner(System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int menu;
		// TODO Auto-generated method stub
		do {
		System.out.println("Indique el numero que desea hacer:");
		System.out.println("1- Renombrar ficheros PDF");
		System.out.println("2- Renombrar ficheros indicando extención por teclado");
		System.out.println("3- Salir");
		menu=menus.nextInt();

		if(menu==1) {
			ejercicio11();
		}else if(menu==2) {
			ejercicio11b();
		}
	}
	while(menu!=3);
	System.out.println("Saliendo del Programa");
	teclado.close();
	menus.close();
		
				
	}
	public static void ejercicio11() {
		System.out.println("Indique la ruta donde quiere renombrar los archivos");
		String pathname = teclado.next();
		File filePathname = new File(pathname);
		File[] files = filePathname.listFiles();
		int index = 1;
		for (File file : files) {
			if (file.isFile()) {
				int i = file.getName().lastIndexOf(".");
				String extension = i > 0 ? file.getName().substring(i) : "";
				if (extension.equals(".pdf")) {
					File newFile = new File(filePathname, "Sin título " + index + ".pdf");
					file.renameTo(newFile);
					index++;
				}
			}
		}
	}
	public static void ejercicio11b() {
		System.out.println("Indique la ruta donde quiere renombrar los archivos");
		String pathname = teclado.next();
		System.out.println("Indique la extencion");
		String extensionCheck = teclado.next();
		File filePathname = new File(pathname);
		File[] files = filePathname.listFiles();
		int index = 1;
		for (File file : files) {
			if (file.isFile()) {
				int i = file.getName().lastIndexOf(".");
				String extension = i > 0 ? file.getName().substring(i) : "";
				if (extension.equals("." + extensionCheck)) {
					File newFile = new File(filePathname, "Sin título " + index + extension);
					file.renameTo(newFile);
					index++;
				}
			}
		}
	}
}
