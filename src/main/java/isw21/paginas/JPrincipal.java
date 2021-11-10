package main.java.isw21.paginas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//se guarda?

import main.java.isw21.paginas.*;

public class JPrincipal extends JFrame
{
    public static void main(String args[])
    {
        new JPrincipal();
    }
    public JPrincipal()
    {
        setSize(500,400);
        this.setLayout(new GridLayout(2,1));
        
        JPanel pnlNorte= new JPanel();
        JLabel lblBienvenida= new JLabel("Bienvenido a DiskAnt");
        Font fuente = new Font("Serif", 0, 35);
        lblBienvenida.setFont(fuente);


       
        pnlNorte.add(lblBienvenida);
        JLabel logoDiskAnt= new JLabel(new ImageIcon("main/java/isw21/LogoDiskAnt.jpeg"));
        pnlNorte.add(logoDiskAnt);
        
        JPanel pnlCentro = new JPanel();
        JButton btnLogin = new JButton("Log in");
        //btn_login.setPreferredSize(new Dimension(200, 50));
        pnlCentro.add(btnLogin);

        btnLogin.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                JLogin login = new JLogin();

            };
        });

        JButton btnRegister = new JButton("Register");
        pnlCentro.add(btnRegister);

        btnRegister.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JRegister register = new JRegister();
            }
        });
        
        this.add(pnlNorte);
        this.add(pnlCentro);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocation(500, 100);
    }

}
