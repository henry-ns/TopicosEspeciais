package br.edu.ifpb.cadastrardados;

import android.util.JsonReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henrique on 05/10/2016.
 */
public class Pessoa {
    private String nome;
    private String email;
    private String endereco;
    private String cpf;

    public Pessoa(){}

    public Pessoa(String nome, String email, String endereco, String cpf){
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.cpf = cpf;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Nome : " + this.nome + "\nEmail: " + this.email + "\nEndereço: " + this.endereco + "\nCPF: "+
                this.cpf;
    }
}
