/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.covid19.util;

import br.com.covid19.exception.ConexaoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrador
 */
public class Conexao {

    public static Connection getConnection() throws ConexaoException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_covid19?autoReconnect=true&useSSL=false&&serverTimezone=UTC", "root", "android9");            
        } catch (ClassNotFoundException | SQLException e) {
            throw new ConexaoException(e.getMessage());
        }
    }

    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws ConexaoException {
        close(conn, stmt, rs);
    }

    public static void closeConnection(Connection conn, Statement stmt) throws ConexaoException {
        close(conn, stmt, null);
    }

    public static void closeConnection(Connection conn) throws ConexaoException {
        close(conn, null, null);
    }

    private static void close(Connection conn, Statement stmt, ResultSet rs) throws ConexaoException {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new ConexaoException(e.getMessage());
        }
    }

}
