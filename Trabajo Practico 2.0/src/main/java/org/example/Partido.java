package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;



    public String partidoEntre(){
        String var = getEquipo1().getNombre() + " VS " + getEquipo2().getNombre();
        return var;
    }

    public String resultadoPartido (){
        if (golesEquipo1 > golesEquipo2) {
            return "Gano equipo LOCAL";
        } else if (golesEquipo2 > golesEquipo1) {
            return "Gano equipo VISITANTE";
        } else {
            return "EMPATE";
        }
    }
    public Equipo equipoGanador() {
        if (golesEquipo1 > golesEquipo2) {
            return equipo1;
        } else if (golesEquipo2 > golesEquipo1) {
            return equipo2;
        } else {
            return null; // o algún otro valor predeterminado en caso de empate
        }
    }

    public boolean ganoEquipo1() {
        if (golesEquipo1 > golesEquipo2) {
            return true;
        } else {
            return false;
        }
    }
    public boolean ganoEquipo2() {
        if (golesEquipo1 < golesEquipo2) {
            return true;
        } else {
            return false;
        }
    }
    public boolean empataron() {
        if (golesEquipo1 == golesEquipo2) {
            return true;
        } else {
            return false;
        }
    }

}
