package br.com.ada.agenda;

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
}
