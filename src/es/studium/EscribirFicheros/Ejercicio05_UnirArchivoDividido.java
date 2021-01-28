/**
 * 
 */
package es.studium.EscribirFicheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Alvca
 *
 */
public class Ejercicio05_UnirArchivoDividido {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		unsplitFile(".\\src\\es\\studium\\EscribirFicheros\\dividir.txt");
	}
	private static void unsplitFile(String fileName) {
		File file = new File(fileName);
		int i = file.getName().lastIndexOf("."), index = 1;
		String name = file.getName().substring(0, i);
		try {
			FileOutputStream outputStream = new FileOutputStream(file, true);
			while (true) {
				File partialFile = new File(file.getParent(), name + "." + index);
				if (!partialFile.exists())
					break;
				FileInputStream inputStream = new FileInputStream(partialFile);
				byte[] buffer = new byte[(int) partialFile.length()];
				inputStream.read(buffer);
				outputStream.write(buffer);
				inputStream.close();
				partialFile.delete();
				index++;
			}
			outputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
			;
		} catch (IOException e) {
			System.out.println("Error al leer");
		}
	}
}
