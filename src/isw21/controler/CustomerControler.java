package isw21.controler;

import java.util.ArrayList;

import isw21.dao.CustomerDAO;
import isw21.domain.Customer;

public class CustomerControler {

    public void getCustomer(ArrayList<Customer> lista) {
        CustomerDAO.getClientes(lista);
    }
}