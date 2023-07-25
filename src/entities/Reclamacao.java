package entities;

public class Reclamacao extends Manifestacao {
	public Reclamacao (String tipo, Pessoa pessoa) {
		super(pessoa, tipo);
		this.setTipo ("Reclamacao");
	}

	@Override
	public String toString() {
		return "Reclamacao [pessoa=" + pessoa + ", getPessoa()=" + getPessoa() + ", getTipo()=" + getTipo() + "]";
	}

	
	}
	
	
	
	

