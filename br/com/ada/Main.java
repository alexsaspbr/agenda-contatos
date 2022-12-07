package br.com.ada;

import br.com.ada.agenda.Agenda;
import br.com.ada.agenda.Contato;

import java.util.Scanner;

public class Main {

    private static Agenda agenda;

    public static void main(String[] args) {

        agenda = new Agenda();

        Scanner entrada = new Scanner(System.in);

        int resposta = 0;

        do {

            System.out.println("####### AGENDA CONTATOS ##########\n");
            System.out.println("Escolha uma opção: \n");
            System.out.println("1 - Adicionar Contato   2 - Listar Contatos");

            switch (entrada.nextInt()) {

                case 1:
                    adicionarContato(entrada);
                    break;

                case 2:
                    listarContatos();
                    break;

                default:

                    break;

            }

            System.out.println("Deseja continuar? 1 - Sim, 2 - Não");
            resposta = entrada.nextInt();

        } while(resposta == 1);


    }

    private static void listarContatos() {
        agenda.getContatos().forEach(contato -> {
            System.out.println(contato.getNome()
                    .concat(" ")
                    .concat(contato.getSobreNome())
                    .concat(" ")
                    .concat(contato.getEmail()));
        });
    }

    private static void adicionarContato(Scanner entrada) {

        System.out.println("Nome do Contato");
        String nome = entrada.next();

        System.out.println("Sobrenome do Contato");
        String sobreNome = entrada.next();

        System.out.println("E-mail do Contato");
        String email = entrada.next();

        System.out.println("Empresa do Contato");
        String empresa = entrada.next();

        Contato novoContato = new Contato(nome, sobreNome, empresa, email);

        boolean contatoExiste = agenda.getContatos()
                .stream().anyMatch(contato -> contato.equals(novoContato));

        if(!contatoExiste)
            agenda.getContatos().add(novoContato);
        else
            System.out.println("O contato já existe");
    }

}
