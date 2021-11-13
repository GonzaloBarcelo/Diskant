package main.java.isw21.paginas;

import main.java.isw21.client.Client;
import main.java.isw21.configuration.PropertiesISW;
import main.java.isw21.domain.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

import main.java.isw21.domain.Customer;
import org.apache.log4j.Logger;
import main.java.isw21.client.Client;
import main.java.isw21.descuentos.Descuento;


public class JDescuento extends JFrame
{
	Customer customer;
    Client cliente;

	public JDescuento(Customer customer, Client cliente, ArrayList<Descuento> descuentos)
	{
		this.customer=customer;
        this.cliente=cliente;
        
		setSize(450,300);

		Font fuente = new Font("Serif", 0, 15);
		Font fuente1 = new Font("Serif", 1, 18);
		Font fuente2 = new Font("Serif", 0, 12);
		Font fuente3 = new Font("Serif", 0, 30);

		this.setLayout(new BorderLayout());

	//NORTE
		JPanel pnlNorte = new JPanel();
		pnlNorte.setBackground(new Color(112,157,119));
		JLabel lblTitulo = new JLabel("Agregar nuevo descuento");
		lblTitulo.setFont(fuente3);
		lblTitulo.setForeground(Color.white);
		pnlNorte.setAlignmentX(lblTitulo.CENTER_ALIGNMENT);
		pnlNorte.add(lblTitulo);


	//CENTRO

		JPanel pnlCentro = new JPanel();
		pnlCentro.setLayout(new GridLayout(6,2));
		//pnlCentro.setLayout(new FlowLayout());

		JLabel lblEntidad = new JLabel("Entidad: ");
		JTextField txtEntidad = new JTextField();

		JLabel lblInicio = new JLabel("Fecha inicio: ");
		JTextField txtInicio = new JTextField();
		JLabel lblFin = new JLabel("Fecha fin: ");
		JTextField txtFin = new JTextField();

		JLabel lblTipo = new JLabel("Tipo: ");
		String[] tipos = {"Porcentaje", "Cantidad", "Cupon"};
		JComboBox<String> cbxTipo = new JComboBox<String>(tipos);

		JLabel lblValor = new JLabel("Valor: ");
		JTextField txtValor = new JTextField();

		JLabel lblCodigo = new JLabel("Codigo:");
		JTextField txtCodigo = new JTextField();

	//SUR
		JPanel pnlSur = new JPanel();
		JButton btnCrear = new JButton("Crear Descuento");
		btnCrear.setForeground(new Color(37, 56, 40));
		btnCrear.setFont(fuente);
		btnCrear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
            {
                cliente.setContext("/addDescuento");
                HashMap<String,Object> session= new HashMap<String,Object>();
                Descuento descuento = new Descuento(txtEntidad.getText(),txtInicio.getText(),txtFin.getText(),cbxTipo.getSelectedIndex(),Integer.parseInt(txtValor.getText()),txtCodigo.getText());
                descuentos.add(descuento);
                session.put("Descuento",descuento);
                session.put("Customer",customer);
                cliente.setSession(session);
                cliente.run(cliente);
                setVisible(false);
                // Al añadir el descuento, se abre la de inicio
                JInicio ini = new JInicio(customer, cliente);
            }

		});
		pnlSur.add(btnCrear);

	//LADOS
		JPanel pnlEste = new JPanel();
		pnlEste.setPreferredSize(new Dimension(50, 60));

		JPanel pnlOeste = new JPanel();
		pnlOeste.setPreferredSize(new Dimension(50, 60));

//FUNCIONES
		txtEntidad.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode()==KeyEvent.VK_ENTER) //valor de key: enter
					txtInicio.requestFocus();
				
			}
		});

		txtInicio.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode()==KeyEvent.VK_ENTER) //valor de key: enter
					txtFin.requestFocus();
			}
		});

		txtFin.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode()==KeyEvent.VK_ENTER) //valor de key: enter
					cbxTipo.requestFocus();
				
			}
		});

		txtValor.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode()==KeyEvent.VK_ENTER) //valor de key: enter
					txtCodigo.requestFocus();
				
			}
		});
		txtCodigo.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode()==KeyEvent.VK_ENTER) //valor de key: enter
					btnCrear.requestFocus();
				
			}
		});

		pnlCentro.add(lblEntidad);
		pnlCentro.add(txtEntidad);
		pnlCentro.add(lblInicio);
		pnlCentro.add(txtInicio);
		pnlCentro.add(lblFin);
		pnlCentro.add(txtFin);
		pnlCentro.add(lblTipo);
		pnlCentro.add(cbxTipo);
		pnlCentro.add(lblValor);
		pnlCentro.add(txtValor);
		pnlCentro.add(lblCodigo);
		pnlCentro.add(txtCodigo);
		

		this.add(pnlCentro, BorderLayout.CENTER);
		this.add(pnlNorte, BorderLayout.NORTH);
		this.add(pnlSur, BorderLayout.SOUTH);
		this.add(pnlEste, BorderLayout.EAST);
		this.add(pnlOeste, BorderLayout.WEST);

		//Al cerrar la ventana, se abre la de inicio anterior
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				JInicio ini = new JInicio(customer, cliente);

			}
		});
		//this.pack();
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(true); 
		this.setLocation(550, 250);
	}

	
}
