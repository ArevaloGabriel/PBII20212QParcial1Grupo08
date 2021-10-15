package ar.edu.unlam.pb2.parcial.test;

import ar.edu.unlam.pb2.parcial.models.Cliente;
import ar.edu.unlam.pb2.parcial.models.Clientes;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class ClientesTest {

    private Clientes lista;

    @Before
    public void seInicializaElVectorDeClientes (){
        this.lista = new Clientes();
    }

    @Test
    public void queSeIntentaIngresarUnNuevoClienteYNoHaSidoIngresadoAnteriormente(){
        Cliente nuevo = new Cliente("Cristian", "Feldmand", 33557055, "Pepe 123");
        Boolean valorEsperado = true;
        Boolean valorObtenido = this.lista.agregarCliente(nuevo);
        Assert.assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void queSeIntentaIngresarUnNuevoClientePeroYaHabiaSidoIngresadoAntesPorEsoDaError(){
        Boolean valorEsperado = false;
        this.lista.agregarCliente(new Cliente("Cristian","Feldman",33557055,"Pepe 123"));
        Boolean valorObtenido = this.lista.agregarCliente(new Cliente("Cristian","Feldman",33557055,"pepe 123"));
        Assert.assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void queSeIntentaIngresarUnNuevoCLientePeroConDNIYaIngresadoAntes(){
        Boolean valorEsperado = false;
        this.lista.agregarCliente(new Cliente("Cristian","Feldman",33557055,"Pepe 123"));
        Boolean valorObtenido = this.lista.agregarCliente(new Cliente("Carlos","Gomez",33557055,"pepe 123"));
        Assert.assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void queSeIntentaModificarLosDatosPersonalesDelClienteYQueEseClienteNoExiste(){
        Boolean valorEsperado = false;
        Boolean valorObtenido = this.lista.modificarDatosDelCliente(new Cliente("Pedro","Gomez",33557054,"pepe 123"));
        Assert.assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void queSeIntentaModificarLosDatosPersonalesDelClienteYQueEseClienteSiExiste(){
        Boolean valorEsperado = true;
        this.lista.agregarCliente(new Cliente("Cristian","Feldman",33557055,"Pepe 123"));
        Boolean valorObtenido = this.lista.modificarDatosDelCliente(new Cliente("Pedro","Gomez",33557055,"pepe 123"));
        Assert.assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void queSeIntenteIngresarUnNuevoClientePeroLaBaseEsteLLena(){
        Boolean valorEsperado = false;
        this.lista.agregarCliente(new Cliente("Cristian","Feldman",33557055,"Pepe 123"));
        this.lista.agregarCliente(new Cliente("Cristian","Feldman",33557054,"Pepe 123"));
        this.lista.agregarCliente(new Cliente("Cristian","Feldman",33557053,"Pepe 123"));
        this.lista.agregarCliente(new Cliente("Cristian","Feldman",33557052,"Pepe 123"));
        Boolean valorObtenido = this.lista.agregarCliente(new Cliente("Pedro","Gomez",33557051,"pepe 123"));
        Assert.assertEquals(valorEsperado,valorObtenido);
    }
}

