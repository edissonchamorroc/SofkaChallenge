package juego_carros_por_consola;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Desarrollo {
	
		public Desarrollo(ArrayList<Jugador> jugadores,ArrayList<Carro> carros,ArrayList<Carril> carril,int kilometers,Map<String,String> resultados) {
			this.jugadores=jugadores;
			this.carros=carros;
			this.carril=carril;
			this.kilometers=kilometers;
			this.resultados=resultados;
			
		}
		
		private ArrayList<Jugador> jugadores;
		private ArrayList<Carro> carros;
		private ArrayList<Carril> carril;
		private int kilometers;
		private Matriz pistas;
		private Map<String,String> resultados=new HashMap<String,String>();
			

		//--------- comienzo de juego-----------------
		public void jugar() {
			Podio podio=new Podio(jugadores,carros,resultados);
			podio.CreacionMap();
			pistas=new Matriz(jugadores,kilometers/100);
			pistas.creacionMatriz();
			pistas.impresion();
		
			while(podio.getCounter()<3) {
				for(int i=0;i<carros.size();i++) {
					carril.get(i).setDistance(jugadores.get(i).getDado());
					carros.get(i).setDistancia(carril.get(i).actualDistance());
					pistas.setPosicion(carril.get(i).actualDistance()/100, i, jugadores.get(i).getName());
					if(carros.get(i).getJugando()!=false)pistas.impresion();
					podio.winners(i);
				}
			}
			podio.setValoresMap();

			podio.imprimirResultados();
		}
		public Map<String,String> getMap(){
			return resultados;
		}
	}
		





