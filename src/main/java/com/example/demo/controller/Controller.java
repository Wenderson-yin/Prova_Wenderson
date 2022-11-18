package com.example.demo.controller;

import com.example.demo.entity.Cliente;
import com.example.demo.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cliente/v1")
public class Controller
{
    @Autowired
    Repository resposity;
    @PostMapping
    public Cliente create(@RequestBody @Valid Cliente cliente) {
            Cliente clienteSaved = resposity.save(cliente);
            return clienteSaved;
    }
    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Cliente> cliente(@PathVariable Long id)
    {
        Optional<Cliente> clienteReturned = resposity.findById(id);
        return clienteReturned;
    }
    @DeleteMapping("/{id}") //Deleta tal cliente atraves do id
    public String deleteClienteById(@PathVariable Long id)
    {
        try
        {

         Optional<Cliente> cliente = Optional.of(resposity.getById(id));
            if (cliente.isPresent())
            {
                resposity.deleteById(id);
                return "Cliente de " + id + "deletado com sucesso! ";
            }else
            {
                throw new Exception("Cliente inexistente");   //throw significa jogar
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            return "O cliente de " + id + " não existe para ser deletado! ";
        }

    }
    @GetMapping //Puxa todos os cliente
    public List<Cliente> clienteList()
    {
        return resposity.findAll();
    }
}
