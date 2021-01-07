package com.academia.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.academia.model.models.Usuario;
import com.academia.model.service.UsuarioService;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class UsuarioGUI extends JFrame {

	private static final long serialVersionUID = 6282980174908539630L;
	
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private JPasswordField passwordFieldPassword;
	
	private JButton btnIncluir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	
	private JRadioButton rdbtnAtivo;
	
	private JRadioButton rdbtnAdmin;
	private JButton btnSair;
	
	private JTextField textFieldCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioGUI frame = new UsuarioGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UsuarioGUI() {
		setTitle("Cadastro de Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblName = new JLabel("Nome:");
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Senha:");
		
		passwordFieldPassword = new JPasswordField();
		
		//-----------------------------------------------------------------//		
		
		rdbtnAtivo = new JRadioButton("Ativo");
		
		rdbtnAdmin = new JRadioButton("Adimistrador");
		
		//-----------------------------------------------------------------//		
		
		btnIncluir = new JButton("Incluir");
		
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IncluirUsuario();
			}
		});
		
		//-----------------------------------------------------------------//		
		btnAlterar = new JButton("Alterar");
		
		btnExcluir = new JButton("Excluir");
		
		btnSair = new JButton("Sair");
		
		JLabel lblCodigo = new JLabel("Codigo");
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setColumns(10);
		//-----------------------------------------------------------------//	
				
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(59)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblPassword)
									.addComponent(btnIncluir)
									.addComponent(lblName, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblEmail)
								.addGap(38)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCodigo)
							.addGap(33)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(textFieldEmail, 574, 574, 574)
								.addGap(169))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textFieldName, GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
									.addContainerGap())
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(16)
											.addComponent(btnAlterar)
											.addGap(18)
											.addComponent(btnExcluir)
											.addPreferredGap(ComponentPlacement.RELATED, 348, Short.MAX_VALUE)
											.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(passwordFieldPassword, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
											.addGap(30)
											.addComponent(rdbtnAtivo)
											.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
											.addComponent(rdbtnAdmin)))
									.addGap(168))))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigo)
						.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordFieldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnAtivo, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnAdmin))
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSair)
						.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(112, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		createEvents();
	}
	
	private void IncluirUsuario() {
		
		Usuario usuario = PegarDadosUsuario();
		//System.out.println(usuario.toString());

		UsuarioService usuarioservice = new UsuarioService();
		
		usuarioservice.save(usuario);
	}
	
	private void createEvents() {
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	@SuppressWarnings("deprecation")
	public Usuario PegarDadosUsuario() {
		Usuario usuario = new Usuario();
		
		usuario.setId(Integer.valueOf(textFieldCodigo.getText()));
		usuario.setUsername(textFieldName.getText());
		usuario.setEmail(textFieldEmail.getText());
		usuario.setPassword(passwordFieldPassword.getText());
		
		if(rdbtnAtivo.isSelected()) {
			usuario.setAtivo(true);
		} else{
			usuario.setAtivo(false);
		}
		
		if(rdbtnAdmin.isSelected()) {
			usuario.setAdmin(true);
		} else{
			usuario.setAdmin(false);
		}
		
		return usuario;
	}
}
