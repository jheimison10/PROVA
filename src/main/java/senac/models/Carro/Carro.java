package senac.models;

public class Carro {
    private String marca;
    private String modelo;
    private int ano;
    private String cor;
    private String placa;
    private String renavan;

    public Carro(String marca, String modelo, int ano, String cor, String placa, String renavan) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.placa = placa;
        this.renavan = renavan;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAno() { return ano; }
    public String getCor() { return cor; }
    public String getPlaca() { return placa; }
    public String getRenavan() { return renavan; }

    @Override
    public String toString() {
        return String.format("%s - %s (%d) | Cor: %s | Placa: %s | Renavan: %s",
                marca, modelo, ano, cor, placa, renavan);
    }
}
