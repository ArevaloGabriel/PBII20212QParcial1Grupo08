package ar.edu.unlam.pb2.parcial.models;

public class Clientes {

	private Cliente []vecClientes;
	private Integer idx;
	private final Integer MAX_CLIENTES = 4;
	
	public Clientes () {
		this.vecClientes = new Cliente[this.MAX_CLIENTES];
		this.idx = 0;
	}
	
	public Boolean agregarCliente (Cliente nuevo) {
		Boolean est = false;
		if(this.idx < this.MAX_CLIENTES) {
			if(!this.buscarClienteXDNI(nuevo.getDni())) {
				this.vecClientes[this.idx] = nuevo;
				this.idx++;
				est = true;
			}
		}
		return est;
	}
	
	public Boolean buscarClienteXDNI(Integer dni) {
		Boolean enc = false;
		if(this.idx > 0) {
			for (int i = 0; i < this.idx && !enc; i++) {
				if(this.vecClientes[i].getDni().equals(dni))
					enc=true;
			}
		}
		return enc;
	}

	public Cliente[] listarCliente(){
		return this.vecClientes;
	}

	public Boolean modificarDatosDelCliente(Cliente nuevo){
		Boolean est = false;
		Integer ind = 0;
		while (ind < this.idx && !est){
			if (nuevo.getDni().equals(this.vecClientes[ind].getDni())){
				this.vecClientes[ind].actualizarDatos((Persona)nuevo);
				est = true;
			}else{
				ind++;
			}
		}
		return est;
	}

	public Cliente obtenerClienteDadoDNI (Integer dni){
		Cliente cli = null;
		Boolean enc = false;
		if(this.idx > 0){
			for (int i = 0; i < this.idx && !enc; i++) {
				if(dni.equals(this.vecClientes[i].getDni())){
					enc = true;
					cli = this.vecClientes[i];
				}
			}
		}
		return cli;
	}
}
