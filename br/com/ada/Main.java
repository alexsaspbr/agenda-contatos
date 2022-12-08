package br.com.ada;

import br.com.ada.agenda.Agenda;
import br.com.ada.agenda.Contato;
import de.vandermeer.asciitable.AsciiTable;

import java.util.Scanner;

public class Main {

    private static Agenda agenda;

    public static void main(String[] args) {

        agenda = new Agenda();

        Scanner entrada = new Scanner(System.in);

        int resposta = 0;

        do {

          /*  AsciiTable at = new AsciiTable();

            at.addRule();
            at.addRow("row 1 col 1", "row 1 col 2");
            at.addRule();
            at.addRow("row 2 col 1", "row 2 col 2");
            at.addRule();

            System.out.println(at.render());*/

            System.out.println("####### AGENDA CONTATOS #########\n");
            System.out.println("Escolha uma opção: \n");
            System.out.println("1 - Adicionar Contato   2 - Listar Contatos");

            switch (Integer.parseInt(entrada.nextLine())) {

                case 1:
                    agenda.adicionarContato(entrada);
                    break;

                case 2:
                    agenda.listarContatos();
                    break;

                default:

                    break;

            }

            System.out.println("Deseja continuar? 1 - Sim, 2 - Não");
            resposta = Integer.parseInt(entrada.nextLine());

        } while(resposta == 1);

    }

}
