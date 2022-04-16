package be.technifutur.musicManagement.business.mapper;

import be.technifutur.musicManagement.model.dto.AlbumDTO;
import be.technifutur.musicManagement.model.entity.Album;
import be.technifutur.musicManagement.model.entity.Artist;
import be.technifutur.musicManagement.model.form.AlbumForm;
import org.springframework.stereotype.Service;

@Service
public class AlbumMapper {

    public AlbumDTO entityToDTO(Album entity) {
        if (entity == null)
            return null;

        return AlbumDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .releaseDate(entity.getReleaseDate())
                .recordLabel(entity.getRecordLabel())
                .imageUrl(entity.getImageUrl())
                .build();
    }

    public Album formToEntity(AlbumForm form) {
        if (form == null)
            return null;

        // Je reçois un artistId: Long
        // Je veux renvoyer un artist: Artist
        // Il me faut : Artist artist = getArtistById(artistId)



        return Album.builder()
                .name(form.getName())
                .releaseDate(form.getReleaseDate())
                .recordLabel(form.getRecordLabel())
                .imageUrl(form.getImageUrl())
                .artist(
                        Artist.builder()
                                .id(form.getArtistId())
                                .build())
                .build();
    }

}
