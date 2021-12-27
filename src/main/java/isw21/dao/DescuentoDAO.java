package main.java.isw21.dao;
import main.java.isw21.descuentos.Descuento;
import main.java.isw21.domain.Customer;
import main.java.isw21.paginas.JDescuento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DescuentoDAO {
    public static Descuento addDescuento(Customer customer, Descuento descuento) {
        // iniciamos la conexion con la base de datos
        Connection con = ConnectionDAO.getInstance().getConnection();
        if (DescuentoDAO.isInBase(descuento) == false) {
            try {
                // Añadimos el descuento a la tabla de descuentos con el formato previamente establecido.
                // El primer valor será el ID del dueño del descuento seguido por el descuento.
                PreparedStatement pst = con.prepareStatement("INSERT INTO descuentos VALUES ('" + descuento.getComercio() + "','" + descuento.getFechaIn() + "','"
                        + descuento.getFechaFin() + "','" + descuento.getTipo() + "','" + descuento.getValor() + "','" + descuento.getCodigo() + "');");
                ResultSet rs = pst.executeQuery();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println("Hola");
        try {
            // Añadimos el descuento a la tabla de descuentos con el formato previamente establecido.
            // El primer valor será el ID del dueño del descuento seguido por el descuento.
            System.out.println("Aquí estoy");
            PreparedStatement pst = con.prepareStatement("INSERT INTO usudescs VALUES ('" + customer.getUsuario() + "','" + descuento.getCodigo() + "');");
            ResultSet rs = pst.executeQuery();
            return descuento;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }


    public static ArrayList<Descuento> getDescuentos(ArrayList<Descuento> lista, Customer customer){
        Connection con = ConnectionDAO.getInstance().getConnection();
        if(lista == null || lista.size() == 0)
        {
            lista = new ArrayList<Descuento>();
        }
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM usudescs WHERE usuario= '"+customer.getUsuario()+ "';");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                try (PreparedStatement pst1 = con.prepareStatement("SELECT * FROM descuentos WHERE codigo= '"+rs.getString(2)+ "';");
                     ResultSet rs1 = pst1.executeQuery()) {

                    while (rs1.next()) {

                        // Estos descuentos son añadidos a la lista que se ha pasado por parámetro.
                        lista.add(new Descuento(rs1.getString(1),rs1.getString(2),rs1.getString(3),rs1.getInt(4),rs1.getInt(5),rs1.getString(6)));
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    public static ArrayList<Descuento> getDescuentosTotal(){
        //Como debemos extraer descuentos, necesitamos conexion a la base de datos, por lo que tenemos que gnerar una conexion
        Connection con = ConnectionDAO.getInstance().getConnection();
        //Si la lista que debemos actualizar no existe o si su tamaño es cero, la volvemos a crear

        ArrayList<Descuento> lista = new ArrayList<Descuento>();

        //Ejecutamos la query que obtiene los descuentos asociados a un usuario
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM descuentos;");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                // Estos descuentos son añadidos a la lista que se ha pasado por parámetro.
                lista.add(new Descuento(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    public static void eliminarDescuento(Customer customer,Descuento descuento){
        Connection con = ConnectionDAO.getInstance().getConnection();
        try {
            // Añadimos el descuento a la tabla de descuentos con el formato previamente establecido.
            // El primer valor será el ID del dueño del descuento seguido por el descuento.
            PreparedStatement pst = con.prepareStatement("DELETE FROM usudescs WHERE descuento = '" + descuento.getCodigo() + "' AND usuario = '" + customer.getUsuario() + "';");
            ResultSet rs = pst.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static boolean isInBase(Descuento descuentoIN) {
        ArrayList<Descuento> listaDesc=new ArrayList<Descuento>();
        //extraemos la lista de customers y vemos si el introducido figura en ella
        listaDesc = DescuentoDAO.getDescuentosTotal();
        for (Descuento descuento : listaDesc) {
            if (descuentoIN.equals(descuento)) {
                return true;
            }
        }
        return false;
    }


}
