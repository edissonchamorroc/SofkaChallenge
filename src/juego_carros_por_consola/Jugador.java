package juego_carros_por_consola;

public class Jugador {
	private int IdPlayer;
	private static int IdNextPlayer=1;
	private String name;	

	public Jugador(String name) {
		this.name=name;
		IdPlayer=IdNextPlayer;
		IdNextPlayer++;
	}
	public int getId(){
		return IdPlayer;
	}
	public String getName() {
		return name;
	}

	public int getDado() {
		return (int)(Math.random()*6 +1)*100;
	}

}
