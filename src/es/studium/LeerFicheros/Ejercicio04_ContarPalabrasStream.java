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
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio04_ContarPalabrasStream {
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
			reader.close();//cerramos el teclado
			//Entramos al fichero
			File file = new File(fileName);
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
				//Leemos las lineas del fichero comparamos con el texto introducido, si coincide cuenta
				long counter = bufferedReader.lines().flatMap(line -> Arrays.stream(line.split("[\\s,\\.]")))
						.filter(w -> w.equals(word)).count();
				//Nos muestra por pantalla la cantidad de veces que aparece la palabra
				if(counter==1)
				{
					System.out.println("En el fichero aparece " + counter + " vez la palabra " + word);
				}
				else {
					System.out.println("En el fichero aparece " + counter + " veces la palabra " + word);
				}
				//cerramos el bufferedReader del dichero
				bufferedReader.close();
				//Creamos la excepcion imprimiendo el mensaje de error de apertura del fichero
			} catch (FileNotFoundException e) {
				System.out.println("Error al abrir el archivo.");
				//Creamos la excepcion imprimiendo el mensaje de error de lectura
			} catch (IOException e) {
				System.out.println("Error al leer el archivo.");
			}
			//Creamos la excepcion imprimiendo el mensaje de error indicando que el fichero no es un txt
		} else {
			System.out.println("El fichero no es un archivo de texto plano.");
		}
	}
}
