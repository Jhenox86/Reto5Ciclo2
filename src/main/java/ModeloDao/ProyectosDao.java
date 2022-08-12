/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDao;

import ModeloVo.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Util.JDBCUtilities;
import java.sql.Statement;

/**
 *
 * @author Jheno3
 */
public class ProyectosDao {

    //crear metodo para listar
    public List<ProyectosVo> listar() throws SQLException {
        ArrayList<ProyectosVo> respuesta = new ArrayList<ProyectosVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        String consulta = "SELECT p.ID_Proyecto as id, p.Constructora, p.Numero_Habitaciones as habitaciones , p.Ciudad"
                + " FROM Proyecto p"
                + " WHERE p.Ciudad IN ('Santa Marta','Cartagena', 'Barranquilla')"
                + " AND p.Clasificacion = 'Casa Campestre' ";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                ProyectosVo vo = new ProyectosVo();
                vo.setId(rs.getInt("id"));
                vo.setConstructora(rs.getString("constructora"));
                vo.setHabitaciones(rs.getInt("habitaciones"));
                vo.setCiudad(rs.getString("ciudad"));
                respuesta.add(vo);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return respuesta;
    }

}
