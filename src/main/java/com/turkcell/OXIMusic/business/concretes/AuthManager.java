package com.turkcell.OXIMusic.business.concretes;

import java.time.LocalDateTime;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.turkcell.OXIMusic.business.abstracts.AuthService;
import com.turkcell.OXIMusic.business.rules.AuthBusinessRules;
import com.turkcell.OXIMusic.core.security.jwt.JwtService;
import com.turkcell.OXIMusic.core.security.jwt.RefreshTokenService;
import com.turkcell.OXIMusic.dataAccess.RoleRepository;
import com.turkcell.OXIMusic.dataAccess.UserRepository;
import com.turkcell.OXIMusic.dtos.requests.login.LoginRequest;
import com.turkcell.OXIMusic.dtos.requests.register.RegisterRequest;
import com.turkcell.OXIMusic.entities.Role;
import com.turkcell.OXIMusic.entities.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthManager implements AuthService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;
	private final ModelMapper modelMapper;
	private final AuthBusinessRules authBusinessRules;
	private final RefreshTokenService refreshTokenService;
	
	@Override
	public User register(RegisterRequest request) {
		
		User user = modelMapper.map(request, User.class);
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setCreatedDate(LocalDateTime.now());

		Role userRole = roleRepository.findByName("user")
				.orElseThrow(() -> new RuntimeException("Role not found"));
		
		user.setAuthorities(Set.of(userRole));

		return userRepository.save(user);
	}

	@Override
	public String login(LoginRequest request) {
		
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		
		authBusinessRules.isAuthenticated(authentication);

		var user = (User) authentication.getPrincipal();
		var roles = user.getAuthorities().stream().map(role -> role.getAuthority()).toList();

		 String accessToken = jwtService.generateToken(user.getUsername(), roles);
	     String refreshToken = jwtService.generateRefreshToken(user.getUsername(), roles);

	        refreshTokenService.saveRefreshToken(user.getUsername(), refreshToken);
	        
	        return accessToken;
	}
	@Override
	public String refreshToken(String username, String existingRefreshToken) {
        String storedRefreshToken = refreshTokenService.getRefreshToken(username);
        if (storedRefreshToken != null && storedRefreshToken.equals(existingRefreshToken)) {
            var user = userRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("User not found"));
            var roles = user.getAuthorities().stream().map(role -> role.getAuthority()).toList();
            return jwtService.generateToken(user.getUsername(), roles);
        }
        throw new RuntimeException("Invalid refresh token");
    }
	
}
