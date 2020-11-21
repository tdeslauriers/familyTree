package world.deslauriers.tree.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
public class Role implements Serializable {

	private static final long serialVersionUID = -1898983944210853056L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private RoleName role;
	
	@OneToMany(
			mappedBy = "role1",
			fetch = FetchType.LAZY)
	@JsonManagedReference(value = "relationship-role1")
	private Set<Relationship> relationship1;
	
	@OneToMany(
			mappedBy = "role2",
			fetch = FetchType.LAZY)
	@JsonManagedReference(value = "relationship-role2")
	private Set<Relationship> relationship2;
}
