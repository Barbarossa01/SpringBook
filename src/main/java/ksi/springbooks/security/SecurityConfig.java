package ksi.springbooks.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/", "/index", "/book_list", "/book_list_sort", "/category_list", "/publisher_list").permitAll()
                
                .requestMatchers("/delete_category/**","/delete_book/**","/delete_publisher/**","/new_category","/add_category", "/edit_book/**", "/edit_category/**", "/edit_publisher/**", "/new_book", "/new_publisher").authenticated()
                
                .anyRequest().permitAll()
            )
            

            .formLogin(form -> form
                .loginPage("/login") 
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/") 
                .permitAll()
            )
            
            
            .logout(logout -> logout
                .logoutSuccessUrl("/") 
            );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        
        UserDetails user = User.builder()
            .username("user1")
            .password(passwordEncoder().encode("password")) 
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
