package src.main.Functions;

import src.main.Connection.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class UltimosJogos {

    public static String listarUltimosJogos(){
        StringBuilder resposta = new StringBuilder();

        try(Connection conn = Database.connect()){
            String sql = "SELECT * FROM jogos_furia WHERE data_jogo <= CURDATE() ORDER BY data_jogo";
            creatingResponseMethod(resposta, conn, sql);
        } catch(SQLException e){
            resposta.append("Erro ao listar ultimos jogos\n");
        }
        return resposta.toString();
    }


    public static String listarUltimos5Jogos(){
        StringBuilder resposta = new StringBuilder();

        try(Connection conn = Database.connect()){
            String sql = "SELECT * FROM jogos_furia WHERE data_jogo <= CURDATE() ORDER BY data_jogo DESC LIMIT 5";
            creatingResponseMethod(resposta, conn, sql);
        } catch(SQLException e){
            resposta.append("Erro ao listar ultimos jogos\n");
        }
        return resposta.toString();
    }

    private static void creatingResponseMethod(StringBuilder resposta, Connection conn, String sql) throws SQLException {
        PreparedStatement st = conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();


        while(rs.next()) {
            resposta.append("- ")
                    .append(rs.getDate("data_jogo"))
                    .append(":")
                    .append("\nFURIA vs ")
                    .append(rs.getString("adversario"))
                    .append(" - ")
                    .append(rs.getString("resultado"))
                    .append(" (")
                    .append(rs.getString("torneio"))
                    .append(")\n");
        }
    }
}
