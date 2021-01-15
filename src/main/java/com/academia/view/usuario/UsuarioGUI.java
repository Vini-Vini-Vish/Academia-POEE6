package com.academia.view.usuario;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.academia.estrutura.util.VariaveisProjeto;
import com.academia.model.models.Departamento;
import com.academia.model.models.Usuario;
import com.academia.model.service.UsuarioService;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
	
	private JLabel checkNome;
	private JLabel checkEmail;
	private JLabel checkSenha;
	
	private boolean status = true;  

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
		textFieldName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if( verificaDigitacaoNome() ) {
					textFieldName.requestFocus();
				} else {
					digitacaoNomeValido();
				}
			}
		});
		
		textFieldName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if( verificaDigitacaoNome() ) {
						textFieldName.requestFocus();
					} else {
						digitacaoNomeValido();
					}				
					textFieldEmail.requestFocus();
				}				 
			}			
		});
		textFieldName.setColumns(10);
		
		//-----------------------------------------------------------------//		
		
		JLabel lblEmail = new JLabel("Email:");
		
		textFieldEmail = new JTextField();
		textFieldEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if( verificaDigitacaoEmail() ) {
					textFieldEmail.requestFocus();
				} else {
					digitacaoEmailValido();
				}	
			}
		});
		
		textFieldEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if( verificaDigitacaoEmail() ) {
						textFieldEmail.requestFocus();
					} else {
						digitacaoEmailValido();
					}					
					passwordFieldPassword.requestFocus();
				}
			}
		});
		textFieldEmail.setColumns(10);
		
		//-----------------------------------------------------------------//		
		
		JLabel lblPassword = new JLabel("Senha:");
		
		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if( verificaDigitacaoSenha() ) {
					passwordFieldPassword.requestFocus();
				} else {
					digitacaoSenhaValida();
				}
			}
		});
		
		passwordFieldPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					if( verificaDigitacaoSenha() ) {
						passwordFieldPassword.requestFocus();
					} else {
						digitacaoSenhaValida();
					}
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
		
		checkNome = new JLabel("");
		checkNome.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		checkEmail = new JLabel("");
		checkEmail.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		checkSenha = new JLabel("");
		checkSenha.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		
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
											.addComponent(checkSenha, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
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
										.addComponent(checkNome, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
										.addComponent(checkEmail, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))))
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
						.addComponent(checkNome))
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkEmail, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordFieldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkSenha, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
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

	//-------------------------Incluir--------------------------------//
	//-----------------------------------------------------------------//	
	
	private void IncluirUsuario() {
		
		Integer toReturn = 0;
		
		Usuario usuario = PegarDadosUsuario();
		//System.out.println(usuario.toString());
		
		Departamento departamento = new Departamento();
		
		departamento.setId(1L);
		departamento.setNome("Vendas");
		
		usuario.setDepartamento(departamento);

		UsuarioService usuarioservice = new UsuarioService();
		
		toReturn = usuarioservice.save(usuario);
		
		if( toReturn == VariaveisProjeto.NOME_CAMPO_VAZIO ) {
			status = false;
			mudaStatusCheckNome();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		if ( toReturn == VariaveisProjeto.ERRO_INCLUSAO ) {
			showMensagem("Erro na Inclusão do Registro, verifique com seu administrador!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		if ( toReturn == VariaveisProjeto.INCLUSAO_REALIZADA) {
			showMensagem("Inclusão do Registro realizada com sucesso!", "OK", JOptionPane.OK_OPTION);
			
			limpaTextoCampo();
			
			usuario = new Usuario();
		}
		
	}	
	
	//-------------------------Alterar---------------------------------//	
	//-----------------------------------------------------------------//	
	
	protected void AlterarUsuario() {
		
		Integer toReturn = 0;
		
		Usuario usuario = PegarDadosUsuario();
		
		Departamento departamento = new Departamento();
		
		departamento.setId(1L);
		departamento.setNome("Vendas");
		
		usuario.setDepartamento(departamento);
		
		UsuarioService usuarioservice = new UsuarioService();
		
		toReturn = usuarioservice.update(usuario);		
		
		if( toReturn == VariaveisProjeto.NOME_CAMPO_VAZIO ) {
			status = false;
			mudaStatusCheckNome();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		if ( toReturn == VariaveisProjeto.ERRO_ALTERACAO ) {
			showMensagem("Erro na alteração do Registro, verifique com seu administrador!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		if ( toReturn == VariaveisProjeto.ERRO_ALTERACAO) {
			showMensagem("alteração do Registro realizada com sucesso!", "OK", JOptionPane.OK_OPTION);
			
			limpaTextoCampo();
			
			usuario = new Usuario();
		}
	}	
	
	//-------------------------Excluir---------------------------------//
	//-----------------------------------------------------------------//	
	
	protected void ExcluirUsuario() {
		
		Integer toReturn = 0;
		
		Usuario usuario = PegarDadosUsuario();
		
		Departamento departamento = new Departamento();
		
		departamento.setId(1L);
		departamento.setNome("Vendas");
		
		UsuarioService usuarioService = new UsuarioService();
		
		toReturn = usuarioService.delete(usuario);
		
		if ( toReturn == VariaveisProjeto.ERRO_EXCLUSAO ) {
			showMensagem("Erro na Exclusão do Registro, verifique com seu administrador!",
					   	 "Erro",JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.EXCLUSAO_REALIZADA) {
			showMensagem("Exclusão do Registro realizada com sucesso!",
					     "OK",JOptionPane.OK_OPTION);
			limpaTextoCampo();
			usuario = new Usuario();
		}
	}	
	
	//-------------------------Show Mensagem---------------------------//
	//-----------------------------------------------------------------//
	
	private void showMensagem(String mensagem, String status, int option ) {
		JOptionPane.showMessageDialog(null, mensagem, status, option );
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
	
	private void digitacaoNomeValido() {
		status = true;
		mudaStatusCheckNome();
		checkNome.setVisible(true);
		textFieldEmail.requestFocus();
	}
	
	//-----------------------------------------------------------------//	
	
	private boolean verificaDigitacaoNome() {
				
		if(VariaveisProjeto.digitacaoCampo(textFieldName.getText())) {
			status = false;
			mudaStatusCheckNome();
			return true;
		}
		
		return false;
	}
	
	//-----------------------------------------------------------------//	
	
	private void mudaStatusCheckNome() {
		
		checkNome.setVisible(true);
		
		if(status == false) {
			checkNome.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			checkNome.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		}
		
	}
	
	//-----------------------------------------------------------------//	
	
	private void digitacaoEmailValido() {
		status = true;
	    mudaStatusCheckEmail();
		checkEmail.setVisible(true);	
		passwordFieldPassword.requestFocus();
	}
	
	//-----------------------------------------------------------------//
	
	private boolean verificaDigitacaoEmail() {
		if ( VariaveisProjeto.digitacaoCampo(textFieldEmail.getText())) {
		     status = false;
			 mudaStatusCheckEmail();
			 return true; 
		}
		return false;
	}
	
	//-----------------------------------------------------------------//		
	
	private void mudaStatusCheckEmail() {
		
		checkEmail.setVisible(true);
		
		if(status == false) {
			checkEmail.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			checkEmail.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		}
		
	}
		
	//-----------------------------------------------------------------//	
	
	private void digitacaoSenhaValida() {
		status = true;
	    mudaStatusCheckSenha();
		checkSenha.setVisible(true);	
		rdbtnAtivo.requestFocus();
	}
	
	//-----------------------------------------------------------------//	
	
	@SuppressWarnings("deprecation")
	private boolean verificaDigitacaoSenha() {
		if ( VariaveisProjeto.digitacaoCampo(passwordFieldPassword.getText())) {
		     status = false;
			 mudaStatusCheckSenha();
			 return true; 
		}
		return false;
	}
	
	//-----------------------------------------------------------------//	
	
	private void mudaStatusCheckSenha() {
		checkSenha.setVisible(true);
		if (status == false ) {
			checkSenha.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
		} else {
			checkSenha.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
		}
	}
	
	//-----------------------------------------------------------------//	
			
	private void desabilitaCheckCampo() {
		checkNome.setVisible(false);
		checkEmail.setVisible(false);
		checkSenha.setVisible(false);
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
