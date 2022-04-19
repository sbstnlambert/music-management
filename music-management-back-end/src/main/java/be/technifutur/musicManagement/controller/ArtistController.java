package be.technifutur.musicManagement.controller;

import be.technifutur.musicManagement.business.service.specification.ArtistService;
import be.technifutur.musicManagement.model.dto.ArtistDTO;
import be.technifutur.musicManagement.model.form.ArtistForm;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/artist")
public class ArtistController {

    private final ArtistService service;

    // GET - http://localhost:8080/artist/:id
    @GetMapping("/{id}")
    public ResponseEntity<ArtistDTO> getArtistById(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.getArtistById(id));
    }

    // GET - http://localhost:8080/artist/search?name
    @GetMapping("/search")
    public List<ArtistDTO> getArtistsByNameWithAutocomplete(@RequestParam(name = "name") String nameFragment) {
        return this.service.getArtistsByNameWithAutocomplete(nameFragment);
    }

    // GET - http://localhost:8080/artist
    @GetMapping
    public List<ArtistDTO> getAllArtists() {
        return this.service.getAllArtists();
    }

    // POST - http://localhost:8080/artist/add
    @PostMapping("/add")
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<ArtistDTO> insertArtist(@Valid @RequestBody ArtistForm form) {
        return ResponseEntity.ok(this.service.insertArtist(form));
    }

    // DELETE - http://localhost:8080/artist/:id
    @DeleteMapping("/{id}")
    @Secured({"ROLE_ADMIN"})
    public ArtistDTO deleteArtistById(@PathVariable Long id) {
        return this.service.deleteArtistById(id);
    }
}
