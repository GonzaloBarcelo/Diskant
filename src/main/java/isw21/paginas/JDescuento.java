package main.java.isw21.paginas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class JDescuento extends JFrame
{
    public static void main(String args[])
    {
        new JDescuento();
    }
    public JDescuento()
    {
        Font fuente = new Font("Serif", 0, 15);
        Font fuente3 = new Font("Serif", 0, 18);

        this.setLayout(new BorderLayout());

        JPanel pnlNorte = new JPanel();
        JLabel lblTitulo = new JLabel("Agregar nuevo descuento");
        lblTitulo.setFont(fuente3);
        pnlNorte.add(lblTitulo);

        JPanel pnlSur = new JPanel();
        JButton btnCrear = new JButton("Crear Descuento");
        btnCrear.setFont(fuente);
        btnCrear.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
            }

        });
        pnlSur.add(btnCrear);

        JPanel pnlCentro = new JPanel();
        pnlCentro.setLayout(new GridLayout(6,2));
        //pnlCentro.setLayout(new FlowLayout());

        JLabel lblEntidad = new JLabel("Entidad: ");
        JTextField txtEntidad = new JTextField();


/*Opción: Ponemos checkbox para indicar si tiene fecha de caducidad.
Si se marca se abre un rellenable con fecha incio y fin. Esto
facilita en el caso de agregar un calendario.

		JCheckBox chkCaducidad = new JCheckBox ("Marque si su descuento tiene caducidad");
		this.add(chkCaducidad);
		JLabel lbl = new JLabel();
		this.add(lbl);

		chkCaducidad.addActionListener(new ActionListener()
		{
		   public void stateChanged(ChangeEvent e)
		   {
	        if (chkCaducidad.isSelected()==true)
			}
		});*/

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
        this.pack();
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocation(550, 250);
    }


}
