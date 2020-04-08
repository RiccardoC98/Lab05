package DAO;
import java.sql.*;

public class MarkDAO {
	
	public boolean esiste(String parola) {
		String sql = "SELECT nome FROM parola WHERE nome = ?";
		boolean result = false;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, parola);
			
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				result = true;
			}
			
			conn.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
