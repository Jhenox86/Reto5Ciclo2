/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Vista;


import Vista.ReportesView;
import java.awt.*;
import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 *
 * @author Jheno3
 */
public class Reto5 {

    public static void main(String[] args) {
         
         var reportesView =new ReportesView();
         reportesView.setLayout(new FlowLayout()); //un flowlayout va agregando componentes uno al lado del otro.
         reportesView.setSize(600, 400);
         reportesView.setVisible(true);
         reportesView.setResizable(false);
         reportesView.setTitle("Informes - Reto 5 Ciclo 2");         
         reportesView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         reportesView.setLocationRelativeTo(null);      //ubica la ventana en el centro de la pantalla 
    }
}
