/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Controlador.ReportesController;
import java.util.List;
import ModeloVo.ComprasProveedorVo;
import ModeloVo.ListaLiderVo;
import ModeloVo.ProyectosVo;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuItem;

/**
 *
 * @author Jheno3
 */
public class ReportesView extends JFrame implements ActionListener {

    private static ReportesController controlador;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem primerInf, segundoInf, tercerInf;
    private JTable tabla;
    private DefaultTableModel modelo;
    private JLabel lblTitulo, lblConsulta;

    public ReportesView() {
        controlador = new ReportesController();
        menu();
        etiqueta1();
        etiqueta2();
        tabla();
    }

    public void tabla() {
        tabla = new JTable(modelo);
        tabla.setPreferredScrollableViewportSize(new Dimension(500, 200));
        add(tabla);
        JScrollPane pane = new JScrollPane(tabla);
        add(pane);

    }

    public void etiqueta1() {
        lblTitulo = new JLabel("Informe Reto 5 Ciclo 2");
        lblTitulo.setPreferredSize(new Dimension(500, 30));
        lblTitulo.setFont(new Font("Monospaced", Font.BOLD, 24));
        add(lblTitulo);
    }

    public void etiqueta2() {
        lblConsulta = new JLabel();
        lblConsulta.setPreferredSize(new Dimension(500, 30));
        lblConsulta.setFont(new Font("Sitka Small", Font.ITALIC, 14));
        lblConsulta.setForeground(new java.awt.Color(255, 51, 0));
        add(lblConsulta);
    }

    public void menu() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(new java.awt.Color(0, 0, 0));        
        menu = new JMenu("Informes");
        menu.setForeground(new java.awt.Color(255, 255, 0));
        menuBar.add(menu);
        primerInf = new JMenuItem("Primer Informe");
        primerInf.setForeground(new java.awt.Color(102, 0, 102));
        segundoInf = new JMenuItem("Segundo Informe");
        segundoInf.setForeground(new java.awt.Color(102, 0, 102));
        tercerInf = new JMenuItem("Tercer Informe");
        tercerInf.setForeground(new java.awt.Color(102, 0, 102));
        menu.add(primerInf);
        menu.add(segundoInf);
        menu.add(tercerInf);
        primerInf.addActionListener(this);
        segundoInf.addActionListener(this);
        tercerInf.addActionListener(this);
    }

    public void segundoInforme() {
        try {
            List<ProyectosVo> proyectos = controlador.listarProyectos();
            modelo = new DefaultTableModel();
            modelo.addColumn("Id Proyecto");
            modelo.addColumn("Construtora");
            modelo.addColumn("Habitaciones");
            modelo.addColumn("Ciudad");
            for (ProyectosVo proyecto : proyectos) {
                Object[] fila = new Object[4];
                fila[0] = proyecto.getId();
                fila[1] = proyecto.getConstructora();
                fila[2] = proyecto.getHabitaciones();
                fila[3] = proyecto.getCiudad();
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
            modelo.fireTableDataChanged(); // se usa para actualizar el modelo de la tabla

        } catch (Exception ex) {
            System.err.println("error: " + ex);
        }
    }

    public void tercerInforme() {
        try {
            List<ComprasProveedorVo> compras = controlador.listarCompras();
            modelo = new DefaultTableModel();
            modelo.addColumn("Id Compras");
            modelo.addColumn("Construtora");
            modelo.addColumn("Banco Vinculado");            
            for (ComprasProveedorVo compra : compras) {
                Object[] fila = new Object[3];
                fila[0] = compra.getId();
                fila[1] = compra.getConstructora();
                fila[2] = compra.getBanco();                
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
            modelo.fireTableDataChanged();
            
            
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
    }

    public void primerInforme() {
        try {
            List<ListaLiderVo> lideres = controlador.listarLideres();
            //creacion del modelo:
            modelo = new DefaultTableModel();
            modelo.addColumn("Id Lider");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Ciudad");
            for (ListaLiderVo lider : lideres) {
                Object[] fila = new Object[4];
                fila[0] = lider.getId();
                fila[1] = lider.getNombre();
                fila[2] = lider.getApellido();
                fila[3] = lider.getCiudad();
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
            modelo.fireTableDataChanged(); // se usa para actualizar el modelo de la tabla

        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == primerInf) {
            primerInforme();
            lblConsulta.setText("Informe de Lideres");
        }
         if (e.getSource() == segundoInf) {
            segundoInforme();
            lblConsulta.setText("Informe de Proyectos");
        }
         if (e.getSource() == tercerInf) {
            tercerInforme();
            lblConsulta.setText("Informe de Compras Proveedor");
        }
    }
}
