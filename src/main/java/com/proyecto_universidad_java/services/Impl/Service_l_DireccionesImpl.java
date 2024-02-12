package com.proyecto_universidad_java.services.Impl;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_l_Direcciones;
import com.proyecto_universidad_java.repository.models.l_Direcciones;
import com.proyecto_universidad_java.services.Service_l_Direcciones;
// import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Service_l_DireccionesImpl implements Service_l_Direcciones {
    private final Repository_l_Direcciones crudRepository_l_Direcciones;

    public Service_l_DireccionesImpl(Repository_l_Direcciones crudRepository_l_Direcciones) {
        this.crudRepository_l_Direcciones = crudRepository_l_Direcciones;
    }

    // private Connection getConnection() throws SQLException {
    //     return ConexionBDMysql.getInstance();
    // }

    public List<l_Direcciones> listar() {
        return this.crudRepository_l_Direcciones.listar();
    }

    public l_Direcciones porCodigo(int codigo) {
        return this.crudRepository_l_Direcciones.porCodigo(codigo);
        }    

    public void crear(l_Direcciones obj){
        this.crudRepository_l_Direcciones.crear(obj);
    }

    public void editar(l_Direcciones obj){
        this.crudRepository_l_Direcciones.editar(obj);
    }

    public void eliminar(int codigo){
        this.crudRepository_l_Direcciones.eliminar(codigo);        
    }
}