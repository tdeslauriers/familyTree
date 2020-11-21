package world.deslauriers.tree.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "relationship")
public class Relationship implements Serializable {
	
	private static final long serialVersionUID = -4872717527622945987L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne(
			targetEntity = Family.class,
			fetch = FetchType.LAZY)
	@JsonBackReference(value = "family-human")
	private Family family;	
	
	@ManyToOne(
			targetEntity = Human.class, 
			fetch = FetchType.LAZY)
	@JsonBackReference(value = "human-relationship1")
	private Human human1;
	
	@ManyToOne(
			targetEntity = Role.class, 
			fetch = FetchType.LAZY)
	@JsonBackReference(value = "relationship-role1")
	private Role role1;
	
	@ManyToOne(
			targetEntity = Type.class,
			fetch = FetchType.LAZY)
	@JsonBackReference(value = "relationship-type")
	private Type type;
	
	@ManyToOne(
			targetEntity = Human.class, 
			fetch = FetchType.LAZY)
	@JsonBackReference(value = "human-relationship2")
	private Human human2;
	
	@ManyToOne(
			targetEntity = Role.class, 
			fetch = FetchType.LAZY)
	@JsonBackReference(value = "relationship-role2")
	private Role role2;
}
