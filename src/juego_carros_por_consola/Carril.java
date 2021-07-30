package juego_carros_por_consola;

public class Carril {

	private int actualDistance=0;

	private int IdCarril;

	public Carril(Jugador player) {

		IdCarril=player.getId();

	}
	public void setDistance(int distance) {
		actualDistance+=distance;
	}
	public int actualDistance() {
		return actualDistance;
	}

	public int getIdCarril() {
		return IdCarril;
	}

}
