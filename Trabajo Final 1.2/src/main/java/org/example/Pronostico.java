package org.example;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Pronostico {

    private Partido partido;
    private boolean  ganaEquipoLocal;
    private boolean  ganaEquipoVisitante;
    private boolean  empatan;

    public Pronostico() throws FileNotFoundException {
    }

    public Pronostico(Partido partido, boolean ganaEquipoLocal, boolean ganaEquipoVisitante, boolean empatan) {
        this.partido = partido;
        this.ganaEquipoLocal = ganaEquipoLocal;
        this.ganaEquipoVisitante = ganaEquipoVisitante;
        this.empatan = empatan;
    }





    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public boolean getGanaEquipoLocal() {
        return ganaEquipoLocal;
    }

    public void setGanaEquipoLocal(boolean ganaEquipoLocal) {
        this.ganaEquipoLocal = ganaEquipoLocal;
    }

    public boolean getGanaEquipoVisitante() {
        return ganaEquipoVisitante;
    }

    public void setGanaEquipoVisitante(boolean ganaEquipoVisitante) {
        this.ganaEquipoVisitante = ganaEquipoVisitante;
    }

    public boolean getEmpatan() {
        return empatan;
    }

    public void setEmpatan(boolean empatan) {
        this.empatan = empatan;
    }
    public int puntos(){
        if ( partido.ganoEquipo1()&& ganaEquipoLocal  ){
            return 1;
        }else if (partido.ganoEquipo2() && ganaEquipoVisitante){
            return 1;
        }else if (partido.empataron() && empatan){
            return 1;
        }else {return 0;}
    }
    public String partidoAPronosticar(){
        return partido.partidoEntre();
    }

}
