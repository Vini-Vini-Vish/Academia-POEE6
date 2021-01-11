package com.academia.view;

import java.awt.BorderLayout; 
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.academia.estrutura.util.VariaveisProjeto;
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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class UsuarioGUI extends JFrame {

	private static final long serialVersionUID = 6282980174908539630L;
	
	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private JPasswordField passwordFieldPassword;
	
	private JButton btnIncluir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnSair;
	
	private JRadioButton rdbtnAtivo;	
	private JRadioButton rdbtnAdmin;
	
	private JLabel checkNomeSucesso;
	private JLabel checkEmailSucesso;
	private JLabel checkSenhaSucesso;
	
	private JLabel checkNomeErro;
	private JLabel checkEmailErro;
	private JLabel checkSenhaErro;

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
		
		//-----------------------------------------------------------------//		
		
		JLabel lblCodigo = new JLabel("Codigo");
		
		textFieldCodigo = new JTextField();
		
		textFieldCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				BuscarUsuario();	
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldName.requestFocus();
				}
			}
		});
		
		textFieldCodigo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				BuscarUsuario();	
			}
		});
		textFieldCodigo.setColumns(10);
				 
		//-----------------------------------------------------------------//		
		
		JLabel lblName = new JLabel("Nome:");
		
		textFieldName = new JTextField();
		
		textFieldName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if( verificaDigitacaoNome() ) {
						textFieldName.requestFocus();
					} else {
						checkNomeSucesso.setVisible(true);
						textFieldEmail.requestFocus();
					}					
				}				 
			}
		});
		textFieldName.setColumns(10);
		
		//-----------------------------------------------------------------//		
		
		JLabel lblEmail = new JLabel("Email:");
		
		textFieldEmail = new JTextField();
		
		textFieldEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					passwordFieldPassword.requestFocus();
				}
			}
		});
		textFieldEmail.setColumns(10);
		
		//-----------------------------------------------------------------//		
		
		JLabel lblPassword = new JLabel("Senha:");
		
		passwordFieldPassword = new JPasswordField();
		
		passwordFieldPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					rdbtnAtivo.requestFocus();
				}
			}
		});
		
		//-----------------------------------------------------------------//		
		
		rdbtnAtivo = new JRadioButton("Ativo");
		
		rdbtnAtivo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					rdbtnAdmin.requestFocus();
				}
			}
		});
		
		//-----------------------------------------------------------------//	
		
		rdbtnAdmin = new JRadioButton("Adimistrador");
		
		rdbtnAdmin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnIncluir.requestFocus();
				}
			}
		});
		
		//-----------------------------------------------------------------//		
		
		btnIncluir = new JButton("Incluir");
		btnIncluir.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/academia/estrutura/imagens/application_form_add.png")));
		
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IncluirUsuario();
			}
		});
		
		//-----------------------------------------------------------------//		
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/academia/estrutura/imagens/application_form_edit.png")));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarUsuario();
			}
		});
		
		//-----------------------------------------------------------------//	
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/academia/estrutura/imagens/application_form_delete.png")));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcluirUsuario();
			}
		});
		
		btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/academia/estrutura/imagens/sair.png")));
		
		//-----------------------------------------------------------------//	
		
		checkNomeSucesso = new JLabel("");
		checkNomeSucesso.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		checkEmailSucesso = new JLabel("");
		checkEmailSucesso.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		checkSenhaSucesso = new JLabel("");
		checkSenhaSucesso.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		
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
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(16)
											.addComponent(btnAlterar)
											.addGap(18)
											.addComponent(btnExcluir))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(passwordFieldPassword, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(checkSenhaSucesso, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(rdbtnAtivo)
											.addGap(16)
											.addComponent(rdbtnAdmin))
										.addComponent(btnSair)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(textFieldName, Alignment.LEADING)
										.addComponent(textFieldEmail, Alignment.LEADING, 574, 574, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(checkNomeSucesso, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
										.addComponent(checkEmailSucesso, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))))
							.addGap(127))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
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
						.addComponent(lblName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(checkNomeSucesso))
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkEmailSucesso, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordFieldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkSenhaSucesso, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnAdmin)
						.addComponent(rdbtnAtivo, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSair))
					.addContainerGap(94, Short.MAX_VALUE))
		);
		
		//-----------------------------------------------------------------//	
		
		contentPane.setLayout(gl_contentPane);
		createEvents();
		
		limpaTextoCampo();
		
		desabilitaCheckCampo();
	}

	//-----------------------------------------------------------------//	
	
	private void IncluirUsuario() {
		
		Usuario usuario = PegarDadosUsuario();
		//System.out.println(usuario.toString());

		UsuarioService usuarioservice = new UsuarioService();
		
		usuarioservice.save(usuario);
		
		limpaTextoCampo();
	}	
	
	//-----------------------------------------------------------------//	
	
	protected void AlterarUsuario() {
		Usuario usuario = PegarDadosUsuario();
		UsuarioService usuarioservice = new UsuarioService();
		
		usuarioservice.update(usuario);		
		
		limpaTextoCampo();
	}	
	
	//-----------------------------------------------------------------//	
	
	protected void ExcluirUsuario() {
		
		Usuario usuario = PegarDadosUsuario();
		
		UsuarioService usuarioservice = new UsuarioService();
		
		usuarioservice.save(usuario);
		
		usuarioservice.delete(usuario);
		
		limpaTextoCampo();
	}	
	
	//-----------------------------------------------------------------//	
	
	private void createEvents() {
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}	
	
	//-----------------------------------------------------------------//	
	
	private boolean verificaDigitacaoNome() {
				
		if(VariaveisProjeto.digitacaoCampo(textFieldName.getText())) {
			mudaStatusCheckNome();
			return true;
		}
		
		return false;
	}
	
	//-----------------------------------------------------------------//	
	
	private void mudaStatusCheckNome() {
		
		checkNomeSucesso.setVisible(true);
		checkNomeSucesso.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
				
		/*
		checkEmailSucesso = new JLabel("");
		checkEmailSucesso.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		checkSenhaSucesso = new JLabel("");
		checkSenhaSucesso.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		*/
	}
	
	//-----------------------------------------------------------------//	
	
	private void desabilitaCheckCampo() {
		checkNomeSucesso.setVisible(false);
		checkEmailSucesso.setVisible(false);
		checkSenhaSucesso.setVisible(false);
	}

	//-----------------------------------------------------------------//	
			
	private void BuscarUsuario(){
		Usuario usuario = new Usuario();
		UsuarioService usuarioservice = new UsuarioService();
		
		if(VariaveisProjeto.digitacaoCampo(textFieldCodigo.getText())) {
			textFieldCodigo.requestFocus();
			return;
		}
		
		Integer id = Integer.valueOf(textFieldCodigo.getText()); 
		
		usuario = usuarioservice.findById(id);		
		
		textFieldName.setText(usuario.getUsername());
		textFieldEmail.setText(usuario.getEmail());
		passwordFieldPassword.setText(usuario.getPassword()); 
		
		if(usuario.isAdmin()) {
			rdbtnAdmin.setSelected(true);
		}
		
		if(usuario.isAtivo()) {
			rdbtnAtivo.setSelected(true);
		} 
		
	}
		
	//-----------------------------------------------------------------//
	
	@SuppressWarnings("deprecation")
	public Usuario PegarDadosUsuario() {
		
		Usuario usuario = new Usuario();
		
		if(!"".equals(textFieldCodigo.getText())) {
			usuario.setId(Integer.valueOf(textFieldCodigo.getText()));
		}
		
		usuario.setId(VariaveisProjeto.convertToInteger(textFieldCodigo.getText()));
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
	
	private void limpaTextoCampo() {
		
		textFieldCodigo.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldName.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldEmail.setText(VariaveisProjeto.LIMPA_CAMPO);
		passwordFieldPassword.setText(VariaveisProjeto.LIMPA_CAMPO);
		rdbtnAdmin.setSelected(false);
		rdbtnAtivo.setSelected(false);
	}
}
