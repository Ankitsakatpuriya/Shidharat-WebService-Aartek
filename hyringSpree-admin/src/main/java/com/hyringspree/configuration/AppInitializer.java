package com.hyringspree.configuration;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.hyringspree.filter.JwtTokenAuthenticationFilter;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { HibernateConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebMvcConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		/*If the JwtTokenAuthenticationFilter was diretly used as a ServletFilter, then only this filter would be applied.
        In this case, chained filters managed by Spring Security (ExceptionTranslationFilter, SessionManagementFilter et FilterSecurityInterceptor, etc.)
        wouldn't be applied. As such, URL filtering wouln't be secured as expected by the configuration).

        We need to specify the springSecurityFilterChain as the initial Servlet filter. This proxy takes care of chaining filter calls as they
         are indicated in the WebSecurityConfiguration class.*/
	
		final String secret = "ksfdlkvopiurutueijflkdsvf,cjnjnxjnvsoifoiropiezaropioezkvf,k,c kv,ckvdkfjgvorieoigfopziefpozepfiezikfozkfldsmvflkvdldvl,fdvk,fdkv,dkfgkjfdgkjvicooiviuzieopiztpoirpotimldkflg,vlkfckjshayauiueruergregierpogipdfogiklxvcjnxvjnfvjdsmkfmslfklgkfgoirgjitrooritjg";
		return new Filter[] { new JwtTokenAuthenticationFilter("/auth/**", secret), new CORSFilter() };
	}

}
