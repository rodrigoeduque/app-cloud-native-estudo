package br.com.rodrigoeduque;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Veiculo> listaVeiculos;

        listaVeiculos = List.of(
                new Veiculo("Toyota", "Corolla", "Prata", 80000, 2020, 180, "Gasolina"),
                new Veiculo("Honda", "Civic", "Preto", 90000, 2021, 190, "Gasolina"),
                new Veiculo("Ford", "Mustang", "Vermelho", 150000, 2019, 250, "Gasolina"),
                new Veiculo("Chevrolet", "Camaro", "Amarelo", 140000, 2018, 240, "Gasolina"),
                new Veiculo("Volkswagen", "Golf", "Azul", 70000, 2020, 170, "Gasolina"),
                new Veiculo("Nissan", "Sentra", "Branco", 75000, 2021, 160, "Gasolina"),
                new Veiculo("Hyundai", "Elantra", "Cinza", 65000, 2019, 150, "Gasolina"),
                new Veiculo("Kia", "Optima", "Prata", 85000, 2020, 180, "Gasolina"),
                new Veiculo("Kia", "Cerato", "Vermelho", 60000, 2021, 160, "Gasolina"),
                new Veiculo("Subaru", "Impreza", "Azul", 70000, 2018, 170, "Gasolina")
        );

        System.out.println("##########  Ordenacao por Ano  ##########");
        listaVeiculos.stream().sorted(Comparator.comparing(Veiculo::getAno)).forEach(veiculo -> {
            System.out.println(veiculo.getAno() + " - " + veiculo.getMarca() + " " + veiculo.getModelo());
                }
        );

        System.out.println("##########  Ordenacao por Marca  ##########");
        listaVeiculos.stream().sorted(Comparator.comparing(Veiculo::getMarca)).forEach(veiculo -> {
            System.out.println(veiculo.getMarca() + " - " + veiculo.getModelo() + " - Ano: " + veiculo.getAno());
        });

        System.out.println("##########  Filtro por Marca 'Kia'  ##########");
        listaVeiculos.stream().filter(veiculo -> veiculo.getMarca().equalsIgnoreCase("Kia")).forEach(v -> {
            System.out.println(v.getMarca() + " - " + v.getModelo() + " - Ano: " + v.getAno());
        });

        System.out.println("##########  Filtro por Ano > 2019  ##########");
        listaVeiculos.stream().filter(v -> v.getAno() > 2019).forEach(veiculo -> {
            System.out.println(veiculo.getMarca() + " - " + veiculo.getModelo() + " - Ano: " + veiculo.getAno());
        });

        Double mediaPreco = listaVeiculos.stream().mapToDouble(Veiculo::getPreco).average().orElse(0.0);
        System.out.println("##########  Media de Preco dos Veiculos  ##########");
        System.out.println("Media de Preco: R$ " + mediaPreco);

        Double carroMaisCaro = listaVeiculos.stream().mapToDouble(Veiculo::getPreco).max().orElseThrow();
        System.out.println("##########  Carro Mais Caro  ##########");
        System.out.println("Preco do Carro Mais Caro: R$ " + carroMaisCaro);

        double mediaKia = listaVeiculos.stream().filter(kia -> kia.getMarca().equalsIgnoreCase("Kia")).mapToDouble(Veiculo::getPreco).average().orElseThrow(() -> new RuntimeException("Nenhum carro da marca Kia encontrado"));
        System.out.println("##########  Media de Preco dos Carros da Marca Kia  ##########");
        System.out.println("Media de Preco dos Carros da Marca Kia: R$ " + mediaKia);

        List<Veiculo> upperCaseVeiculos = listaVeiculos.stream().map(veiculos -> conversaoUpperCase(veiculos)).collect(Collectors.toList());

        System.out.println("##########  Veiculos com Atributos em UpperCase  ##########");
        System.out.println(upperCaseVeiculos);

        System.out.println("##########  Veiculos com Preco Ajustado em 10%  ##########");
        List<Veiculo> veiculosAjustados = listaVeiculos.stream().map(veiculo -> ajustePreco(veiculo, 10)).collect(Collectors.toList());
        System.out.println(veiculosAjustados);

    }

    public static Veiculo conversaoUpperCase(Veiculo veiculo) {
        return new Veiculo(
                veiculo.getMarca().toUpperCase(),
                veiculo.getModelo().toUpperCase(),
                veiculo.getCor().toUpperCase(),
                veiculo.getPreco(),
                veiculo.getAno(),
                veiculo.getVelMaxima(),
                veiculo.getTipoCombustivel().toUpperCase()
        );
    }

        public static Veiculo ajustePreco(Veiculo veiculo, double percentualAjuste) {
            double novoPreco = veiculo.getPreco() * (1 + percentualAjuste / 100);
            return new Veiculo(
                    veiculo.getMarca(),
                    veiculo.getModelo(),
                    veiculo.getCor(),
                    novoPreco,
                    veiculo.getAno(),
                    veiculo.getVelMaxima(),
                    veiculo.getTipoCombustivel()
            );
        }
    }