package be.technifutur.musicManagement.controller;

import be.technifutur.musicManagement.business.service.specification.TrackService;
import be.technifutur.musicManagement.model.dto.TrackDetailedDTO;
import be.technifutur.musicManagement.model.dto.TrackSimpleDTO;
import be.technifutur.musicManagement.model.form.TrackForm;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/track")
public class TrackController {

    private final TrackService service;

    // GET - http://localhost:8080/track/:id
    @GetMapping("/{id}")
    public TrackDetailedDTO getTrackById(@PathVariable Long id) {
        return this.service.getTrackById(id);
    }

    // GET - http://localhost:8080/track/search?name
    @GetMapping("/search")
    public List<TrackSimpleDTO> getTracksByNameWithAutocomplete(@RequestParam(name = "name") String nameFragment) {
        return this.service.getTracksByNameWithAutocomplete(nameFragment);
    }

    // GET - http://localhost:8080/track/album/:albumId
    @GetMapping("/album/{albumId}")
    public List<TrackSimpleDTO> getTracksByAlbum(@PathVariable Long albumId) {
        return this.service.getTracksByAlbum(albumId);
    }

    // GET - http://localhost:8080/track/artist/:artistId
    @GetMapping("/artist/{artistId}")
    public List<TrackSimpleDTO> getTracksByArtist(@PathVariable Long artistId) {
        return this.service.getTracksByArtist(artistId);
    }

    // POST - http://localhost:8080/track/add
    @PostMapping("/add")
    public ResponseEntity<TrackSimpleDTO> insertTrack(@Valid @RequestBody TrackForm form) {
        return ResponseEntity.ok(service.insertTrack(form));
    }

    // DELETE - http://localhost:8080/track/:id
    @DeleteMapping("/{id}")
    public TrackSimpleDTO deleteTrackById(@PathVariable Long id) {
        return this.service.deleteTrackById(id);
    }

}
