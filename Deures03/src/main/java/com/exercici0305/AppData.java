package com.exercici0305;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AppData {
    private static AppData instance;
    private Connection conn;

    private AppData() {
        // Connecta al crear la primera instància
        connect();
    }

    // Singleton
    public static AppData getInstance() {
        if (instance == null) {
            instance = new AppData();
        }
        return instance;
    }

    private void connect() {
        String url = "jdbc:mysql://localhost:3308/government?useSSL=false&allowPublicKeyRetrieval=true";
        String user = "root";
        String password = "pwd";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false); // Desactiva l'autocommit per permetre control manual de transaccions
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error connectant a la base de dades MySQL.");
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(String sql) {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            conn.commit(); // Confirma els canvis
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                conn.rollback(); // Reverteix els canvis en cas d'error
            } catch (SQLException ex) {
                System.out.println("Error en fer rollback.");
                ex.printStackTrace();
            }
        }
    }
    public int insertAndGetId(String sql) {
        int generatedId = -1;
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                generatedId = rs.getInt(1); // Obtenir el primer camp com a ID generat
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                conn.rollback();
            } catch (SQLException ex) {
                System.out.println("Error en fer rollback.");
                ex.printStackTrace();
            }
        }
        return generatedId;
    }

    public List<Map<String, Object>> query(String sql) {
        List<Map<String, Object>> resultList = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(metaData.getColumnLabel(i), rs.getObject(i));
                }
                resultList.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultList;
    }
}