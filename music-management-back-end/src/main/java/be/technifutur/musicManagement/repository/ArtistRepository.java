package be.technifutur.musicManagement.repository;

import be.technifutur.musicManagement.model.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    @Query("SELECT a FROM Artist a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%',?1,'%'))")
    List<Artist> findArtistsByNameWithAutocomplete(String name);

}
