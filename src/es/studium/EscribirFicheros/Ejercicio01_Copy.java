/*
 * Realizar un programa en java que copie un archivo binario datos01.dat en otro archivo binario datos02.dat.
 * */
package es.studium.EscribirFicheros;
//Importamos los paquetes necesarios ctl+mayus+o
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio01_Copy {
	//Creamos la clase Main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		copy(".\\src\\es\\studium\\EscribirFicheros\\prueba.txt");
	}
	private static void copy(String path) {
		//Creamos la clase file y la iniciamos con la ruta y nombre del fichero.
		File fileA = new File(path, "datos01.dat");
		File fileB = new File(path, "datos02.dat");
		try {
			//Entrada de archivos
			FileInputStream inputStream = new FileInputStream(fileA);
			//Salida de archivos
			FileOutputStream outputStream = new FileOutputStream(fileB);
			
			byte[] buffer = new byte[15];
			int numberOfBytes = inputStream.read(buffer);
			while (numberOfBytes != -1) {
				outputStream.write(buffer, 0, numberOfBytes);
				numberOfBytes = inputStream.read(buffer);
			}
			inputStream.close();
			outputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		} catch (IOException e) {
			System.out.println("Error al leer");
		}
	}
}
