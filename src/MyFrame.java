import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.TableModel;

public class MyFrame extends JFrame{
	
	Connection conn = null;
	PreparedStatement state = null;
	ResultSet result = null;
	ComboBox boxhelp = new ComboBox();
	int product_id = 0;
	int shop_id = 0;
	int employee_id = 0;
	
	/* JTabbedPane */
	JTabbedPane tabbedPane = new JTabbedPane();
	
	JPanel products = new JPanel();
	JPanel shop = new JPanel();
	JPanel employees = new JPanel();
	JPanel firstJoin = new JPanel();
	JPanel secondJoin = new JPanel();
	
	/* products */
	
	JTable table = new JTable();
	JScrollPane scroller = new JScrollPane(table);
	
	JPanel upPanel = new JPanel();
	JPanel midPanel = new JPanel();
	JPanel downPanel = new JPanel();
	JPanel btnPanel = new JPanel();
	JPanel statusPanel = new JPanel();
	
	JButton addBtn = new JButton("Add");
	JButton delBtn = new JButton("Delete");
	JButton editBtn = new JButton("Edit");
	JButton searchBtn = new JButton("Search");
	
	JLabel nameLabel = new JLabel("Name:");
	JLabel priceLabel = new JLabel("Price:");
	JLabel typeLabel = new JLabel("Type:");
	JLabel statusLabel = new JLabel();
	
	JTextField nameTField = new JTextField();
	JTextField priceTField = new JTextField();
	
	String[] content = {"","Clothes","Food","Makeup"};
	JComboBox<String> typeCombo = new JComboBox<>(content);
	
	/* shop */
	
	JTable tableShop = new JTable();
	JScrollPane scrollerShop = new JScrollPane(tableShop);
	
	JPanel upPanelShop = new JPanel();
	JPanel midPanelShop = new JPanel();
	JPanel downPanelShop = new JPanel();
	JPanel btnPanelShop = new JPanel();
	JPanel statusPanelShop = new JPanel();
	
	JButton addBtnShop = new JButton("Add");
	JButton delBtnShop = new JButton("Delete");
	JButton editBtnShop = new JButton("Edit");
	JButton searchBtnShop = new JButton("Search");
	
	JLabel nameLabelShop = new JLabel("Shop name:");
	JLabel addressLabel = new JLabel("Address:");
	JLabel productcomboLabel = new JLabel("Product:");
	
	JLabel statusLabelShop = new JLabel();

	JTextField nameTFieldShop = new JTextField();
	JTextField addressTField = new JTextField();
	
	JComboBox<String> productcombo = new JComboBox<String>(boxhelp.fillProductCombo("select PRODUCT_ID, NAME from products"));
	
	/* employees */
	
	JTable Employees = new JTable();
	JScrollPane scrollerEmployees = new JScrollPane(Employees);
	
	JPanel upPanelEmployees = new JPanel();
	JPanel midPanelEmployees = new JPanel();
	JPanel downPanelEmployees = new JPanel();
	JPanel btnPanelEmployees = new JPanel();
	JPanel statusPanelEmployees = new JPanel();
	
	JButton addBtnEmployees = new JButton("Add");
	JButton delBtnEmployees = new JButton("Delete");
	JButton editBtnEmployees = new JButton("Edit");
	JButton searchBtnEmployees = new JButton("Search");
	
	JLabel nameLabelEmployees = new JLabel("Name:");
	JLabel familyLabel = new JLabel("Family:");
	JLabel ageLabel = new JLabel("Age:");
	JLabel salaryLabel = new JLabel("Salary:");
	JLabel shopcomboLabel = new JLabel("Shop:");
	
	JLabel statusLabelEmployees = new JLabel();
	
	JTextField nameTFieldEmployees = new JTextField();
	JTextField familyTField = new JTextField();
	JTextField ageTField = new JTextField();
	JTextField salaryTField = new JTextField();
	
	JComboBox<String> shopcombo = new JComboBox<String>(boxhelp.fillShopComboBox("select SHOP_ID, SHOP_NAME from shop"));
	
	/* join1 */
	
