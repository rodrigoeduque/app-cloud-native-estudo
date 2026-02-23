package br.com.rodrigoeduque;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        LocalDate dataAtual = LocalDate.now();
        LocalTime horaAtual = LocalTime.now();
        LocalDateTime dataHoraAtual = LocalDateTime.now();

        System.out.println("Data atual: " + dataAtual);
        System.out.println("Hora atual: " + horaAtual);
        System.out.println("Data/Hora atual: " + dataHoraAtual);

        System.out.println("\n" + "---- Formatacao ----" + "\n");
        DateTimeFormatter format =  DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Data atual formatada: " + dataAtual.format(format));

        System.out.println("\n" + "---- Testando entrada ----" + "\n");

        String dataAniversario = "01/08/1985";
        LocalDate dataAniversarioEntrada = LocalDate.parse(dataAniversario, format);

        System.out.println("Data aniversario entrada: " + dataAniversarioEntrada);
        System.out.println("Data aniversario entrada formatada: " + dataAniversarioEntrada.format(format));


    }
}