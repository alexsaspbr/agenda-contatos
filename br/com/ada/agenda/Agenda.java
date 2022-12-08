package br.com.ada.agenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void adicionarContato(Scanner entrada) {

        System.out.println("Nome do Contato");
        String nome = entrada.nextLine();

        System.out.println("Sobrenome do Contato");
        String sobreNome = entrada.nextLine();

        System.out.println("E-mail do Contato");
        String email = entrada.nextLine();

        System.out.println("Empresa do Contato");
        String empresa = entrada.nextLine();

        Contato novoContato = new Contato(nome, sobreNome, empresa, email);

        boolean contatoExiste = this.contatos
                .stream().anyMatch(contato -> contato.equals(novoContato));

        if(!contatoExiste)
            this.contatos.add(novoContato);
        else
            System.out.println("O contato já existe");
    }

    public void listarContatos() {

        if(!this.contatos.isEmpty()){

            this.contatos.forEach(contato -> {
                System.out.println(
                         String.valueOf(this.contatos.indexOf(contato)+1)
                         .concat(" ")
                         .concat(contato.getNome())
                        .concat(" ")
                        .concat(contato.getSobreNome())
                        .concat(" ")
                        .concat(contato.getEmail()));
            });

        } else {
            System.out.println("Não há contatos");
        }
    }


}
