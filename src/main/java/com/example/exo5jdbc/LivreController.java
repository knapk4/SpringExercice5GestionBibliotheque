package com.example.exo5jdbc;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livres")
public class LivreController {

    private final LivreService livreService;

    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }

    @GetMapping("/all")
    public List<Livre> getAllLivres() {
        return livreService.getAllLivres();
    }

    @GetMapping("/{id}")
    public Livre getLivreById(@PathVariable Long id) {
        return livreService.getLivreById(id);
    }

    @PostMapping("/add")
    public Livre createLivre(@RequestBody Livre livre) {
        return livreService.createLivre(livre);
    }

    @PatchMapping("/update")
    public Livre updateLivre(@RequestBody Livre livre) {
        return livreService.updateLivre(livre);
    }

    @DeleteMapping("delete/{id}")
    public void deleteLivre(@PathVariable Long id) {
        livreService.deleteLivre(id);
    }

    @GetMapping("/recherche/titre/{titre}")
    public List<Livre> searchLivresByTitre(@PathVariable String titre) {
        return livreService.searchLivresByTitre(titre);
    }

    @GetMapping("/recherche/auteur/{auteur}")
    public List<Livre> searchLivresByAuteur(@PathVariable String auteur) {
        return livreService.searchLivresByAuteur(auteur);
    }
}
