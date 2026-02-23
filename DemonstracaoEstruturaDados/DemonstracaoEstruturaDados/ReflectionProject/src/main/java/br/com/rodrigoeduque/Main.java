package br.com.rodrigoeduque;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {


        var produto = new Produto(1, "Computador novo", 1000.1);

        ClassExplorer.exploreMetadata(produto);
    }
}