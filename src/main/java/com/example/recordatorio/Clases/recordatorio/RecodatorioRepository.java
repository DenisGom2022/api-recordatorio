package com.example.recordatorio.Clases.recordatorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RecodatorioRepository extends JpaRepository<RecordatorioEntity, Integer> {
    @Query(
        value = "SELECT * FROM recordatorio c WHERE c.id = ?1", 
        nativeQuery = true
    ) 
    RecordatorioEntity search(int id);
}
