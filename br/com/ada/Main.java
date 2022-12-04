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



    }

}
