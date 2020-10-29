/*
 * Escribe un método que recibe la ruta de un archivo. 
 * El método comprobará que se trata de un archivo de texto plano, y en caso afirmativo, pedirá al usuario una palabra y mostrará cuántas veces aparece la palabra en el archivo.
 */
package es.studium.LeerFicheros;
//Importamos los paquetes necesarios ctl+mayus+o
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio04_ContarPalabras {
	//Creamos la clase Main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Llamamos a la funcion.
		countWords(".\\src\\es\\studium\\LeerFicheros\\prueba.txt");
	}
	public static void countWords(String fileName) {
		//Comprobamos que enviamos un archivo txt
		if (fileName.endsWith(".txt")) {
			//Pedimos la palabra a buscar y la leemos por teclado
			System.out.println("Escribe la palabra a buscar: ");
			Scanner reader = new Scanner(System.in);
			String word = reader.nextLine();
			int counter = 0;
			reader.close(); //cerramos el teclado
			//Entramos al fichero
			File file = new File(fileName);
			try {
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				//Leemos las lineas del fichero
				String line = bufferedReader.readLine();
				
				//Mientras linea no sea nulo
				while (line != null) {
					//Guardamos en un array las palabras, reconociendo una palabra si tiene espacio tras ella.
					String[] words = line.split(" ");
					//Guardamos la palabra en un String (guarda cada palabra sustitullendo a la anterior)
					for (String string : words) {
						//Si la palabra coincide sumamos 1 al contador
						if (string.equals(word)) {
							counter++;
						}
					}
					//Leemos la siguiente linea, si no hay se acabara el bucle
					line = bufferedReader.readLine();
				}
				//cerramos el bufferedReader del fichero
				bufferedReader.close();
				//Nos muestra por pantalla la cantidad de veces que aparece la palabra
				System.err.println("En el fichero aparece " + counter + " veces la palabra " + word);
				//Creamos la excepcion imprimiendo el mensaje de error de apertura del fichero
			} catch (FileNotFoundException e) {
				System.err.println("Error al abrir el archivo.");
				//Creamos la excepcion imprimiendo el mensaje de error de lectura
			} catch (IOException e) {
				System.err.println("Error al leer el archivo.");
			}
			//Creamos la excepcion imprimiendo el mensaje de error indicando que el fichero no es un txt
		} else {
			System.err.println("El fichero no es un archivo de texto plano.");
		}
	}
}
