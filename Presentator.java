package ClienteC;

import java.io.DataInputStream;
import java.io.IOException;
//import java.net.ServerSocket;
import java.net.Socket;

public class Presentator {

	public void mostrar(Socket soc) {

		try {
			
			DataInputStream flujo_entrada = new DataInputStream(soc.getInputStream());
			String Mensaje_texto = flujo_entrada.readUTF();
			
			if(Mensaje_texto.indexOf("N")==2) {
				
				Capturator.Numeros(Mensaje_texto);
				
			}else {
				System.out.println(Mensaje_texto);
				Capturator.Proces();
			}
			
			soc.close();

		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	public void mostrarRes(Socket SO) throws IOException {
		
		DataInputStream flujo_entrada2 = new DataInputStream(SO.getInputStream());
		String Mensaje_texto = flujo_entrada2.readUTF();		
		System.out.println(Mensaje_texto);
		Capturator.Proces();
	}	
	
}
