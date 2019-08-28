package ClienteC;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Messenger {

	private static Socket miSocket;
	Presentator pres = new Presentator();
	
	public Messenger() {		
	}

	public static boolean enviar(String IP, int puerto) {
		
		try {
			miSocket = new Socket(IP, puerto);
			System.out.println(">> \n");
		
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
			System.out.println(">> Error en la conexión");
			return false;
		}
		return true;
	}
	
	public void EnviarComando(String comand) throws IOException {
		
		DataOutputStream flujo_salida = new DataOutputStream(miSocket.getOutputStream());
		flujo_salida.writeUTF(comand);		
		pres.mostrar(miSocket);		
		flujo_salida.close();		
	}	
}
