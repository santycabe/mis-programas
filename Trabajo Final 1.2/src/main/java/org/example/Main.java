package org.example;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {


        // Ruta del archivo de texto a leer
        String rutaArchivo = "D:/resultados.txt";

        // Variables para almacenar los datos del archivo
        String equipo1, equipo2;
        int golesEquipo1, golesEquipo2;
        // Listas para almacenar los equipos , partidos y pronosticos
        List<Equipo> equipos = new ArrayList<>();
        List<Partido> partidos = new ArrayList<>();
        List<Pronostico> pronosticos = new ArrayList<>();

        //__________________________________________Lector de Resultados________________________________________________
        try {
            Scanner sc = new Scanner(new File(rutaArchivo));
            String renglon;
            while (sc.hasNextLine()){
                renglon = sc.nextLine();
                String[] partes = renglon.split(",");
                equipo1 = partes[0];
                golesEquipo1 = Integer.parseInt(partes[1]);
                golesEquipo2 = Integer.parseInt(partes[2]);
                equipo2 = partes[3];



                Equipo equipoLocal = new Equipo();// Crear objeto Equipo para el equipo local
                equipoLocal.setNombre(equipo1);
                equipos.add(equipoLocal);// Agregar el objeto Equipo a la lista

                Equipo equipoVisitante = new Equipo(); // Crear objeto Equipo para el equipo visitante
                equipoVisitante.setNombre(equipo2);
                equipos.add(equipoVisitante);// Agregar el objeto Equipo a la lista

                Partido part = new Partido(equipoLocal,equipoVisitante,golesEquipo1,golesEquipo2);
                partidos.add(part); // Agregar el objeto partidos a la lista

            }
            sc.close();


        }catch (FileNotFoundException error){
            error.printStackTrace();
        }
        //_________________________________________Lector de Pronosticos________________________________________________

        String rutaArchivo1 = "D:/pronostico.txt";
        // Variables para almacenar los datos del archivo
        boolean gl,gv,e;
        try {
            Scanner sc2 = new Scanner(new File(rutaArchivo1));
            String renglon;
            int i = 0;
            while (sc2.hasNextLine()) {
                renglon = sc2.nextLine();
                String[] partes2 = renglon.split(";");
                gl = Boolean.parseBoolean( partes2[0]);
                gv = Boolean.parseBoolean (partes2[1]);
                e = Boolean.parseBoolean (partes2[2]);

                Pronostico pro = new Pronostico(partidos.get(i),gl,gv,e);
                i++;
                pronosticos.add(pro); // Agregar el objeto partidos a la lista


            }
            sc2.close();
        } catch (FileNotFoundException error){
            error.printStackTrace();
        }
        //___________________________________________________________________________________________________________

        Ronda ron = new Ronda("1",partidos); // creo un objero ronda



        // Imprimir la lista de equipos
        System.out.println("Lista de equipos:");
        for (Equipo equipo : equipos) {
            System.out.println(equipo.getNombre());
        }
        // Imprimir la lista de partidos
        System.out.println("Lista de partidos y equipo ganador:");
        for (Partido partido : partidos) {
            if (partido.equipoGanador() != null) {
                System.out.println(partido.partidoEntre() + " |  El ganador es: " + partido.equipoGanador().getNombre());
            }
            else {
                System.out.println(partido.partidoEntre() + " |  Empate!");
            }
        }
        //imprimir la ronda
        System.out.println("-------------Partidos que se juegan en la ronda------------- " );
        for (int i = 0; i < ron.getPartidos().size(); i++) {
            System.out.println( ron.getPartidos().get(i).partidoEntre());
        }
        //imprimir los pronosticos
        System.out.println("-------------Pronosticos------------- " );
        for (Pronostico pro : pronosticos) {
            System.out.println( pro.getGanaEquipoVisitante() + "| puntos: "+ pro.puntos() );
        }

    }
}