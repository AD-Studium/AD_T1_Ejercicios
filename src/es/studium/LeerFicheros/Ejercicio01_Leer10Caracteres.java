/*
 * Crear un método que lea los primeros 10 caracteres de un fichero pasado por parámetros. Debe funcionar bien aunque el fichero contenga menos de 10 caracteres.
 */
package es.studium.LeerFicheros;
//Importamos los paquetes necesarios ctl+mayus+o
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio01_Leer10Caracteres {
	//Creamos la clase Main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Llamamos a la funcion. Como esta tiene un throws IOException debemos manejar las excepciones con try y catch
		try {
			readTenCharacters(".\\src\\es\\studium\\LeerFicheros\\prueba.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void readTenCharacters(String fileName) throws IOException {
		//Creamos la clase file y la iniciamos con la ruta y nombre del fichero.
		File file = new File(fileName);
		//Creamos y Iniciamos la clase fileReader dandole los datos de la clase file
		FileReader fileReader = new FileReader(file);
		try {
			int contador = 0;
			//Guardamos en character el valor ascii
			int character = fileReader.read();
			//mientra halla caracteres y tengamos menos de 10 caracteres. Vamos imprimiendo caracteres y leyendo nuevos
			while (character != -1 && contador < 10) {
				System.out.print((char) character);
				character = fileReader.read();
				contador++;
			}
		} 
		//Creamos la excepcion
		catch (IOException e) {
			System.err.println(e.getMessage());
		}
		//Cerramos el fileReader
		fileReader.close();
	}
}
