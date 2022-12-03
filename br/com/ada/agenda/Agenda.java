package br.com.ada.agenda;

import java.util.List;

public class Agenda {

    public Contato contato;
    private String descricao;
    public List<Contato> contatos;

    public Agenda(){}

    public Agenda(Contato contato){
        this.contato = contato;
    }

    public Agenda(String descricao, List<Contato> contatos) {
        this.descricao = descricao;
        this.contatos = contatos;
    }

}
