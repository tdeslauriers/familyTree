package world.deslauriers.tree.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "family")
public class Family implements Serializable {

	private static final long serialVersionUID = 1623901663234604456L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotBlank
	@Size(min = 2, max = 30)
	@Column(name = "name")
	private String familyName;
	
	@NotBlank
	@Size(min = 2, max = 1000)
	@Column(name = "description")
	private String description;
	
	@ManyToOne(
			targetEntity = Human.class, 
			fetch = FetchType.LAZY)
	@JsonBackReference(value = "human-family")
	private Human human;
	
	@OneToMany(
			mappedBy = "family",
			fetch = FetchType.LAZY)
	@JsonManagedReference(value = "family-relationship")
	private Set<Relationship> relationship;
}
