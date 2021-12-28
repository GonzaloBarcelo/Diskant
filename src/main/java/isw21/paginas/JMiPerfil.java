package main.java.isw21.paginas;
import main.java.isw21.client.Client;
import main.java.isw21.descuentos.Oferta;
import main.java.isw21.domain.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;



public class JMiPerfil extends JFrame
{
    //Este corchete public static no se pone en github 
    //public static void main(String args[])
    //{
    //    new JMiPerfil();
        
    //}
  
    /*Customer customer;
    Client cliente;*/

    //public JMiPerfil()
    public JMiPerfil(Customer customer, Client cliente, ArrayList<Oferta> ofertas)
    {
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
        JLabel l6 = new JLabel("Mi Perfil");
        JLabel l7 = new JLabel();
        pnlNorte.setPreferredSize(new Dimension(600, 50));

        pnlNorte.add(l5);
        pnlNorte.add(l6);
        pnlNorte.add(l7);

        //CENTRO
        JPanel pnlCentro = new JPanel();
        pnlCentro.setLayout(new BorderLayout());
        pnlCentro.setBackground(new Color(174,200,178));


        JPanel pnlCentroNorte = new JPanel();
        pnlCentroNorte.setBackground(new Color(174,200,178));
        pnlCentroNorte.setLayout(new FlowLayout());

        JLabel lblCara = new JLabel();
        ImageIcon imagenCara= new ImageIcon("src/main/java/isw21/media/Cara.png");
        lblCara.setIcon(new ImageIcon(imagenCara.getImage().getScaledInstance(110, 80, Image.SCALE_SMOOTH)));
        lblCara.setBorder(BorderFactory.createLineBorder(new Color(150,150,150)));

        JLabel lblEspacio = new JLabel();
        lblEspacio.setPreferredSize(new Dimension(20, 130));


        JLabel lblInfo = new JLabel("info");
        lblInfo.setBorder(BorderFactory.createLineBorder(new Color(150,150,150)));
        lblInfo.setPreferredSize(new Dimension(200, 110));
        lblInfo.setBackground(new Color(17,90,29));

        pnlCentroNorte.add(lblCara);
        pnlCentroNorte.add(lblEspacio);
        pnlCentroNorte.add(lblInfo);

        JPanel pnlCentroCentro = new JPanel();
        pnlCentroCentro.setLayout(new FlowLayout());
        pnlCentroCentro.setBackground(new Color(174,200,178));

      JButton btnCuenta = new JButton("Mi cuenta");
      btnCuenta.setBorder(BorderFactory.createLineBorder(new Color(150,150,150)));
      btnCuenta.setPreferredSize(new Dimension(500, 30));
      btnCuenta.setBackground(new Color(34,20,43));
      btnCuenta.setForeground(new Color(150,150,150));

      JButton btnConfiguracion = new JButton("Configuracion");
      btnConfiguracion.setBorder(BorderFactory.createLineBorder(new Color(150,150,150)));
      btnConfiguracion.setPreferredSize(new Dimension(500, 30));
      btnConfiguracion.setBackground(new Color(34,20,43));
      btnConfiguracion.setForeground(new Color(150,150,150));

      JButton btnAyuda = new JButton("Ayuda");
      btnAyuda.setBorder(BorderFactory.createLineBorder(new Color(150,150,150)));
      btnAyuda.setPreferredSize(new Dimension(500, 30));
      btnAyuda.setBackground(new Color(34,20,43));
      btnAyuda.setForeground(new Color(150,150,150));

      JButton btnPrivacidad = new JButton("Privacidad");
      btnPrivacidad.setBorder(BorderFactory.createLineBorder(new Color(150,150,150)));
      btnPrivacidad.setPreferredSize(new Dimension(500, 30));
      btnPrivacidad.setBackground(new Color(34,20,43));
      btnPrivacidad.setForeground(new Color(150,150,150));

      JButton btnSesion = new JButton("Cerrar sesion");
      btnSesion.setBorder(BorderFactory.createLineBorder(new Color(150,150,150)));
      btnSesion.setPreferredSize(new Dimension(500, 30));
      btnSesion.setBackground(new Color(34,20,43));
      btnSesion.setForeground(new Color(150,150,150));

      JButton btnInvitar = new JButton("Invitar");
      btnInvitar.setBorder(BorderFactory.createLineBorder(new Color(150,150,150)));
      btnInvitar.setPreferredSize(new Dimension(500, 30));
      btnInvitar.setBackground(new Color(34,20,43));
      btnInvitar.setForeground(new Color(150,150,150));

      JButton btnOpinion = new JButton("¡Danos tu opinion!");
      btnOpinion.setBorder(BorderFactory.createLineBorder(new Color(150,150,150)));
      btnOpinion.setPreferredSize(new Dimension(500, 30));
      btnOpinion.setBackground(new Color(34,20,43));
      btnOpinion.setForeground(new Color(150,150,150));



        pnlCentroCentro.add(btnCuenta);
        pnlCentroCentro.add(btnConfiguracion);
        pnlCentroCentro.add(btnAyuda);
        pnlCentroCentro.add(btnPrivacidad);
        pnlCentroCentro.add(btnSesion);
        pnlCentroCentro.add(btnInvitar);
        pnlCentroCentro.add(btnOpinion);


        pnlCentro.add(pnlCentroNorte, BorderLayout.NORTH);
        pnlCentro.add(pnlCentroCentro, BorderLayout.CENTER);


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


        btnHome.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //JInicio inicio = new JInicio();
                JInicio inicio = new JInicio(customer, cliente);
                setVisible(false);
            }
        });

        btnMas.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JAgregar agregar = new JAgregar(customer, cliente, ofertas);
                //JAgregar agregar = new JAgregar();
                setVisible(false);
            }
        });
        
        btnOpinion.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JOpinon opinon = new JOpinion();
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JPrincipal jprinc = new JPrincipal();

            }
        });
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocation(250, 100);


    }
}
