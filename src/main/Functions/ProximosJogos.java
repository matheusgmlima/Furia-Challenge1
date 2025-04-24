package src.main.Functions;

import src.main.Connection.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProximosJogos {

    public static String listarProximosJogos(){
        StringBuilder resposta = new StringBuilder();

        try(Connection conn = Database.connect()){
            String sql = "SELECT * FROM jogos_furia WHERE data_jogo >= CURDATE() ORDER BY data_jogo";

            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while(rs.next()) {
                resposta.append("- ")
                        .append(rs.getDate("data_jogo"))
                        .append(": vs ")
                        .append(rs.getString("adversario"))
                        .append(" (")
                        .append(rs.getString("torneio"))
                        .append(")\n");
            }
        } catch(SQLException e){
            resposta.append("Erro ao listar proximos jogos\n");
        }
        return resposta.toString();
    }
}
