package com.turkcell.OXIMusic.business.concretes;

import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.turkcell.OXIMusic.business.abstracts.UserAuthService;
import com.turkcell.OXIMusic.dataAccess.RoleRepository;
import com.turkcell.OXIMusic.dataAccess.UserRepository;
import com.turkcell.OXIMusic.entities.Role;
import com.turkcell.OXIMusic.entities.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserAuthManager implements UserDetailsService, UserAuthService{
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email ile kullanıcı bulunamadı: " + email));

        return user;
    
	}

	@Override
	public UserDetails getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    if (authentication != null) {
	        Object principal = authentication.getPrincipal();
	        if (principal instanceof UserDetails) {
	            return (UserDetails) principal;
	        } else if (principal instanceof String) {
	            
	            return loadUserByUsername((String) principal);
	        }
	    }
	    throw new UsernameNotFoundException("User not found");
	}

}
