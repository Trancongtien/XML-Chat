package Login;

import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import Controller.LoginController;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class login extends JDialog {
	private static final long serialVersionUID = 1L;
    private javax.swing.JButton btLogin;
    private javax.swing.JLabel lbView;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbuser;
    private javax.swing.JLabel lbpass;
    private javax.swing.JLabel lberror;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuser;

	public login(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		jPanel1 = new javax.swing.JPanel();
        lbView = new javax.swing.JLabel();
        pnMain = new javax.swing.JPanel();
        pnMain.setBackground(Color.GREEN);
        jLabel5 = new javax.swing.JLabel();
        lbuser = new javax.swing.JLabel();

        lbuser.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lbpass = new javax.swing.JLabel();
        lbpass.setFont(new Font("Times New Roman", Font.BOLD, 14));
        txtuser = new javax.swing.JTextField();
        txtuser.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        txtpass = new javax.swing.JPasswordField();
        txtpass.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btLogin = new javax.swing.JButton();
        btLogin.setBackground(Color.WHITE);
        btLogin.setForeground(Color.BLACK);
        btLogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lberror = new javax.swing.JLabel();
        lberror.setForeground(Color.RED);
        lberror.setFont(new Font("Arial", Font.PLAIN, 13));
        lberror.setHorizontalAlignment(SwingConstants.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);


        jLabel5.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("QUẢN LÝ TRÁI CÂY");

        lbuser.setText("Tên Đăng Nhập :");

        lbpass.setText("Mật Khẩu : ");

        btLogin.setText("Đăng Nhập");

        lberror.setText("Vui lòng nhập thông tin đăng nhập");

        javax.swing.GroupLayout gl_pnMain = new javax.swing.GroupLayout(pnMain);
        gl_pnMain.setHorizontalGroup(
        	gl_pnMain.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_pnMain.createSequentialGroup()
        			.addGap(157)
        			.addGroup(gl_pnMain.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pnMain.createSequentialGroup()
        					.addComponent(lbuser, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(txtuser))
        				.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_pnMain.createSequentialGroup()
        					.addComponent(lbpass, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(txtpass)))
        			.addContainerGap(158, Short.MAX_VALUE))
        		.addGroup(gl_pnMain.createSequentialGroup()
        			.addContainerGap(233, Short.MAX_VALUE)
        			.addGroup(gl_pnMain.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(lberror, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(btLogin, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
        			.addGap(223))
        );
        gl_pnMain.setVerticalGroup(
        	gl_pnMain.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pnMain.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel5)
        			.addGap(44)
        			.addGroup(gl_pnMain.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lbuser, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtuser, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(gl_pnMain.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lbpass, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtpass, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(btLogin)
        			.addGap(18)
        			.addComponent(lberror, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(43, Short.MAX_VALUE))
        );
        pnMain.setLayout(gl_pnMain);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbView)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbView, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        LoginController controller= new LoginController(this, btLogin, txtuser, txtpass, lberror);
        controller.setEvent();
	}

	
}
