package world.deslauriers.tree.domain;

import java.io.Serializable;
import java.time.LocalDate;
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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "human")
public class Human implements Serializable {

	private static final long serialVersionUID = -5604470315805218995L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotBlank
	@Size(min = 2, max = 30)
	@Column(name = "firstname")
	private String firstname;
	
	@Size(min = 2, max = 30)
	@Column(name = "middlename")
	private String middlename;
	
	@NotBlank
	@Size(min = 2, max = 30)
	@Column(name = "lastname")
	private String lastname;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Sex sex;
	
	@NotNull
	@Column(name = "is_alive")
	private Boolean is_alive;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "born_in")
	private State bornIn;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "lives_in")
	private State livesIn;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "died_in")
	private State DiedIn;
	
	@NotNull
	@Column(name = "born")
	private LocalDate born;
	
	@Column(name = "died")
	private LocalDate died;
	
	@ManyToMany(
			mappedBy = "humans", 
			fetch = FetchType.LAZY, 
			cascade = CascadeType.PERSIST)
	@JsonManagedReference(value = "human-address")
	private Set<Address> addresses;
	
	@Email
	@Column(name = "email")
	private String email;
	
	@Size(min = 7, max = 10)
	@Column(name = "phone")
	private String phone;
	
	@OneToMany(
			mappedBy = "human",
			fetch = FetchType.LAZY)
	@JsonManagedReference(value = "human-family")
	private Set<Family> family;
	
	@OneToMany(
			mappedBy = "human1",
			fetch = FetchType.LAZY)
	@JsonManagedReference(value = "human-relationship1")
	private Set<Relationship> relationship1;
	
	@OneToMany(
			mappedBy = "human2",
			fetch = FetchType.LAZY)
	@JsonManagedReference(value = "human-relationship2")
	private Set<Relationship> relationship2;
}
