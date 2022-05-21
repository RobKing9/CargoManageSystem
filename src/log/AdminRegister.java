package log;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;

import javax.swing.*;


public class AdminRegister {
	AdminRegister () {
		init();
	}
	void init() {

            JFrame frame = new JFrame("注册管理员账号") ;
//            frame.setLayout(null);
            //面板
    //		System.out.println(System.getProperty("java.class.path"));
            Image image = new ImageIcon("image/bg2.jpg").getImage();
            JPanel panel = new JPanel() {
                @Override
                public void paintComponent(Graphics g) {
                    g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
                }
            };
            panel.setLayout(null);
            frame.add(panel);

            
            JLabel nameStr = new JLabel("用户名:");
            nameStr.setBounds(130, 40, 100, 25);
            panel.add(nameStr);
        
            JLabel IDStr = new JLabel("账号:");
            IDStr.setBounds(130, 90, 100, 25);

            panel.add(IDStr);

            JLabel passwordStr = new JLabel("密码:");
            passwordStr.setBounds(130, 140, 100, 25);
            panel.add(passwordStr);
               
            JLabel confrimStr = new JLabel("确认密码:");
            confrimStr.setBounds(130, 190, 100, 30);
             panel.add(confrimStr);
            
            JTextField userName = new JTextField();
            userName.setBounds(200, 40, 150, 25);
            panel.add(userName);

            JTextField userID = new JTextField();
            userID.setBounds(200, 90, 150, 25);
          //设置提示语句
            String hint3 = "请输入电话号码";
            userID.setText(hint3);
            userID.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					if(userID.getText().equals("")) {
						userID.setText(hint3);
					}
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub
					if(userID.getText().equals(hint3)) {
						userID.setText("");
					}
					
				}
			});
            panel.add(userID);

            JPasswordField password = new JPasswordField();
            password.setBounds(200, 140, 150, 25);
            panel.add(password);

            JPasswordField confrimPassword = new JPasswordField();
            confrimPassword.setBounds(200, 190, 150, 25);
            panel.add(confrimPassword);
            
            JButton buttonregister = new JButton("注册");
            buttonregister.setBounds(230, 230, 70, 25);
            panel.add(buttonregister);
            


            frame.setBounds(400, 100, 500, 300);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
          //为注册按钮增加监听器
            buttonregister.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = userName.getText();
                    String ID = userID.getText();
                    String passwd = new String (password.getPassword());
                    String confrimpasswd = new String (confrimPassword.getPassword());
                    
                    //创建Register类
                    Register register = new Register();
                    register.setID(ID);
                    register.setName(name);
                    register.setPassword(passwd);
                    register.setconfirmpasswd(confrimpasswd);
                    
                    //如果注册成功，返回登录界面
                    try {
						if(register.JudgeRegister()) {

						    frame.setVisible(false);
						    Login_Register login_register = new Login_Register();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

                }
                
            });
	}
}
