package be.technifutur.musicManagement.repository;

import be.technifutur.musicManagement.model.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
