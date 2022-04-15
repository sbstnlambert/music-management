package be.technifutur.musicManagement.controller;

import be.technifutur.musicManagement.business.service.specification.ArtistService;
import be.technifutur.musicManagement.model.dto.ArtistDTO;
import be.technifutur.musicManagement.model.form.ArtistForm;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/artist")
public class ArtistController {

    private final ArtistService service;

    // GET - http://localhost:8080/artist
    @GetMapping
    public List<ArtistDTO> getAllArtists() {
        return service.getAllArtists();
    }

    // GET - http://localhost:8080/artist/id
    @GetMapping("/{id}")
    public ResponseEntity<ArtistDTO> getArtistById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getArtistById(id));
    }

    // POST - http://localhost:8080/artist/add
    @PostMapping("/add")
    public ResponseEntity<ArtistDTO> insertArtist(@RequestBody ArtistForm form) {
        return ResponseEntity.ok(service.insertArtist(form));
    }
}
