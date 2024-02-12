package com.proyecto_universidad_java.views;

import com.proyecto_universidad_java.repository.impl.Repository_m_PersonasMysqlImpl;
import com.proyecto_universidad_java.repository.models.m_Personas;

public class Main {
    public static void main(String[] args) {
        Repository_m_PersonasMysqlImpl testImpl = new Repository_m_PersonasMysqlImpl();

        for (m_Personas valor : testImpl.listar()){
            System.out.println(valor);
        }
    }
}
