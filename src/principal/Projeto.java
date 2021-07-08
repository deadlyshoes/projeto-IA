package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Variable;
import aima.core.search.csp.solver.CspSolver;
import aima.core.search.csp.solver.FlexibleBacktrackingSolver;

public class Projeto {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Digite o número do caso: ");
		int n_caso = in.nextInt();
		
		Caso caso;
		
		if (n_caso == 1) {
			caso = new Caso1();
		} else {
			System.out.println("Caso " + n_caso + " não existe.");
			return;
		}
		
		System.out.println("Para adicionar uma tarefa, digite o nome e a duração da tarefa.");
		System.out.println("Para parar de adicionar tarefas, digite apenas 0");
		while (true) {
			String nome = in.next();
			if (nome.equals("0"))
				break;
			
			int duracao = in.nextInt();
			
			caso.addTarefa(nome, duracao);
		}
		
		CspSolver<Variable, Horario> algoritmo = new FlexibleBacktrackingSolver<Variable, Horario>().setAll();
		Optional<Assignment<Variable, Horario>> solucao = algoritmo.solve(caso);
		if (solucao.isPresent()) {
			for (Variable var : solucao.get().getVariables()) {
				Horario horario = solucao.get().getValue(var);
				System.out.println(var.getName());
				System.out.println("Dia: " + horario.dia);
				System.out.println("Hora: " + horario.inicio);
				System.out.println("Duração: " + horario.duracao);
				System.out.println("");
			}
		}
	}
}
