package com.example.exo5jdbc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LivreRepository extends CrudRepository<Livre, Long> {

    List<Livre> findByAuteur(String auteur);
}
