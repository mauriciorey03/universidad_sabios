package com.proyecto_universidad_java.services.Impl;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_e_Cursos;
import com.proyecto_universidad_java.repository.impl.Repository_e_CursosMysqlImpl;
import com.proyecto_universidad_java.repository.models.e_Cursos;
import com.proyecto_universidad_java.services.Service_e_Cursos;
// import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Service_e_CursosImpl implements Service_e_Cursos {
    private final Repository_e_Cursos crudRepository_e_Cursos;

    public Service_e_CursosImpl(Repository_e_CursosMysqlImpl repository_e_CursosMysqlImpl) {
        this.crudRepository_e_Cursos = repository_e_CursosMysqlImpl;
    }

    // private Connection getConnection() throws SQLException {
    //     return ConexionBDMysql.getInstance();
    // }

    public List<e_Cursos> listar() {
        return this.crudRepository_e_Cursos.listar();
    }

    public e_Cursos porCodigo(int codigo) {
        return this.crudRepository_e_Cursos.porCodigo(codigo);
        }    

    public void crear(e_Cursos obj){
        this.crudRepository_e_Cursos.crear(obj);
    }

    public void editar(e_Cursos obj){
        this.crudRepository_e_Cursos.editar(obj);
    }

    public void eliminar(int codigo){
        this.crudRepository_e_Cursos.eliminar(codigo);        
    }
}