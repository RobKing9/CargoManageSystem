package cargomanage;

import infoin.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CargoUI extends JFrame{
    public CargoUI() {
        //设置窗口
        setBounds(400, 200, 500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置面板及背景图片
        Image image = new ImageIcon("image/bg2.jpg").getImage();
        JScrollPane scrollPane = new JScrollPane() {
            public void paintComponent(Graphics g) {
                g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
//        scrollPane.setBackground(new Color(121, 167, 219));
        add(scrollPane);

        //设置面板的布局
        scrollPane.setLayout(null);
        //组件
        JLabel info = new JLabel("欢迎进入货物管理系统");
        info.setBounds(135, 20, 300, 20);
        info.setFont(new Font(null, Font.PLAIN, 22));
        info.setForeground(new Color(208, 2, 27));
        scrollPane.add(info);

        //录入商品
        JButton infoin = new JButton("录入商品");
        infoin.setBounds(150, 70, 200, 50);
        infoin.setFont(new Font(null, Font.PLAIN, 20));
        //设置按钮的监听
        ActionListener infoinlitener = new InfoinListener();
        infoin.addActionListener(infoinlitener);
        scrollPane.add(infoin);

//        //显示商品
//        JButton show = new JButton("显示商品");
//        show.setBounds(150, 150, 200, 50);
//        show.setFont(new Font(null, Font.PLAIN, 20));
//        //设置监听
//        ActionListener showlistener = new ShowListener();
//        show.addActionListener(showlistener);
////        scrollPane.add(show);

        //修改商品
        JButton edit = new JButton("显示编辑商品");
        edit.setBounds(150, 150, 200, 50);
        edit.setFont(new Font(null, Font.PLAIN, 20));
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditUI scorelnfofFrame = new EditUI();
            }
        });
        //设置监听
//        ActionListener editlistener = new EditListener();
//        edit.addActionListener(editlistener);
        scrollPane.add(edit);

    }
}
