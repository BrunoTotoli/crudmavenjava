package com.bruno.model;

public class Usuario {
    private String nome;
    private String email;
    private Long id;

    public Usuario() {
    }

    public Usuario(String nome, String email, Long id) {
        this.nome = nome;
        this.email = email;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
