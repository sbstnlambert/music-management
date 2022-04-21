package be.technifutur.musicManagement.controller;

import be.technifutur.musicManagement.business.service.specification.PlaylistService;
import be.technifutur.musicManagement.model.dto.PlaylistDTO;
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

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public List<PlaylistDTO> getPlaylistsByUser(Authentication auth) {
        return this.playlistService.getPlaylistsByUser(((User) auth.getPrincipal()).getUsername());
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public PlaylistDTO getPlaylistById(Authentication auth, @PathVariable Long id) {
        return this.playlistService.getPlaylistById(((User) auth.getPrincipal()).getUsername(), id);
    }

    @PostMapping("/add")
    @PreAuthorize("isAuthenticated()")
    public PlaylistDTO createPlaylist(Authentication auth, @RequestParam String name) {
        return this.playlistService.createPlaylist(((User) auth.getPrincipal()).getUsername(), name);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public PlaylistDTO deletePlaylistById(Authentication auth, @PathVariable Long id) {
        return this.playlistService.deletePlaylistById(((User) auth.getPrincipal()).getUsername(), id);
    }

}
