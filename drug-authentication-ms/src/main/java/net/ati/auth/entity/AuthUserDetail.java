/**
 * 
 */
package net.ati.auth.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * @author Nayeemul
 *
 */
public class AuthUserDetail extends User implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AuthUserDetail(User user) {
        super(user);
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		getRoles().forEach(role ->{
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
			role.getPermissions().forEach(permission ->
			grantedAuthorities.add(new SimpleGrantedAuthority(permission.getName())));
		});
		
		
		
		return grantedAuthorities;
	}

}

















