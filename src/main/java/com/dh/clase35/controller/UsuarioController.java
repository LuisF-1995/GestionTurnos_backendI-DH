package com.dh.clase35.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @GetMapping("/")
    public String paginaInicio(){

        String indexHtml = "<!DOCTYPE html> \n" +
                "<html lang=\"es\">\n" +
                "<head>\n" +
                "    <title>DH Odontologia</title>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\">\n" +
                "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n" +
                "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n" +
                "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"></script>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n" +
                "        <a class=\"navbar-brand\" href=\"/#\">Inicio</a>\n" +
                "        <a type=\"button\" class=\"btn btn-link\" href=\"/logout\">Salir</a>\n" +
                "        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
                "            <span class=\"navbar-toggler-icon\"></span>\n" +
                "        </button>\n" +
                "\n" +
                "        <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n" +
                "            <ul class=\"navbar-nav mr-auto\">\n" +
                "                <li class=\"nav-item dropdown\">\n" +
                "                    <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n" +
                "                        Gestión de Usuarios\n" +
                "                    </a>\n" +
                "                    <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n" +
                "                        <a class=\"dropdown-item\" href=\"/vistaUsuario.html\">Ingresar usuario</a>\n" +
                "                        <a class=\"dropdown-item\" href=\"/vistaAdmin.html\">Ingresar administrador</a>\n" +
                "                    </div>\n" +
                "                </li>\n" +
                "            </ul>\n" +
                "        </div>\n" +
                "    </nav>\n" +
                "    <h1>Inicio del sistema Trabajo Final Backend I</h1>\n" +
                "</body>\n" +
                "</html>";

        return indexHtml;
    }

    @GetMapping("/admin")
    public String adminPage(){
        String adminHtml= "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Admin DH</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Bienvenido Administrador!</h1>\n" +
                "    <h2>Gestionar Personal</h2>\n" +
                "\n" +
                "    <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n" +
                "        <a class=\"navbar-brand\" href=\"/\">Inicio</a>\n" +
                "        <a type=\"button\" class=\"btn btn-link\" href=\"/logout\">Salir</a>\n" +
                "        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
                "            <span class=\"navbar-toggler-icon\"></span>\n" +
                "        </button>\n" +
                "\n" +
                "        <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n" +
                "            <ul class=\"navbar-nav mr-auto\">\n" +
                "                <li class=\"nav-item dropdown\">\n" +
                "                    <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n" +
                "                        Gestion de Personal\n" +
                "                    </a>\n" +
                "                    <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n" +
                "                        <a class=\"dropdown-item\" href=\"/get_all_odontologo.html\">Ver odontologos</a>\n" +
                "                        <a class=\"dropdown-item\" href=\"/post_odontologo.html\">Agregar odontologos</a>\n" +
                "                        <a class=\"dropdown-item\" href=\"/get_all_pacientes.html\">Ver Pacientes</a>\n" +
                "                        <a class=\"dropdown-item\" href=\"/post_paciente.html\">Agregar Pacientes</a>\n" +
                "                    </div>\n" +
                "                </li>\n" +
                "            </ul>\n" +
                "        </div>\n" +
                "    </nav>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        return adminHtml;
    }

    @GetMapping("/user")
    public String userPage(){
        String userHtml= "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Usuario DH</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Bienvenido Usuario!</h1>\n" +
                "    <h2>Gestionar turnos</h2>\n" +
                "\n" +
                "    <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n" +
                "        <a class=\"navbar-brand\" href=\"/\">Inicio</a>\n" +
                "        <a type=\"button\" class=\"btn btn-link\" href=\"/logout\">Salir</a>\n" +
                "        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
                "            <span class=\"navbar-toggler-icon\"></span>\n" +
                "        </button>\n" +
                "\n" +
                "        <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n" +
                "            <ul class=\"navbar-nav mr-auto\">\n" +
                "                <li class=\"nav-item dropdown\">\n" +
                "                    <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n" +
                "                        Gestion de turnos\n" +
                "                    </a>\n" +
                "                    <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n" +
                "                        <a class=\"dropdown-item\" href=\"/agregarTurno.html\">Agregar turno</a>\n" +
                "                        <a class=\"dropdown-item\" href=\"/verTurnos.html\">Ver turnos</a>\n" +
                "                    </div>\n" +
                "                </li>\n" +
                "            </ul>\n" +
                "        </div>\n" +
                "    </nav>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        return userHtml;
    }

}
