package be.technifutur.musicManagement.business.service.implementation;

import be.technifutur.musicManagement.business.service.specification.PlaylistService;
import be.technifutur.musicManagement.model.dto.PlaylistDTO;
import org.springframework.security.core.Authentication;

import java.util.List;

public class PlaylistServiceImpl implements PlaylistService {
    @Override
    public PlaylistDTO createrPlaylist(String name) {
        return null;
    }

    @Override
    public PlaylistDTO getPlaylistById(Long id) {
        return null;
    }

    @Override
    public List<PlaylistDTO> getPlaylistsByUser(String username) {
        return null;
    }

    @Override
    public PlaylistDTO deletePlaylistById(Long id) {
        return null;
    }
}
