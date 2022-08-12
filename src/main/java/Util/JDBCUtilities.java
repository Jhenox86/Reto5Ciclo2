/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jheno3
 */
public class JDBCUtilities {
    // Atributos de clase para gestión de conexión con la base de datos

    private static final String UBICACION_BD = "C:\\Users\\Jheno3\\Documents\\NetBeansProjects\\Reto5Ciclo2\\ProyectosConstruccion.db";

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + UBICACION_BD;
        return DriverManager.getConnection(url);
    }

}
