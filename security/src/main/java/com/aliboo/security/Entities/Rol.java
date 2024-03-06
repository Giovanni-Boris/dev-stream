package com.aliboo.security.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ROL")
public class Rol {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IdRol", nullable = false)
  private Long id;

  @Column(name = "Nombre", length = Integer.MAX_VALUE)
  private String nombre;

  @Column(name = "Descripcion", length = Integer.MAX_VALUE)
  private String descripcion;

  @ManyToMany(mappedBy = "roles")
  private Set<Usuario> usuarios = new HashSet();
}
