/**
 * 
 */
package net.ati.auth.foreign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import net.ati.auth.entity.User;

/**
 * @author Nayeemul
 *
 */

@Component
@RefreshScope
public class ForeignUser {
	
	@Autowired
	RestTemplate restTemplate;
	
	public User saveUser()
	{
		try {
			String url = "http://prod-server:8082/product-api/foreign/add";
			ResponseEntity<User> response =
					restTemplate.getForEntity(url, User.class);
			System.out.println(response.getBody());
			return response.getBody();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
















