package be.technifutur.musicManagement.controller;

import be.technifutur.musicManagement.business.service.specification.AlbumService;
import be.technifutur.musicManagement.model.dto.AlbumDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/album")
public class AlbumController {

    private final AlbumService service;

    // GET - http://localhost:8080/album/:id
    @GetMapping("/{id}")
    public AlbumDTO getAlbumById(@PathVariable Long id) {
        return this.service.getAlbumById(id);
    }

    // GET - http://localhost:8080/album/search?name
    @GetMapping("/search")
    public List<AlbumDTO> getAlbumsByNameWithAutocomplete(@RequestParam(name = "name") String nameFragment) {
        return this.service.getAlbumsByNameWithAutocomplete(nameFragment);
    }

    // GET - http://localhost:8080/album/artist/:artistId
    @GetMapping("/artist/{artistId}")
    public List<AlbumDTO> getAlbumsByArtist(@PathVariable Long artistId) {
        return this.service.getAlbumsByArtist(artistId);
    }

}
