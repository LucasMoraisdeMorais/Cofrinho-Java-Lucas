package Uninter;

	import java.util.Objects;

	public abstract class Moeda {
	    // Protegido para ser acessível pelas subclasses
	    protected double valor;
	    protected String pais;
	    protected String nome; // Nome da moeda 

	    public Moeda(double valor, String pais, String nome) {
	        this.valor = valor;
	        this.pais = pais;
	        this.nome = nome;
	    }

	    public double getValor() {
	        return valor;
	    }
	    
	    // Métodos abstratos implementados por todas as classes filhas.
	    public abstract void info();
	    public abstract double converterParaReal();

	    // Sobrescrita do método equals para permitir a remoção de moedas
	    // Comparação baseada no valor, nome e país 
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Moeda moeda = (Moeda) o;
	        return Double.compare(moeda.valor, valor) == 0 &&
	               Objects.equals(pais, moeda.pais) &&
	               Objects.equals(nome, moeda.nome);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(valor, pais, nome);
	    }
	}

