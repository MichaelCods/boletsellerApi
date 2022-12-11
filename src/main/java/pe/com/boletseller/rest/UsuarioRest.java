package pe.com.boletseller.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.boletseller.dao.UsuarioDAO;
import pe.com.boletseller.entitys.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioRest {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> gerEntity(){
		List<Usuario> usuario= usuarioDAO.findAll();
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
		Usuario newUsuario = usuarioDAO.save(usuario);
		return ResponseEntity.ok(newUsuario);
		
	}
	
	@PutMapping
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario){
		Optional<Usuario> optionalUsuario = usuarioDAO.findById(usuario.getId());
		if(optionalUsuario.isPresent()) {
			Usuario updateUsuario = optionalUsuario.get();
			updateUsuario.setNombre(usuario.getNombre());
			updateUsuario.setApellido(usuario.getApellido());
			updateUsuario.setEmail(usuario.getEmail());
			updateUsuario.setContraseña(usuario.getContraseña());
			usuarioDAO.save(updateUsuario);
			return ResponseEntity.ok(updateUsuario);
		}else {
			return ResponseEntity.notFound().build();
			
		}
		
		
	}


}
