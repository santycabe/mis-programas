package org.example;
public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;

    public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }

    public String partidoEntre() {
        String var = getEquipo1().getNombre() + " VS " + getEquipo2().getNombre();
        return var;
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
