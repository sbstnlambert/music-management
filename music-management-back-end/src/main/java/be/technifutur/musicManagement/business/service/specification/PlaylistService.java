package be.technifutur.musicManagement.business.service.specification;

import be.technifutur.musicManagement.model.dto.PlaylistDTO;

import java.util.List;

public interface PlaylistService {

    // CREATE
    PlaylistDTO createPlaylist(String username, String name);

    // READ
    PlaylistDTO getPlaylistById(String username, Long id);
    List<PlaylistDTO> getPlaylistsByUser(String username);

    // DELETE
    PlaylistDTO deletePlaylistById(String username, Long id);

}
