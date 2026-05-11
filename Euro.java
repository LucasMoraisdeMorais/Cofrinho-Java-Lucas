package Uninter;

public class Euro extends Moeda {

    // Taxa de câmbio (Euro para Real)
    private static final double TAXA_CONVERSAO = 6.0; 

    public Euro(double valor) {
        super(valor, "União Europeia", "Euro");
    }

    @Override
    public void info() {
        System.out.printf("Euro (EUR): %.2f%n", valor);
    }

    // O método de polimórfismo aplica a taxa de conversão.
    @Override
    public double converterParaReal() {
        return valor * TAXA_CONVERSAO;
    }
}
