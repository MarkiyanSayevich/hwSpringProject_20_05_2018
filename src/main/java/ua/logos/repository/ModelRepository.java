package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.logos.entity.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {

}
