package conexoes;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.ModelSessaoUsuario;

public class ConexaoFirebird {
    private Connection con = null;
    private Statement statement;
    private ResultSet resultSet;
    private final String databaseURL = "jdbc:firebirdsql:localhost:C:\\Sistema Assistencia OS\\banco\\bdOS.fdb";
    private final String user = "sysdba";
    private final String password = "masterkey";
    private final String driverName = "org.firebirdsql.jdbc.FBDriver";

    public void conectar() {
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver").newInstance();
            this.con = DriverManager.getConnection(this.databaseURL, "sysdba", "masterkey");
        }
        catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        catch (Exception e) {
            System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
        }
    }

    public void executarSQL(String sql) {
        try {
            this.statement = this.con.createStatement(1005, 1007);
            this.resultSet = this.statement.executeQuery(sql);
        }
        catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Problema de conex\u00e3o com o banco de dados!.", "Erro", 0);
            System.out.println("aqui");
            sqlex.printStackTrace();
        }
    }

    public void executarUpdateDeleteSQL(String sql) {
        try {
            this.statement = this.con.createStatement(1005, 1007);
            this.statement.executeUpdate(sql);
        }
        catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }

    public int insertSQL(String pSQL) {
        int idRetorno = 0;
        try {
            this.statement = this.con.createStatement(1005, 1007);
            this.resultSet = this.statement.executeQuery(pSQL);
            while (this.getResultSet().next()) {
                idRetorno = this.getResultSet().getInt(1);
            }
        }
        catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
        return idRetorno;
    }

    public boolean fecharConexao() {
        try {
            if (this.getResultSet() != null && this.statement != null) {
                this.getResultSet().close();
                this.statement.close();
            }
            this.getCon().close();
            return true;
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public Statement getStatement() {
        return this.statement;
    }

    public ResultSet getResultSet() {
        return this.resultSet;
    }

    public Connection getCon() {
        return this.con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
}

