package com.turkcell.OXIMusic.core.security.jwt;

import java.time.Duration;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RefreshTokenService 
{
	 private final RedisTemplate<String, Object> redisTemplate;
	    private static final long REFRESH_TOKEN_EXPIRATION = 604800; // 7 gün

	    public RefreshTokenService(RedisTemplate<String, Object> redisTemplate) {
	        this.redisTemplate = redisTemplate;
	    }

	    public void saveRefreshToken(String username, String refreshToken) {
	        redisTemplate.opsForValue().set(username, refreshToken, Duration.ofSeconds(REFRESH_TOKEN_EXPIRATION));
	    }

	    public String getRefreshToken(String username) {
	        return (String) redisTemplate.opsForValue().get(username);
	    }

	    public void deleteRefreshToken(String username) {
	        redisTemplate.delete(username);
	    }
	}

