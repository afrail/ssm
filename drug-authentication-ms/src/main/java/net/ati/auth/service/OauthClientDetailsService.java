/**
 * 
 */
package net.ati.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.ati.auth.entity.OauthClientDetails;
import net.ati.auth.repository.OauthClientDetailsRepository;

/**
 * @author Nayeemul
 *
 */

@Service
public class OauthClientDetailsService {
	
	@Autowired
	private OauthClientDetailsRepository oauthClientDetailsRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public String addOrUpdateClient(OauthClientDetails clientDetails)
	{
		clientDetails.setScope("READ,WRITE,TRUSTED");
		clientDetails.setClientSecret(passwordEncoder.encode(clientDetails.getClientSecret()));
		
		clientDetails.setAccessTokenValidity(3600);
		clientDetails.setRefreshTokenValidity(360000);
		clientDetails.setAuthorizedGrantTypes("authorization_code,password,refresh_token,implicit");
		
		try {
			oauthClientDetailsRepository.save(clientDetails);
			return "saved";
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("failed");
		}
		
	}
	

}
