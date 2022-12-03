package br.com.ada;

import br.com.ada.agenda.Agenda;
import br.com.ada.agenda.Contato;
import br.com.ada.agenda.Telefone;
import br.com.ada.agenda.TipoTelefone;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;


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

        //contato.listarTelefonesFormatados().forEach(System.out::println);

        Contato contato2 = new Contato("Thiago", "Sol", "Ada");
        Contato contato3 = new Contato("Adriano", "Sol", "Ada");
        Contato contato4 = new Contato("Adriano", "Sol", "Ada");

        Agenda agenda = new Agenda();

        agenda.contatos = new ArrayList<>();

        agenda.contatos.add(contato);
        agenda.contatos.add(contato2);
        agenda.contatos.add(contato3);
        agenda.contatos.add(contato4);

        agenda.contatos.stream()
                       //.filter(c -> {
                           //return c.sobreNome.equalsIgnoreCase("Sol"); //true or false
                       //})
                       //.distinct()
                       //.limit(3)
                       //.sorted(Comparator.comparing(Contato::getNome).reversed())
                       //.findFirst()
                       /*.map(c -> {
                           if(c.nome.equalsIgnoreCase("Alex"))
                               return new Contato(c.nome, "Silva", c.empresa, new ArrayList<>());
                           return c; //objeto
                       })*/
                       //.skip(2) //pula pela quantidade de elementos


                       .forEach(System.out::println);

       /* System.out.println("DEPOIS \n");

        agenda.contatos.forEach(System.out::println);*/

        System.out.printf("AllMatch %s \n", agenda.contatos.stream().allMatch(Objects::nonNull));
        System.out.printf("AnyMatch %s \n",agenda.contatos.stream().anyMatch(c -> c.getNome().equals("Alex")));
        System.out.printf("NoneMatch %s \n",agenda.contatos.stream().noneMatch(c -> c.getNome().equals("Ana")));

        //agenda.contatos = new ArrayList<>();
        System.out.println(agenda.contatos.size());
        System.out.println(agenda.contatos.stream().count());

        Map<String, List<Contato>> collect = agenda.contatos
                .stream()
                //.map(Contato::getNome)
                .collect(groupingBy(Contato::getSobreNome));
        System.out.println(collect);

        List<String> nomesContatos = agenda.contatos
                .stream()
                .map(Contato::getNome)
                .collect(Collectors.toList());

        List<Integer> numeros = List.of(1,2,3,4,5);

        System.out.printf("SOMA: %s", numeros.stream().reduce(0, Integer::sum));

    }

}
