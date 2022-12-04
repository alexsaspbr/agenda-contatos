package br.com.ada.ecommerce;

import java.math.BigDecimal;
import java.util.List;

public class Carrinho {

    private BigDecimal total;
    private List<Item> itens;

    public Carrinho(List<Item> itens) {
        this.itens = itens;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
