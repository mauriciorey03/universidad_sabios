package com.proyecto_universidad_java.services.Impl;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_j_Matriculas;
import com.proyecto_universidad_java.repository.models.j_Matriculas;
import com.proyecto_universidad_java.services.Service_j_Matriculas;
// import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Service_j_MatriculasImpl implements Service_j_Matriculas {
    private final Repository_j_Matriculas crudRepository_j_Matriculas;

    public Service_j_MatriculasImpl(Repository_j_Matriculas crudRepository_j_Matriculas) {
        this.crudRepository_j_Matriculas = crudRepository_j_Matriculas;
    }

    // private Connection getConnection() throws SQLException {
    //     return ConexionBDMysql.getInstance();
    // }

    public List<j_Matriculas> listar() {
        return this.crudRepository_j_Matriculas.listar();
    }

    public j_Matriculas porCodigo(int codigo) {
        return this.crudRepository_j_Matriculas.porCodigo(codigo);
        }    

    public void crear(j_Matriculas obj){
        this.crudRepository_j_Matriculas.crear(obj);
    }

    public void editar(j_Matriculas obj){
        this.crudRepository_j_Matriculas.editar(obj);
    }

    public void eliminar(int codigo){
        this.crudRepository_j_Matriculas.eliminar(codigo);        
    }
}