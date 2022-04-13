package be.technifutur.musicManagement.business.mapper;

import be.technifutur.musicManagement.model.dto.TrackSimpleDTO;
import be.technifutur.musicManagement.model.entity.Track;
import org.springframework.stereotype.Service;

@Service
public class TrackMapper {
    public TrackSimpleDTO entityToSimpleDTO(Track entity) {
        if (entity == null)
            return null;

        return TrackSimpleDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .numberOfLikes(entity.getNumberOfLikes())
                .build();
    }
}
