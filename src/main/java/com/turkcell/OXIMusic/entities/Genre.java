package com.turkcell.OXIMusic.entities;

import java.util.List;

import com.turkcell.OXIMusic.commonPackage.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Genres")
public class Genre extends BaseEntity {
	
	@Column(name= "name")
	private String name;

	@OneToMany(mappedBy = "genre")
	private List<Song> songs;
	
	
}
