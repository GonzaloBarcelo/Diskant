package main.java.isw21.io;


import main.java.isw21.descuentos.Descuento;
import main.java.isw21.descuentos.Oferta;

import java.io.*;
import java.util.ArrayList;

public class IODescuento {
    public static ArrayList<Oferta> leerOfertas(String entidad){
        FileInputStream fis=null;
        ObjectInputStream ois= null;
        try{
            fis=new FileInputStream("src/main/java/isw21/apis/" +entidad+".ofrt");
            ois= new ObjectInputStream(fis);
            return (ArrayList<Oferta>) ois.readObject();
        }
        catch (EOFException eofe){
            try
            {
                ois.close();
                fis.close();
            }
            catch(IOException ioe)
            {
                ioe.printStackTrace();
            }
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        catch(ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
        }
        return new ArrayList<>();
    }
    public static void escribirOferta(ArrayList<Oferta> ofertas, String entidad){
        try{
            FileOutputStream fos = new FileOutputStream("src/main/java/isw21/apis/"+entidad+".ofrt"); //.ser
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ofertas);
            oos.close();
            fos.close();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
