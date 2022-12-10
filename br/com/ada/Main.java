package br.com.ada;

import br.com.ada.agenda.Agenda;
import br.com.ada.agenda.Contato;
import br.com.ada.agenda.util.ConsoleUIHelper;

public class Main {

    private static Agenda agenda;

    public static void main(String[] args) {

        agenda = new Agenda();
        int resposta = 0;

        do {

            int width = 80;
            ConsoleUIHelper.drawHeader("Agenda", width);
            agenda.listarContatos();
            ConsoleUIHelper.fillVSpace(1, width);
            int opcao = ConsoleUIHelper.askChooseOption("Escolha uma opção"
                    , "Adicionar Contato",                     //0
                              "Adicionar um telefone a um contato");   //1

            switch (opcao) {

                case 0:
                    agenda.adicionarContato();
                    break;

                case 1:
                    int codigoContato = Integer.parseInt(ConsoleUIHelper.askSimpleInput("Para qual contato?"));
                    Contato contato = agenda.getContatoPeloCodigo(codigoContato);
                    contato.adicionarTelefone();
                    break;

                default:

                    break;

            }

            resposta = ConsoleUIHelper.askChooseOption("Deseja continuar?"
                    , "Sim", "Não");

        } while(resposta == 0);

    }

}
