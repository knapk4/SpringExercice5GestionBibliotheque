package com.example.exo5jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreService {

    private final JdbcTemplate jdbcTemplate;

    private final LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository, JdbcTemplate jdbcTemplate) {
        this.livreRepository = livreRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Livre> getAllLivres() {
        return (List<Livre>) livreRepository.findAll();
    }

    public Livre getLivreById(Long id) {
        return livreRepository.findById(id).orElse(null);
    }

    public Livre createLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    public Livre updateLivre( Livre livre) {
        if(livre.getId() == null) {
            livreRepository.save(livre);
        }else {
            jdbcTemplate.update("UPDATE livre SET name = ?, auteur = ? WHERE id = ?",
                    livre.getTitre(), livre.getAuteur(), livre.getId());
        }
        return livre;
    }

    public void deleteLivre(Long id) {
        livreRepository.deleteById(id);
    }

    public List<Livre> searchLivresByTitre(String titre) {
        return jdbcTemplate.query("SELECT * FROM livres WHERE titre = ?", new BeanPropertyRowMapper(Livre.class), titre);
    }


    public List<Livre> searchLivresByAuteur(String auteur) {
        return livreRepository.findByAuteur(auteur);
    }
}
