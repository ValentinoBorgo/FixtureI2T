package com.example.Fixture.Repository;

import com.example.Fixture.Model.Clasificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClasificacionRepository extends JpaRepository<Clasificacion, Long> {
}
