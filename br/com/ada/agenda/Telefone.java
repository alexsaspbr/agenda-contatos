package br.com.ada.agenda;


import java.util.Objects;

public class Telefone {

    public TipoTelefone tipo;
    public String ddi;
    public String ddd;
    public String numero;

    public Telefone(TipoTelefone tipo, String ddi, String ddd, String numero){
        this.tipo = tipo;
        this.ddi = ddi;
        this.ddd = ddd;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return String.format(
                "Tipo: %s \n" +
                "DDI %s \n" +
                "DDD %s \n" +
                "Numero %s \n", tipo, ddi, ddd, numero)
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return Objects.equals(ddi, telefone.ddi) && Objects.equals(ddd, telefone.ddd) && Objects.equals(numero, telefone.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ddi, ddd, numero);
    }
}
