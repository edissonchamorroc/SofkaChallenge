package juego_carros_por_consola;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejecutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ContinuarJugando="si";
		Map<String,String> resultados=new HashMap<String,String>();
		Podio podio;
		ManipulaFicheros deleter=new ManipulaFicheros("DDBB1.txt");
		deleter.borrarArchivo();
		while(ContinuarJugando.equalsIgnoreCase("si")) {

			System.out.println(" Bienvenido al juego de carros por consola");
			System.out.print("Por favor, ingrese el número de jugadores (minimo 3): ");

			
			Scanner Inplayers= new Scanner(System.in);
			int players=Inplayers.nextInt();
			
			
			if(players<=3)players=3;	
			System.out.print("Ingrese la longitud de la pista en km: ");
			Scanner Inkm= new Scanner(System.in);
			int kilometers=Inkm.nextInt()*1000;
			
			if(kilometers<1000)kilometers=1000;

			//creación de objetos para juego
			ArrayList<Jugador> jugadores =new ArrayList<>(players);
			ArrayList<Carril> carril =new ArrayList<>(players);
			ArrayList<Carro> carros =new ArrayList<>(players);

			for(int i=0;i<players;i++) {
				System.out.println("Ingrese el nombre del jugador "+(i+1)+" :");
				Scanner nombre=new Scanner(System.in);
				jugadores.add(new Jugador(nombre.next()));
				carril.add(new Carril(jugadores.get(i)));
				carros.add(new Carro(kilometers));
			}
			//creacion de juego
			
			Desarrollo juegoNuevo= new Desarrollo(jugadores,carros,carril,kilometers,resultados);
			juegoNuevo.jugar();
			System.out.println("Desea seguir jugando? (si/no):");
			Scanner inn=new Scanner(System.in);
			ContinuarJugando=inn.next();
			
			
		}
	podio=new Podio(resultados);
	podio.escribirMap();
	}
}


