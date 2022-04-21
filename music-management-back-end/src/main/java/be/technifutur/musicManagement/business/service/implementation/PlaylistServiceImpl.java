package be.technifutur.musicManagement.business.service.implementation;

import be.technifutur.musicManagement.business.mapper.PlaylistMapper;
import be.technifutur.musicManagement.business.service.specification.PlaylistService;
import be.technifutur.musicManagement.exception.ElementNotFoundException;
import be.technifutur.musicManagement.model.dto.PlaylistDTO;
import be.technifutur.musicManagement.model.entity.Playlist;
import be.technifutur.musicManagement.repository.PlaylistRepository;
import be.technifutur.musicManagement.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final UserRepository userRepository;
    private final PlaylistMapper mapper;

    @Override
    public PlaylistDTO createPlaylist(String username, String name) {
        Playlist playlist = Playlist.builder()
                .name(name)
                .user(
                    this.userRepository.findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException(
                                String.format("Username '%s' has not been found", username))
                        )
                )
                .build();
        playlist = this.playlistRepository.save(playlist);
        return this.mapper.entityToDTO(playlist);
    }

    @Override
    public PlaylistDTO getPlaylistById(String username, Long id) {
        return this.playlistRepository.findById(id)
                .filter(p -> p.getUser().getUsername().equals(username))
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(id, PlaylistDTO.class));
    }

    @Override
    public List<PlaylistDTO> getPlaylistsByUser(String username) {
        return this.playlistRepository.findPlaylistsByUser(username)
                .stream()
                .map(mapper::entityToDTO)
                .toList();
    }

    @Override
    public PlaylistDTO deletePlaylistById(String username, Long id) {
        Playlist toDelete = this.playlistRepository
                .findById(id)
                .filter(p -> p.getUser().getUsername().equals(username))
                .orElseThrow(() -> new ElementNotFoundException(id, Playlist.class));
        this.playlistRepository.delete(toDelete);
        return this.mapper.entityToDTO(toDelete);
    }
}
