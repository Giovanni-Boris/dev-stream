package com.aliboo.security.Repository;

import com.aliboo.security.Repository.Model.Rol;
import com.aliboo.security.Repository.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Long> {
  Optional<Rol> findByNombre(String name);
}