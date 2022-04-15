package be.technifutur.musicManagement.business.mapper;

import be.technifutur.musicManagement.model.dto.ArtistDTO;
import be.technifutur.musicManagement.model.entity.Artist;
import be.technifutur.musicManagement.model.form.ArtistForm;
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

    public Artist formToEntity(ArtistForm form) {
        if (form == null)
            return null;

        return Artist.builder()
                .name(form.getName())
                .imageUrl(form.getImageUrl())
                .build();
    }
}
