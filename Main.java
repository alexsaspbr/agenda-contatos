import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Telefone> telefones = new ArrayList<>();

        Telefone telefone1 = new Telefone(TipoTelefone.CELULAR, "+55", "011", "956565656");
      /*  telefone1.tipo = TipoTelefone.CELULAR;
        telefone1.ddi = "+55";
        telefone1.ddd = "011";
        telefone1.numero = "956565656";*/

        Telefone telefone2 = new Telefone(TipoTelefone.COMERCIAL, "+55", "011","978454545" );
  /*      telefone2.tipo = TipoTelefone.COMERCIAL;
        telefone2.ddi = "+55";
        telefone2.ddd = "011";
        telefone2.numero = "978454545";*/

        telefones.add(telefone1);
        telefones.add(telefone2);

        Contato contato = new Contato("Alex", "Araujo", "Ada", telefones);

        //System.out.println(contato.toString());
        /*System.out.println(contato);
        contato.telefones.forEach(tel -> System.out.println(tel.toString()));*/

        contato.listarTelefonesFormatados().forEach(System.out::println);



    }



}
