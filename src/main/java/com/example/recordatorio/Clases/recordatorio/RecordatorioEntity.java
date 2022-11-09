package com.example.recordatorio.Clases.recordatorio;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Entity(name = "Recordatorio")
@Getter
@Setter
public class RecordatorioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreActividad;
    private String descripcion;
    private LocalDate fecha;
    private String responsable;
}
