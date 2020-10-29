/*
 * Escribe un programa que guarde en un fichero de texto el progreso de un juego. El juego es muy simple:
 * El juego pide al usuario el nombre del jugador.
 * Después de eso el juego pedirá que el usuario escriba una palabra tras otra hasta escribir la palabra "exit", que saldrá del juego.
 * Al salir se habrá creado un fichero de texto que muestre cuántas veces se han escrito cada palabra.
 * Al empezar el juego de nuevo, si el jugador ya ha jugado antes, la cuenta continuará por donde iba.
 * */
package es.studium.EscribirFicheros;

//Importamos los paquetes necesarios
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio03_JuegoContarPalabras {
//Creamos la clase Main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Llamamos a la funcion.
		gameWord(".\\src\\es\\studium\\EscribirFicheros");
	}
	//Funcion del juego
	public static void gameWord(String fileName) {
		//Nos pide el nombre del Usuario y lo lee por teclado
		System.out.println("Escribe tu nombre de usuario: ");
		Scanner reader = new Scanner(System.in);
		String username = reader.nextLine();
		System.out.println("El archivo es " + username);
		//Crea un fichero con el nombre de usuario con extencion txt
		File file = new File(fileName, username + ".txt");
		//
		Map<String, Integer> pairs = new HashMap<String, Integer>();
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("No se puede crear");
			}
		} else {
			FileReader fileReader;
			try {
				fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line = bufferedReader.readLine();
				while (line != null) {
					String[] pair = line.split("-");
					pairs.put(pair[0], Integer.parseInt(pair[1]));
					line = bufferedReader.readLine();
				}
				bufferedReader.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		while (reader.hasNext()) {
			String word = reader.nextLine();
			if (word.equals("exit"))
				break;
			//Optener el valor de la palabra si existe y incrementa en 1
			int total = pairs.containsKey(word) ? pairs.get(word) + 1 : 1;
			pairs.put(word, total);
		}
		//Cerramos el escaner
		reader.close();
		//Entramos en el fichero para escribir
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (String key : pairs.keySet()) {
				bufferedWriter.write(key + "-" + pairs.get(key));
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
