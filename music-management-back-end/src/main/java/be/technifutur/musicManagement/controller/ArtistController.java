package be.technifutur.musicManagement.controller;

import be.technifutur.musicManagement.business.service.specification.ArtistService;
import be.technifutur.musicManagement.model.dto.ArtistDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
