package br.com.rodrigoeduque;

public class Veiculo {

    private String marca;
    private String modelo;
    private String cor;
    private double preco;
    private int ano;
    private double velMaxima;
    private String tipoCombustivel;

    public Veiculo(String marca, String modelo, String cor, double preco, int ano, double velMaxima, String tipoCombustivel) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.preco = preco;
        this.ano = ano;
        this.velMaxima = velMaxima;
        this.tipoCombustivel = tipoCombustivel;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getVelMaxima() {
        return velMaxima;
    }

    public void setVelMaxima(double velMaxima) {
        this.velMaxima = velMaxima;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", cor='" + cor + '\'' +
                ", preco=" + preco +
                ", ano=" + ano +
                ", velMaxima=" + velMaxima +
                ", tipoCombustivel='" + tipoCombustivel + '\'' +
                '}';
    }
}
