package com.example.Fixture.Repository;

import com.example.Fixture.Model.Competencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompetenciaRepository extends JpaRepository<Competencia, Long> {
}
