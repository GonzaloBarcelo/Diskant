package main.java.isw21.paginas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

import main.java.isw21.descuentos.Descuento;
import main.java.isw21.domain.Customer;
import main.java.isw21.client.Client;

public class JInicio extends JFrame
{
    Customer customer;
    Client cliente;
    ArrayList<Descuento> plDescuentos;

    public JInicio(Customer customer,Client cliente)
    {
        this.customer = customer;
        this.cliente = cliente;

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
                JDescuento descuento = new JDescuento(customer,cliente,plDescuentos);
                //plDescuentos= getDescuentos(customer);
            }
        });

        plDescuentos= getDescuentos(customer);

        if(plDescuentos == null || plDescuentos.size() == 0)
        {
            System.out.println("No hay descuentos");
        }
        else {
            for (Descuento d : plDescuentos) {
                System.out.println(d.getCodigo());
            }
        }
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

        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocation(250, 100);
    }

    public ArrayList<Descuento> getDescuentos(Customer customer){
        cliente.setContext("/getDescuentos");
        HashMap<String,Object> session= new HashMap<String,Object>();
        session.put("Customer",customer);
        ArrayList<Descuento> descuentos= new ArrayList<Descuento>();
        descuentos.add(new Descuento("Diskant (Bienvenida)","Hoy","Nunca",1,50,"DISKANTMOLA"));
        session.put("Descuentos",descuentos);
        cliente.setSession(session);
        cliente.run(cliente);
        return cliente.getDescuentos();
    }

}
