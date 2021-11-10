package main.java.isw21.descuentos;
import main.java.isw21.comercio.Comercio;
import java.util.Date;

public class Descuento {

    public String fechaIn;
    public String fechaFin;
    public int tipo;
    public int valor;
    public String codigo;
    public String comercio;

    public Descuento(String fechaIn, String fechaFin, int tipo,int valor, String comercio, String codigo ){
        this.fechaIn=fechaIn;
        this.fechaFin=fechaFin;
        this.valor=valor;
        this.tipo=tipo;
        this.comercio=comercio;
        this.codigo=codigo;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(String fechaIn) {
        this.fechaIn = fechaIn;
    }

    public String getComercio() {
        return comercio;
    }

    public void setComercio(String comercio) {
        this.comercio = comercio;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
