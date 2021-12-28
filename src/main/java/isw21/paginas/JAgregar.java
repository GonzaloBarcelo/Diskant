package main.java.isw21.paginas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

//package main.java.isw21.paginas;

import main.java.isw21.client.Client;
import main.java.isw21.descuentos.OfertaFactory;
import main.java.isw21.domain.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.*;

import main.java.isw21.tools.Checker;
import main.java.isw21.descuentos.Oferta;



public class JAgregar extends JFrame
{
    Customer customer;
    Client cliente;

    public JAgregar(Customer customer, Client cliente, ArrayList<Oferta> ofertas)
    {   
      	this.customer=customer;
        this.cliente=cliente;
        
      setSize(600,600);
      this.setLayout(new BorderLayout());
      Font fuente = new Font("Serif", 0, 15);
      Font fuente1 = new Font("Serif", 1, 18);
      Font fuente3 = new Font("Serif", 0, 30);

//GRÁFICO
  //NORTE
      JPanel pnlNorte = new JPanel();
      pnlNorte.setBackground(new Color(255,255,255));
      pnlNorte.setLayout(new GridLayout(1,3));
      JLabel l5 = new JLabel();
      ImageIcon imagen1 = new ImageIcon("src/main/java/isw21/media/LogoDiskAnt.jpeg");
      l5.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(150, 60, Image.SCALE_SMOOTH)));
      JLabel l6 = new JLabel("AGREGAR DESCUENTO");
      l6.setFont(fuente1);
      JLabel l7 = new JLabel();
      pnlNorte.setPreferredSize(new Dimension(600, 50));
      
      pnlNorte.add(l5);
      pnlNorte.add(l6);
      pnlNorte.add(l7);
  //CENTRO
      JPanel pnlCentro = new JPanel();
      pnlCentro.setBackground(new Color(174,200,178));
      pnlCentro.setLayout(new GridLayout(3,1));
        JPanel pnlCentroCentro = new JPanel();
        pnlCentroCentro.setLayout(new FlowLayout());
        Border line = BorderFactory.createLineBorder(Color.WHITE, 6);
        pnlCentroCentro.setBorder(line);
        
        pnlCentroCentro.setBackground(new Color(174,200,178));
        JButton btnLapiz = new JButton();
        btnLapiz.setPreferredSize(new Dimension(200, 130));
        ImageIcon imagenLapiz = new ImageIcon("src/main/java/isw21/media/Lapiz.png");
        btnLapiz.setIcon(new ImageIcon(imagenLapiz.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH)));


        JLabel lblEspacio = new JLabel();
        lblEspacio.setPreferredSize(new Dimension(40, 130));
        JButton btnCamara = new JButton();
        btnCamara.setPreferredSize(new Dimension(200, 130));
        ImageIcon imagenCamara = new ImageIcon("src/main/java/isw21/media/Camara.png");
        btnCamara.setIcon(new ImageIcon(imagenCamara.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH)));



        pnlCentroCentro.add(btnLapiz);
        pnlCentroCentro.add(lblEspacio);
        pnlCentroCentro.add(btnCamara);

      JLabel l9 = new JLabel();
      JLabel l8 = new JLabel();
      pnlCentro.add(l9);
      pnlCentro.add(pnlCentroCentro);
      pnlCentro.add(l8);


  //SUR
        JPanel pnlSur = new JPanel();
        pnlSur.setLayout(new GridLayout(1, 5));

        JButton btnMas = new JButton();
        btnMas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ImageIcon imagenMas = new ImageIcon("src/main/java/isw21/media/Mas.png");
        btnMas.setIcon(new ImageIcon(imagenMas.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));

        JButton btnLupa = new JButton();
        btnLupa.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ImageIcon imagenLupa = new ImageIcon("src/main/java/isw21/media/Lupa.png");
        btnLupa.setIcon(new ImageIcon(imagenLupa.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));

        JButton btnHome = new JButton();
        btnHome.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ImageIcon imagenHome = new ImageIcon("src/main/java/isw21/media/Home.png");
        btnHome.setIcon(new ImageIcon(imagenHome.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));

        JButton btnCorazon = new JButton();
        btnCorazon.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ImageIcon imagenCorazon = new ImageIcon("src/main/java/isw21/media/Corazon.png");
        btnCorazon.setIcon(new ImageIcon(imagenCorazon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));

        JButton btnMiPerfil= new JButton();
        btnMiPerfil.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ImageIcon imagen = new ImageIcon("src/main/java/isw21/media/Perfil.png");
        btnMiPerfil.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));

        pnlSur.add(btnMas);
        pnlSur.add(btnLupa);
        pnlSur.add(btnHome);
        pnlSur.add(btnCorazon);
        pnlSur.add(btnMiPerfil);
  //LADOS
      JPanel pnlEste = new JPanel();
      pnlEste.setPreferredSize(new Dimension(40, 60));
      pnlEste.setBackground(new Color(174,200,178));
      JPanel pnlOeste = new JPanel();
      pnlOeste.setPreferredSize(new Dimension(40, 60));
      pnlOeste.setBackground(new Color(174,200,178));

      this.add(pnlNorte, BorderLayout.NORTH);
      this.add(pnlCentro, BorderLayout.CENTER);
      this.add(pnlSur, BorderLayout.SOUTH);
      this.add(pnlEste, BorderLayout.EAST);
      this.add(pnlOeste, BorderLayout.WEST);
        
//FUNCIONES

    btnLapiz.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {

        JDescuento descuento = new JDescuento(customer,cliente, ofertas);
        setVisible(false);
      }
    });
    
     btnHome.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        JInicio inicio = new JInicio(customer, cliente);
        setVisible(false);
      }
    });
    /*btnMiPerfil.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        JMiPerfil perfil = new JMiPerfil(customer,cliente, ofertas);
        setVisible(false);
      }
    });*/

        //this.pack();
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //LO DE ABAJO VA EN EL CODIGO
        /*this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JPrincipal jprinc = new JPrincipal();

            }
        });*/
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setVisible(true);
        this.setLocation(250, 100);

    }
}
