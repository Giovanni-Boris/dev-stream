package com.aliboo.security.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "PROFESOR")
public class Profesor {
  @Id
  @Column(name = "IdProfesor", nullable = false)
  private Long id;

  @Column(name = "Correo", length = Integer.MAX_VALUE)
  private String correo;

  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "IdUsuario", nullable = false)
  private Usuario idUsuario;

  @OneToMany(mappedBy = "idProfesor")
  private Set<Clase> clases = new LinkedHashSet<>();

}