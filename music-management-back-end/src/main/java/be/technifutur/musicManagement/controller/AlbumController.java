package be.technifutur.musicManagement.controller;

import be.technifutur.musicManagement.business.service.specification.AlbumService;
import be.technifutur.musicManagement.model.dto.AlbumDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    // GET - http://localhost:8080/album/artist/:artistId
    @GetMapping("/artist/{artistId}")
    public List<AlbumDTO> getAlbumsByArtist(@PathVariable Long artistId) {
        return this.service.getAlbumsByArtist(artistId);
    }

}
