package br.com.cloudnative.hexagonal.application.ports.out;

public interface DeleteClientOutputPort {

    void delete(Long id);
}
