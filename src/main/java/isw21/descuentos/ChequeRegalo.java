package main.java.isw21.descuentos;

public class ChequeRegalo extends Oferta {
    int valor;
    int gastado;

    public ChequeRegalo(String comercio, String fechaIn, String fechaFin, int valor, String codigo, int gastado) {
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

    public int getGastado(){ return gastado;}
}
