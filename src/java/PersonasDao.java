
import configuracion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Humberto Manjarres
 */
public class PersonasDao extends Conexion {

    Connection con = null;
    ResultSet rs = null;
    CallableStatement call = null;
    Persona persona;

    public List<Persona> listar() throws SQLException {
        List<Persona> listaPersonas = new ArrayList<>();
        try {
            con = conectar();
            call = con.prepareCall("call crud_empleados(?,?,?,?,?,?,?,?)");
            call.setString(1, "");
            call.setString(2, "");
            call.setString(3, "");
            call.setString(4, "");
            call.setInt(5, 0);
            call.setString(6, "");
            call.setString(7, "listar");
            call.registerOutParameter(8, Types.VARCHAR);
            call.execute();
            if (call.getString(8).equals("0|")) {
                rs = call.getResultSet();
                while (rs.next()) {
                    persona = new Persona();
                    persona.setNombre(rs.getString("nombre"));
                    persona.setEdad(rs.getInt("salario"));
                    listaPersonas.add(persona);
                }
            }
        } catch (Exception e) {
            System.out.println("error-->"+e);
        }finally{cerrarConexion();}
        
        
        for (Persona listaPersona : listaPersonas) {
            System.out.println("p --> "+listaPersona.getNombre());
        }
        
        return listaPersonas;
    }
    
    
     public void cerrarConexion() throws SQLException {
        if (rs != null) {
            rs.close();
            rs = null;
        }

        if (call != null) {
            call.close();
        }

        if (con != null) {
            con.close();
            con = null;
        }
    }
    
}
