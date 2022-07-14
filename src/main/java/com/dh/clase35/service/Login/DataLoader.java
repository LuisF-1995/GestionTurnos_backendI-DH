package com.dh.clase35.service.Login;

import com.dh.clase35.entities.Usuario;
import com.dh.clase35.entities.UsuarioRole;
import com.dh.clase35.respository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UsuarioRepository usuarioRepository;
    @Autowired
    public DataLoader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
        String passwordUserHash=passwordEncoder.encode("Luis1995");
        Usuario usuario1 =new Usuario("Luis Usuario","Luis1995","luisF1995@hotmail.com",passwordUserHash, UsuarioRole.ROLE_USER);
        usuarioRepository.save(usuario1);

        String passwordAdminHash=passwordEncoder.encode("AdminLuis1995");
        Usuario Admin1 =new Usuario("Luis Admin","AdminLuis1995","luisAdmin1995@hotmail.com", passwordAdminHash, UsuarioRole.ROLE_ADMIN);
        usuarioRepository.save(Admin1);
    }




}
