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
    public PlaylistDTO getPlaylistById(@PathVariable Long id) {
        return this.playlistService.getPlaylistById(id);
    }

    @PostMapping("/add")
    public PlaylistDTO createPlaylist(@RequestParam String name) {
        return this.playlistService.createrPlaylist(name);
    }

    @DeleteMapping("/{id}")
    public PlaylistDTO deletePlaylistById(@PathVariable Long id) {
        return this.playlistService.deletePlaylistById(id);
    }

}
