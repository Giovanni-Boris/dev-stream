package com.aliboo.security.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ALUMNO")
public class Alumno {
  @Id
  @Column(name = "IdEstudiante", nullable = false)
  private Long id;

  @Column(name = "Direccion", length = Integer.MAX_VALUE)
  private String direccion;

  @Column(name = "Fecha de Nacimiento")
  private LocalDate fechaDeNacimiento;

  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "IdUsuario", nullable = false)
  private Usuario idUsuario;

  @OneToMany(mappedBy = "idEstudiante")
  private Set<DetalleClase> detalleClases = new LinkedHashSet<>();

}