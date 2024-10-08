package com.turkcell.OXIMusic.business.abstracts;

import com.turkcell.OXIMusic.dtos.requests.login.LoginRequest;
import com.turkcell.OXIMusic.dtos.requests.register.RegisterRequest;
import com.turkcell.OXIMusic.entities.User;

public interface AuthService {

    User register(RegisterRequest request);

    String login(LoginRequest request);

    String refreshToken(String username, String existingRefreshToken);
}
