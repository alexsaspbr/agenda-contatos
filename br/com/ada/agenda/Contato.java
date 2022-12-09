package br.com.ada.agenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Contato {

    private String nome;
    private String sobreNome;
    private String empresa;
    private String email;
    private List<Telefone> telefones;

    private List<Endereco> enderecos;


    public Contato(String nome, String sobreNome, String email, String empresa) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.email = email;
        this.empresa = empresa;
        this.telefones = new ArrayList<>();
        this.enderecos = new ArrayList<>();
    }

    public Contato (String nome, String sobreNome, String empresa, List<Telefone> telefones, List<Endereco> enderecos) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.empresa = empresa;
        this.telefones = telefones;
        this.enderecos = enderecos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(nome, contato.nome) && Objects.equals(sobreNome, contato.sobreNome) && Objects.equals(empresa, contato.empresa) && Objects.equals(email, contato.email) && Objects.equals(telefones, contato.telefones) && Objects.equals(enderecos, contato.enderecos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, sobreNome, empresa, email, telefones, enderecos);
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
