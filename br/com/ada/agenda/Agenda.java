package br.com.ada.agenda;

import br.com.ada.agenda.util.ConsoleUIHelper;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> contatos;

    public Agenda(){
        this.contatos = new ArrayList<>();
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public void adicionarContato() {

        String nome = ConsoleUIHelper.askSimpleInput("Nome do Contato");
        String sobreNome = ConsoleUIHelper.askSimpleInput("Sobrenome do Contato");
        String email = ConsoleUIHelper.askSimpleInput("E-mail do Contato");
        String empresa = ConsoleUIHelper.askSimpleInput("Empresa do Contato");

        Contato novoContato = new Contato(nome, sobreNome, empresa, email);

        boolean contatoExiste = this.contatos
                .stream().anyMatch(contato -> contato.equals(novoContato));

        if(!contatoExiste)
            this.contatos.add(novoContato);
        else
            System.out.println("O contato já existe");
    }

    public void listarContatos() {

        int width = 80;

        if(!this.contatos.isEmpty()){
            this.contatos.stream()
                      .map(contato -> {
                        StringBuilder sb = new StringBuilder();
                        sb.append(ConsoleUIHelper.columnPaddingRight(String.valueOf(this.contatos.indexOf(contato)+1), 3, ' '));
                        sb.append(ConsoleUIHelper.columnPaddingRight((contato.getNome() + " " + contato.getSobreNome()), 52, ' '));
                        sb.append(ConsoleUIHelper.columnPaddingRight(contato.getEmail(), 25, ' '));
                        return sb.toString();
                    })
                   .forEach(System.out::println);
            ConsoleUIHelper.drawLine(width);
        } else {
            ConsoleUIHelper.drawWithPadding("Não há contatos", width);
        }
    }


}
