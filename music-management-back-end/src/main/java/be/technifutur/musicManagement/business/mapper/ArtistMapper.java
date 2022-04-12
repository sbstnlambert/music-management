package be.technifutur.musicManagement.business.mapper;

import be.technifutur.musicManagement.model.dto.ArtistDTO;
import be.technifutur.musicManagement.model.entity.Artist;
import org.springframework.stereotype.Service;

@Service
public class ArtistMapper {
    public ArtistDTO entityToDTO(Artist entity) {
            if (entity == null)
                return null;

            return ArtistDTO.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .imageUrl(entity.getImageUrl())
                    .build();
    }
}
