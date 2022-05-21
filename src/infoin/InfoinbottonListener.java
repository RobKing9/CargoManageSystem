package infoin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InfoinbottonListener implements ActionListener {
    private JLabel id, name, price, nums;
    private JTextField idtext, nametext, pricetext, numstext;
    public InfoinbottonListener(JLabel labels[], JTextField text[]){
        id = labels[0];
        name = labels[1];
        price = labels[2];
        nums = labels[3];
        idtext = text[0];
        nametext = text[1];
        pricetext = text[2];
        numstext = text[3];
    }
    //JDBC驱动程序
    String driver1 = "com.mysql.cj.jdbc.Driver";
    //连接数据库
    String uri = "jdbc:mysql://localhost:3306/goods?serverTimezone=UTC&characterEncoding=utf-8";
    //数据库账号密码
    String usename = "root";
    String passwString = "LKD2020.0921.";
    //
    @Override
    public void actionPerformed(ActionEvent e) {
    	//向数据库goods添加商品信息
    	//sql语句
    	String sqlString = "insert into goods values (?,?,?,?)";
    	
    	try {
    		//加载JDBC程序
			Class.forName(driver1);
			//连接代码
			Connection con1 = DriverManager.getConnection(uri, usename, passwString);
			//向数据库发送sql语句
			PreparedStatement ps = con1.prepareStatement(sqlString);
			//存放数据
			ps.setString(1, idtext.getText());
			ps.setString(2, nametext.getText());
			ps.setString(3, pricetext.getText());
			ps.setString(4, numstext.getText());
//			System.out.println(idtext.getText());
			//关闭连接
			ps.executeUpdate();
			ps.close();
			con1.close();
			idtext.setText("");
            nametext.setText("");
            pricetext.setText("");
            numstext.setText("");
			JOptionPane.showMessageDialog(null, "录入成功");
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
//			JOptionPane.showMessageDialog(null, "录入失败");
			System.out.println("录入失败");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
//			JOptionPane.showMessageDialog(null, "录入失败");
			System.out.println("录入失败");
		}
    	
    }
}
