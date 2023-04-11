package org.example;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.sql.*;
public class Main {
    public static void main(String[] args) throws SQLException, FileNotFoundException {

        // Listas para almacenar los equipos, partidos y pronosticos
        List<Equipo> equipos = new ArrayList<>();
        List<Partido> partidos = new ArrayList<>();
        List<Pronostico> listaPronosticos = new ArrayList<>();

        Ronda ron = new Ronda(); //CREAMOS RONDA
        partidos= ron.leerDatosRonda(); //METEMOS EN LA LISTA PARTIDOS LOS PARTIDOS Y RESULTADOS LEIDOS DE LA BASE DE DATOS

        Pronostico pro = new Pronostico(); // CREAMOS PRONOSTICO
        listaPronosticos= pro.leerDatosPronostico();// METEMOS EN LA LISTA DE PRONOSTICOS LOS PRONOSTICOS DE UN PARTICIPANTE

        Participante san = new Participante(1,"santiago Cabello",listaPronosticos);

        //for(Partido partido : partidos){
        //    System.out.println(partido.partidoEntre());
        //}
        int puntosTotal=0;
        for (int i = 0; i < listaPronosticos.size(); i++) {

            pro.setPartido(partidos.get(i));// AGREGA PARTIDO A LA LISTA DE PRONOSTICO
            san.getPronostico().get(i).setPartido(partidos.get(i));

            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("Partido Entre: " + pro.getPartido().partidoEntre());

            System.out.println("Apuesta de Participante: gana local? [" + san.getPronostico().get(i).isGanaEquipoLocal()
            +"] gana visitante? ["+ san.getPronostico().get(i).isGanaEquipoVisitante()+"] o empatan? ["+
                    san.getPronostico().get(i).isEmpatan()+"]");
            System.out.println("Suma " + san.getPronostico().get(i).puntos()+" Puntos");

            puntosTotal = puntosTotal + san.getPronostico().get(i).puntos();

        }

        System.out.println("Puntos totales del Jugador: -------------- "+ puntosTotal+ " --------------");


    }
}