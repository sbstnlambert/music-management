package be.technifutur.musicManagement.repository;

import be.technifutur.musicManagement.model.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
