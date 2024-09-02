
package com.orden.compras.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.orden.compras.modelo.Cliente;
import com.orden.compras.servicio.ClienteServicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/apiCliente")
public class ClienteControlador {
	
	private   final Logger LOG = Logger.getLogger(ClienteControlador.class.getName());
    @Autowired
    ClienteServicio clientServicio;

    @GetMapping("/clienteList")
    public ResponseEntity<List<Cliente>> listar() {
        try {
            List<Cliente> clientes = new ArrayList<Cliente>();
            clientServicio.listar().forEach(clientes::add);
            if (clientes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id) {
        Optional<Cliente> cli = clientServicio.porId(id);
        if (cli.isPresent()) {
            return ResponseEntity.ok(cli.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/crearCliente")
    public ResponseEntity<Cliente> crearClient(@RequestBody Cliente cli) {
        try {
            Cliente client = clientServicio
                    .guardar(new Cliente(cli.getIdCliente(), cli.getNombreCliente(),cli.getDescripcionCliente()));
            return new ResponseEntity<>(client, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/actualizarCliente/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable("id") long id, @RequestBody Cliente cli) {
        Optional<Cliente> clienteData = clientServicio.porId(id);

        if (clienteData.isPresent()) {
            Cliente client = clienteData.get();
            client.setNombreCliente(cli.getNombreCliente());
            client.setDescripcionCliente(cli.getDescripcionCliente());
            return new ResponseEntity<>(clientServicio.guardar(client), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @DeleteMapping("/borrarCliente/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable Long id) {
        Optional<Cliente> client = clientServicio.porId(id);
        if (client.isPresent()) {
            clientServicio.eliminar(client.get().getIdCliente());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
