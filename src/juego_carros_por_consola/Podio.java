package juego_carros_por_consola;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Podio {
	private ArrayList<Jugador> players;
	private ArrayList<Carro> cars ;
	private String firstPlace="";
	private String scdPlace="";
	private String thrPlace="" ;
	private Map<String,String> DB;
	

	private int counter=0;
	public Podio(ArrayList<Jugador>  players,ArrayList<Carro> cars,Map<String,String> DB) {
		this.players=players;
		this.cars=cars;
		this.DB=DB;
	}
	//sobrecarga de constructor
	public Podio(Map<String,String> DB) {
		this.DB=DB;
	}
	
	//metodos
	public void imprimirResultados() {
		System.out.println("1er lugar "+firstPlace);
		System.out.println("2do lugar "+scdPlace);
		System.out.println("3er lugar "+thrPlace);
		

	}
	public void winners(int iteCars) {

		if(cars.get(iteCars).getWin() && cars.get(iteCars).getJugando()!=false){		
			if(counter==0) {
				firstPlace=players.get(iteCars).getName();
				cars.get(iteCars).setJugando(false);
			}

			else if(counter==1) {
				scdPlace=players.get(iteCars).getName();
				cars.get(iteCars).setJugando(false);
			}

			else {
				thrPlace=players.get(iteCars).getName();
				cars.get(iteCars).setJugando(false);
			}

			counter++;
		}
	}
	public int getCounter() {
		return counter;
	}
	public String getWins() {
		return firstPlace+" "+scdPlace+" "+thrPlace;
	}
	
	public Boolean bucarEnMap(String j) {
		boolean bandera=false;
		Iterator itk=DB.keySet().iterator();
		while(itk.hasNext()) {
			String key=(String)itk.next();
			if(key.equalsIgnoreCase(j))bandera=true;
		}
		return bandera;
	}
	public void CreacionMap() {
		
		for(int i=0;i<players.size();i++) {
			if(!this.bucarEnMap(players.get(i).getName())) {
				DB.put(players.get(i).getName(), "0-0-0");	
				}
			}
		}
	public int charplus(char c) {
		c-=48;
		c+=1;
		return c; 
	}
	public void setValoresMap() {
		Iterator itk=DB.keySet().iterator();
		
		while(itk.hasNext()) {
			String key=(String)itk.next();
			String value=null; String caracter;
			if(key.equalsIgnoreCase(firstPlace)) {
				value=DB.get(key);
				caracter=String.valueOf(this.charplus(value.charAt(0))) ;
				value=caracter+"-"+value.charAt(2)+"-"+value.charAt(4);
				DB.put(key, value);
			}
			else if(key.equalsIgnoreCase(scdPlace)) {
				value=DB.get(key);
				caracter=String.valueOf(this.charplus(value.charAt(2))) ;
				value=value.charAt(0)+"-"+caracter+"-"+value.charAt(4);
				DB.put(key, value);
			}
			else if(key.equalsIgnoreCase(thrPlace)) {
				value=DB.get(key);
				caracter=String.valueOf(this.charplus(value.charAt(4))) ;
				DB.put(key, value.charAt(0)+"-"+value.charAt(2)+"-"+caracter);
			}
		}
	
	}
	
	public void escribirMap() {
		ManipulaFicheros escri=new ManipulaFicheros(players,"DDBB1.txt");
		String texto="";
		Set<String> keys=DB.keySet();
		for(String key:keys) {
			texto+=key+" "+DB.get(key)+"\n";
		}
		escri.escribir(texto);
	}
	
	public Map<String,String> getMap(){
		return DB;
	}
}

