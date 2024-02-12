package com.proyecto_universidad_java.services.Impl;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_b_Departamentos;
import com.proyecto_universidad_java.repository.models.b_Departamentos;
import com.proyecto_universidad_java.services.Service_b_Departamentos;
// import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Service_b_DepartamentosImpl implements Service_b_Departamentos {
    private final Repository_b_Departamentos crudRepository_b_Departamentos;

    public Service_b_DepartamentosImpl(Repository_b_Departamentos crudRepository_b_Departamentos) {
        this.crudRepository_b_Departamentos = crudRepository_b_Departamentos;
    }

    // private Connection getConnection() throws SQLException {
    //     return ConexionBDMysql.getInstance();
    // }

    public List<b_Departamentos> listar() {
        return this.crudRepository_b_Departamentos.listar();
    }

    public b_Departamentos porCodigo(int codigo) {
        return this.crudRepository_b_Departamentos.porCodigo(codigo);
        }    

    public void crear(b_Departamentos obj){
        this.crudRepository_b_Departamentos.crear(obj);
    }

    public void editar(b_Departamentos obj){
        this.crudRepository_b_Departamentos.editar(obj);
    }

    public void eliminar(int codigo){
        this.crudRepository_b_Departamentos.eliminar(codigo);        
    }
}