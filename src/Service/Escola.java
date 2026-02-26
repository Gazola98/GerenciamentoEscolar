package Service;

import Model.Aluno;
import Model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class Escola {

    private List<Pessoa> pessoas = new ArrayList<>();

    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public void listarPessoas() {
        if(pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }

        for (Pessoa p : pessoas) {
            System.out.println("--------------------");
            System.out.println(p.getDescricao());

            if (p instanceof Aluno aluno) {
                aluno.listarNotas();
            }
        }
    }

    public Pessoa buscarPorNome(String nome) {
        for (Pessoa p : pessoas) {
            if(p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public boolean removerPorNome(String nome) {
        Pessoa pessoa = buscarPorNome(nome);

        if(pessoa != null) {
            pessoas.remove(pessoa);
            return true;
        }

        return false;
    }
}
