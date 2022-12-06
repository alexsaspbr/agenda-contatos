package br.com.ada;

import br.com.ada.agenda.Agenda;
import br.com.ada.agenda.Contato;
import br.com.ada.agenda.Telefone;
import br.com.ada.agenda.TipoTelefone;
import br.com.ada.ecommerce.Carrinho;
import br.com.ada.ecommerce.Item;
import br.com.ada.ecommerce.Produto;

import java.awt.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;


public class Main {

    public static void main(String[] args) {

        Produto produto1 = new Produto(1L, "PS5", new BigDecimal("5000.0"));
        Produto produto2 = new Produto(2L, "Echo Dot", new BigDecimal("200.0"));
        Produto produto3 = new Produto(3L, "Iphone 13", new BigDecimal("10000.0"));

        Item item1 = new Item(2, produto2);
        Item item2 = new Item(1, produto1);

        List<Item> itens = new ArrayList<>();
        itens.add(item1);
        itens.add(item2);

        Carrinho carrinho = new Carrinho(itens);

       /* carrinho.getItens().stream()
                           .map(item -> {
                                return "Produto: " + item.getProduto().getNome() + "" +
                                        " Valor Unitário " + item.getProduto().getValor();
                            })
                            .forEach(System.out::println);*/

/*        carrinho.getItens()
                .forEach(item -> System.out.printf("Produto: %-15s Valor Unitário: %9s%n",
                        item.getProduto().getNome(),
                        item.getProduto().getValor()));*/

/*        for(Item item : carrinho.getItens()) {
            System.out.printf("Produto: %-15s Valor Unitário: %9s%n",
                    item.getProduto().getNome(),
                    item.getProduto().getValor());
        }*/

        BigDecimal total = carrinho.getItens().stream()
                .map(item -> item.getProduto().getValor().multiply(new BigDecimal(item.getQuantidade())))
                //.forEach(System.out::println);
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        //System.out.println("Total " + total);


        Optional<BigDecimal> optionalTotal = carrinho.getItens().stream()
                .map(item -> item.getProduto().getValor().multiply(new BigDecimal(item.getQuantidade())))
                //.forEach(System.out::println);
                .reduce(BigDecimal::add);

        optionalTotal.ifPresent(System.out::println);
        optionalTotal.ifPresent(carrinho::setTotal);

        carrinho.setTotal(total);

    }

}
