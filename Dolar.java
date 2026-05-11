package Uninter;

public class Dolar extends Moeda {

    // Taxa de câmbio fixa para o exemplo (Dólar para Real)
    private static final double TAXA_CONVERSAO = 5.0; 

    public Dolar(double valor) {
        super(valor, "Estados Unidos", "Dólar Americano");
    }

    @Override
    public void info() {
        System.out.printf("Dólar (USD): %.2f%n", valor);
    }

    // O método polimórfico na taxa de conversão.
    @Override
    public double converterParaReal() {
        return valor * TAXA_CONVERSAO;
    }
}
