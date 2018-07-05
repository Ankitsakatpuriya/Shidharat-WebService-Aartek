package com.hyringspree.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* The persistent class for the `USER` database table.
* 
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_admin")	
public class User implements Serializable , UserDetails
{
  
	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	/** The Email id. */
	@Column(name="EMAIL_ID")
	private String emailId;
	
	/** The Password. */
	@Column(name="PASSWORD")
	private String password;
	
	@Transient
	private String token;
	
	//@Transient
	//private ObjectId objId;
	
	@Transient
	private String strAuthorities;
	
/*	@Transient
	String str1;*/
	
/*	@Transient
	String str2;*/

	@Transient
	@Column(name="AUTHORITIES")
	private Collection<? extends GrantedAuthority> authorities;
	
	/*public User(){
    }*/
	
//	public User(String emailId, String password, String str1, String str2,  Collection<? extends GrantedAuthority> authorities) {
//        this.emailId = emailId;
//        this.password = password;
//        this.str1 = str1;
//        this.str2 = str2;
//        this.authorities = authorities;
//    }
	
	public User(String emailId, String password, Collection<? extends GrantedAuthority> authorities) {
        this.emailId = emailId;
        this.password = password;
        this.authorities= authorities;
    }
	public User(String token) {
        this.token = token;
      
    }
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @param authorities the authorities to set
	 */
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		
		this.authorities = authorities;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/*public String getPassword() {
		return password;
	}*/

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return emailId;
	}
	public void setUsername(String username) {
		this.emailId = username;
	}
	
	
	
	
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	// @Override
	    public boolean isEnabled() {
	        // always enabled in JWT case.
	        return true;
	    }
		/**
		 * @return the strAuthorities
		 */
		public String getStrAuthorities() {
			return strAuthorities;
		}
		/**
		 * @param strAuthorities the strAuthorities to set
		 */
		public void setStrAuthorities(String strAuthorities) {
			this.strAuthorities = strAuthorities;
		}

		public String getPassword() {
			// TODO Auto-generated method stub
			return password;
		}

		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}
}