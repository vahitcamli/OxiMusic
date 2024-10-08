package com.turkcell.OXIMusic.business.abstracts;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserAuthService {
	UserDetails getCurrentUser();
}
