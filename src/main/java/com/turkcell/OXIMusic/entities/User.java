package com.turkcell.OXIMusic.entities;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

import com.turkcell.OXIMusic.commonPackage.BaseEntity;
import com.turkcell.OXIMusic.entities.enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "Users")
public class User extends BaseEntity implements UserDetails{
	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surName;

	@Column(name = "birthDate")
	private LocalDateTime birthDate;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;

	@Column(name = "gender")
	private Gender gender;

	 @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(
	            name="user_roles",
	            joinColumns = @JoinColumn(name="user_id"),
	            inverseJoinColumns = @JoinColumn(name="role_id")
	    )
	    private Set<Role> authorities;


	    @Override
	    public String getUsername() {
	        return this.email;
	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return true;
	    }
}
