package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        //Establecer conexion
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/resultados","root","china1313");

        //Obtener sentencia
        Statement st = conn.createStatement();

        //Ejecutar consulta
        ResultSet rs = st.executeQuery("select * from resultadopartidos");

        //Recorrer conjunto de filas
        while (rs.next()){
            // una vuelta por cada partido
            String el = rs.getNString("EquipoLocal");
            int gl = rs.getInt("GolesLocal");
            int gv = rs.getInt("GolesVisitante");
            String ev = rs.getNString("EquipoVisitante");

            System.out.println(" - "+ el + " - "+ gl + " - "+ gv + " - "+ ev  );
        }

        //Cerrar todo
        conn.close();
        rs.close();
    }
}