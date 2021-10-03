package main.java.isw21.paginas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

public class JLogin extends JFrame
{
    public static void main(String args[])
    {
        new JLogin();
    }
    public JLogin()
    {
        setSize(450,600);
        //this.setColor(BLUE);
        this.setLayout(new BorderLayout());
        Font fuente = new Font("Serif", 0, 15);

        //NORTE
        JPanel pnlNorte = new JPanel();
        pnlNorte.setPreferredSize(new Dimension(350, 100));
        JLabel lblTitulo = new JLabel("Login");
        lblTitulo.setFont(fuente);
        pnlNorte.setAlignmentX(lblTitulo.CENTER_ALIGNMENT);
        pnlNorte.add(lblTitulo);
        pnlNorte.setBorder(BorderFactory.createEtchedBorder());



        //CENTRO



        JPanel pnlCentro = new JPanel();
        JPanel pnlCentro1 = new JPanel();

        pnlCentro1.setLayout(new GridLayout(4,1));



        JLabel lblUser = new JLabel("Username");
        lblUser.setFont(fuente);
        JTextField txtUser = new JTextField("Type your username", 20);
        txtUser.setFont(fuente);
        txtUser.setForeground(new Color(148, 148, 148));

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(fuente);
        JTextField txtPassword = new JTextField("Type your password", 20);
        txtPassword.setFont(fuente);
        txtPassword.setForeground(new Color(148, 148, 148));

        pnlCentro1.add(lblUser);
        pnlCentro1.add(txtUser);
        pnlCentro1.add(lblPassword);
        pnlCentro1.add(txtPassword);
        pnlCentro1.setBorder(BorderFactory.createEtchedBorder());


        pnlCentro.add(pnlCentro1);
        pnlCentro.setAlignmentX(pnlCentro1.CENTER_ALIGNMENT);
        pnlCentro.setAlignmentY(pnlCentro1.CENTER_ALIGNMENT);
        //System.out.println(pnlCentro.getPreferredSize());




        //SUR
        JPanel pnlSur = new JPanel();
        pnlSur.setPreferredSize(new Dimension(350, 100));
        JButton btnLogin = new JButton("Login");
        btnLogin.setForeground(Color.BLUE);  //new Color(254, 155, 32)
        //pnlSur.add(new JLabel( "prueba",JLabel.CENTER ),BorderLayout.CENTER );

        pnlSur.add(btnLogin);

        btnLogin.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
            };
        });
        pnlSur.setBorder(BorderFactory.createEtchedBorder());


        this.add(pnlNorte, BorderLayout.NORTH);
        this.add(pnlCentro, BorderLayout.CENTER);
        this.add(pnlSur, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocation(500, 100);
    }


}

