package org.example;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static java.sql.DriverManager.getConnection;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Ronda {
    private int nro;
    private List<Partido> partidos ;

    int numeroRonda = 0;
    //__________________________________________Lector de Resultados________________________________________________
    public List<Partido> leerDatosRonda() throws SQLException, FileNotFoundException {

        // Variables para almacenar los datos del archivo
        String equipo1, equipo2;
        int golesEquipo1, golesEquipo2;
        List<Equipo> equipos = new ArrayList<>();
        List<Partido> partidos = new ArrayList<>();


        //Establecer conexion
        Connection conn = getConnection("jdbc:mysql://localhost/resultados","root","china1313");

        //Obtener sentencia
        Statement st = conn.createStatement();

        //Ejecutar consulta
        ResultSet rs = st.executeQuery("select * from resultadopartidos");

        //Recorrer conjunto de filas
        while (rs.next()){
            // una vuelta por cada partido
            equipo1 = rs.getNString("EquipoLocal");
            golesEquipo1 = rs.getInt("GolesLocal");
            golesEquipo2 = rs.getInt("GolesVisitante");
            equipo2 = rs.getNString("EquipoVisitante");

            Equipo equipoLocal = new Equipo();// Crear objeto Equipo para el equipo local
            equipoLocal.setNombre(equipo1);
            equipos.add(equipoLocal);// Agregar el objeto Equipo a la lista

            Equipo equipoVisitante = new Equipo(); // Crear objeto Equipo para el equipo visitante
            equipoVisitante.setNombre(equipo2);
            equipos.add(equipoVisitante);// Agregar el objeto Equipo a la lista

            Partido part = new Partido(equipoLocal,equipoVisitante,golesEquipo1,golesEquipo2);
            partidos.add(part); // Agregar el objeto partidos a la lista
        }
        numeroRonda++;
        this.nro=numeroRonda;
        //Cerrar todo
        conn.close();
        rs.close();

        return partidos;
    }


}
