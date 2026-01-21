package br.com.cloudnative.hexagonal.application.core.domain;

public class Client {

    public Client(Long id, String name, String cpf, String email){
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    private Long id;

    private String name;

    private String cpf;

    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
