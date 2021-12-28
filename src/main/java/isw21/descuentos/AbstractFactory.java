package main.java.isw21.descuentos;

public abstract class AbstractFactory {
    public abstract Oferta getOferta(String txtEntidadText, String fechaIni, String fechaFin, int i, String text, int p, double gastado);
}