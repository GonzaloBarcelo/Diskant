package main.java.isw21.server;

import junit.framework.TestCase;
import main.java.isw21.descuentos.Descuento;
import main.java.isw21.domain.Customer;
import main.java.isw21.server.SocketServer;
import java.net.ServerSocket;
import java.util.ArrayList;

public class SocketServerTest extends TestCase {
    private Customer customer= new Customer("test","test");
    private ArrayList<Descuento> lista= new ArrayList<Descuento>();

    private static SocketServer sS= null;

    protected void setUp() throws Exception {

        ServerSocket server = new ServerSocket(8081);
        new SocketServer(server.accept());
    }
    // Prueba del metodo IsInBase
    public void testIsInBase() {
        // Introducimos un usuario existente en la base de datos y nos devuelve el mismo si funciona correctamente
        assertEquals(new Customer("test","test") , sS.isInBase(new Customer("test","test")));
    }
    // Prueba adCliente
    public void testAddCliente() {
        //Prueba erronea para ver comportamiento correcto
        // Introducimos un usuario ya existente en la base de datos, por lo que no nos deberia dejar y su respuesta debe ser null
        assertEquals(null,sS.addCliente(new Customer("test","test")));
    }
    // Prueba del método addDescuento
    public void testAddDescuento() {
        //Introducimos un descuento y nos devuelve el mismo si el método funciona correctamente
        assertEquals(new Descuento("ComercioTest","test","test",1,1,"test"),sS.addDescuento(customer,new Descuento("ComercioTest","test","test",1,1,"test")));
    }

    public void testGetDescuentos() {
        // Comprobamos que la lista de los descuentos asociados al usuario test coincida con la esperada
        lista.add(new Descuento("ComercioTest","test","test",1,1,"test"));
        assertEquals(lista,sS.getDescuentos(lista,customer));
    }
}