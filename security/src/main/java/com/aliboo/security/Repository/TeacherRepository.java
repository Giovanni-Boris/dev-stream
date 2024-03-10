package com.aliboo.security.Repository;

import com.aliboo.security.Repository.Model.Profesor;
import com.aliboo.security.Repository.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Profesor, Long> {
  Optional<Profesor> findByIdUsuario(Usuario usuario);
}
