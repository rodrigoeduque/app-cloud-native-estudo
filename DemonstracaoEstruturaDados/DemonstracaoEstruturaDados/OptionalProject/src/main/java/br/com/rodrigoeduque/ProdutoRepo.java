package br.com.rodrigoeduque;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoRepo {

    private List<Produto> database;

    public ProdutoRepo() {
        this.database = new ArrayList<>() {{
            add(new Produto(1, "Computador", 1500.0));
            add(new Produto(2, "Mouse", 50.0));
            add(new Produto(3, "Teclado", 100.0));
            add(new Produto(4, "Monitor", 500.0));
        }};
    }

    public Optional<Produto> findById(int id) {
        return database.stream().filter(prod -> prod.getId() == id).findFirst();
    }
}
