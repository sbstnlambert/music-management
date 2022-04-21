package be.technifutur.musicManagement.business.mapper;

import be.technifutur.musicManagement.model.dto.PlaylistDTO;
import be.technifutur.musicManagement.model.entity.Playlist;
import org.springframework.stereotype.Service;

@Service
public class PlaylistMapper {

    public PlaylistDTO entityToDTO(Playlist entity) {
        if (entity == null)
            return null;

        return PlaylistDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
