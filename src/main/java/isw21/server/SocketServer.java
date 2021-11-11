package main.java.isw21.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import main.java.isw21.controler.CustomerControler;
import main.java.isw21.dao.ConnectionDAO;
import main.java.isw21.descuentos.Descuento;
import main.java.isw21.domain.Customer;
import main.java.isw21.message.Message;

public class SocketServer extends Thread {
    public static final int PORT_NUMBER = 8081;

    protected Socket socket;

    private SocketServer(Socket socket) {
        this.socket = socket;
        System.out.println("New client connected from " + socket.getInetAddress().getHostAddress());
        start();
    }

    public void run() {
        InputStream in = null;
        OutputStream out = null;
        try {

            in = socket.getInputStream();
            out = socket.getOutputStream();

            //first read the object that has been sent
            ObjectInputStream objectInputStream = new ObjectInputStream(in);
            Message mensajeIn= (Message)objectInputStream.readObject();
            //Object to return informations
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
            Message mensajeOut=new Message();
            System.out.println("Server working");
            switch (mensajeIn.getContext()) {
                case "/getCustomer":
                    CustomerControler customerControler=new CustomerControler();
                    ArrayList<Customer> lista=new ArrayList<Customer>();
                    customerControler.getCustomer(lista);
                    mensajeOut.setContext("/getCustomerResponse");
                    HashMap<String,Object> session=new HashMap<String, Object>();
                    session.put("Customer",lista);
                    mensajeOut.setSession(session);
                    objectOutputStream.writeObject(mensajeOut);
                    break;

                case "/getAccess":
                    Customer customerIN= mensajeIn.getCustomer();
                    mensajeOut.setContext("/getAccessResponse");

                    session=new HashMap<String, Object>();
                    session.put("Customer",false);
                    if (isInBase(customerIN)!=null){
                        session.put("Customer",true);
                        System.out.println("Se ha autenticado el usuario: "+customerIN.getId());
                    }
                    else{
                        session.put("Customer",false);
                        System.out.println("Se ha introducido mal la contraseña para el ID"+customerIN.getId());
                    }
                    mensajeOut.setSession(session);
                    objectOutputStream.writeObject(mensajeOut);
                    break;

                case "/addNewUser":
                    customerIN = mensajeIn.getCustomer();
                    mensajeOut.setContext("/addNewUserResponse");
                    session=new HashMap<String, Object>();
                    session.put("Customer",false);
                    if (this.isInBase(customerIN)!=null){
                        session.put("Customer",false);
                    }
                    else{
                        this.addCliente(customerIN);
                        if (this.isInBase(customerIN)!=null){
                            session.put("Customer",true);
                        }
                    }
                    mensajeOut.setSession(session);
                    objectOutputStream.writeObject(mensajeOut);
                    break;

                case "/addDescuento":
                    mensajeOut.setContext("/addDescuentoResponse");
                    Customer customer =(Customer) mensajeIn.getSession().get("Customer");
                    Descuento descuento= (Descuento) mensajeIn.getSession().get("Descuento");
                    this.addDescuento(customer,descuento);
                    session=new HashMap<String, Object>();
                    session.put("Descuento",descuento);
                    mensajeOut.setSession(session);
                    objectOutputStream.writeObject(mensajeOut);
                    System.out.println("Se ha añadido el descuento");
                    //Se debe inlcuir codigo para evitar introucir descuentos repetidos
                    break;
                case "/getDescuentos":
                    System.out.println("Pasa por aquí");
                    mensajeOut.setContext("/getDescuentosResponse");
                    customer =(Customer) mensajeIn.getSession().get("Customer");
                    ArrayList<Descuento> descuentos = (ArrayList<Descuento>) mensajeIn.getSession().get("Descuentos");
                    this.getDescuentos(descuentos,customer);
                    session=new HashMap<String, Object>();
                    session.put("Descuentos",descuentos);
                    mensajeOut.setSession(session);
                    objectOutputStream.writeObject(mensajeOut);
                    break;

                default:
                    System.out.println("\nParámetro no encontrado");
                    break;

            }

            //Lógica del controlador
            //System.out.println("\n1.- He leído: "+mensaje.getContext());
            //System.out.println("\n2.- He leído: "+(String)mensaje.getSession().get("Nombre"));



            //Prueba para esperar
		    /*try {
		    	System.out.println("Me duermo");
				Thread.sleep(15000);
				System.out.println("Me levanto");
			} catch (InterruptedException e) {
				// TO DO Auto-generated catch block
				e.printStackTrace();
			}*/
            // create an object output stream from the output stream so we can send an object through it
			/*ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);

			//Create the object to send
			String cadena=((String)mensaje.getSession().get("Nombre"));
			cadena+=" añado información";
			mensaje.getSession().put("Nombre", cadena);
			//System.out.println("\n3.- He leído: "+(String)mensaje.getSession().get("Nombre"));
			objectOutputStream.writeObject(mensaje);*
			*/

        } catch (IOException ex) {
            System.out.println("Unable to get streams from client");
        } catch (ClassNotFoundException e) {
            // TO DO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public Customer isInBase(Customer customerIN){
        CustomerControler customerControler=new CustomerControler();
        ArrayList<Customer> listaCust=new ArrayList<Customer>();
        customerControler.getCustomer(listaCust);
        for (Customer customer : listaCust) {
            if (customerIN.equals(customer)) {
                return customer;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("SocketServer Example");
        ServerSocket server = null;
        try {
            server = new ServerSocket(PORT_NUMBER);
            while (true) {
                /**
                 * create a new {@link SocketServer} object for each connection
                 * this will allow multiple client connections
                 */
                new SocketServer(server.accept());
            }
        } catch (IOException ex) {
            System.out.println("Unable to start server.");
            ex.printStackTrace();
        } finally {
            try {
                if (server != null)
                    server.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void addCliente(Customer customer){

        if (this.isInBase(customer)==null){
            Connection con= ConnectionDAO.getInstance().getConnection();
            try{
                PreparedStatement pst = con.prepareStatement("INSERT INTO usuarios VALUES ('"+customer.getId()+"','"+customer.getName()+"');");
                ResultSet rs = pst.executeQuery();
            }
            catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        else{
            System.out.println("El usuario ya se encuentra dentro de la base de datos.");
        }
    }

    //Codigo que inserta en la base de datos los descuentos de cada cliente
    public void addDescuento(Customer customer,Descuento descuento) {
        Connection con = ConnectionDAO.getInstance().getConnection();
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO descuentos VALUES ('" + customer.getId() +"','"+descuento.getComercio() + "','" + descuento.getFechaIn() +"','"
                    +descuento.getFechaFin()+"','"+ descuento.getTipo()+"','"+descuento.getValor()+"','"+descuento.getCodigo()+"');");
            ResultSet rs = pst.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void getDescuentos(ArrayList<Descuento> lista, Customer customer){
        Connection con = ConnectionDAO.getInstance().getConnection();
        if(lista == null || lista.size() == 0)
        {
            lista = new ArrayList<Descuento>();
        }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM descuentos WHERE usuario= '"+customer.getId()+ "';");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                System.out.println("Hla");
                lista.add(new Descuento(rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getString(7)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    //public ArrayList<Descuento> getDescuentos (){

    //}

}