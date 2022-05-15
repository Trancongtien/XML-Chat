package View;

import javax.swing.JPanel;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;

import Chat.ClientChatter;
import Chat.ManagerChatter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChatView extends JPanel {
    public final static String SERVER_IP = "127.0.0.1";
    public final static int SERVER_PORT = 7; // Cổng mặc định của Echo Server
    public final static byte[] BUFFER = new byte[4096]; // Vùng đệm chứa dữ liệu cho gói tin nhận
    private JButton btnNewButton;
    private JButton btnNewButton_1;
 
	public ChatView() {
		setLayout(null);
		
		btnNewButton = new JButton("Staff");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientChatter frame = new ClientChatter();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(102, 203, 85, 21);
		add(btnNewButton);
		
		btnNewButton_1 = new JButton("Server");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerChatter frame = new ManagerChatter();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(330, 203, 85, 21);
		add(btnNewButton_1);

	}
}
