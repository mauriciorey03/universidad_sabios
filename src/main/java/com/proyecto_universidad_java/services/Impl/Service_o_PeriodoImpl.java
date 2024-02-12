package com.proyecto_universidad_java.services.Impl;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_o_Periodo;
import com.proyecto_universidad_java.repository.models.o_Periodo;
import com.proyecto_universidad_java.services.Service_o_Periodo;
// import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Service_o_PeriodoImpl implements Service_o_Periodo {
    private final Repository_o_Periodo crudRepository_o_Periodo;

    public Service_o_PeriodoImpl(Repository_o_Periodo crudRepository_o_Periodo) {
        this.crudRepository_o_Periodo = crudRepository_o_Periodo;
    }

    // private Connection getConnection() throws SQLException {
    //     return ConexionBDMysql.getInstance();
    // }

    public List<o_Periodo> listar() {
        return this.crudRepository_o_Periodo.listar();
    }

    public o_Periodo porCodigo(int codigo) {
        return this.crudRepository_o_Periodo.porCodigo(codigo);
        }    

    public void crear(o_Periodo obj){
        this.crudRepository_o_Periodo.crear(obj);
    }

    public void editar(o_Periodo obj){
        this.crudRepository_o_Periodo.editar(obj);
    }

    public void eliminar(int codigo){
        this.crudRepository_o_Periodo.eliminar(codigo);        
    }
}