	JPanel joinOneup = new JPanel();
	JPanel joinOnemid = new JPanel();
	JPanel joinOnedown = new JPanel();
	JTable join1 = new JTable();
	JScrollPane scrollerJoinOne = new JScrollPane(join1);
	JLabel productsShop = new JLabel("Products and Shop");
	
	JTextField nameshop = new JTextField();
	JTextField nameproduct = new JTextField();
	
	JLabel nameproduct1 = new JLabel("Product:");
	JLabel nameshop1 = new JLabel("Shop:");
	
	JButton show = new JButton("Show");
			
	/* join2 */
	
	JPanel joinTwo = new JPanel();
	JTable join2 = new JTable();
	JScrollPane scrollerJoinTwo = new JScrollPane(join2);
	JLabel shopEmployees = new JLabel("Shop and Employees");
	
	
	
	public MyFrame() {
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 800);
		this.setResizable(false);
        
		
		
		tabbedPane.add("Products", products);
		tabbedPane.add("Shop", shop);
		tabbedPane.add("Employees", employees);
		tabbedPane.add("Products & Shop", firstJoin);
		tabbedPane.add("Shop & Employees", secondJoin);
		
		this.add(tabbedPane);
		
		/* products */
		
		products.setLayout(new GridLayout(3, 1));
		
		products.add(upPanel);
		products.add(midPanel);
		products.add(downPanel);
		
		//upPanel
		upPanel.setLayout(new GridLayout(5, 2));
		upPanel.add(nameLabel);
		upPanel.add(nameTField);
		upPanel.add(priceLabel);
		upPanel.add(priceTField);
		upPanel.add(typeLabel);
		upPanel.add(typeCombo);
		
		//midPanel
		midPanel.add(btnPanel);
		midPanel.add(statusPanel);
		statusPanel.add(statusLabel);
		statusLabel.setForeground(Color.RED);
		typeLabel.setForeground(Color.RED);
		btnPanel.add(addBtn);
		btnPanel.add(delBtn);
		btnPanel.add(editBtn);
		btnPanel.add(searchBtn);
		addBtn.addActionListener(new AddAction());
		delBtn.addActionListener(new DeleteAction());
		editBtn.addActionListener(new EditAction());
		searchBtn.addActionListener(new SearchAction());
		
		//downPanel
		downPanel.add(scroller);
		scroller.setPreferredSize(new Dimension(700, 200));
		table.setModel(getDb());
		table.addMouseListener(new TableMouseAction());
		
		/* shop */
		
		shop.setLayout(new GridLayout(3, 1));
		
		shop.add(upPanelShop);
		shop.add(midPanelShop);
		shop.add(downPanelShop);
		
		// upPanelShop
		upPanelShop.setLayout(new GridLayout(4, 2));
		upPanelShop.add(nameLabelShop);
		upPanelShop.add(nameTFieldShop);
		upPanelShop.add(addressLabel);
		upPanelShop.add(addressTField);
		upPanelShop.add(productcomboLabel);
		upPanelShop.add(productcombo);
		
		
		// middlePanelShop
		midPanelShop.add(btnPanelShop);
		midPanelShop.add(statusPanelShop);
		statusPanelShop.add(statusLabelShop);
		statusLabelShop.setForeground(Color.RED);
		productcomboLabel.setForeground(Color.RED);
		btnPanelShop.add(addBtnShop);
		btnPanelShop.add(delBtnShop);
		btnPanelShop.add(editBtnShop);			
		btnPanelShop.add(searchBtnShop);
		
		addBtnShop.addActionListener(new AddActionShop());	
		delBtnShop.addActionListener(new DeleteActionShop());
		editBtnShop.addActionListener(new EditActionShop());
		searchBtnShop.addActionListener(new SearchActionShop());
		
		// downPanelShop
		scrollerShop.setPreferredSize(new Dimension(700, 200));
		downPanelShop.add(scrollerShop);
		tableShop.setModel(ShopgetDb());
		tableShop.addMouseListener(new TouchTableShop());
		
		/* employees */
		
		employees.setLayout(new GridLayout(3, 1));
		
		employees.add(upPanelEmployees);
		employees.add(midPanelEmployees);
		employees.add(downPanelEmployees);
		
