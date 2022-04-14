package be.technifutur.musicManagement.controller;

import be.technifutur.musicManagement.business.service.specification.TrackService;
import be.technifutur.musicManagement.model.dto.TrackDetailedDTO;
import be.technifutur.musicManagement.model.dto.TrackSimpleDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
