package be.technifutur.musicManagement.controller;

import be.technifutur.musicManagement.business.service.specification.ArtistService;
import be.technifutur.musicManagement.model.dto.ArtistDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "artist")
public class ArtistController {

    private final ArtistService service;

    public ArtistController(ArtistService service) {
        this.service = service;
    }

    // GET - http://localhost:8080/artist
    @GetMapping
    public List<ArtistDTO> getAllArtists() {
        return service.getAllArtists();
    }
}
