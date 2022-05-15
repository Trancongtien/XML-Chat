package View;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import Bean.DanhMucBean;
import Controller.ChuyenManHinhController;

import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel lbMain;
	private JPanel pnTraiCay;
	private JPanel pnChat;
	private JPanel pnMenu1;
	private JPanel pnView;
	private JPanel pnMenu;
	private JLabel lbMenu1;
	private JLabel lbChat;

	public MainFrame() {
		setTitle("Quan Ly Thu Vien");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		pnMenu = new JPanel();
		pnMenu.setBackground(Color.DARK_GRAY);
		pnMenu.setBorder(new LineBorder(new Color(0, 0, 0)));

		pnView = new JPanel();
		pnView.setBorder(new LineBorder(new Color(0, 0, 0)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(pnMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(pnView, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addComponent(pnView, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
				.addComponent(pnMenu, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE));

		pnTraiCay = new JPanel();
		pnTraiCay.setBackground(Color.RED);

		pnMenu1 = new JPanel();
		pnMenu1.setBackground(Color.GREEN);

		pnChat = new JPanel();
		pnChat.setBackground(Color.GREEN);
		
		GroupLayout gl_pnMenu = new GroupLayout(pnMenu);
		gl_pnMenu.setHorizontalGroup(
			gl_pnMenu.createParallelGroup(Alignment.TRAILING)
				.addComponent(pnMenu1, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
				.addComponent(pnTraiCay, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
				.addComponent(pnChat, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
		);
		gl_pnMenu.setVerticalGroup(
			gl_pnMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnMenu.createSequentialGroup()
					.addComponent(pnTraiCay, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(112)
					.addComponent(pnMenu1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(59)
					.addComponent(pnChat, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(207, Short.MAX_VALUE))
		);
		pnChat.setLayout(new BorderLayout(0, 0));

		lbChat = new JLabel("Chat");
		lbChat.setBackground(Color.GREEN);
		lbChat.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbChat.setHorizontalAlignment(SwingConstants.CENTER);
		pnChat.add(lbChat);
		pnMenu1.setLayout(new BorderLayout(0, 0));

		lbMenu1 = new JLabel("Menu");
		lbMenu1.setBackground(Color.GREEN);
		lbMenu1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbMenu1.setHorizontalAlignment(SwingConstants.CENTER);
		pnMenu1.add(lbMenu1);
		pnTraiCay.setLayout(new BorderLayout(0, 0));

		lbMain = new JLabel("Trái Cây");
		lbMain.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbMain.setHorizontalAlignment(SwingConstants.CENTER);
		pnTraiCay.add(lbMain);
		pnMenu.setLayout(gl_pnMenu);
		getContentPane().setLayout(layout);

		pack();
		ChuyenManHinhController controller = new ChuyenManHinhController(pnView);
		controller.setView(pnMenu1, lbMenu1);
		List<DanhMucBean> listItem = new ArrayList<>();
		listItem.add(new DanhMucBean("Menu", pnMenu1, lbMenu1));
		listItem.add(new DanhMucBean("Chat", pnChat, lbChat));
		controller.setEvent(listItem);
	}
}
