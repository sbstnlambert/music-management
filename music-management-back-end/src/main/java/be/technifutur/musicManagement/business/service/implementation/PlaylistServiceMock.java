package be.technifutur.musicManagement.business.service.implementation;

import be.technifutur.musicManagement.business.service.specification.PlaylistService;
import be.technifutur.musicManagement.model.dto.PlaylistDTO;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PlaylistServiceMock implements PlaylistService {
    @Override
    public PlaylistDTO createrPlaylist(String name) {
        return PlaylistDTO.builder()
                .id(1L)
                .name("Test playlist")
                .build();
    }

    @Override
    public PlaylistDTO getPlaylistById(Long id) {
        return PlaylistDTO.builder()
                .id(1L)
                .name("Test playlist")
                .build();
    }

    @Override
    public List<PlaylistDTO> getPlaylistsByUser(String username) {
        return Arrays.asList(
                PlaylistDTO.builder()
                        .id(1L)
                        .name("Test playlist 1")
                        .build(),
                PlaylistDTO.builder()
                        .id(2L)
                        .name("Test playlist 2")
                        .build(),
                PlaylistDTO.builder()
                        .id(3L)
                        .name("Test playlist 3")
                        .build()
        );
    }

    @Override
    public PlaylistDTO deletePlaylistById(Long id) {
        return PlaylistDTO.builder()
                .id(1L)
                .name("Test playlist 1")
                .build();
    }
}
