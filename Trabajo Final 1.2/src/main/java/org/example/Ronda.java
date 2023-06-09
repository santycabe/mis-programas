package org.example;
import java.util.List;

public class Ronda {
    private String nro;
    private List<Partido> partidos ;

    public Ronda(String nro, List<Partido> partidos) {
        this.nro = nro;
        this.partidos = partidos;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }


    public static class Jugador {

        //jugador tiene una lista de pronosticos
        //calcular puntos recorrer pronostico y ver si acerto
        private String nombreJugador;
        private String puntosJugador;
        private List<Pronostico> pronosticoJugador;

    }


}
