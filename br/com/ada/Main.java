package br.com.ada;

import br.com.ada.agenda.Agenda;
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
                    , "Adicionar Contato");

            switch (opcao) {

                case 0:
                    agenda.adicionarContato();
                    break;


                default:

                    break;

            }

            resposta = ConsoleUIHelper.askChooseOption("Deseja continuar?"
                    , "Sim", "Não");

        } while(resposta == 0);

    }

}
