/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Conexion;
import modelo.Categoria;
/**
 *
 * @author Liliana
 */
public class CategoriaDAO {
    Conexion conexion;
    
    public CategoriaDAO(){
        conexion = new Conexion();
    }
    
    public String agregarCategoria(Categoria categoria){
         String rptaRegistro = null;
        
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("INSERT INTO categoria(CategoriaId, CategoriaDescripcion, CategoriaEstReg) VALUES (?, ?, ?);");
            cs.setString(1, dni);
            cs.setString(2, nombre);
            cs.setString(3, direccion);
            cs.setString(4, correo);
            cs.setString(5, telefono);
            cs.setString(6, "A");
                    
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                rptaRegistro = "Modificación exitosa.";
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rptaRegistro;
    }
    public String modificarCliente(String dni, String nombre, String direccion,String correo, String telefono, String tipo){
        String rptaRegistro = null;
        
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("UPDATE cliente SET ClienteNombre = ?, ClienteDireccion = ?, ClienteCorreo = ?, ClienteTelefono = ? , ClienteEstReg = ? WHERE ClienteId=?;");
            cs.setString(1, nombre);
            cs.setString(2, direccion);
            cs.setString(3, correo);
            cs.setString(4, telefono);
            cs.setString(5, "A");
            cs.setString(6, dni);
            
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                rptaRegistro = "Modificación exitosa.";
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rptaRegistro;
    }
    public String eliminarCliente(String dni){
        String rptaRegistro = null;
        try{
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("UPDATE  cliente SET  ClienteEstReg =  'I' WHERE ClienteId =?");
            cs.setString(1, dni);
            
            int numFAfectadas = cs.executeUpdate();
            if(numFAfectadas > 0)
                rptaRegistro = "Eliminación exitosa.";
            accesoDB.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rptaRegistro;
    }
    }
   
    

        
    


