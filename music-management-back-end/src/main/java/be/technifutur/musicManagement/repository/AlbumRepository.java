package be.technifutur.musicManagement.repository;

import be.technifutur.musicManagement.model.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
