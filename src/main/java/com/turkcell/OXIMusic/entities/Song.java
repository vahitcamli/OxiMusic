package com.turkcell.OXIMusic.entities;

import com.turkcell.OXIMusic.commonPackage.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Songs")
public class Song extends BaseEntity{
	
	@Column(name= "name")
	private String name;
	
	@Column(name= "description")
	private String description;
	
	@Column(name="stream")
	private int stream;
	
	@ManyToOne
	private Album album;
	
	@ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
	
	@ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
}
