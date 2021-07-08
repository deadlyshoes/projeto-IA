package principal;

import java.util.Arrays;

import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;
import aima.core.search.csp.examples.NotEqualConstraint;

public class Caso1 extends Caso {
	public static final Variable COMP0408_dia1 = new Variable("COMP0408_dia1");
	public static final Variable COMP0408_dia2 = new Variable("COMP0408_dia2");
	public static final Variable COMP0455_dia1 = new Variable("COMP0455_dia1");
	public static final Variable COMP0455_dia2 = new Variable("COMP0455_dia2");
	public static final Variable COMP0481 = new Variable("COMP0481");
	
	@Override
	void addDisciplinas() {
		addVariable(COMP0408_dia1);
		addVariable(COMP0408_dia2);
		addVariable(COMP0455_dia2);
		addVariable(COMP0455_dia1);
		addVariable(COMP0481);
		
		Domain<Horario> dominio_COMP0408_dia1 = new Domain<>(new Horario(SEGUNDA, 21, 2));
		Domain<Horario> dominio_COMP0408_dia2 = new Domain<>(new Horario(QUARTA, 21, 2));
		Domain<Horario> dominio_COMP0455_dia1 = new Domain<>(new Horario(TERCA, 15, 2));
		Domain<Horario> dominio_COMP0455_dia2 = new Domain<>(new Horario(QUINTA, 15, 2));
		Domain<Horario> dominio_COMP0481 = new Domain<>(new Horario(QUINTA, 19, 2));
		
		setDomain(COMP0408_dia1, dominio_COMP0408_dia1);
		setDomain(COMP0408_dia2, dominio_COMP0408_dia2);
		setDomain(COMP0455_dia1, dominio_COMP0455_dia1);
		setDomain(COMP0455_dia2, dominio_COMP0455_dia2);
		setDomain(COMP0481, dominio_COMP0481);
	}
	
	public Caso1() {
		super();
	}
}
