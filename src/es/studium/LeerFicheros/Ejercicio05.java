/**
 * 
 */
package es.studium.LeerFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Alvca
 *
 */
public class Ejercicio05 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		grades(".\\src\\es\\studium\\EscribirFicheros\\Alumnos\\");
	}
	public static void grades(String fileName) {
		System.out.println("Escribe el nombre del alumno: ");
		Scanner reader = new Scanner(System.in);
		String alumn = reader.nextLine();
		reader.close();
		File file = new File(fileName, alumn + ".txt");
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine();
			Map<String, String> map = new HashMap<String, String>();
			while (line != null) {
				String[] pair = line.split("=");
				map.put(pair[0], pair[1]);
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
			String passed = Integer.parseInt(map.get("nota")) >= 5 ? "aprobado" : "suspendido";
			String response = "El alumno %s %s ha %s la asignatura %s";
			System.out.println(String.format(response, map.get("nombre"), map.get("apellido"), passed,
					map.get("asignatura")));
		} catch (FileNotFoundException e) {
			System.out.println("Error al abrir el archivo.");
		} catch (IOException e) {
			System.out.println("Error al leer el archivo.");
		}
	}
}
