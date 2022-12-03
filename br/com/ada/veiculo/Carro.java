package br.com.ada.veiculo;

public class Carro extends Veiculo {

    public Carro(String porta) {
        super(porta);
    }


    public String acelerar() {
        return "Carro acelerando";
    }

}
