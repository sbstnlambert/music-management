package be.technifutur.musicManagement.business.service.specification;

import be.technifutur.musicManagement.model.dto.PlaylistDTO;

import java.util.List;

public interface PlaylistService {

    // CREATE
    PlaylistDTO createrPlaylist(String name);

    // READ
    PlaylistDTO getPlaylistById(Long id);
    List<PlaylistDTO> getPlaylistsByUser(String username);

    // DELETE
    PlaylistDTO deletePlaylistById(Long id);

}
