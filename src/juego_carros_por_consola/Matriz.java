package juego_carros_por_consola;

import java.util.ArrayList;

public class Matriz {
	private int filas;
	private int columnas;
	private String matriz[][];
	ArrayList<Jugador> players;

	public Matriz(ArrayList<Jugador> players,int filas) {
		this.columnas=players.size();
		this.filas=filas;
		this.players=players;
		matriz=new String[filas+1][columnas];
	}

	public void creacionMatriz() {

		for(int i=0;i<=filas;i++) {
			for(int j=0;j<columnas;j++) {
				if(i==0) {
					matriz[i][j]=players.get(j).getName();
				}
				else matriz[i][j]="  ";
			}
		}
	}
	public void impresion() {
		for(int i=0;i<=filas;i++) {
			for(int j=0;j<columnas;j++) {
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("---------------------------");
	}

	public void setPosicion(int f, int colum,String player) {
		if(f<=this.filas & colum<=this.columnas) {
			this.borrarAnterior(player, colum);
			matriz[f][colum]=player;

		}
		else {
			this.borrarAnterior(player, colum);
			matriz[this.filas][colum]=player;
		}

	}

	public void borrarAnterior(String player,int columna) {
		for(int i=0;i<filas;i++) {
			if(matriz[i][columna].equals(player))matriz[i][columna]=" ";
		}
	}

}
