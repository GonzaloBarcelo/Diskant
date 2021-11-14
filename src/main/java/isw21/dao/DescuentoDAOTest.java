package main.java.isw21.dao;

import junit.framework.TestCase;
import main.java.isw21.descuentos.Descuento;
import main.java.isw21.domain.Customer;

import java.util.ArrayList;

public class DescuentoDAOTest extends TestCase {
    private static DescuentoDAO dDAO=null;
    private Customer customer= new Customer("test","test");
    private ArrayList<Descuento> lista= new ArrayList<Descuento>();

    public void setUp() throws Exception {

    }

    public void testAddDescuento() {
        assertEquals(new Descuento("ComercioTest","test","test",1,1,"test"),DescuentoDAO.addDescuento(customer,new Descuento("ComercioTest","test","test",1,1,"test")));
    }

    public void testGetDescuentos() {
        // Comprobamos que la lista de los descuentos asociados al usuario test coincida con la esperada
        lista.add(new Descuento("ComercioTest","test","test",1,1,"test"));
        assertEquals(lista,DescuentoDAO.getDescuentos(lista,customer));
    }
}