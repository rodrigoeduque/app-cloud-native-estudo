package br.com.rodrigoeduque;

import java.util.Optional;

public class Main {
    public static void main(String[] args) throws Exception {

        ProdutoRepo produtoRepo = new ProdutoRepo();

        Produto produto = produtoRepo.findById(100).orElseThrow(() -> new Exception("404 - Produto inexistente"));
        System.out.println(produto);

    }
}