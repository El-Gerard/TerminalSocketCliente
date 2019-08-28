package ClienteC;

import java.io.IOException;
import java.util.Scanner;

public class Capturator {

	public static String code = ">> ";
	public static String server, numeros;
	public static int puerto;
	public static Scanner leer = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		System.out.println(">> Terminal de acceso\n");
		System.out.print(">> IP Servidor: ");
		server = leer.next();
		System.out.print(">> Puerto Servidor: ");
		puerto = leer.nextInt();
		System.out.println(">> Conectando...");
		Proces();
	}

	public static void Proces() throws IOException {

		if (Messenger.enviar(server, puerto)) {

			System.out.println(">> Use el comando /help para ayuda");
			System.out.print(code);
			String comand = leer.next();
			if (comand.indexOf("/") == 0) {
				Messenger Men = new Messenger();
				Men.EnviarComando(comand);
			} else {
				System.out.println(">> Error el comando no existe");				
			}
		}
	}

	public static void Numeros(String msn) throws IOException {

		if (Messenger.enviar(server, puerto)) {

			System.out.print(">> Numeros: ");
			numeros = msn + "-";
			numeros += leer.next();
			Messenger Men = new Messenger();
			Men.EnviarComando(numeros);
		}
	}
}
