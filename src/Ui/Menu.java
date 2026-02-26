package Ui;

import Model.Aluno;
import Model.Nota;
import Model.Professor;
import Service.Escola;

import java.util.Scanner;

public class Menu {

    private Scanner sc = new Scanner(System.in);
    private Escola escola = new Escola();

    public void iniciar() {

        int opcao;

        do {
            mostrarMenu();
            opcao = lerNumero();

            switch (opcao) {
                case 1 -> cadastrarAluno();
                case 2 -> cadastrarProfessor();
                case 3 -> escola.listarPessoas();
                case 4 -> buscarPessoa();
                case 5 -> removerPessoa();
                case 6 -> adicionarNota();
                case 7 -> System.out.println("Encerrando sistema...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 7);
    }

    private void mostrarMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1 - Cadastrar Aluno");
        System.out.println("2 - Cadastrar Professor");
        System.out.println("3 - Listar Pessoas");
        System.out.println("4 - Buscar Pessoa");
        System.out.println("5 - Remover Pessoa");
        System.out.println("6 - Adicionar nota");
        System.out.println("7 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private int lerNumero() {
        while (!sc.hasNextInt()) {
            System.out.println("Digite um número válido!");
            sc.next();
        }
        int numero = sc.nextInt();
        sc.nextLine();
        return numero;
    }

    private void cadastrarAluno() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Idade: ");
        int idade = lerNumero();

        System.out.print("Matrícula: ");
        String matricula = sc.nextLine();

        escola.adicionarPessoa(new Aluno(nome, idade, matricula));
        System.out.println("Aluno cadastrado com sucesso!");
    }

    private void cadastrarProfessor() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Idade: ");
        int idade = lerNumero();

        System.out.print("Discíplina: ");
        String disciplina = sc.nextLine();

        escola.adicionarPessoa(new Professor(nome, idade, disciplina));
        System.out.println("Professor cadastrado com sucesso!");
    }

    private void buscarPessoa() {
        System.out.print("Digite o nome: ");
        String nome = sc.nextLine();

        var pessoa = escola.buscarPorNome(nome);

        if(pessoa != null) {
            System.out.println(pessoa.getDescricao());
        }else {
            System.out.println("Pessoa não encontrada.");
        }
    }

    private void removerPessoa() {
        System.out.print("Digite o nome: ");
        String nome = sc.nextLine();

        if(escola.removerPorNome(nome)) {
            System.out.println("Pessoa removida com sucesso.");
        } else {
            System.out.println("Pessoa não encontrada.");
        }
    }

    private void adicionarNota() {
        System.out.print("Digite o nome do aluno: ");
        String nome = sc.nextLine();

        var pessoa = escola.buscarPorNome(nome);

        if(pessoa == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        if(!(pessoa instanceof Aluno aluno)) {
            System.out.println("A pessoa encontrada não é um aluno.");
            return;
        }

        System.out.print("Nome da matéria: ");
        String materia = sc.nextLine();

        System.out.print("Nota: ");
        double valor = lerNumeroDouble();

        aluno.adicionarNota(materia, valor);

        System.out.println("Nota adicionada com sucesso!");
    }

    private double lerNumeroDouble() {
        while (!sc.hasNextDouble()) {
            System.out.println("Digite um número válido!");
            sc.next();
        }
        double numero = sc.nextDouble();
        sc.nextLine();
        return numero;
    }
}
