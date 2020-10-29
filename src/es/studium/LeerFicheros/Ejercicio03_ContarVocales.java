/*
 * Escribe un método que pida al usuario una ruta a un fichero de texto y muestre por pantalla el número de vocales sin acentuar que contiene
 */
package es.studium.LeerFicheros;
//Importamos los paquetes necesarios ctl+mayus+o
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Ejercicio03_ContarVocales {
	//Creamos la clase Main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Llamamos a la funcion.
		countVowels(".\\src\\es\\studium\\LeerFicheros\\prueba.txt");
	}
	public static void countVowels(String fileName) {
		//Creamos la clase file y la iniciamos con la ruta y nombre del fichero.
		File file = new File(fileName);
		//Creamos la clase FileReader
		FileReader fileReader;
		try {
			//Iniciamos la clase fileReader dandole los datos de la clase file
			fileReader = new FileReader(file);
			//Iniciamos otras variables
			int numberOfVowels = 0;
			int character;
			try {
				//Guardamos en character el valor ascii
				character = fileReader.read();
				//Creamos un array list con las vocales
				List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");
				//mientra halla caracteres. Si las vocales coinciden con el valor del caracter suma 1 a la variable numberOfVowels
				while (character != -1) {
					if (vowels.contains(String.valueOf((char) character))) {
						//System.out.println("Valor: "+character);
						//System.out.println("Valor: "+String.valueOf((char) character));
						numberOfVowels++;
					}
					//Guardamos en character el siguiente caracter su valor ascii
					character = fileReader.read();
				}
				System.err.println("El fichero tiene " + numberOfVowels + " vocales");
				fileReader.close();
				//Creamos la excepcion imprimiendo el mensaje de error de lectura
			} catch (IOException e) {
				System.err.println("Error al leer el archivo.");
			}
			//Creamos la excepcion imprimiendo el mensaje de error de apertura del fichero
		} catch (FileNotFoundException e) {
			System.err.println("Error al abrir el archivo.");
		}
	}
}
