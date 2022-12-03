package br.com.ada.agenda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Contato {

    public String nome;
    public String sobreNome;
    public String empresa;
    public String email;
    public List<Telefone> telefones;

    public Contato(String nome, String sobreNome, String empresa) {
        this(nome, sobreNome, empresa, new ArrayList<>());
    }

    public String getNome(){
        return nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public Contato (String nome, String sobreNome, String empresa, List<Telefone> telefones) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.empresa = empresa;
        this.telefones = telefones;
    }

    public List<String> listarTelefonesFormatados(){
        return telefones.stream().map(t -> {
            return String.format("%s (%s) %s", t.ddi, t.ddd, t.numero);
        }).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return nome.equals(contato.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(
                "Nome: %s \n" +
                "Sobrenome: %s \n" +
                "Empresa: %s \n", nome, sobreNome, empresa
        ));
        sb.append("Telefones\n\n");
        telefones.forEach(telefones -> sb.append(telefones.toString()).append("\n"));
        return sb.toString();
    }

}
