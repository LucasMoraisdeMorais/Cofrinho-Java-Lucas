package Uninter;

public class Real extends Moeda {

    public Real(double valor) {
        super(valor, "Brasil", "Real Brasileiro");
    }

    @Override
    public void info() {
        System.out.printf("Real (R$): %.2f%n", valor);
    }

    // A conversão para Real é 1:1.
    @Override
    public double converterParaReal() {
        return valor;
    }
}
