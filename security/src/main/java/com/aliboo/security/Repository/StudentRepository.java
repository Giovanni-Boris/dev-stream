package com.aliboo.security.Repository;

import com.aliboo.security.Repository.Model.Alumno;
import com.aliboo.security.Repository.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Alumno, Long> {
  Optional<Alumno> findByIdUsuario(Usuario usuario);
}
