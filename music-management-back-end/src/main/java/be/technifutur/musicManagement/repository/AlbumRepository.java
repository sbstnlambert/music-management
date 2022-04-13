package be.technifutur.musicManagement.repository;

import be.technifutur.musicManagement.model.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    @Query("SELECT a FROM Album a WHERE a.artist.id = ?1")
    List<Album> findAlbumsByArtist(Long artistId);

}
