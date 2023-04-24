package org.example;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Pronostico {

    private Partido partido;
    private boolean  ganaEquipoLocal;
    private boolean  ganaEquipoVisitante;
    private boolean  empatan;


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


    public List<Pronostico> leerDatosPronostico() throws SQLException, FileNotFoundException {
    //lee los datos de una base de datos y genera una lista con prnosticos
        List<Pronostico> pronosticos = new ArrayList<>();
        //Establecer conexion
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/pronostico","root","china1313");

        //Obtener sentencia
        Statement st = conn.createStatement();

        //Ejecutar consulta
        ResultSet rs = st.executeQuery("select * from apuesta");

        //Recorrer conjunto de filas
        while (rs.next()){
            // una vuelta por cada partido

            boolean gl = rs.getBoolean("ganaEquipoLocal");
            boolean gv = rs.getBoolean("ganaEquipoVisitante");
            boolean e = rs.getBoolean("empatan");

            Pronostico pro = new Pronostico();
            pro.setGanaEquipoLocal(gl);
            pro.setGanaEquipoVisitante(gv);
            pro.setEmpatan(e);
            pronosticos.add(pro); // Agregar el objeto partidos a la lista



        }

        //Cerrar todo
        conn.close();
        rs.close();
        return pronosticos;
    }
}
