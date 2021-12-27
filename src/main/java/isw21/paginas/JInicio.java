package main.java.isw21.paginas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

import main.java.isw21.dao.OfertaDAO;
import main.java.isw21.descuentos.ChequeRegalo;
import main.java.isw21.descuentos.Descuento;
import main.java.isw21.descuentos.Oferta;
import main.java.isw21.descuentos.Porcentaje;
import main.java.isw21.domain.Customer;
import main.java.isw21.client.Client;


public class JInicio extends JFrame
{
    Client cliente;
	ArrayList<Oferta> plOfertas;
	private Timer timer;
	public JFrame parent= new JFrame();

	Customer customer;
	// Cada pantalla de inicio irá asociada a un solo costumer. Además como queremos mostrar los descuentos asociados a este nada más entrar,
	// tendremos que tener disponible la conexion con el servidor mediante el cliente.
	public JInicio(Customer customer,Client cliente)
	{
		//Establecemos la conexión y el dueño de los descuentos
		this.customer = customer;
        this.cliente = cliente;

		// DESCRIPCION DEL ENTORNO GRAFICO


		setSize(600,600);
		this.setLayout(new BorderLayout());
		Font fuente1 = new Font("Serif", 1, 18);

	//NORTE
		JPanel pnlNorte = new JPanel();
		pnlNorte.setBackground(new Color(255,255,255));
		pnlNorte.setLayout(new GridLayout(1,3));
		JLabel l5 = new JLabel();
		ImageIcon imagen1 = new ImageIcon("src/main/java/isw21/media/LogoDiskAnt.jpeg");
		l5.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(150, 60, Image.SCALE_SMOOTH)));
		JLabel l6 = new JLabel("MIS DESCUENTOS");
		l6.setFont(fuente1);
      		JLabel l7 = new JLabel();
	     	pnlNorte.setPreferredSize(new Dimension(600, 50));

	      	pnlNorte.add(l5);
	      	pnlNorte.add(l6);
	      	pnlNorte.add(l7);

		// getDescuentos devuelve todos los descuentos del que el cliente es el dueño
        plOfertas = getDescuentos(customer);
		//eliminamos el primero ya que siempre nos devuelve en la primera posicion un descuento generico.
        plOfertas.remove(0);


	//CENTRO
		//Establecemos el entorno gráfico dependiendo de los descuentos que tenga asociados un cliente
		JPanel pnlCentro = new JPanel();
		pnlCentro.setBackground(new Color(174,200,178));
		int l= plOfertas.size();
		//Esto habrá que cambiarlo, pero de momento con 16 está nice
		pnlCentro.setLayout(new GridLayout(4, 4));

		// Al iniciar la pestaña, se mostrarán los descuentos asociados a la cuenta

		//Si no hay, se mostrará un mensaje: "En este momento no tienes descuentos".
        if(plOfertas == null || l == 0){
			JLabel lno = new JLabel("En este momento no tienes descuentos");
			lno.setFont(fuente1);
			pnlCentro.add(lno);
			pnlCentro.add(btnCrearDescuento);
		    //Quitar el descuento inicial de bienvenida
        }
		//En caso contrario visualizarán en el centro de la pestaña
		else {
            for (Oferta i : plOfertas) {
				//Para cada descuento que tenga el usuario, se llamará a la funcion mastrar. La cual organiza los descuentos y los muestra al usuario
                mostrarDescuento(i,pnlCentro,btnCrearDescuento,fuente1);


            }
        }



	//SUR

		JPanel pnlSur = new JPanel();
		pnlSur.setLayout(new GridLayout(1, 5));

		JButton btnMiPerfil= new JButton();
		btnMiPerfil.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		ImageIcon imagen = new ImageIcon("src/main/java/isw21/media/Perfil.png");
		btnMiPerfil.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));

		JButton btnMas = new JButton();
      		btnMas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      		ImageIcon imagenMas = new ImageIcon("src/main/java/isw21/media/Mas.png");
      		btnMas.setIcon(new ImageIcon(imagenMas.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		JLabel l2 = new JLabel();
		l2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JLabel l3 = new JLabel();
		l3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JLabel l4 = new JLabel();
		l4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pnlSur.add(btnMas);
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
		btnMas.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Si seleccionamos la opcion de crer descuento, abrimos el entorno gráfico necesario y
				// le introducimos como parámetros, el dueño, la conexion con el servidor y los descuentos asociados al dueño.
				//JDescuento descuento = new JDescuento(customer,cliente, plOfertas);
				JAgregar agregar = new JAgregar(customer,cliente, plOfertas);
				
				setVisible(false);
				//mostrarDescuento(plDescuentos.get(plDescuentos.size()-1),pnlCentro);

			}
		});


        /*timer = new Timer(1000,e ->{
            mostrarDescuentos();
        });
        timer.start();*/


		this.add(pnlNorte, BorderLayout.NORTH);
		this.add(pnlCentro, BorderLayout.CENTER);
		this.add(pnlSur, BorderLayout.SOUTH);
		this.add(pnlEste, BorderLayout.EAST);
		this.add(pnlOeste, BorderLayout.WEST);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocation(250, 100);
	}

	// Metodo de visualización de descuentos
	// Se ejecutará para los descuentos que tenga el usuario
    private void mostrarDescuento(Oferta i , JPanel pnlCentro, JButton btnCrearDescuento, Font fuente1) {
		String tipo = comprobarTipo(i);
        JPanel pnlDescuento = new JPanel();
		pnlDescuento.setLayout(new GridLayout(6, 1));
        if (i instanceof ChequeRegalo) {
			pnlDescuento.setLayout(new GridLayout(7, 1));
			ChequeRegalo cheque = (ChequeRegalo) i;
			JLabel lblGastado = new JLabel("Gastado: " + cheque.getGastado(), JLabel.CENTER);
		}
        JLabel lblComercio = new JLabel(i.getComercio(), JLabel.CENTER);
        JLabel lblValor = new JLabel("Valor: " + i.getValor(), JLabel.CENTER);
        JLabel lblTipo = new JLabel("Tipo: " + tipo, JLabel.CENTER);
        JLabel lblCodigo = new JLabel("Codigo: " + i.getCodigo(), JLabel.CENTER);
        JLabel lblFechaFin = new JLabel("Caduca: " + i.getFechaFin(),JLabel.CENTER);
		JButton btnInfo = new JButton("Info del decuento");
		JButton btnUsar = new JButton("Usar descuento");
        JButton btnEliminar = new JButton("Eliminar descuento");

        lblComercio.setBorder(BorderFactory.createEtchedBorder());
        //new JLabel( "prueba",JLabel.CENTER
		JPanel pnlBotones = new JPanel(new GridLayout(1,3));


        pnlDescuento.add(lblComercio);
        pnlDescuento.add(lblValor);
		if (i instanceof ChequeRegalo) {
			pnlDescuento.setLayout(new GridLayout(7, 1));
			ChequeRegalo cheque = (ChequeRegalo) i;
			JLabel lblGastado = new JLabel("Gastado: " + cheque.getGastado(), JLabel.CENTER);
			pnlDescuento.add(lblGastado);
		}
        pnlDescuento.add(lblTipo);
        pnlDescuento.add(lblCodigo);
        pnlDescuento.add(lblFechaFin);
		pnlBotones.add(btnInfo);
		pnlBotones.add(btnUsar);
		pnlBotones.add(btnEliminar);
        pnlDescuento.add(pnlBotones);

		btnInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Entidad del descuento: "+
						i.getComercio()+"\n Fecha de finalizacion del descuento: " + i.getFechaFin()+
						"\n Valor del descuento: "+i.getValor() + "\n Código del descuento: "+ i.getCodigo());
			}
		});

		btnEliminar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Si seleccionamos la opcion de crer descuento, abrimos el entorno gráfico necesario y
				// le introducimos como parámetros, el dueño, la conexion con el servidor y los descuentos asociados al dueño.
				String eliminado= i.getComercio();
				OfertaDAO.eliminarDescuento(customer,i);
				System.out.println("Descuento eliminado");
				pnlCentro.removeAll();
				pnlCentro.setVisible(false);
				plOfertas = getDescuentos(customer);
				plOfertas.remove(0);
				int l= plOfertas.size();
				//Esto habrá que cambiarlo, pero de momento con 16 está nice
				pnlCentro.setLayout(new GridLayout(4, 4));

				// Al iniciar la pestaña, se mostrarán los descuentos asociados a la cuenta

				//Si no hay, se mostrará un mensaje: "En este momento no tienes descuentos".
				if(plOfertas == null || l == 0	){
						JLabel lno = new JLabel("En este momento no tienes descuentos");
						lno.setFont(fuente1);
						pnlCentro.add(lno);
						pnlCentro.add(btnCrearDescuento);
						//Quitar el descuento inicial de bienvenida
					}
				//En caso contrario visualizarán en el centro de la pestaña
				else {
					for (Oferta i : plOfertas) {
						//Para cada descuento que tenga el usuario, se llamará a la funcion mastrar. La cual organiza los descuentos y los muestra al usuario
						mostrarDescuento(i,pnlCentro,btnCrearDescuento,fuente1);


					}
				}
				pnlCentro.setVisible(true);
				JOptionPane.showMessageDialog(parent,"Se ha eiliminado el descuento de "+eliminado+" y todos los descuentos duplicados.");

				//mostrarDescuento(plDescuentos.get(plDescuentos.size()-1),pnlCentro);

			}
		});

        pnlDescuento.setAlignmentX(lblComercio.CENTER_ALIGNMENT);
        pnlDescuento.setAlignmentX(lblValor.CENTER_ALIGNMENT);
        pnlDescuento.setAlignmentX(lblTipo.CENTER_ALIGNMENT);
        pnlDescuento.setAlignmentX(lblCodigo.CENTER_ALIGNMENT);
		pnlDescuento.setAlignmentX(lblFechaFin.CENTER_ALIGNMENT);

        pnlDescuento.setBorder(BorderFactory.createEtchedBorder());

        pnlCentro.add(pnlDescuento);
    }

	private String comprobarTipo(Oferta i) {
		if (i instanceof Descuento){
			return "Descuento";
		}else if (i instanceof Porcentaje){
			return "Porcentaje";
		}else if (i instanceof ChequeRegalo){
			return "ChequeRegalo";
		}else{
			return "Oferta";
		}
	}

	// Metodo que obtiene los descuentos de cada cliente.
    public ArrayList<Oferta> getDescuentos(Customer customer)
	{
		//Hacemos la solicitud a la base de datos medainte un mensaje con contexto de getDescuentos.
        cliente.setContext("/getDescuentos");
        HashMap<String,Object> session= new HashMap<String,Object>();
		// Los campos que tendrá el mensaje de salida serán el customer --> dueño del descuento
		// Y un arraylist donde queremos que se guarden los descuentos. Para el correcto funcionamiento, pondremos
		// dentro del arraylist un descuento generico para no tener problemas con la lista vacia
        session.put("Customer",customer);
        ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
        ofertas.add(new Descuento("Diskant (Bienvenida)","Hoy","Nunca",50,"DISKANTMOLA"));
        session.put("Descuentos", ofertas);
        cliente.setSession(session);
		//Mandamos la comunicacion al servidor
        cliente.run(cliente);
		// Una vez hecha la conexion, el cliente ya tiene los descuentos del usuario
        return cliente.getDescuentos();
    }


}
