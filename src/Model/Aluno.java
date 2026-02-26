package Model;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {

    private String matricula;
    private List<Nota> notas = new ArrayList<>();

    public Aluno(String nome, int idade, String matricula) {
        super(nome, idade);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void adicionarNota(String nomeMateria, double valor) {
        notas.add(new Nota(nomeMateria, valor));
    }

    public void listarNotas() {
        if(notas.isEmpty()) {
            System.out.println("Nenhuma nota cadastrada");
            return;
        }

        System.out.println("Notas do aluno: ");

        for (Nota nota : notas) {
            System.out.println("- " + nota.getNomeMateria() + ":" + nota.getValor());
        }

        System.out.println("Média: " + calcularMedia());
        System.out.println("Situação: " + getSituacao());
    }

    public double calcularMedia() {
        if(notas.isEmpty()) {
            return 0;
        }

        double soma = 0;

        for (Nota nota : notas) {
            soma += nota.getValor();
        }

        return soma / notas.size();
    }

    public String getSituacao() {
        double media = calcularMedia();

        if(media >=7) {
            return "Aprovado!";
        } else {
            return "Reprovado.";
        }
    }


    @Override
    public String getDescricao() {
        return "Aluno: " + getNome() + " | Idade: " + getIdade() + " | Matrícula: " + matricula + "| Média: " + calcularMedia()
                + "Situação: " + getSituacao();
    }
}
