package com.restaurante.restaurante.controller;

import com.restaurante.restaurante.dto.ClienteRequest;
import com.restaurante.restaurante.dto.ClienteResponse;
import com.restaurante.restaurante.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/todos")
    public List<ClienteResponse> mostrarTodos(){
        return service.listarTodos();
    }

    @GetMapping("/telefone")
    public List<ClienteResponse> buscarPorTel(@RequestParam String telefone){
        return service.buscarPortelefone(telefone);
    }

    @GetMapping("/endereco")
    public List<ClienteResponse> buscarPorEndereco(@RequestParam String endereco){
        return service.buscarPorEndereco(endereco);
    }

    @PostMapping("/login")
    public ClienteResponse registrarCliente(@RequestBody ClienteRequest cliente) { //add login futuramente
        return service.criarCliente(cliente);
    }

    @PutMapping("/{id}")
    public ClienteResponse atualizarCliente(@PathVariable Long id, @RequestBody ClienteRequest clienteRequest){
        return service.atualizarCliente(id, clienteRequest);
    }


}
