package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Cliente
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "O nome é obrigatório!")
    private String nomeCompleto;
    @NotNull(message ="A profissão é obrigatória")
    private String profissao;

    @OneToMany(cascade = CascadeType.ALL)
    // Vai ter dois bancos de dados (Duas tabelas(Cliente e Produtos e vai ser um relacionamento, dizendo que o cliente vai ter uma lista de produtos)
    private List<Endereco> enderecos;
    public Cliente(String nome, String endereco, List<Endereco> enderecos) {
        this.nomeCompleto = nome;
        this.enderecos = enderecos;
    }

    public Cliente(String profissao) {
        this.profissao = profissao;
    }

    public Cliente(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }


    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}

