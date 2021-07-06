package aima.core.search.csp.examples;

public class Horario {
	public int dia, inicio, duracao;
	private int l, r;
	
	/* mapeamento de dias
	 * 0 <=> segunda
	 * 1 <=> terça
	 * 2 <=> quarta
	 * 3 <=> quinta
	 * 4 <=> sexta
	 * 5 <=> sábado
	 */
	
	// início entre 0 e 23
	
	public void calcIntervalo() {
		this.l = 24 * this.dia + this.inicio;
		this.r = 24 * this.dia + this.inicio + this.duracao;
	}
	
	public Horario(int dia, int inicio, int duracao) {
		this.dia = dia;
		this.inicio = inicio;
		this.duracao = duracao;
		
		calcIntervalo();
	}
	
	@Override
	public boolean equals(Object o) {
		Horario b = (Horario)o;

		return (
			// inicia no meio
			b.l >= this.l && b.l < this.r ||
			// termina no meio
			b.r > this.l && b.r <= this.r ||
			// inicia antes, mas termina depois
			b.l < this.l && b.r > this.r
		);
	}
}
