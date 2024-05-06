package com.paf.socialmedia.controller.authentication;

import com.paf.socialmedia.dto.authentication.request.LoginRequest;
import com.paf.socialmedia.dto.authentication.request.SignupRequest;
import com.paf.socialmedia.dto.authentication.response.JwtResponse;
import com.paf.socialmedia.dto.authentication.response.MessageResponse;
import com.paf.socialmedia.entity.authentication.User;
import com.paf.socialmedia.repository.authentication.UserRepository;
import com.paf.socialmedia.service.authentication.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationController {
	private final AuthenticationService authenticationService;
	private final UserRepository userRepository;

	@PostMapping("/signin")
	public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		return authenticationService.authenticateUserDetails(loginRequest);
	}

	@PostMapping("/signup")
	public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		return authenticationService.registerUserDetails(signUpRequest);
	}
	@GetMapping("/{id}")
	public User getCurrentUser(@PathVariable String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElse(new User());

	}
}
