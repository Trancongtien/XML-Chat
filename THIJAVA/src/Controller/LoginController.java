package Controller;

import javax.swing.*;

import Model.Account;
import Service.LoginService;
import Service.LoginServiceImpl;
import View.MainFrame;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginController  {
	private JDialog dialog;
	private JButton login;
	private JTextField txtuser;
	private JPasswordField txtpass;
	private JLabel lberror;

	private LoginService logInService = null;

	public LoginController(JDialog dialog, JButton login, JTextField txtuser, JPasswordField txtpass,
			JLabel lbrror) {
		this.dialog = dialog;
		this.login = login;
		this.txtuser = txtuser;
		this.txtpass = txtpass;
		this.lberror = lbrror;

		logInService = new LoginServiceImpl();
	}

	
	public void setEvent() {
		
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (txtuser.getText().length() == 0 || String.valueOf(txtpass.getPassword()).length() == 0) {
					lberror.setText("Vui lòng nhập dữ liệu bắt buộc!");
				} else {
					Account tk =logInService.login(txtuser.getText(), String.valueOf(txtpass.getPassword()));
					if (tk == null) {
						lberror.setText("Tên Đăng Nhập hoặc Mật Khẩu không đúng");

					} else {
						dialog.dispose();
						MainFrame frame = new MainFrame();
						frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
						frame.setVisible(true);
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				login.setBackground(new Color(0, 200, 83));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				login.setBackground(new Color(100, 221, 23));
			}

		});
		txtpass.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				  if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						if (txtuser.getText().length() == 0 || String.valueOf(txtpass.getPassword()).length() == 0) {
							lberror.setText("Vui lòng nhập dữ liệu bắt buộc!");
						} else {
							Account tk =logInService.login(txtuser.getText(), String.valueOf(txtpass.getPassword()));
							if (tk == null) {
								lberror.setText("Tên Đăng Nhập hoặc Mật Khẩu không đúng");

							} else {
								dialog.dispose();
								MainFrame frame = new MainFrame();
								frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
								frame.setVisible(true);
							}
						}
			}
			}
		});
	}
	
}
