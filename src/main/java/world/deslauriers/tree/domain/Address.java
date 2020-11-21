package world.deslauriers.tree.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address implements Serializable {

	private static final long serialVersionUID = 69845271998177939L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Size(min = 2, max = 50)
	@Column(name = "address")
	private String address;
	
	@Size(min = 2, max = 50)
	@Column(name = "city")
	private String city;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "state")
	private State state;
	
	@Column(name = "zip")
	private Integer zip;
	
	@Column(name = "country")
	private String country;
	
	@ManyToMany(
			fetch = FetchType.LAZY, 
			cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "human_address",
			joinColumns = {@JoinColumn(referencedColumnName = "address_id")},
			inverseJoinColumns = {@JoinColumn(referencedColumnName = "human_id")})
	@JsonBackReference(value = "human-address")
	private Set<Human> humans = new HashSet<>();
}
