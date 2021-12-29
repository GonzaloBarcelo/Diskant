package main.java.isw21.controler;

import main.java.isw21.dao.OfertaDAO;
import main.java.isw21.descuentos.ChequeRegalo;
import main.java.isw21.descuentos.Oferta;
import main.java.isw21.domain.Customer;

import java.util.ArrayList;

public class OfertaControler {

    public void addDescuento(Customer customer, Oferta oferta, int tipo) {
        OfertaDAO.addDescuento(customer,oferta,tipo);
    }

    public void getDescuentos(ArrayList<Oferta> ofertas, Customer customer) {
        OfertaDAO.getDescuentos(ofertas,customer);
    }

    public void updateGastado(Customer customer, ChequeRegalo cheque){
        OfertaDAO.updateGastado(customer,cheque);
    }

    public void eliminarDescuento(Customer customer, Oferta oferta) {
        OfertaDAO.eliminarDescuento(customer, oferta);
    }
}
