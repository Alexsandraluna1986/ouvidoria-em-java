package entities;

public class Sugestao extends Manifestacao {
	public Sugestao (String tipo, Pessoa pessoa) {
		super(pessoa, tipo);
		this.setTipo ("Sugestao");
	}

	@Override
	public String toString() {
		return "Sugestao [pessoa=" + pessoa + ", getPessoa()=" + getPessoa() + ", getTipo()=" + getTipo() + "]";
	}

	
	}
	
	

