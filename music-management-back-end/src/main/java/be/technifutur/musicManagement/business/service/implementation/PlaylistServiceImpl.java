package be.technifutur.musicManagement.business.service.implementation;

import be.technifutur.musicManagement.business.mapper.PlaylistMapper;
import be.technifutur.musicManagement.business.mapper.TrackMapper;
import be.technifutur.musicManagement.business.service.specification.PlaylistService;
import be.technifutur.musicManagement.exception.ElementNotFoundException;
import be.technifutur.musicManagement.model.dto.PlaylistDTO;
import be.technifutur.musicManagement.model.dto.TrackSimpleDTO;
import be.technifutur.musicManagement.model.entity.Playlist;
import be.technifutur.musicManagement.model.entity.Track;
import be.technifutur.musicManagement.repository.PlaylistRepository;
import be.technifutur.musicManagement.repository.TrackRepository;
import be.technifutur.musicManagement.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final TrackRepository trackRepository;
    private final UserRepository userRepository;
    private final PlaylistMapper playlistMapper;
    private final TrackMapper trackMapper;

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
        return this.playlistMapper.entityToDTO(playlist);
    }

    @Override
    public PlaylistDTO getPlaylistById(String username, Long id) {
        return this.playlistRepository.findById(id)
                .filter(p -> p.getUser().getUsername().equals(username))
                .map(playlistMapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(id, PlaylistDTO.class));
    }

    @Override
    public List<PlaylistDTO> getPlaylistsByUser(String username) {
        return this.playlistRepository.findPlaylistsByUser(username)
                .stream()
                .map(playlistMapper::entityToDTO)
                .toList();
    }

    @Override
    public TrackSimpleDTO removeTrackFromPlaylist(String username, Long playlistId, Long trackId) {
        Playlist toUpdate = this.playlistRepository.findById(playlistId)
                .filter(p -> p.getUser().getUsername().equals(username))
                .orElseThrow(() -> new ElementNotFoundException(playlistId, Playlist.class));

        Track toRemove = toUpdate.getTracks()
                .stream()
                .filter(t -> t.getId().longValue() == trackId)
                .findFirst()
                .orElseThrow(() -> new ElementNotFoundException(trackId, Track.class));

        toUpdate.getTracks().remove(toRemove);
        this.playlistRepository.save(toUpdate);

        return this.trackMapper.entityToSimpleDTO(toRemove);
    }

    @Override
    public TrackSimpleDTO addTrackToPlaylist(String username, Long playlistId, Long trackId) {
        Playlist toUpdate = this.playlistRepository.findById(playlistId)
                .filter(p -> p.getUser().getUsername().equals(username))
                .orElseThrow(() -> new ElementNotFoundException(playlistId, Playlist.class));

        Track toAdd = this.trackRepository.findById(trackId)
                .orElseThrow(() -> new ElementNotFoundException(trackId, Track.class));

        boolean alreadyPresent = toUpdate.getTracks()
                .stream()
                .anyMatch(t -> t.getId().longValue() == trackId);

        if (!alreadyPresent) {
            toUpdate.getTracks().add(toAdd);
            this.playlistRepository.save(toUpdate);
        }
        return this.trackMapper.entityToSimpleDTO(alreadyPresent ? null : toAdd);
    }

    @Override
    public PlaylistDTO deletePlaylistById(String username, Long id) {
        Playlist toDelete = this.playlistRepository
                .findById(id)
                .filter(p -> p.getUser().getUsername().equals(username))
                .orElseThrow(() -> new ElementNotFoundException(id, Playlist.class));
        this.playlistRepository.delete(toDelete);
        return this.playlistMapper.entityToDTO(toDelete);
    }
}
