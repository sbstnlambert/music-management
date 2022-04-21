package be.technifutur.musicManagement.controller;

import be.technifutur.musicManagement.business.service.specification.TrackService;
import be.technifutur.musicManagement.model.dto.TrackDetailedDTO;
import be.technifutur.musicManagement.model.dto.TrackSimpleDTO;
import be.technifutur.musicManagement.model.entity.User;
import be.technifutur.musicManagement.model.form.TrackForm;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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

    // GET - http://localhost:8080/track/playlist/:playlistId
    @GetMapping("/playlist/{playlistId}")
    @PreAuthorize("isAuthenticated()")
    public List<TrackSimpleDTO> getTracksByPlaylist(Authentication auth, @PathVariable Long playlistId) {
        return this.service.getTracksByPlaylist(((User) auth.getPrincipal()).getUsername(), playlistId);
    }

    // POST - http://localhost:8080/track/add
    @PostMapping("/add")
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<TrackSimpleDTO> insertTrack(@Valid @RequestBody TrackForm form) {
        return ResponseEntity.ok(this.service.insertTrack(form));
    }

    // DELETE - http://localhost:8080/track/:id
    @DeleteMapping("/{id}")
    @Secured({"ROLE_ADMIN"})
    public TrackSimpleDTO deleteTrackById(@PathVariable Long id) {
        return this.service.deleteTrackById(id);
    }

}
