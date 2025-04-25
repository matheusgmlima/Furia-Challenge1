package src.main.Functions;

import src.main.Connection.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MelhoresCampeonatos {

    public static String listMelhoresCampeonatos() {
        StringBuilder resposta = new StringBuilder();

        try(Connection conn = Database.connect()){
            String sql = "SELECT * FROM campeonatos_furia ORDER BY colocacao";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                resposta.append("- ")
                        .append(rs.getString("colocacao"))
                        .append(" ")
                        .append(rs.getString("nome"))
                        .append(": ")
                        .append(" (entre: ")
                        .append(rs.getDate("data_inicio"))
                        .append(" - ")
                        .append(rs.getDate("data_fim"))
                        .append(")\n");
            }
        }
        catch(SQLException e){
            resposta.append("Erro ao listar a line");
        }
        return resposta.toString();
    }
}
