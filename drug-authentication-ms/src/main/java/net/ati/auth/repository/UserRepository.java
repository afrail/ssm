/**
 * 
 */
package net.ati.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ati.auth.entity.User;

/**
 * @author Nayeemul
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * @param name
	 * @return
	 */
	Optional<User> findByUsername(String name);
	boolean existsByUsername(String name);

}
