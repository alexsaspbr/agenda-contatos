public abstract class Veiculo {

    protected String porta;
    //public abstract String ligar();
    public abstract String acelerar();
    //public abstract String frear();


    public String executar(){
        //ligar();
        acelerar();
        //frear();
        return "Executando";
    }


}
