package br.com.ada.agenda;

import br.com.ada.agenda.util.ConsoleUIHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Agenda {

    private static final int FATOR_INDICE = 1;
    private List<Contato> contatos;

    public Agenda(){
        this.contatos = new ArrayList<>();
    }

    public List<Contato> getContatos() {
        return Collections.unmodifiableList(contatos);
    }

    public void addContatos(List<Contato> contatos) {
        contatos.forEach(novoContato -> {
            if(verificaContatoExiste(novoContato)){
                throw new RuntimeException("Contato já cadastrado");
            }
        });

        if(contatos.stream().distinct().count() != contatos.size()){
            throw new RuntimeException("Contatos duplicados");
        }

        this.contatos.addAll(contatos);
    }

    private boolean verificaContatoExiste(Contato contato){
        return this.contatos
                .stream()
                .anyMatch(contatoCadastrado -> contatoCadastrado.equals(contato));
    }

    public void adicionarContato() {

        String nome = ConsoleUIHelper.askSimpleInput("Nome do Contato");
        String sobreNome = ConsoleUIHelper.askSimpleInput("Sobrenome do Contato");
        String email = ConsoleUIHelper.askSimpleInput("E-mail do Contato");
        String empresa = ConsoleUIHelper.askSimpleInput("Empresa do Contato");

        Contato novoContato = new Contato(nome, sobreNome, email, empresa);

        try{
            addContatos(List.of(novoContato));
        }catch (RuntimeException exception){
            System.out.printf("Erro ao cadastrar: %s %n", exception.getMessage());
        }
    }

    public void listarContatos() {

        int width = 80;

        if(!this.contatos.isEmpty()){
            this.contatos.stream()
                      .map(contato -> {
                        StringBuilder sb = new StringBuilder();
                        sb.append(ConsoleUIHelper.columnPaddingRight(String.valueOf(this.contatos.indexOf(contato)+FATOR_INDICE), 3, ' '));
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

    public Contato getContatoPeloCodigo(int codigoContato) {
        return this.contatos.get(codigoContato - FATOR_INDICE);
    }
}
