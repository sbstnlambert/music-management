package be.technifutur.musicManagement.controller;

import be.technifutur.musicManagement.business.service.specification.TrackService;
import be.technifutur.musicManagement.model.dto.TrackSimpleDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/track")
public class TrackController {
    private final TrackService service;

    public TrackController(TrackService service) {
        this.service = service;
    }

    // GET - http://localhost:8080/track/album/:albumId
    @GetMapping("/album/{albumId}")
    public List<TrackSimpleDTO> getTracksByAlbum(@PathVariable Long albumId) {
        return this.service.getTracksByAlbum(albumId);
    }
}
