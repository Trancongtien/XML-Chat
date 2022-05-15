package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Controller.FruitController;
import Controller.XMLFruit;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FruitPanel extends JPanel {
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtPrice;

	/**
	 * Create the panel.
	 */
	public FruitPanel() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(34, 41, 106, 13);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tên");
		lblNewLabel_1.setBounds(34, 97, 118, 13);
		add(lblNewLabel_1);

		JButton btNew = new JButton("Thêm");

		btNew.setBounds(244, 171, 185, 21);
		add(btNew);

		txtId = new JTextField();
		txtId.setBounds(162, 38, 145, 19);
		add(txtId);
		txtId.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(162, 94, 145, 19);
		add(txtName);
		txtName.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setBounds(403, 41, 118, 13);
		add(lblNewLabel_2);

		txtPrice = new JTextField();
		txtPrice.setBounds(546, 38, 134, 19);
		add(txtPrice);
		txtPrice.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(56, 231, 732, 329);
		add(panel);
		XMLFruit controller = new XMLFruit(panel, txtId, txtName, txtPrice, btNew);
		try {
			controller.XMLConnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
