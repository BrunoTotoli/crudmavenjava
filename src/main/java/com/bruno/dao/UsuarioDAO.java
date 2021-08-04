package com.bruno.dao;

import com.bruno.connection.SingleConnection;
import com.bruno.model.Usuario;

import java.sql.Connection;


public class UsuarioDAO {
    Connection connection = SingleConnection.getConnection();


}
