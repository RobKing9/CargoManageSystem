package log;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

import cargomanage.CargoUI;

public class Login_Register extends JFrame {
	public Login_Register() {
		init();
	}
	public void init () {
		//设置窗口
		setTitle("登录注册");
		setBounds(500, 200, 500, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		add(panel);
		//组件
        JButton about = new JButton("关于");
        about.setBounds(0 ,0, 59, 22);
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //设置窗口L
                JFrame frame = new JFrame();
//                setTitle("关于");
                frame.setBounds(500, 200, 200, 250);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                //组件 北 中
                JTextField about1 = new JTextField("关于此货物管理系统");
                frame.add(about1, BorderLayout.NORTH);
                String str = "完成的功能如下\n1.用户可以进行登录和注册\n2.可以直接进行商品的录入\n3.可以进行商品的增删查改操作\n4.商品的信息以及登录的账号信息\n均保存在数据库中";
                JTextArea textArea = new JTextArea(str);
                frame.add(textArea, BorderLayout.CENTER);
                frame.setVisible(true);
            }

        });
        panel.add(about);

        JButton faceback = new JButton("反馈");
        faceback.setBounds(59, 0, 59, 22);
        faceback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "如在使用过程中有任何问题\n请联系开发者QQ2768817839", "反馈", JOptionPane.INFORMATION_MESSAGE);

            }

        });
        panel.add(faceback);
		JLabel head = new JLabel("货物管理系统");
		head.setBounds(185, 30, 150, 25 );
        head.setFont(new Font(null, Font.BOLD, 24));
//        head.setForeground(new Color(208, 2, 27 ));
        panel.add(head);
		JLabel  nameStr = new JLabel("账号:");
        nameStr.setBounds(150, 70, 100, 25);
        nameStr.setFont(new Font(null, Font.BOLD, 20));
        panel.add(nameStr);
        
        JLabel passwordStr = new JLabel("密码:");
        passwordStr.setBounds(150, 120, 100, 25);
        passwordStr.setFont(new Font(null, Font.BOLD, 20));
        panel.add(passwordStr);  
        
        JTextField userID = new JTextField();
        userID.setBounds(200, 70, 150, 25);
      //默认文字提示
        
        String hint2 = "请输入电 话号码";
        userID.setText(hint2);
        userID.addFocusListener(new FocusListener() {
		
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub 失焦
				if(userID.getText().equals(""))
					userID.setText(hint2);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub 聚焦
				 if(userID.getText().equals(hint2))
					 userID.setText("");
			}
		});
        panel.add(userID);
        
        JPasswordField password = new JPasswordField();
        password.setBounds(200, 120, 150, 25);
        panel.add(password);
        
        JButton buttonlogin = new JButton("登录");
        buttonlogin.setBounds(175, 170, 70, 25);
        panel.add(buttonlogin);

        //为登录按钮添加监听器
        buttonlogin.addActionListener(new ActionListener() {  
           public void actionPerformed(ActionEvent e) {
               String ID = userID.getText();
               String passwd = new String (password.getPassword());
                 
               //创建一个Admin用户，把输入框中的用户名密码和提出来
               Admin admin = new Admin();
               admin.setID(ID);
               admin.setPassword(passwd);
               
               //登录
               Login login = new Login();
               login.setAdmin(admin);
         
               if(login.JudgeAdmin()==0) {
               	//弹出账号或密码错误的窗口
               	JOptionPane.showMessageDialog(null, "账号或密码错误", "账号或密码错误", JOptionPane.WARNING_MESSAGE);
               	//清除密码框中的信息
               	password.setText("");
               	//清除账号框中的信息
//               	userID.setText("");
               	
               	//System.out.println("登陆失败");
               } else {
               	//弹出登录成功的窗口
               	JOptionPane.showMessageDialog(null, "登陆成功", "登陆成功", JOptionPane.NO_OPTION);
               	//点击确定后会跳转到主窗口
               	setVisible(false);
                CargoUI cargo = new CargoUI();
                cargo.setTitle("货物管理系统");
                cargo.setVisible(true);
                       
               }
              
           }
       });
        
        JButton buttonregister = new JButton("注册");
        buttonregister.setBounds(275, 170, 70, 25);
        panel.add(buttonregister);
        //为注册按钮添加监听器
        buttonregister.addActionListener(new ActionListener() {
       	 public void actionPerformed(ActionEvent e) {
       		 //注册页面
//                setVisible(false);
       		 AdminRegister ar = new AdminRegister(); 
       	 }
        });

        
		setVisible(true);
		password.requestFocus();
		
	}
}
