/*
 * Escribir un método que reciba un archivo de texto y cree otro cifrado. Para ello "desplazará" el alfabeto tantas letras como indique el segundo parámetro. 
 * Escribir también otro método que dado un archivo cifrado muestre por pantalla el mensaje descifrado.
 * Por ejemplo, si tengo mensaje el mensaje "casa" ejecuto cipher (ruta_a_mensaje, 1), obtengo un archivo de texto con el contenido "dbtb".
 * Nota: suponer que todos los mensajes están escritos en mayúscula sin tilde y que el alfabeto consta de 128 símbolos.
 * */
package es.studium.EscribirFicheros;
//Importamos los paquetes necesarios ctl+mayus+o
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio02_CifrarDecifrar {
	//Creamos la clase Main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cipher(".\\src\\es\\studium\\EscribirFicheros\\prueba.txt",1);
		decipher(".\\src\\es\\studium\\EscribirFicheros\\CIF_prueba.txt",1);
	}
	public static void cipher(String fileName, int offset) {
		//Creamos la clase file y la iniciamos con la ruta y nombre del fichero.
		File originalFile = new File(fileName);
		File cipheredFile = new File(originalFile.getParent(), "CIF_" + originalFile.getName());
		try {
			cipheredFile.createNewFile();
			FileReader fileReader;
			FileWriter fileWriter;
			fileReader = new FileReader(originalFile);
			fileWriter = new FileWriter(cipheredFile);
			int character = fileReader.read();
			while (character != -1) {
				fileWriter.write((character + offset) % 128);
				character = fileReader.read();
			}
			fileReader.close();
			fileWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void decipher(String fileName, int offset) {
		File cipheredFile = new File(fileName);
		FileReader fileReader;
		try {
			fileReader = new FileReader(cipheredFile);
			int character = fileReader.read();
			String message = "";
			while (character != -1) {
				char letter = (char) ((character - offset) % 128);
				message = message.concat(String.valueOf(letter));
				character = fileReader.read();
			}
			System.out.println(message);
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
