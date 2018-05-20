package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.logos.entity.Make;

@Repository
public interface MakeRepository extends JpaRepository<Make, Integer>{

	@Query("SELECT m FROM Make m WHERE LOWER (m.name) = :name")
	Make findMakeByName(@Param("name") String name);
}
