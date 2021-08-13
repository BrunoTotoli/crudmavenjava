package com.bruno.dao;

import com.bruno.connection.SingleConnection;
import com.bruno.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO {
    Connection connection = SingleConnection.getConnection();

    public void salvar(Usuario usuario) {
        try {
            String sql = "insert into userbancojava(id,nome,email) values(?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setLong(1, usuario.getId());
            stm.setString(2, usuario.getNome());
            stm.setString(3, usuario.getEmail());
            stm.execute();
            connection.commit();
        } catch (Exception exception) {
            try {
                connection.rollback();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            exception.printStackTrace();
        }


    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> users = new ArrayList<>();
        Usuario returnUser = null;
        try {
            String sql = "select * from userbancojava";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                returnUser = new Usuario(rs.getString(2), rs.getString(3), rs.getLong(1));
                users.add(returnUser);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public Usuario listarPorId(Long id) {
        Usuario usuario = null;
        try {
            String sql = "select * from userbancojava where id =" + id;
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                usuario = new Usuario(rs.getString(2), rs.getString(3), rs.getLong(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public void atualizarEmailUsuario(Usuario usuario, String novoEmail) {
        try {
            String sql = "update userbancojava set email = ? where id =" + usuario.getId();
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, novoEmail);
            stm.execute();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public void deletarPorId(Long id) {
        try {
            String sql = "delete from userbancojava where id = " + id;
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.execute();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }


}
