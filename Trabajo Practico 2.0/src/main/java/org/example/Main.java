package org.example;
import java.util.List;
import java.io.FileNotFoundException;
import java.sql.*;
public class Main {
    public static void main(String[] args) throws SQLException, FileNotFoundException {

        // Listas para almacenar los equipos, partidos y pronosticos

        List<Partido> partidos ;
        List<Pronostico> listaPronosticos ;
//-------------------------------------------------------------------------------------------------------------------------------------------------------
        Ronda ron = new Ronda(); //CREAMOS RONDA
        partidos= ron.leerDatosRonda("resultadopartidos"); //METEMOS EN LA LISTA PARTIDOS LOS PARTIDOS Y RESULTADOS LEIDOS DE LA BASE DE DATOS

        Pronostico pro = new Pronostico(); // CREAMOS PRONOSTICO
        listaPronosticos= pro.leerDatosPronostico("apuesta1");// METEMOS EN LA LISTA DE PRONOSTICOS LOS PRONOSTICOS DE UN PARTICIPANTE

        Participante san = new Participante(1,"santiago Cabello",listaPronosticos);
//--------------------------------------------------------------------------------------------------------------------------------------------------------

        int puntosTotal=0;


        if(partidos.size() == listaPronosticos.size()) {
            for (int i = 0; i < listaPronosticos.size(); i++) { //PRIMER RECORRIDO ANALIZANDO LOS PRONOSTICOS Y RESULTADOS

                pro.setPartido(partidos.get(i));// AGREGA PARTIDO A LA LISTA DE PRONOSTICO
                san.getPronostico().get(i).setPartido(partidos.get(i)); //AGREGA PARTIDO A LOS PROnOSTICOS DEL PARTICIPANTE


                System.out.println("---------------------------------------- Ronda "+ ron.getNumeroRonda() +"--------------------------------------------");
                System.out.println("Partido Entre: " + san.getPronostico().get(i).partidoAPronosticar()); //IMPRIME EL STRING DEL PARTIDO APOSTADO
                System.out.println("Resultado: " +  san.getPronostico().get(i).getPartido().resultadoPartido());//IMPRIME EL STRING DEL RESULTADO DE PARTIDO APOSTADO
                System.out.println("Apuesta de Participante: gana local? [" + san.getPronostico().get(i).isGanaEquipoLocal() //IMPRIME LA APUESTA DEL PARTICIPANTE
                        + "] gana visitante? [" + san.getPronostico().get(i).isGanaEquipoVisitante() + "] o empatan? [" +
                        san.getPronostico().get(i).isEmpatan() + "]");
                System.out.println("Suma " + san.getPronostico().get(i).puntos() + " Puntos");//INVOCA AL METODO PUNTOS() QUE SUMA 1 PUNTO SI GANA EL EQUIPO QUE APOSTO EL PARTICIPANTE

                puntosTotal = puntosTotal + san.getPronostico().get(i).puntos();//ACUMULADOR DE PUNTOS

            }
        }
        if (puntosTotal == partidos.size()){//SI EL PARTICIPANTE ACIERTA TODOS LOS PARTIDOS SE DUPLICAN LOS PUNTOS TOTALES
            System.out.println("acertò todos los partidos, duplica puntos !!");
            puntosTotal= puntosTotal * 2;
        }
        System.out.println("Puntos totales del Jugador hasta la ronda "+ron.getNumeroRonda()+  ":     ---- "+ puntosTotal+ " ----");

        //-------------------------------------------------------------------------------------------------------------------------------------------------------
        List<Partido> partidosRonda2 ;
        List<Pronostico> listaPronosticos2;

        partidosRonda2 = ron.leerDatosRonda("resultadopartidos2"); //METEMOS EN LA LISTA PARTIDOS LOS PARTIDOS Y RESULTADOS LEIDOS DE LA BASE DE DATOS

        listaPronosticos2 = pro.leerDatosPronostico("apuesta2");// METEMOS EN LA LISTA DE PRONOSTICOS LOS PRONOSTICOS DE UN PARTICIPANTE

        //--------------------------------------------------------------------------------------------------------------------------------------------------------

        if(partidosRonda2.size() == listaPronosticos2.size()) {
            for (int i = 0; i < listaPronosticos2.size(); i++) {

                pro.setPartido(partidosRonda2.get(i));// AGREGA PARTIDO A LA LISTA DE PRONOSTICO
                san.getPronostico().get(i).setPartido(partidosRonda2.get(i)); //AGREGA PARTIDO A LOS PRONOSTICOS DEL PARTICIPANTE


                System.out.println("---------------------------------------- Ronda "+ ron.getNumeroRonda() +"--------------------------------------------");
                System.out.println("Partido Entre: " + san.getPronostico().get(i).partidoAPronosticar()); //IMPRIME EL STRING DEL PARTIDO APOSTADO
                System.out.println("Resultado: " +  san.getPronostico().get(i).getPartido().resultadoPartido());//IMPRIME EL STRING DEL RESULTADO DE PARTIDO APOSTADO
                System.out.println("Apuesta de Participante: gana local? [" + san.getPronostico().get(i).isGanaEquipoLocal() //IMPRIME LA APUESTA DEL PARTICIPANTE
                        + "] gana visitante? [" + san.getPronostico().get(i).isGanaEquipoVisitante() + "] o empatan? [" +
                        san.getPronostico().get(i).isEmpatan() + "]");
                System.out.println("Suma " + san.getPronostico().get(i).puntos() + " Puntos");//INVOCA AL METODO PUNTOS() QUE SUMA 1 PUNTO SI GANA EL EQUIPO QUE APOSTO EL PARTICIPANTE

                puntosTotal = puntosTotal + san.getPronostico().get(i).puntos();//ACUMULADOR DE PUNTOS

            }
        }
        if (puntosTotal == partidos.size()){//SI EL PARTICIPANTE ACIERTA TODOS LOS PARTIDOS SE DUPLICAN LOS PUNTOS TOTALES
            System.out.println("acertò todos los partidos, duplica puntos !!");
            puntosTotal= puntosTotal * 2;
        }
        System.out.println("Puntos totales del Jugador hasta la ronda "+ron.getNumeroRonda()+  ":      ----"+ puntosTotal+ " ----");


    }
}