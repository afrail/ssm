package net.ati.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.ati.auth.entity.OauthClientDetails;

/**
 * @author Nayeemul
 *
 */

@Repository
public interface OauthClientDetailsRepository extends JpaRepository<OauthClientDetails, String>{

}
