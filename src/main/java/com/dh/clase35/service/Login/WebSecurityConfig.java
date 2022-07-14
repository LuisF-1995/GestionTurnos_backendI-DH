package com.dh.clase35.service.Login;

import com.dh.clase35.entities.Usuario;
import com.dh.clase35.entities.UsuarioRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private UsuarioService usuarioService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public WebSecurityConfig(UsuarioService usuarioService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioService = usuarioService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
            .antMatchers("/", "static/**").permitAll()

            .antMatchers("/admin").hasRole("ADMIN")
            .antMatchers("/vistaAdmin.html").hasRole("ADMIN")
            .antMatchers("/odontologos").hasRole("ADMIN")
            .antMatchers("/pacientes").hasRole("ADMIN")
            //.antMatchers(HttpMethod.GET, "/**").hasAnyRole(UsuarioRole.USER.name(), UsuarioRole.ADMIN.name())
            .antMatchers("/user").hasRole("USER")
            .antMatchers("/vistaUsuario.html").hasRole("USER")
            .antMatchers("/turnos").hasRole("USER")
            .anyRequest().authenticated().and()
            .formLogin().and().logout().and().httpBasic();
    }

    /*
    protected void configure(AuthenticationManagerBuilder autenticacion) throws Exception {
        autenticacion.inMemoryAuthentication()
            .withUser("Luis1995").password(bCryptPasswordEncoder.encode("Luis1995")).roles(UsuarioRole.USER.name()).and()
            .withUser("AdminLuis1995").password(bCryptPasswordEncoder.encode("AdminLuis1995")).roles(UsuarioRole.ADMIN.name());
    }

     */

}
