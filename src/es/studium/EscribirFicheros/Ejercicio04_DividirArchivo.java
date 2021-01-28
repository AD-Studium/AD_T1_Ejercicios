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
public class Ejercicio04_DividirArchivo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		splitFile(".\\src\\es\\studium\\EscribirFicheros\\dividir.txt",10);
	}
	public static void splitFile(String fileName, int size) {
		File file = new File(fileName);
		int i = file.getName().lastIndexOf("."), index = 1;
		String name = file.getName().substring(0, i);
		try {
			FileInputStream inputStream = new FileInputStream(file);
			byte[] buffer = new byte[size];
			while (true) {
				int data = inputStream.read(buffer);
				if (data == -1)
					break;
				File newFile = new File(file.getParent(), name + "." + index);
				FileOutputStream outputStream = new FileOutputStream(newFile);
				outputStream.write(buffer, 0, size);
				outputStream.close();
				index++;
			}
			inputStream.close();
			file.delete();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch (IOException e) {
			System.out.println("Error al leer");
		}
	}
}
