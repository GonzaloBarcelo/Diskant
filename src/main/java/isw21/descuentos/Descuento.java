package main.java.isw21.descuentos;
import main.java.isw21.comercio.Comercio;
import java.util.Date;

public class Descuento {

    public Date fechaIn;
    public Date fechaFin;
    public int tipo;
    public int valor;
    public String codigo;
    public Comercio comercio;

    public Descuento(Date fechaIn, Date fechaFin, int tipo,int valor, Comercio comercio, String codigo ){
        this.fechaIn=fechaIn;
        this.fechaFin=fechaFin;
        this.valor=valor;
        this.tipo=tipo;
        this.comercio=comercio;
        this.codigo=codigo;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(Date fechaIn) {
        this.fechaIn = fechaIn;
    }

    public Comercio getComercio() {
        return comercio;
    }

    public void setComercio(Comercio comercio) {
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
