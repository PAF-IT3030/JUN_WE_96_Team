package com.paf.socialmedia.controller.authentication;

import com.paf.socialmedia.entity.authentication.User;
import com.paf.socialmedia.repository.authentication.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class TestController {
	private final UserRepository userRepository;
	@GetMapping("/all")
	public User allAccess() {
		return userRepository.findAll().stream().findFirst().orElse(new User());
	}
	
	@GetMapping("/student")
	@PreAuthorize("hasRole('STUDENT') or hasRole('FACULTY') or hasRole('ADMIN')")
	public String userAccess() {
		return "Student Content.";
	}

	@GetMapping("/faculty")
	@PreAuthorize("hasRole('FACULTY')")
	public String moderatorAccess() {
		return "Faculty Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}
