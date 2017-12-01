/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Conexion;
import modelo.Usuario;

/**
 *
 * @author Mario-Snow
 */
public class UsuarioDAO {
    Conexion conexion;
    
    public UsuarioDAO(){
        conexion = new Conexion();
    }
    
    public Usuario verificarUsuario(String codigo, String password){
        Usuario usuario = null;
        Connection acceso = conexion.getConexion();
        try{
            PreparedStatement ps = acceso.prepareStatement("select * from usuario where UsuarioId=? and UsuarioContra=?");
            ps.setString(1, codigo);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                usuario = new Usuario();
                usuario.setId(rs.getString(1));
                usuario.setNombres(rs.getString(2));
                usuario.setContra(rs.getString(3));
                usuario.setCargo(rs.getInt(4));
                usuario.setEstadoRegistro(rs.getString(5));
                return usuario;
            }
            acceso.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return usuario;
    }
}
