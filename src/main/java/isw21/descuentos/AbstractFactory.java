package main.java.isw21.descuentos;

/**
 * Clase abstracta para crear factorías. Patrón AbstractFactory.
 * @version 0.3
 * @see OfertaFactory
 */
public abstract class AbstractFactory {
    public abstract Oferta getOferta(String txtEntidadText, String fechaIni, String fechaFin, int i, String text, int p, double gastado);
}