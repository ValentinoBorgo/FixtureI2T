package com.example.Fixture.Repository;

import com.example.Fixture.Model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPartidoRepository extends JpaRepository<Partido,Long> {
}
