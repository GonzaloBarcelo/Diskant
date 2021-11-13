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
    private Timer timer;

	public JInicio(Customer customer,Client cliente)
	{
		this.customer = customer;
        this.cliente = cliente;

		setSize(600,600);
		this.setLayout(new BorderLayout());
		Font fuente1 = new Font("Serif", 1, 18);

	//NORTE
		JPanel pnlNorte = new JPanel();
		pnlNorte.setBackground(new Color(255,255,255));
		pnlNorte.setLayout(new GridLayout(1,3));
		JLabel l5 = new JLabel();
		ImageIcon imagen1 = new ImageIcon("main/java/isw21/media/LogoDiskAnt.jpeg");
		l5.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(150, 60, Image.SCALE_SMOOTH)));
		JLabel l6 = new JLabel("Mis descuentos");

		JButton btnCrearDescuento = new JButton("Agregar descuento");
		btnCrearDescuento.setFont(fuente1);
		btnCrearDescuento.setForeground(new Color(17,90,29));
		//btnCrearDescuento.setBackground(new Color(160,160,160));
		pnlNorte.setPreferredSize(new Dimension(600, 50));
		
		pnlNorte.add(l5);
		pnlNorte.add(l6);
		pnlNorte.add(btnCrearDescuento);
		
		


	//CENTRO
		JPanel pnlCentro = new JPanel();
		pnlCentro.setBackground(new Color(174,200,178));
		int l=App.importDescuentos().size();
		pnlCentro.setLayout(new GridLayout(l/2+1, 2));
		for(Descuento i:App.importDescuentos())  
			{

				JPanel pnlDescuento = new JPanel();
				pnlDescuento.setLayout(new GridLayout(4,1));

				JLabel lblComercio = new JLabel( i.getComercio(), JLabel.CENTER);
				JLabel lblValor = new JLabel("Valor: "+i.getValor(), JLabel.CENTER);
				JLabel lblTipo = new JLabel("Tipo: "+i.getTipo(), JLabel.CENTER);
				JLabel lblCodigo = new JLabel("Codigo: "+i.getCodigo(), JLabel.CENTER);

				lblComercio.setBorder(BorderFactory.createEtchedBorder());
				//new JLabel( "prueba",JLabel.CENTER 
				
				pnlDescuento.add(lblComercio);
				pnlDescuento.add(lblValor);
				pnlDescuento.add(lblTipo);
				pnlDescuento.add(lblCodigo);

				pnlDescuento.setAlignmentX(lblComercio.CENTER_ALIGNMENT);
				pnlDescuento.setAlignmentX(lblValor.CENTER_ALIGNMENT);
				pnlDescuento.setAlignmentX(lblTipo.CENTER_ALIGNMENT);
				pnlDescuento.setAlignmentX(lblCodigo.CENTER_ALIGNMENT);

				pnlDescuento.setBorder(BorderFactory.createEtchedBorder());

				pnlCentro.add(pnlDescuento);
	
			}

		

	//SUR

		JPanel pnlSur = new JPanel();
		pnlSur.setLayout(new GridLayout(1, 5));

		JButton btnMiPerfil= new JButton();
		btnMiPerfil.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		ImageIcon imagen = new ImageIcon("main/java/isw21/media/Perfil.png");
		btnMiPerfil.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
	
		JLabel l1 = new JLabel();
		l1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JLabel l2 = new JLabel();
		l2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JLabel l3 = new JLabel();
		l3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JLabel l4 = new JLabel();
		l4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pnlSur.add(l1);
		pnlSur.add(l2);
		pnlSur.add(l3);
		pnlSur.add(l4);
		pnlSur.add(btnMiPerfil);

	//LADOS
		JPanel pnlEste = new JPanel();
		pnlEste.setBackground(new Color(174,200,178));
		pnlEste.setPreferredSize(new Dimension(60, 60));


		JPanel pnlOeste = new JPanel();
		pnlOeste.setPreferredSize(new Dimension(60, 60));
		pnlOeste.setBackground(new Color(174,200,178));


		

//FUNCIONES
		btnCrearDescuento.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JDescuento descuento = new JDescuento(customer,cliente,plDescuentos);
			}
		});

		plDescuentos= getDescuentos(customer);

        timer = new Timer(1000,e ->{
            mostrarDescuentos();
        });
        timer.start();
		
	
		this.add(pnlNorte, BorderLayout.NORTH);
		this.add(pnlCentro, BorderLayout.CENTER);
		this.add(pnlSur, BorderLayout.SOUTH);
		this.add(pnlEste, BorderLayout.EAST);
		this.add(pnlOeste, BorderLayout.WEST);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(true); 
		this.setLocation(250, 100);
	}

	public ArrayList<Descuento> getDescuentos(Customer customer)
	{
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

    public void mostrarDescuentos()
    {
        if(plDescuentos == null || plDescuentos.size() == 0)
        {
            System.out.println("No hay descuentos. Añade con el código los que tengas");
        }
        else {
            for (Descuento d : plDescuentos) {
                System.out.println(d.getCodigo());
            }
        }
    }
}
