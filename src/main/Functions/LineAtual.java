package src.main.Functions;

import src.main.Connection.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LineAtual {

    public static String getLineAtual(){
        StringBuilder resposta = new StringBuilder();

        try(Connection conn = Database.connect()){
            String sql = "SELECT * FROM lineup_furia";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                resposta.append("- ")
                        .append(rs.getString("nickname"))
                        .append(": ")
                        .append(rs.getString("funcao"))
                        .append(" (since: ")
                        .append(rs.getDate("desde"))
                        .append(")\n");
            }
        }
        catch(SQLException e){
            resposta.append("Erro ao listar a line");
        }
        return resposta.toString();
    }
}
