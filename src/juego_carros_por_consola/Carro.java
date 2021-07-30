package juego_carros_por_consola;

public class Carro{

	public Carro( int kilometers) {
		meta=kilometers;

	}
	private boolean jugando=true;
	private int meta;
	private int distancia;
	private static boolean win=false;

	public void setDistancia(int distancia) {
		if(jugando)this.distancia=distancia;
	}
	public boolean getWin() {

		if(jugando) {
			if(this.distancia>=meta) {
				win=true;
			}
			else win=false;

		}
		return win;
	}
	public void setJugando(boolean jugando) {
		this.jugando=jugando;
	}
	public boolean getJugando() {
		return jugando;
	}



}
