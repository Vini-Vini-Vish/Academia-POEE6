package com.academia.view.atividade;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import com.academia.estrutura.util.VariaveisProjeto;
import com.academia.estrutura.util.imagem.ImageFilter;
import com.academia.estrutura.util.imagem.ImagePreview;
import com.academia.model.models.Atividade;
import com.academia.model.models.Foto;
import com.academia.model.models.user.Departamento;
import com.academia.model.models.user.Usuario;
import com.academia.model.service.AtividadeService;
import com.academia.model.service.DepartamentoService;
import com.academia.model.service.LocalFotoStorageService;
import com.academia.view.dadosusuario.departamento.BuscarDepartamento;
import com.academia.view.dadosusuario.usuario.TabelaUsuarioModel;
import com.academia.view.dadosusuario.usuario.UsuarioGUI;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;

public class AtividadeGUI extends JDialog {

	private static final long serialVersionUID = 5753282394509450001L;
	
	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldNome;
	private JTextField textFieldDescricao;
	
	private JLabel lblCodigo;
	private JLabel lblNome;
	private JLabel lblDescricao;	
	
	private JButton CheckNome;
	private JButton CheckDescricao;
	
	private JButton btnIncluir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnSair;

	private boolean status = true;  

	private JTable tabelaAtividade;
    private TabelaAtividadeModel tabelaAtividadeModel;
    private int linha=0;
    private int acao = 0;  
    
    private String nomeFoto;
    private JLabel lblIconFoto;
    private JButton btnAddFoto;
    private JButton btnExcluirFoto;
	
	//-----------------------------------------------------------------//
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AtividadeGUI frame = new AtividadeGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	//-----------------------------------------------------------------//
	
	public AtividadeGUI(JFrame frame, boolean modal, JTable tabelaAtividade, TabelaAtividadeModel tabelaAtividadeModel, int linha, int acao) {
		
		super(frame, modal);

		initComponents();
		
		this.tabelaAtividade = tabelaAtividade;
		this.tabelaAtividadeModel = tabelaAtividadeModel;
		this.linha = linha;
        this.acao = acao;
		
		limpaTextoCampo();
		
		desabilitaCheckCampo();
		
		configuraAcaoAtividade();	
	
	}
	
	//-----------------------------------------------------------------//	
    
    private void configuraAcaoAtividade() {
		
		if (this.acao == VariaveisProjeto.INCLUSAO) {
			btnIncluir.setVisible(true);
			btnAlterar.setVisible(false);
			btnExcluir.setVisible(false);
		}
		if (this.acao == VariaveisProjeto.ALTERACAO) {
			btnAlterar.setVisible(true);
			btnExcluir.setVisible(false);
			btnIncluir.setVisible(false);
			BuscarAtividade();
		}
		if (this.acao == VariaveisProjeto.EXCLUSAO) {
			btnExcluir.setVisible(true);
			btnIncluir.setVisible(false);
			btnAlterar.setVisible(false);
			BuscarAtividade();
		}
	}
	
	private void initComponents() {
		
		setTitle("Cadastro de Atividades");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 412);
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
		
