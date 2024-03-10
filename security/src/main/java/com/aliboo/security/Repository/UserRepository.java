package com.aliboo.security.Repository;

import com.aliboo.security.Repository.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario, Integer> {
  Optional<Usuario> findByNombreUsuario(String name);
}
