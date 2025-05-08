package com.miproyecto.dao;

import com.miproyecto.conexion.conexionBD;
import com.miproyecto.modelos.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    // Método para listar todos los usuarios
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        Connection conn = conexionBD.conectar();

        if (conn != null) {
            String query = "SELECT id, nombre, correo FROM usuario";
            try (PreparedStatement pst = conn.prepareStatement(query);
                 ResultSet rs = pst.executeQuery()) {

                while (rs.next()) {
                    // Creando un nuevo usuario por cada fila
                    Usuario usuario = new Usuario(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("correo")
                    );
                    usuarios.add(usuario);
                }

            } catch (SQLException e) {
                System.out.println("Error al listar usuarios: " + e.getMessage());
            }
        } else {
            System.out.println("Conexión no disponible.");
        }

        return usuarios;
    }
}
