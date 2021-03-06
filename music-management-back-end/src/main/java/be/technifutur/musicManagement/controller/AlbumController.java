package be.technifutur.musicManagement.controller;

import be.technifutur.musicManagement.business.service.specification.AlbumService;
import be.technifutur.musicManagement.model.dto.AlbumDTO;
import be.technifutur.musicManagement.model.form.AlbumForm;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    // POST - http://localhost:8080/album/add
    @PostMapping("/add")
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<AlbumDTO> insertAlbum(@Valid @RequestBody AlbumForm form) {
        return ResponseEntity.ok(this.service.insertAlbum(form));
    }

    // DELETE - http://localhost:8080/album/:id
    @DeleteMapping("/{id}")
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<AlbumDTO> deleteAlbumById(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.deleteAlbumById(id));
    }
}
