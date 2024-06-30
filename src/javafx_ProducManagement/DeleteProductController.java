package javafx_ProducManagement;

import java.sql.ResultSet;
import java.sql.SQLException;

import Common.DBUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class DeleteProductController {
	@FXML
	TextField deleteproduct;
	@FXML
	Label errormessage;
	
	public void deleteProduct() throws SQLException
	{
		String deleteQuery="delete from product where productName='"+deleteproduct.getText()+"'";
		DBUtil.executeQuery(deleteQuery);
		String checkQuery="select * from product where productName='"+deleteproduct.getText()+"'";
		ResultSet deleteResultSet=DBUtil.executeSelectQuery(checkQuery);
		if(deleteResultSet.next())
		{
			errormessage.setText("Delete Product Unsuccessfully..!");
			errormessage.setTextFill(Color.RED);
		}
		else
		{
			errormessage.setText("Delete Product Successfully..!");
			errormessage.setTextFill(Color.GREEN);
		}
	}
	public void backButton()
	{
		ProductManagementView.showBackUnderProductManagement();
	}

}
