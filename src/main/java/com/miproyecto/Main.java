package com.miproyecto;

import com.miproyecto.dao.UsuarioDao;
import com.miproyecto.modelos.Usuario;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UsuarioDao usuarioDAO = new UsuarioDao();
        
        // Listando todos los usuarios
        List<Usuario> usuarios = usuarioDAO.listarUsuarios();
        
        // Mostrando los usuarios
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }
}
