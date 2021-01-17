package com.academia.view.atividade;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.academia.estrutura.util.VariaveisProjeto;
import com.academia.model.models.Atividade;
import com.academia.model.service.AtividadeService;
import com.academia.view.dadosusuario.usuario.UsuarioGUI;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class AtividadeGUI extends JFrame {

	private static final long serialVersionUID = 5753282394509450001L;
	
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldDescricao;
	
	private JLabel lblNome;
	private JLabel lblDescricao;
	
	private JButton CheckNome;
	private JButton CheckDescricao;
	
	private JButton btnIncluir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnSair;

	private boolean status = true;  
	private JLabel lblCodigo;
	private JTextField textFieldCodigo;
	
	//-----------------------------------------------------------------//
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtividadeGUI frame = new AtividadeGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//-----------------------------------------------------------------//
	
	public AtividadeGUI() {
		setTitle("Cadastro de Atividades");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//-----------------------------------------------------------------//
		
		lblCodigo = new JLabel("Codigo");
		
		textFieldCodigo = new JTextField();
		
		textFieldCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				BuscarAtividade();	
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldNome.requestFocus();
				}
			}
		});
		
		textFieldCodigo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				BuscarAtividade();	
			}
		});
		
		textFieldCodigo.setColumns(10);
		
		//-----------------------------------------------------------------//
		
		lblNome = new JLabel("Nome:");
		
		textFieldNome = new JTextField();		
		
		textFieldNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if( verificaDigitacaoNome() ) {
					textFieldNome.requestFocus();
				} else {
					digitacaoNomeValido();
				}
			}
		});
		
		textFieldNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if( verificaDigitacaoNome() ) {
						textFieldNome.requestFocus();
					} else {
						digitacaoNomeValido();
					}				
					textFieldDescricao.requestFocus();
				}				 
			}			
		});
		
		textFieldNome.setColumns(10);
		
		//-----------------------------------------------------------------//
		
		lblDescricao = new JLabel("Descrição:");
		
		textFieldDescricao = new JTextField();
		
		textFieldDescricao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if( verificaDigitacaoDescricao() ) {
						textFieldDescricao.requestFocus();
					} else {
						digitacaoDescricaoValido();
					}									
				}				 
			}			
		});
		
		textFieldDescricao.setColumns(10);
		
		//-----------------------------------------------------------------//
		
		CheckNome = new JButton("");
		CheckNome.setIcon(new ImageIcon(AtividadeGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		CheckDescricao = new JButton("");
		CheckDescricao.setIcon(new ImageIcon(AtividadeGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		//-----------------------------------------------------------------//
				
		btnIncluir = new JButton("Incluir");
		btnIncluir.setIcon(new ImageIcon(AtividadeGUI.class.getResource("/com/academia/estrutura/imagens/application_form_add.png")));
		
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IncluirAtividade();
			}
		});
		
		//-----------------------------------------------------------------//
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(AtividadeGUI.class.getResource("/com/academia/estrutura/imagens/application_form_edit.png")));
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarAtividade();
			}
		});
		
		//-----------------------------------------------------------------//
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(AtividadeGUI.class.getResource("/com/academia/estrutura/imagens/application_form_delete.png")));
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcluirAtividade();
			}
		});
		
		//-----------------------------------------------------------------//
		
		btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(AtividadeGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
				
		//-----------------------------------------------------------------//
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnIncluir)
								.addGap(18)
								.addComponent(btnAlterar)
								.addGap(18)
								.addComponent(btnExcluir)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSair))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblDescricao)
									.addComponent(lblNome))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(textFieldDescricao, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE)
									.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCodigo)
							.addGap(35)
							.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(CheckNome)
						.addComponent(CheckDescricao))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(14, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(CheckNome)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCodigo)
								.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNome)
								.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDescricao)
								.addComponent(textFieldDescricao, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnIncluir)
								.addComponent(btnAlterar)
								.addComponent(btnExcluir)
								.addComponent(btnSair)))
						.addComponent(CheckDescricao))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		createEvents();
		
		limpaTextoCampo();
		desabilitaCheckCampo();
	}
	
	
	
	//----------------------------NOME---------------------------------//	
	//-----------------------------------------------------------------//	

	private void digitacaoNomeValido() {
		status = true;
		mudaStatusCheckNome();
		CheckNome.setVisible(true);	
		textFieldDescricao.requestFocus();
	}
	
	//-----------------------------------------------------------------//	
	
	private boolean verificaDigitacaoNome() {
				
		if ( VariaveisProjeto.digitacaoCampo(textFieldNome.getText())) {
		     status = false;
			 mudaStatusCheckNome();
			 return true; 
		}
		return false;
	}
	
	//-----------------------------------------------------------------//	
	
	private void mudaStatusCheckNome() {
		
		CheckNome.setVisible(true);
		
		if(status == false) {
			CheckNome.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			CheckNome.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		}
		
	}		
	
	//-------------------------Incluir--------------------------------//
	//-----------------------------------------------------------------//	
	
	private void IncluirAtividade() {
		
		Integer toReturn = 0;
		
		Atividade atividade = PegarDadosAtividade();
		//System.out.println(usuario.toString());	

		AtividadeService atividadeservice = new AtividadeService();
		
		toReturn = atividadeservice.save(atividade);
		
		//-----------------------------------------------------------------//	
		
		erroDigitacao(toReturn);	
		
		//-----------------------------------------------------------------//	
		
		if ( toReturn == VariaveisProjeto.ERRO_INCLUSAO ) {
			showMensagem("Erro na Inclusão do Registro, verifique com seu administrador!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		if ( toReturn == VariaveisProjeto.INCLUSAO_REALIZADA) {
			showMensagem("Inclusão do Registro realizada com sucesso!", "OK", JOptionPane.OK_OPTION);
			
			limpaTextoCampo();
			
			atividade = new Atividade();
		}
		
	}	
	
	//-------------------------Alterar---------------------------------//	
	//-----------------------------------------------------------------//	
	
	protected void AlterarAtividade() {
		
		Integer toReturn = 0;
		
		Atividade atividade = PegarDadosAtividade();		
		
		AtividadeService atividadeservice = new AtividadeService();
		
		toReturn = atividadeservice.update(atividade);		
		
		//-----------------------------------------------------------------//	
		
		erroDigitacao(toReturn);	
		
		//-----------------------------------------------------------------//	
		
		if ( toReturn == VariaveisProjeto.ERRO_ALTERACAO ) {
			showMensagem("Erro na alteração do Registro, verifique com seu administrador!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		if ( toReturn == VariaveisProjeto.ERRO_ALTERACAO) {
			showMensagem("alteração do Registro realizada com sucesso!", "OK", JOptionPane.OK_OPTION);
			
			limpaTextoCampo();
			
			atividade = new Atividade();
		}
	}
	
	//-------------------------Excluir---------------------------------//
	//-----------------------------------------------------------------//	
	
	protected void ExcluirAtividade() {
		
		Integer toReturn = 0;
		
		Atividade atividade = PegarDadosAtividade();
				
		AtividadeService atividadeService = new AtividadeService();
		
		toReturn = atividadeService.delete(atividade);
		
		if ( toReturn == VariaveisProjeto.ERRO_EXCLUSAO ) {
			showMensagem("Erro na Exclusão do Registro, verifique com seu administrador!",
					   	 "Erro",JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.EXCLUSAO_REALIZADA) {
			showMensagem("Exclusão do Registro realizada com sucesso!",
					     "OK",JOptionPane.OK_OPTION);
			
			limpaTextoCampo();
			
			atividade = new Atividade();
		}
	}
	
	//-------------------------Sair------------------------------------//
	//-----------------------------------------------------------------//
	
	private void createEvents() {
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}	
	
	//-------------------------Erro Digitação--------------------------//
	//-----------------------------------------------------------------//
	
	private void erroDigitacao(Integer toReturn) {
		if( toReturn == VariaveisProjeto.NOME) {
			status = false;
			mudaStatusCheckNome();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		if( toReturn == VariaveisProjeto.DESCRICAO ) {
			status = false;
			mudaStatusCheckDescricao();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}	
	
	//-------------------------Show Mensagem---------------------------//
	//-----------------------------------------------------------------//
	
	private void showMensagem(String mensagem, String status, int option ) {
		JOptionPane.showMessageDialog(null, mensagem, status, option );
	}
	
	//----------------------------DESCRICAO----------------------------//	
	//-----------------------------------------------------------------//	
	
	private void digitacaoDescricaoValido() {
		status = true;
		mudaStatusCheckDescricao();
		CheckNome.setVisible(true);				
	}
	
	//-----------------------------------------------------------------//	
	
	private boolean verificaDigitacaoDescricao() {
				
		if ( VariaveisProjeto.digitacaoCampo(textFieldDescricao.getText())) {
		     status = false;
			 mudaStatusCheckDescricao();
			 return true; 
		}
		return false;
	}
	
	//-----------------------------------------------------------------//	
	
	private void mudaStatusCheckDescricao() {
		
		CheckDescricao.setVisible(true);
		
		if(status == false) {
			CheckDescricao.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			CheckDescricao.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		}
		
	}		

	//-----------------------------------------------------------------//	

	private void BuscarAtividade(){
		
		Atividade atividade = new Atividade();
		AtividadeService ativiadadeservice = new AtividadeService();
		
		if(VariaveisProjeto.digitacaoCampo(textFieldCodigo.getText())) {
			textFieldCodigo.requestFocus();
			return;
		}
		
		Integer id = Integer.valueOf(textFieldCodigo.getText()); 
		
		atividade = ativiadadeservice.findById(id);		
		
		textFieldNome.setText(atividade.getNome());
		textFieldDescricao.setText(atividade.getDescricao());
		
	}
	
	//-----------------------------------------------------------------//
	
	public Atividade PegarDadosAtividade() {
		
		Atividade atividade = new Atividade();
		
		if(!"".equals(textFieldCodigo.getText())) {
			atividade.setIdAtividade(Integer.valueOf(textFieldCodigo.getText()));
		}
		
		atividade.setIdAtividade(VariaveisProjeto.convertToInteger(textFieldCodigo.getText()));
		atividade.setNome(textFieldNome.getText());
		atividade.setDescricao(textFieldDescricao.getText());								
		
		return atividade;			
	}
		
	//-----------------------------------------------------------------//
	
	private void desabilitaCheckCampo() {
		CheckNome.setVisible(false);
		CheckDescricao.setVisible(false);			
	}
	
	//-----------------------------------------------------------------//
	
	private void limpaTextoCampo() {
		
		textFieldCodigo.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldNome.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldDescricao.setText(VariaveisProjeto.LIMPA_CAMPO);		
		
	}
	
}
