package pe.com.boletseller.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="prueba")
public class prueba {
	@Id
	@Column(name="id_prueba")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="tipo")
	private String nombre;

}
