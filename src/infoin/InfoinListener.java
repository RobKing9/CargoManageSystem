package infoin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class InfoinListener extends JFrame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        //设置窗口
        setTitle("录入商品");
        setBounds(400, 200, 500, 300);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        //面板 背景图片
        Image image = new ImageIcon("image/bg2.jpg").getImage();
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        panel.setLayout(null);
        add(panel);

        /*
        组件
         */
        //序号
        JLabel id = new JLabel("序号");
        id.setBounds(150, 30, 50, 20);
        id.setFont(new Font(null, Font.BOLD, 20));
        panel.add(id);
        //序号对应的输入框
        JTextField idtext = new JTextField();
        idtext.setBounds(230,30, 110,20);
        //默认文字提示
        String hint1 = "请输入类001序号";
        idtext.setText(hint1);
        idtext.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub 失焦
				if(idtext.getText().equals(""))
                    idtext.setText(hint1);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub 聚焦
				 if(idtext.getText().equals(hint1))
	                    idtext.setText("");
			}
		});
//        idtext.setFont(new Font(null, Font.PLAIN, 24));
        panel.add(idtext);
        //商品名
        JLabel name = new JLabel("商品名");
        name.setFont(new Font(null, Font.BOLD, 20));
        name.setBounds(150, 80, 80, 20);
        panel.add(name);
        //商品名对应的输入框
        JTextField nametext = new JTextField();
        nametext.setBounds(230,80,110,20);
//        nametext.setFont(new Font(null, Font.PLAIN, 24));
        panel.add(nametext);
        //价格
        JLabel price = new JLabel("价格");
        price.setFont(new Font(null, Font.BOLD, 20));
        price.setBounds(150, 130, 80, 20);
        panel.add(price);
        //价格对应的输入框
        JTextField pricetext = new JTextField();
        pricetext.setBounds(230,130,110,20);
//        pricetext.setFont(new Font(null, Font.PLAIN, 24));
        panel.add(pricetext);
        //数量
        JLabel nums = new JLabel("数量");
        nums.setFont(new Font(null, Font.BOLD, 20));
        nums.setBounds(150, 180, 80, 20);
        panel.add(nums);
        //数量对应的输入框
        JTextField numstext = new JTextField();
        numstext.setBounds(230,180,110,20);
//        numstext.setFont(new Font(null, Font.PLAIN, 24));
        panel.add(numstext);
        //确定按钮
        JButton infoinbotton = new JButton("确定");
        infoinbotton.setBounds(200, 230, 100, 30);
        infoinbotton.setFont(new Font(null, Font.PLAIN, 24));
        //设置确定按钮的监听器
        JLabel label[] = {id, name, price, nums};
        JTextField text[] = {idtext, nametext, pricetext, numstext};
        ActionListener infoinbottonListener = new InfoinbottonListener(label, text);
        infoinbotton.addActionListener(infoinbottonListener);
        panel.add(infoinbotton);
        //窗口可见
        setVisible(true);
    }
}
