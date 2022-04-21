package be.technifutur.musicManagement.controller;

import be.technifutur.musicManagement.business.service.specification.PlaylistService;
import be.technifutur.musicManagement.model.dto.PlaylistDTO;
import be.technifutur.musicManagement.model.dto.TrackSimpleDTO;
import be.technifutur.musicManagement.model.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    // GET - http://localhost:8080/playlist
    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public List<PlaylistDTO> getPlaylistsByUser(Authentication auth) {
        return this.playlistService.getPlaylistsByUser(((User) auth.getPrincipal()).getUsername());
    }

    // GET - http://localhost:8080/playlist/:id
    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public PlaylistDTO getPlaylistById(Authentication auth, @PathVariable Long id) {
        return this.playlistService.getPlaylistById(((User) auth.getPrincipal()).getUsername(), id);
    }

    // POST - http://localhost:8080/playlist/add?name
    @PostMapping("/add")
    @PreAuthorize("isAuthenticated()")
    public PlaylistDTO createPlaylist(Authentication auth, @RequestParam String name) {
        return this.playlistService.createPlaylist(((User) auth.getPrincipal()).getUsername(), name);
    }

    // DELETE - http://localhost:8080/playlist/:id
    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public PlaylistDTO deletePlaylistById(Authentication auth, @PathVariable Long id) {
        return this.playlistService.deletePlaylistById(((User) auth.getPrincipal()).getUsername(), id);
    }

    // PATCH - http://localhost:8080/playlist/:playlistId/removeTrack/:trackId
    @PatchMapping("/{playlistId}/removeTrack/{trackId}")
    @PreAuthorize("isAuthenticated()")
    public TrackSimpleDTO removeTrackFromPlaylist(Authentication auth, @PathVariable Long playlistId, @PathVariable Long trackId) {
        return this.playlistService.removeTrackFromPlaylist(((User) auth.getPrincipal()).getUsername(), playlistId, trackId);
    }

    // PATCH - http://localhost:8080/playlist/:playlistId/addTrack/:trackId
    @PatchMapping("/{playlistId}/addTrack/{trackId}")
    @PreAuthorize("isAuthenticated()")
    public TrackSimpleDTO addTrackToPlaylist(Authentication auth, @PathVariable Long playlistId, @PathVariable Long trackId) {
        return this.playlistService.addTrackToPlaylist(((User) auth.getPrincipal()).getUsername(), playlistId, trackId);
    }

}
