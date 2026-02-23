package br.com.rodrigoeduque;

import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        System.out.println("Lista de Produtos:");
        List<Produto> lista = new ArrayList<>();
        lista.add(new Produto(1, "Computador", 1500.0));
        lista.add(new Produto(2, "Mouse", 50.0));
        lista.add(new Produto(3, "Teclado", 100.0));
        //Permite Duplicidade
        lista.add(new Produto(1, "Computador", 1500.0));
        lista.add(new Produto(2, "Mouse", 50.0));
        System.out.println(lista);
        System.out.println("#######################################################");

        System.out.println("Set de Produtos:");
        Set<Produto> conjunto = new HashSet<>();
        conjunto.add(new Produto(1, "Computador", 1500.0));
        conjunto.add(new Produto(2, "Mouse", 50.0));
        conjunto.add(new Produto(3, "Teclado", 100.0));
        //O Set desconsidera elementos duplicados, mas preciso implementar o hash e equals para que ele garanta que trata-se do mesmo produto
        conjunto.add(new Produto(1, "Computador", 1500.0));
        conjunto.add(new Produto(2, "Mouse", 50.0));
        System.out.println(conjunto);
        System.out.println("#######################################################");

        System.out.println("Map de Produtos:");
        Map<Integer, Produto> mapa = new HashMap<>();
        mapa.put(1, new Produto(1, "Computador", 1500.0));
        mapa.put(2, new Produto(2, "Mouse", 50.0));
        mapa.put(3, new Produto(3, "Teclado", 100.0));
        System.out.println(mapa);
        System.out.println("#######################################################");

    }

    public static void benchmarksList(int tamanho){
        List<Produto> lista = new ArrayList<>();

        for(int i = 0; i < tamanho; i++){
            lista.add(new Produto(i+1, "Produto " + (i+1), (i+1)*100));
        }
        int itemBusca = tamanho - 1;
        long inicio = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++){
            Produto produto = lista.get(itemBusca);
        }
        long fim = System.currentTimeMillis();
        
    }
}
