package Model;

public class Nota {

    private String nomeMateria;
    private double valor;

    public Nota(String nomeMateria, double valor) {
        this.nomeMateria = nomeMateria;
        this.valor = valor;
    }

    public String getNomeMateria() {
        return nomeMateria;
    }

    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
