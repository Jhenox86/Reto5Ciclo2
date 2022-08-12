/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import java.sql.SQLException;
import java.util.List;
import ModeloDao.ComprasProveedorDao;
import ModeloDao.ListaLiderDao;
import ModeloDao.ProyectosDao;
import ModeloVo.ComprasProveedorVo;
import ModeloVo.ListaLiderVo;
import ModeloVo.ProyectosVo;


/**
 *
 * @author Jheno3
 */
public class ReportesController {

    private ProyectosDao proyectosDao;   
    private ComprasProveedorDao comprasProveedorDao;
    private ListaLiderDao listaLiderDao;
    
    //private ProyectosDao proyectoBancoDao;
   
    public ReportesController() {
        proyectosDao = new ProyectosDao();
        comprasProveedorDao = new ComprasProveedorDao();
        listaLiderDao = new ListaLiderDao();
      
    }

    //tresmetodos para entregar la informacion asi la vista pueda proyectarla
    public List<ProyectosVo> listarProyectos() throws SQLException {
        return proyectosDao.listar();
    }
    
    public List<ComprasProveedorVo> listarCompras() throws SQLException {
        return comprasProveedorDao.listar();        
    }

   public List<ListaLiderVo> listarLideres() throws SQLException {
        return listaLiderDao.listar();        
    }
    
}