		// upPanelEmployees
		upPanelEmployees.setLayout(new GridLayout(5, 2));
		upPanelEmployees.add(nameLabelEmployees);
		upPanelEmployees.add(nameTFieldEmployees);
		upPanelEmployees.add(familyLabel);
		upPanelEmployees.add(familyTField);
		upPanelEmployees.add(ageLabel);
		upPanelEmployees.add(ageTField);
		upPanelEmployees.add(salaryLabel);
		upPanelEmployees.add(salaryTField);
		upPanelEmployees.add(shopcomboLabel);
		upPanelEmployees.add(shopcombo);
		
		// middlePanelEmployees
		midPanelEmployees.add(btnPanelEmployees);
		midPanelEmployees.add(statusPanelEmployees);
		statusPanelEmployees.add(statusLabelEmployees);
		statusLabelEmployees.setForeground(Color.RED);
		shopcomboLabel.setForeground(Color.RED);
		btnPanelEmployees.add(addBtnEmployees);
		btnPanelEmployees.add(delBtnEmployees);
		btnPanelEmployees.add(editBtnEmployees);
		btnPanelEmployees.add(searchBtnEmployees);
		addBtnEmployees.addActionListener(new AddActionEmployess());
		delBtnEmployees.addActionListener(new DeleteActionEmployees());
		editBtnEmployees.addActionListener(new EditActionEmployees());	
		searchBtnEmployees.addActionListener(new SearchActionEmployees());
		
		// downPanelEmployees
		scrollerEmployees.setPreferredSize(new Dimension(700, 150));
		downPanelEmployees.add(scrollerEmployees);
		Employees.setModel(EmployeesgetDb());
		Employees.addMouseListener(new TouchTableEmployees());
		
		/* join1 */

		firstJoin.setLayout(new GridLayout(3,1));
		firstJoin.add(joinOneup);
		firstJoin.add(joinOnemid);
		firstJoin.add(joinOnedown);
		
		joinOnedown.add(productsShop);
		scrollerJoinOne.setPreferredSize(new Dimension(700, 200));
		joinOnedown.add(scrollerJoinOne);
		join1.setModel(joinOneGetDB());
		
		
		joinOneup.setLayout(new GridLayout(5,2));		
		joinOneup.add(nameshop1);
	
		joinOneup.add(nameshop);
		
		joinOneup.add(nameproduct1);
		joinOneup.add(nameproduct);
		joinOnemid.add(show);
		show.setPreferredSize(new Dimension(200, 60));
		show.addActionListener(new ShowActionJoin1());
	
				
		/* join2 */

