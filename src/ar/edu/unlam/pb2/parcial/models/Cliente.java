package ar.edu.unlam.pb2.parcial.models;

public class Cliente extends Persona {
	private Boolean est;

	public Cliente(String nombre, String apellido, Integer dni, String dir) {
		super(nombre, apellido, dni, dir);
		this.est = false;
	}

	public void bloquearCliente (){
		this.est = true;
	}

	public void desbloquearCliente (){
		this.est = false;
	}

	public Boolean getEst() {
		return est;
	}
	
}