		lblIconFoto = new JLabel("");
		lblIconFoto.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		btnAddFoto = new JButton("Add Foto");
		btnAddFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarFoto();
			}
		});
		btnAddFoto.setIcon(new ImageIcon(AtividadeGUI.class.getResource("/com/academia/estrutura/imagens/useravatar.png")));
		
		btnExcluirFoto = new JButton("Excluir Foto");
		btnExcluirFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirFoto();
			}
		});
		btnExcluirFoto.setIcon(new ImageIcon(AtividadeGUI.class.getResource("/com/academia/estrutura/imagens/useravatar.png")));
				
		//-----------------------------------------------------------------//
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
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
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(CheckNome)
								.addComponent(CheckDescricao))
							.addGap(49)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnAddFoto)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnExcluirFoto))
								.addComponent(lblIconFoto, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCodigo)
							.addGap(35)
							.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
					.addGap(30))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
						.addComponent(lblDescricao)
						.addComponent(textFieldDescricao, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addComponent(CheckDescricao))
					.addGap(83)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIncluir)
						.addComponent(btnAlterar)
						.addComponent(btnExcluir)
						.addComponent(btnSair))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(55)
					.addComponent(lblIconFoto, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddFoto)
						.addComponent(btnExcluirFoto))
					.addContainerGap(106, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		createEvents();	
	}	
	
	protected void excluirFoto() {
		Atividade atividade = tabelaAtividadeModel.getAtividade(this.linha);
		nomeFoto = atividade.getFoto();
		LocalFotoStorageService localFotoStorageService = new LocalFotoStorageService();
		localFotoStorageService.remover(nomeFoto);
		lblIconFoto.setIcon(null);
		lblIconFoto.revalidate();
	}



	protected void carregarFoto() {
		
		JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new ImageFilter());
		fc.setAcceptAllFileFilterUsed(false);
		fc.setAccessory(new ImagePreview(fc));
		int returnVal = fc.showDialog(lblIconFoto, "Anexar");
		
		if (lblIconFoto.getIcon() != null) {
			excluirFoto();
		}
		
		if ( returnVal == JFileChooser.APPROVE_OPTION ) {
			try {
				File file = fc.getSelectedFile();
				FileInputStream fin = new FileInputStream(file);
				BufferedImage img = ImageIO.read(fin);
				ImageIcon icon = new ImageIcon(img);
				lblIconFoto.setIcon(icon);
				lblIconFoto.setHorizontalAlignment(SwingConstants.CENTER);
				LocalFotoStorageService localFotoStorageService = new LocalFotoStorageService();
				Foto foto = new Foto();
				foto.setNomeArquivo(file.getName());
				foto.setInputStream(fin);
				foto.setFile(file);
				nomeFoto = localFotoStorageService.armazenar(foto);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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
		
		AtividadeService atividadeservice = new AtividadeService();
		
		toReturn = atividadeservice.save(atividade);
		
		//-----------------------------------------------------------------//	
		
		erroDigitacao(toReturn);	
		
		//-----------------------------------------------------------------//	
		
		if ( toReturn == VariaveisProjeto.ERRO_INCLUSAO ) {
			showMensagem("Erro na Inclusão do Registro, verifique com seu administrador!",
					   	 "Erro",JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.INCLUSAO_REALIZADA) {
			showMensagem("Inclusão do Registro realizada com sucesso!",
					     "OK",JOptionPane.OK_OPTION);
			limpaTextoCampo();
			
			tabelaAtividadeModel.fireTableDataChanged();
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
			showMensagem("Erro na Alteração do Registro, verifique com seu administrador!",
					   	 "Erro",JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.ALTERACAO_REALIZADA) {
			showMensagem("Alteração do Registro realizada com sucesso!",
					     "OK",JOptionPane.OK_OPTION);				
			limpaTextoCampo();
			
			tabelaAtividadeModel.fireTableDataChanged();
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
			
			tabelaAtividadeModel.fireTableDataChanged();
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
		
		atividade = tabelaAtividadeModel.getAtividade(this.linha);
				
		textFieldCodigo.setText(String.valueOf(atividade.getIdAtividade()));
		textFieldNome.setText(atividade.getNome());
		textFieldDescricao.setText(atividade.getDescricao());
		nomeFoto = atividade.getFoto();  
		
		 if ( !Objects.isNull(nomeFoto) ) {
		 	    LocalFotoStorageService localFotoStorageService = new LocalFotoStorageService();
			    String fileInput = localFotoStorageService.recuperar(nomeFoto);
			    File file = new File(fileInput);
			    FileInputStream fis;
				try {
					fis = new FileInputStream(file);
					BufferedImage img = ImageIO.read(fis);
					ImageIcon imagem = new ImageIcon(img);
					lblIconFoto.setIcon(imagem);
					lblIconFoto.setHorizontalAlignment(SwingConstants.CENTER);
				}  catch (IOException e) {
					e.printStackTrace();
				}
			}
		
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
		atividade.setFoto(nomeFoto);
	
		
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
