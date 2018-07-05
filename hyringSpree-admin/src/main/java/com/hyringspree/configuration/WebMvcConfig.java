package com.hyringspree.configuration;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hyringspree.filter.JwtTokenAuthenticationFilter;
import com.hyringspree.filter.RestAccessDeniedHandler;
import com.hyringspree.filter.SecurityAuthenticationEntryPoint;
import com.hyringspree.util.IConstant;

@EnableWebMvc 
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableTransactionManagement
@Configuration
@ComponentScan(basePackages = { "com.hyringspree" })
public class WebMvcConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
	
	@Autowired
	private ApplicationSecurityIntercepter applicationSecurityIntercepter;
	
	    public WebMvcConfig() {
	        /*
	         * Ignores the default configuration, useless in our case (session management, etc..)
	         */
	        super(true);
	    }

	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(10485760); // 10MB
		multipartResolver.setMaxUploadSizePerFile(1048576); // 1MB
		return multipartResolver;
	}
	
	 public void addInterceptors(InterceptorRegistry registry) {
	  registry.addInterceptor(applicationSecurityIntercepter)
	  
	  .addPathPatterns("/**") .excludePathPatterns("/home/*")
	  .excludePathPatterns(IConstant.SEARCH_JOB_FILTER_FOR_HOMEPAGE)
	  .excludePathPatterns(IConstant.LOGIN_USER) // For login
	  .excludePathPatterns(IConstant.SAVE_RECRUITER)
	  .excludePathPatterns(IConstant.GETALLCOMPANY_DETAILS)
	  .excludePathPatterns(IConstant.GET_STATE_AND_CITY_ZIP)
	  .excludePathPatterns(IConstant.GET_STATE_AND_ZIP_LOCATIONCITY)
	  .excludePathPatterns(IConstant.SAVEJOBSEEKER_DETAILS)
	  .excludePathPatterns(IConstant.FORGET_PASSWORD)
	  .excludePathPatterns(IConstant.RESET_PASSWORD)
	  .excludePathPatterns(IConstant.CHECK_JOBSEEKER_BY_EMAILID)
	  .excludePathPatterns(IConstant.SAVECONTACT_DETAILS);


	  }
	
	    @Autowired
	    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
	        /*
	         Configures the AuthenticationManagerBuilder to use the specified DetailsService.
	         The password is also specified as being encrypted in database.
	         */
	       // authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	    }


	    @Override
	    protected void configure(HttpSecurity httpSecurity) throws Exception {

	        /* the secret key used to signe the JWT token is known exclusively by the server.
	         With Nimbus JOSE implementation, it must be at least 256 characters longs.
	         */
	        final String secret = "ksfdlkvopiurutueijflkdsvf,cjnjnxjnvsoifoiropiezaropioezkvf,k,c kv,ckvdkfjgvorieoigfopziefpozepfiezikfozkfldsmvflkvdldvl,fdvk,fdkv,dkfgkjfdgkjvicooiviuzieopiztpoirpotimldkflg,vlkfckjshayauiueruergregierpogipdfogiklxvcjnxvjnfvjdsmkfmslfklgkfgoirgjitrooritjg";
	       
	        httpSecurity
	                /*
	                Filters are added just after the ExceptionTranslationFilter so that Exceptions are catch by the exceptionHandling()
	                 Further information about the order of filters, see FilterComparator
	                 */
	                .addFilterAfter(jwtTokenAuthenticationFilter("/**", secret), ExceptionTranslationFilter.class)
	                //.addFilterAfter(ExceptionTranslationFilter.class)
	                /*
	                 Exception management is handled by the authenticationEntryPoint (for exceptions related to authentications)
	                 and by the AccessDeniedHandler (for exceptions related to access rights)
	                */
	                .exceptionHandling()
	                .authenticationEntryPoint(new SecurityAuthenticationEntryPoint())
	                .accessDeniedHandler(new RestAccessDeniedHandler())
	                .and()
	                /*
	                  anonymous() consider no authentication as being anonymous instead of null in the security context.
	                 */
	                .anonymous()
	                .and()
	                /* No Http session is used to get the security context */
	                .sessionManagement().sessionCreationPolicy(STATELESS)
	                .and()
	                .authorizeRequests()
	                    /* All access to the authentication service are permitted without authentication (actually as anonymous) */
	                .antMatchers("/auth/**").permitAll()
	                    /* All the other requests need an authentication.
	                     Role access is done on Methods using annotations like @PreAuthorize
	                     */
	                .anyRequest().authenticated();
	    }

	    private JwtTokenAuthenticationFilter jwtTokenAuthenticationFilter(String path, String secret) {
	        return new JwtTokenAuthenticationFilter(path, secret);
	    }

}