package com.proyecto_universidad_java.services.Impl;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_f_Asignaturas;
import com.proyecto_universidad_java.repository.models.f_Asignaturas;
import com.proyecto_universidad_java.services.Service_f_Asignaturas;
// import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Service_f_AsignaturasImpl implements Service_f_Asignaturas {
    private final Repository_f_Asignaturas crudRepository_f_Asignaturas;

    public Service_f_AsignaturasImpl(Repository_f_Asignaturas crudRepository_f_Asignaturas) {
        this.crudRepository_f_Asignaturas = crudRepository_f_Asignaturas;
    }

    // private Connection getConnection() throws SQLException {
    //     return ConexionBDMysql.getInstance();
    // }

    public List<f_Asignaturas> listar() {
        return this.crudRepository_f_Asignaturas.listar();
    }

    public f_Asignaturas porCodigo(int codigo) {
        return this.crudRepository_f_Asignaturas.porCodigo(codigo);
        }    

    public void crear(f_Asignaturas obj){
        this.crudRepository_f_Asignaturas.crear(obj);
    }

    public void editar(f_Asignaturas obj){
        this.crudRepository_f_Asignaturas.editar(obj);
    }

    public void eliminar(int codigo){
        this.crudRepository_f_Asignaturas.eliminar(codigo);        
    }
}