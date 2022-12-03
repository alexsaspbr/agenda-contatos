package br.com.ada.veiculo;


public class Moto extends Veiculo {
    protected Moto(String porta) {
        super(porta);
    }

    //@Override
    public String acelerar() {
        return "Moto acelerando";
    }
}
