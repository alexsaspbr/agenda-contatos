package br.com.ada.agenda;

import br.com.ada.agenda.util.ConsoleUIHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        return Collections.unmodifiableList(telefones);
    }

    public void addTelefone(Telefone novoTelefone){
        if(verificaTelefoneExiste(novoTelefone)){
            throw new RuntimeException("Telefone já cadastrado!");
        }
        this.telefones.add(novoTelefone);
    }

    private boolean verificaTelefoneExiste(Telefone telefone){
        return this.telefones.stream()
                .anyMatch(telefoneCadastrado -> telefoneCadastrado.equals(telefone));
    }

    public List<Endereco> getEnderecos() {
        return Collections.unmodifiableList(enderecos);
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

    public void adicionarTelefone(){
        //List<TipoTelefone> tipoTelefones = Arrays.stream(TipoTelefone.values()).toList();
        List<TipoTelefone> tipoTelefones = Arrays.stream(TipoTelefone.values())
                .collect(Collectors.toList());

        String menuTipos = tipoTelefones.stream()
                .map(tipoTelefone -> String.format("%n%s - %s", tipoTelefone.ordinal() + 1, tipoTelefone.name()))
                .reduce("", String::concat);

        String tipoTelefone = ConsoleUIHelper.askSimpleInput(String.format("Tipo do Telefone%s", menuTipos));
        TipoTelefone tipo = tipoTelefones.get(Integer.parseInt(tipoTelefone) -1);

        String ddi = ConsoleUIHelper.askSimpleInput("DDI do Telefone");
        String ddd = ConsoleUIHelper.askSimpleInput("DDD do Telefone");
        String numero = ConsoleUIHelper.askSimpleInput("Número do Telefone");

        Telefone telefone = new Telefone(tipo, ddi, ddd, numero);

        try{
            addTelefone(telefone);
        }catch (RuntimeException exception){
            System.out.printf("Erro ao cadastrar: %s %n", exception.getMessage());
        }
    }

}
