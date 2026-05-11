package Uninter;

import java.util.ArrayList;

public class Cofre {
    // A coleção guarda objetos do tipo Moeda
    private ArrayList<Moeda> listaMoedas;

    public Cofre() {
        this.listaMoedas = new ArrayList<>();
    }

    public void adicionarMoeda(Moeda m) {
        this.listaMoedas.add(m);
        System.out.println("Moeda adicionada: " + m.nome + " de " + m.valor);
    }

    public boolean removerMoeda(Moeda m) {
        // Usa o método equals() sobrescrito na classe Moeda
        if (this.listaMoedas.remove(m)) {
            System.out.println("Moeda removida com sucesso!");
            return true;
        } else {
            System.out.println("Moeda não encontrada no cofrinho.");
            return false;
        }
    }

    public void listarMoedas() {
        if (listaMoedas.isEmpty()) {
            System.out.println("O cofrinho está vazio.");
            return;
        }
        
        System.out.println("\n--- Moedas no Cofrinho ---");
        for (Moeda moeda : listaMoedas) {
            moeda.info(); // Chama o método info() específico de cada moeda
        }
        System.out.println("--------------------------");
    }

    public double totalConvertido() {
        double total = 0;
        for (Moeda moeda : listaMoedas) {
            // Chama o método converterParaReal() específico de cada moeda (Polimorfismo)
            total += moeda.converterParaReal(); 
        }
        return total;
    }
}
