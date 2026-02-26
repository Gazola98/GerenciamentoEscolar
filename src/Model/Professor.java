package Model;

public class Professor extends Pessoa {
    private String disciplina;


    public Professor(String nome, int idade, String disciplina) {
        super(nome, idade);
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String getDescricao() {
        return "Professor: " + getNome() + " | Idade: " + getIdade() + " | Disciplina: " + disciplina;
    }
}
