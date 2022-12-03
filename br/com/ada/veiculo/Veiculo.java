package br.com.ada.veiculo;


public class Veiculo {

    protected String porta;

    protected Veiculo(String porta){
        this.porta = porta;
    }

    public String executar(){
        return "Executando";
    }

}
