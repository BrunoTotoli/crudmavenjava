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


}
