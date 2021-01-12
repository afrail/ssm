/**
 * 
 */
package net.ati.auth.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.ati.auth.entity.Role;
import net.ati.auth.entity.User;
import net.ati.auth.exception.RecordNotFoundException;
import net.ati.auth.repository.UserRepository;


/**
 * @author Nayeemul
 *
 */
@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public String addOrUpdateUser(User user)
	{
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);
		System.out.println(user.getPassword());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		System.out.println(user.getPassword());
		
		try {
			userRepository.save(user);
			return "saved";
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("failed");
		}
		
	}
	public String addOrUpdateUserFromRS(User user)
	{
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		Role role = new Role(2, "ROLE_operator");
		
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		
		user.setRoles(roles);
		
		System.out.println(user);
		
		try {
			userRepository.save(user);
			return "saved";
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("failed");
		}
		
	}

	public User findUserByName(String name) {
		Optional<User> users = userRepository.findByUsername(name);
		return users.orElseThrow(() -> new RecordNotFoundException("No record found for given user name: " + name));
	}

	public List<User> findAllActiveUsers() {
		return userRepository.findAll();
	}
	
	public User findActiveUserInfo(int userId) {
		return userRepository.findById(userId).orElseThrow(() -> new RecordNotFoundException("No record found for given user name: " + userId));
	}


}
