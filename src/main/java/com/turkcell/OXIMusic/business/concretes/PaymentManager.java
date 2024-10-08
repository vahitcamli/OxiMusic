package com.turkcell.OXIMusic.business.concretes;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.turkcell.OXIMusic.business.abstracts.PaymentService;
import com.turkcell.OXIMusic.business.abstracts.UserAuthService;
import com.turkcell.OXIMusic.business.rules.PaymentBusinessRules;
import com.turkcell.OXIMusic.dataAccess.RoleRepository;
import com.turkcell.OXIMusic.dataAccess.UserRepository;
import com.turkcell.OXIMusic.dtos.requests.payment.PaymentRequest;
import com.turkcell.OXIMusic.dtos.responses.payment.PaymentResponse;
import com.turkcell.OXIMusic.entities.Role;
import com.turkcell.OXIMusic.entities.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentManager implements PaymentService {
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final ModelMapper modelMapper;
	private final UserAuthService userAuthService;
	private final PaymentBusinessRules paymentBusinessRules;

	@Override
	@Transactional
	public PaymentResponse SubscribeprocessPayment(PaymentRequest paymentRequest) {

		boolean paymentSuccessful = true;

		if (paymentSuccessful) {

			UserDetails currentUserDetails = userAuthService.getCurrentUser();
			User currentUser = userRepository.findByEmail(currentUserDetails.getUsername())
					.orElseThrow(() -> new UsernameNotFoundException("User not found"));

			paymentBusinessRules.checkIfAlreadyPartner(currentUser);

			Role subscriberRole = roleRepository.findByName("subscriber")
					.orElseThrow(() -> new IllegalArgumentException("Role not found"));

			Set<Role> roles = new HashSet<>();
			roles.add(subscriberRole);
			currentUser.setAuthorities(roles);

			userRepository.save(currentUser);
		}

		return new PaymentResponse(paymentSuccessful, "Payment successful and role updated to Subscriber");
	}

	@Override
	public PaymentResponse PartnerprocessPayment(PaymentRequest paymentRequest) {

		boolean paymentSuccessful = true;

		if (paymentSuccessful) {

			UserDetails currentUserDetails = userAuthService.getCurrentUser();
			User currentUser = userRepository.findByEmail(currentUserDetails.getUsername())
					.orElseThrow(() -> new UsernameNotFoundException("User not found"));

			paymentBusinessRules.checkIfAlreadyPartner(currentUser);

			Role subscriberRole = roleRepository.findByName("partner")
					.orElseThrow(() -> new IllegalArgumentException("Role not found"));

			Set<Role> roles = new HashSet<>(currentUser.getAuthorities());
			roles.add(subscriberRole);
			currentUser.setAuthorities(roles);

			userRepository.save(currentUser);
		}

		return new PaymentResponse(paymentSuccessful, "Payment successful and role updated to Subscriber");
	}
}