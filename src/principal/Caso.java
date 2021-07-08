package principal;

import java.util.ArrayList;
import java.util.List;

import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;
import aima.core.search.csp.examples.NotEqualConstraint;

public abstract class Caso extends CSP<Variable, Horario> {
	public static final int SEGUNDA = 0;
	public static final int TERCA   = 1;
	public static final int QUARTA  = 2;
	public static final int QUINTA  = 3;
	public static final int SEXTA   = 4;
	public static final int SABADO  = 5;
	
	public Caso() {
		addDisciplinas();
		
		for (Variable var1 : getVariables())
			for (Variable var2 : getVariables())
				if (var1 != var2)
					addConstraint(new NotEqualConstraint<>(var1, var2));
	}
	
	void addTarefa(String nome, int duracao) {
		Variable tarefa = new Variable(nome);
		addVariable(tarefa);
		
		List<Horario> horarios = new ArrayList<>();
		// segunda a sexta
		for (int dia = SEGUNDA; dia <= SEXTA; dia++) {
			for (int hora = 0; hora <= 23; hora++) {
				horarios.add(new Horario(dia, hora, duracao));
			}
		}
		// sábado
		for (int hora = 0; hora <= 23 - duracao; hora++) {
			horarios.add(new Horario(SABADO, hora, duracao));
		}
		
		setDomain(tarefa, new Domain<>(horarios));
		
		for (Variable var : getVariables())
			if (tarefa != var)
				addConstraint(new NotEqualConstraint<>(tarefa, var));
	}
	
	abstract void addDisciplinas();
}
