package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;

/**
 * Db Connector Singleton. Uses queries defined in queries.csv
 * Access object with MySQLConnector.getConnector();
 * Use one of <operation>Query methods.
 */
public class MySQLConnector {

    final private String queriesPath = "src/main/java/models/queries.csv";
    private static MySQLConnector connector = null;

    private MySQLConnector() {
    }

    public static MySQLConnector getConnector() {
        if (connector == null) {
            connector = new MySQLConnector();
        }
        return connector;
    }

    public LinkedList<String[]> selectQuery(String queryName, String... args) throws NullPointerException {
        try (BufferedReader br = new BufferedReader(new FileReader(queriesPath))) {
            String query = br.readLine();
            String[] line = null;
            while (query != null) {
                line = query.trim().split(";");
                if (line[0].equals(queryName)) {
                    for (int i = 0; i < args.length; i++) {
                        line[1] = line[1].replace("{" + i + "}", args[i]);
                    }
                    return select(line[1], line[2], line[3], line[4], line[5], line[6]);
                }
                query = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private LinkedList<String[]> select(String query, String db, String ip, String port, String user, String password) {
        LinkedList<String[]> queryReturn = new LinkedList<String[]>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + db, user, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();

            String[] headerRow = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                headerRow[i - 1] = md.getColumnName(i);
            }
            queryReturn.add(headerRow);

            while (rs.next()) {
                String[] dataRow = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    dataRow[i - 1] = rs.getString(i);
                }
                queryReturn.add(dataRow);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return queryReturn;
    }

    public int executeUpdate(String queryName, String... args) {
        try (BufferedReader br = new BufferedReader(new FileReader(queriesPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split(";");
                if (parts[0].equals(queryName)) {
                    String query = parts[1];
                    for (int i = 0; i < args.length; i++) {
                        query = query.replace("{" + i + "}", args[i]);
                    }
                    return executeUpdateQuery(query, parts[2], parts[3], parts[4], parts[5], parts[6]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    private int executeUpdateQuery(String query, String db, String ip, String port, String user, String password) {
        int rowsAffected = -1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + db, user, password);
            Statement stmt = con.createStatement();
            rowsAffected = stmt.executeUpdate(query);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return rowsAffected;
    }
}