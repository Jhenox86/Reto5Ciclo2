/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDao;

import ModeloVo.*;
import Util.JDBCUtilities;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jheno3
 */
public class ComprasProveedorDao {

    public List<ComprasProveedorVo> listar() throws SQLException {
        ArrayList<ComprasProveedorVo> respuesta = new ArrayList<ComprasProveedorVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        String consulta = "SELECT c.ID_Compra as id, p.Constructora, p.Banco_Vinculado as banco"
                + " FROM Proyecto p"
                + " JOIN Compra c  ON c.ID_Compra = p.ID_Proyecto"
                + " WHERE p.Ciudad ='Salento' AND c.Proveedor = 'Homecenter'";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                ComprasProveedorVo vo = new ComprasProveedorVo();
                vo.setId(rs.getInt("id"));
                vo.setConstructora(rs.getString("constructora"));
                vo.setBanco(rs.getString("banco"));
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
