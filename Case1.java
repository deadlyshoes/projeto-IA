package aima.core.search.csp.examples;

import java.util.Arrays;

import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;
import aima.core.search.csp.examples.Horario;

public class Caso1 extends CSP<Variable, Horario> {
	public static final Variable COMP0408_dia1 = new Variable("COMP0408_dia1");
	public static final Variable COMP0408_dia2 = new Variable("COMP0408_dia2");
	public static final Variable COMP0455_dia1 = new Variable("COMP0455_dia1");
	public static final Variable COMP0455_dia2 = new Variable("COMP0455_dia2");
	public static final Variable COMP0481 = new Variable("COMP0481");

	public static final int SEGUNDA = 0;
	public static final int TERCA   = 1;
	public static final int QUARTA  = 2;
	public static final int QUINTA  = 3;
	public static final int SEXTA   = 4;
	public static final int SABADO  = 5;
	
	public Caso1() {
		super(Arrays.asList(COMP0408_dia1, COMP0408_dia2, COMP0455_dia1, COMP0455_dia2, COMP0481));
		
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
		
		for (Variable var1 : getVariables())
			for (Variable var2 : getVariables())
				if (var1 != var2)
					addConstraint(new NotEqualConstraint<>(var1, var2));
	}
}
