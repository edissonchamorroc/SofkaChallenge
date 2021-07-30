package juego_carros_por_consola;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManipulaFicheros {
	
	public ManipulaFicheros(ArrayList<Jugador> jug,String nombreFichero){
		this.nombreFichero=nombreFichero;
		
	}
	
	public ManipulaFicheros(String nombreFichero) {
		this.nombreFichero=nombreFichero;
	}

	private File archivoE;
	private String nombreFichero;
	 

	public void escribir(String texto) {
		archivoE=new File(nombreFichero);
		if(!archivoE.exists()) {
			try {
				archivoE.createNewFile();
				FileWriter escritura=new FileWriter(archivoE.getAbsoluteFile(),true);
				System.out.println("A continuación se muestra las Bases de Datos de todos los juegos realizados\nJugador: 1er-2do-3er");
				for(int i=0;i<texto.length();i++) {
					escritura.write(texto.charAt(i));
					System.out.print(texto.charAt(i));
				}
				
				escritura.close();
			}
			catch(Exception ex){
				System.out.println("Mensaje escritura: "+ex.getMessage());
			}
		}		
	}
	public void borrarArchivo() {
		archivoE=new File(nombreFichero);
		if(archivoE.exists())archivoE.delete();
	}
	
}