		secondJoin.setLayout(new GridLayout(2,1));
		secondJoin.add(joinTwo);
		joinTwo.add(shopEmployees);
		scrollerJoinTwo.setPreferredSize(new Dimension(700, 550));
		joinTwo.add(scrollerJoinTwo);
		join2.setModel(joinTwoGetDB());
		
		
	}//end constructor
	
	
     /* PRODUCTS */
	
	public void refreshComboProducts() {
		productcombo.removeAllItems();
		String sql="select product_id, name from products";
		conn=DBConnector.getConnection();
		String item=" ";
		try {
			state=conn.prepareStatement(sql);
			result=state.executeQuery();
			while(result.next())
			{
				item=result.getInt("PRODUCT_ID") + "." + result.getString("NAME");
				productcombo.addItem(item);
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
				
	}
	
	class AddAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = nameTField.getText();
			Float price = Float.parseFloat(priceTField.getText());
			String type = typeCombo.getSelectedItem().toString();
			String sql = "insert into products values (null,?,?,?);";
			
			conn = DBConnector.getConnection();
			try {
				state = conn.prepareStatement(sql);
				state.setString(1, name);
				state.setFloat(2, price);
				state.setString(3, type);
				state.execute();
				statusLabel.setText("New product is added!");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}finally {
				try {
					state.close();
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			productcombo = new JComboBox<String>(boxhelp.fillProductCombo("select PRODUCT_ID, NAME from products"));
			
			clearForm();
			/* refresh table */
			table.setModel(getDb());
			refreshComboProducts();
			
		}
		
	}//end AddAction
	
	public void clearForm() {
		nameTField.setText("");
		priceTField.setText("");
		typeCombo.setSelectedIndex(0);
	}
	
	 public MyModel getDb() {
		conn = DBConnector.getConnection();
		String sql = "select * from products";
		try {
			state = conn.prepareStatement(sql);
		   result = state.executeQuery();
			return (new MyModel(result));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	} 
	 
	 public MyModel getSearch(float price) {
			conn = DBConnector.getConnection();
			String sql = "select * from products where price = ? ";
			try {
				state = conn.prepareStatement(sql);
				state.setFloat(1, price);
				ResultSet result = state.executeQuery();
				return (new MyModel(result));
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	
	
	class SearchAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Float price = Float.parseFloat(priceTField.getText());

			conn = DBConnector.getConnection();
			String sql = "select * from products where price = ? ";
			try {
				state = conn.prepareStatement(sql);

				state.setFloat(1, price);

				state.execute();
				clearForm();
				table.setModel(getSearch(price));

				statusLabel.setText("The search is ready!");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}

	}
	
	class EditAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String name = nameTField.getText();
			float price = Float.parseFloat(priceTField.getText());
			String type = (typeCombo.getSelectedItem()).toString();

			conn = DBConnector.getConnection();
			String sql = "update products set name=?, price=?, type=? where PRODUCT_ID=? ";
			try {
				state = conn.prepareStatement(sql);
				state.setString(1, name);
				state.setFloat(2, price);
				state.setString(3, type);
				state.setInt(4, product_id);
				state.execute();
				clearForm();
				table.setModel(getDb());
				refreshComboProducts();
				statusLabel.setText("Product is updated!");
				product_id = 0;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	class DeleteAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String sql = "delete from products where PRODUCT_ID=?";
			conn = DBConnector.getConnection();
			
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, product_id);
				state.execute();
				table.setModel(getDb());
				refreshComboProducts();
				statusLabel.setText("Product is deleted!");
				product_id=0;
				clearForm();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	class TableMouseAction implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();
			Object idObject = table.getValueAt(row, 0);
			product_id = Integer.parseInt((idObject.toString()));
			if (e.getClickCount() > 1) {
				nameTField.setText(table.getValueAt(row, 1).toString());
				priceTField.setText(table.getValueAt(row, 2).toString());
				String type = table.getValueAt(row, 3).toString();
				if (type.equals("Clothes")) {
					typeCombo.setSelectedIndex(1);
				}
				if (type.equals("Food")) {
					typeCombo.setSelectedIndex(2);
				}
				if (type.equals("Makeup")) {
					typeCombo.setSelectedIndex(3);
				}
				if (type.equals("")) {
					typeCombo.setSelectedIndex(0);
				}

			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	/* SHOP */
	
	public void refreshComboShop() {
		shopcombo.removeAllItems();
		String sql="select shop_id, shop_name from shop";
		conn=DBConnector.getConnection();
		String item=" ";
		try {
			state=conn.prepareStatement(sql);
			result=state.executeQuery();
			while(result.next())
			{
				item=result.getInt("SHOP_ID") + "." + result.getString("SHOP_NAME");
				shopcombo.addItem(item);
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
				
	}
	
	
	class AddActionShop implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = nameTFieldShop.getText();
			String address = addressTField.getText();
			String product = productcombo.getSelectedItem().toString();
			String product_id = product.substring(0,product.indexOf("."));
			System.out.println(product_id);
			String sql = "insert into shop values (null,?,?,?);";
			
			conn = DBConnector.getConnection();
			try {
				state = conn.prepareStatement(sql);
				state.setString(1, name);
				state.setString(2, address);
				state.setString(3, product_id);
				state.execute();
				statusLabelShop.setText("New shop is added!");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}finally {
				try {
					state.close();
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			clearFormShop();
			/* refresh table */
			tableShop.setModel(ShopgetDb());
			refreshComboShop();
			
		}
		
}//end AddAction
	
	public void clearFormShop() {
		nameTFieldShop.setText("");
		addressTField.setText("");
		productcombo.setSelectedIndex(0);

	}
	
    public MyModel ShopgetDb() {
		
		String sql = "select shop_id, shop_name, address, "
				+ " name "
				+ " from products join shop "
				+ " on products.product_id = shop.product_id ";
		
		conn = DBConnector.getConnection();
		try {
			state = conn.prepareStatement(sql);
			ResultSet result = state.executeQuery();
			return (new MyModel(result));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	class TouchTableShop implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			int row = tableShop.getSelectedRow();
			Object idObject = tableShop.getValueAt(row, 0);
			shop_id = Integer.parseInt((idObject.toString()));
			if (e.getClickCount() > 1) {
				nameTFieldShop.setText(tableShop.getValueAt(row, 1).toString());
				addressTField.setText(tableShop.getValueAt(row, 2).toString());
				productcombo.setSelectedItem(tableShop.getValueAt(row, 3).toString());

			}

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
	}
	
	class DeleteActionShop implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			conn = DBConnector.getConnection();
			String sql = "delete from shop where shop_id = ?";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, shop_id);
				state.execute();
				tableShop.setModel(ShopgetDb());
				refreshComboShop();
				statusLabelShop.setText("Shop is deleted!");
				shop_id = 0;
				clearFormShop();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
	
	class EditActionShop implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String name = nameTFieldShop.getText();
			String address = addressTField.getText();
            String product = productcombo.getSelectedItem().toString();
            String product_id = product.substring(0,product.indexOf("."));

			conn = DBConnector.getConnection();
			String sql = "update shop set shop_name=?, address=?, product_id=? where shop_id=?";
			try {
				state = conn.prepareStatement(sql);
				state.setString(1, name);
				state.setString(2, address);
				state.setString(3, product_id);
				state.setInt(4, shop_id);
				state.execute();
				clearFormShop();
				tableShop.setModel(ShopgetDb()); 
				refreshComboShop();
				statusLabelShop.setText("Shop is updated!");
				shop_id = 0;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	public MyModel getSearchS(String name) {
		conn = DBConnector.getConnection();
		String sql = "select shop_id, shop_name, address, "
				+ " name "
				+ " from products join shop "
				+ " on products.product_id = shop.product_id "
				+ " where shop_name = ? ";
		try {
			state = conn.prepareStatement(sql);
			state.setString(1, name);
			ResultSet result = state.executeQuery();
			return (new MyModel(result));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	class SearchActionShop implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String name = nameTFieldShop.getText();

			conn = DBConnector.getConnection();
			String sql = "select shop_id, shop_name, address, "
					+ " name "
					+ " from products join shop "
					+ " on products.product_id = shop.product_id "
					+ " where shop_name = ? ";
			try {
				state = conn.prepareStatement(sql);

				state.setString(1, name);

				state.execute();
				clearFormShop();
				tableShop.setModel(getSearchS(name)); 

				statusLabelShop.setText("The search is ready!");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}

	}
	
	/* EMPLOYEES */
	
	class AddActionEmployess implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = nameTFieldEmployees.getText();
			String family = familyTField.getText();
			int age = Integer.parseInt(ageTField.getText());
			float salary = Float.parseFloat(salaryTField.getText());
			String shop = (shopcombo.getSelectedItem()).toString();
			String shop_id = shop.substring(0,shop.indexOf("."));

			String sql = "insert into employees values(null,?,?,?,?,?);";
			conn = DBConnector.getConnection();

			try {
				state = conn.prepareStatement(sql);
				state.setString(1, name);
				state.setString(2, family);
				state.setInt(3, age);
				state.setFloat(4, salary);
				state.setString(5, shop_id);
				state.execute();
				statusLabelEmployees.setText("New employee is added!");
				clearFormEmployees();
				Employees.setModel(EmployeesgetDb());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}
	
	public void clearFormEmployees() {
		nameTFieldEmployees.setText("");
		familyTField.setText("");
		ageTField.setText("");
		salaryTField.setText("");
		shopcombo.setSelectedIndex(0);

	}
	
	public MyModel EmployeesgetDb() {
		conn = DBConnector.getConnection();
		String sql = "select employee_id, employee_name, family, age, salary, "
				+ " shop_name "
				+ " from employees join shop "
				+ " on shop.shop_id = employees.shop_id ";
		
		try {
			state = conn.prepareStatement(sql);
			ResultSet result = state.executeQuery();
			return (new MyModel(result));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	class TouchTableEmployees implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			int row = Employees.getSelectedRow();
			Object idObject = Employees.getValueAt(row, 0);
			employee_id = Integer.parseInt((idObject.toString()));
			if (e.getClickCount() > 1) {
				nameTFieldEmployees.setText(Employees.getValueAt(row, 1).toString());
				familyTField.setText(Employees.getValueAt(row, 2).toString());
				ageTField.setText(Employees.getValueAt(row, 3).toString());
				salaryTField.setText(Employees.getValueAt(row, 4).toString());
			}

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
	}
	
	class DeleteActionEmployees implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			conn = DBConnector.getConnection();
			String sql = "delete from employees where employee_id = ?";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, employee_id);
				state.execute();
				Employees.setModel(EmployeesgetDb());
				statusLabelEmployees.setText("Employee is deleted!");
				employee_id = 0;
				clearFormEmployees();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
	
	class EditActionEmployees implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String name = nameTFieldEmployees.getText();
			String family = familyTField.getText();
			int age = Integer.parseInt(ageTField.getText());
			float salary = Float.parseFloat(salaryTField.getText());
			String shop = (shopcombo.getSelectedItem()).toString();
			String shop_id = shop.substring(0,shop.indexOf("."));
			
			conn = DBConnector.getConnection();
			String sql = "update employees set employee_name=?, family=?, age=?, salary=?, shop_id=? where employee_id=?";
			try {
				state = conn.prepareStatement(sql);
				state.setString(1, name);
				state.setString(2, family);
				state.setInt(3, age);
				state.setFloat(4, salary);
				state.setString(5, shop_id);
				state.setInt(6, employee_id);
				state.execute();
				clearFormEmployees();
				Employees.setModel(EmployeesgetDb());
				statusLabelEmployees.setText("Employee is updated!");
				employee_id = 0;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

   public MyModel getSearchE(Float salary) {
	conn = DBConnector.getConnection();
	String sql = "select employee_id, employee_name, family, age, salary, "
			+ " shop_name "
			+ " from employees join shop "
			+ " on employees.shop_id = shop.shop_id "
			+ " where salary = ? ";
	try {
		state = conn.prepareStatement(sql);
		state.setFloat(1, salary);
		ResultSet result = state.executeQuery();
		return (new MyModel(result));
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}
	
	class SearchActionEmployees implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Float salary = Float.parseFloat(salaryTField.getText());

			conn = DBConnector.getConnection();
			String sql = "select employee_id, employee_name, family, age, salary, "
					+ " shop_name "
					+ " from employees join shop "
					+ " on employees.shop_id = shop.shop_id "
					+ " where salary = ? ";
			try {
				state = conn.prepareStatement(sql);

				state.setFloat(1, salary);

				state.execute();
				clearFormEmployees();
				Employees.setModel(getSearchE(salary));

				statusLabelEmployees.setText("The search is ready!");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} 
	
	}
	
	   class ShowActionJoin1 implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = nameproduct.getText();
				String shop_name = nameshop.getText();

				conn = DBConnector.getConnection();
				String sql = "select name, price, type, "
						+ " shop_name, address "
						+ " from products join shop "
						+ " on products.product_id = shop.product_id "
						+ " where name = ? and shop_name = ? ";
				try {
					state = conn.prepareStatement(sql);

					state.setString(1, name);
					state.setString(2, shop_name);

					result=state.executeQuery();
					clearFormJoin1();
					join1.setModel(new MyModel(result));

				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		
		}
	
	public void clearFormJoin1() {
		nameTField.setText("");
		nameTFieldShop.setText("");
	} 
	

	
	public MyModel joinOneGetDB() {
		conn = DBConnector.getConnection();
		String sql = "select name, price, type, "
				+ " shop_name, address "
				+ " from products join shop "
				+ " on products.product_id = shop.product_id ";
		
		try {
			state = conn.prepareStatement(sql);
			result = state.executeQuery();
			return (new MyModel(result));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	} 

	public MyModel joinTwoGetDB() {
		conn = DBConnector.getConnection();
		String sql = "select shop_name, address,"
				+ " employee_name, family, age, salary"
				+ " from shop join employees"
				+ " on shop.shop_id = employees.shop_id";
		try {
			state = conn.prepareStatement(sql);
			result = state.executeQuery();
			return (new MyModel(result));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}//end class MyFrame
