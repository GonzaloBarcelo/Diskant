package main.java.isw21.paginas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import main.java.isw21.descuentos.Descuento;
import main.java.isw21.domain.Customer;


public class JInicio extends JFrame
{
    Customer customer;

    public JInicio(Customer customer)
    {

        setSize(900,600);
        this.setLayout(new BorderLayout());

        JPanel pnlCentro = new JPanel();
        pnlCentro.setLayout(new GridLayout(1,3));

        JLabel lblnombre = new JLabel("Bienvenido \n"+customer.getId());
        JLabel lblMarca = new JLabel("DISKANT");

        JButton btnCrearDescuento = new JButton("Agregar descuento");
        pnlCentro.add(lblnombre);
        pnlCentro.add(lblMarca);
        pnlCentro.add(btnCrearDescuento);
        btnCrearDescuento.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JDescuento descuento = new JDescuento();
            }
        });
        //JButton btnMisDescuentos = new JButton("Mis descuentos");
        //pnlCentro.add(btnMisDescuentos);

        /*btnMisDescuentos.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //JMisDescuentos misDescuentos = new JMisDescuentos();
                setVisible(false);
            }
        });
        */


        //pnlCentro.add(btnCrearDescuento);
        //pnlCentro.add(btnMisDescuentos);
        this.add(pnlCentro, BorderLayout.NORTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocation(250, 100);
    }


}
