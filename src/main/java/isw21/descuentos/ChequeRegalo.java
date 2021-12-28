package main.java.isw21.descuentos;

public class ChequeRegalo extends Oferta {
    int valor;
    double gastado;

    public ChequeRegalo(String comercio, String fechaIn, String fechaFin, int valor, String codigo, double gastado) {
        super(comercio, fechaIn, fechaFin,valor, codigo);
        this.valor = valor;
        this.gastado = gastado; //Cuando pongamos qué cantidad ha utilizado
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public double getGastado(){ return gastado;}

    public void setGastado(double gastado){this.gastado = gastado;}
}
