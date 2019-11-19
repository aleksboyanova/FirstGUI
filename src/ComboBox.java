import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ComboBox {
	static Connection conn = null;
	static PreparedStatement state = null;
	static ResultSet result = null;
	public String[] fillShopComboBox(String sql) {
		ArrayList<String> shopList = new ArrayList<>();
		
		conn = DBConnector.getConnection();
		try {
			state = conn.prepareStatement(sql);
			result = state.executeQuery();
			while(result.next()) {
				shopList.add(result.getInt("SHOP_ID") + "." + result.getString("SHOP_NAME"));
			}
		}catch (SQLException e1){
			e1.printStackTrace();
		}
		
		String[] names = new String[shopList.size() + 1];
		for(int i = 0; i < shopList.size(); i++) {
			names[i+1] = shopList.get(i);
		}
		return names;
	}
	
	public String[] fillProductCombo(String sql) {
		ArrayList<String> productList = new ArrayList<>();
		
		conn = DBConnector.getConnection();
		try {
			state = conn.prepareStatement(sql);
			result = state.executeQuery();
			while(result.next()) {
				productList.add(result.getInt("PRODUCT_ID") + "." + result.getString("NAME"));
			}
		}catch (SQLException e1){
			e1.printStackTrace();
		}
		
		String[] namesP = new String[productList.size() + 1];
		for(int i = 0; i < productList.size(); i++) {
			namesP[i+1] = productList.get(i);
		}
		return namesP;
	}
   
}
