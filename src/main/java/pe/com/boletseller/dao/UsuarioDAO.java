package pe.com.boletseller.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.boletseller.entitys.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long> {
}
