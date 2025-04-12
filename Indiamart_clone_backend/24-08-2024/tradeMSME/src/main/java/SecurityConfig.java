//import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//	 @Bean
//	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	        http.cors().and().csrf().disable()
//	            .authorizeHttpRequests()
//	            .requestMatchers("/login","/random").permitAll()  // Allow login endpoint without authentication
//	            .anyRequest().authenticated();   // Protect other endpoints
//	        return http.build();
//	    }
//}
