package com.softserveinc.dokazovi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * The Direction Entity is responsible for correlating with
 * Directions table in the database.
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "direction_entity")
@Table(name = "directions")
public class DirectionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "direction_id")
	private Integer id;

	private String name;
	private String label;

	@Column(length = 7)
	private String color;

	@ColumnDefault("false")
	private Boolean hasDoctors;

	@ColumnDefault("false")
	private Boolean hasPosts;

	@ManyToMany(mappedBy = "directions")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<PostEntity> posts;

	@ManyToMany(mappedBy = "directions")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<DoctorEntity> users;
}
