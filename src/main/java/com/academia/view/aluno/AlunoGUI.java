package com.academia.view.aluno;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.academia.estrutura.util.VariaveisProjeto;
import com.academia.model.models.Aluno;
import com.academia.model.service.AlunoService;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class AlunoGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblCodigo;	
	private JTextField textFieldCodigo;
	private JTextField textFieldNome;
	private JTextField textFieldGender;
	private JTextField textFieldAge;
	private JLabel lblAdress;
	private JTextField textFieldAdress;
	private JLabel lblNumber;
	private JTextField textFieldNumber;
	private JLabel lblNeighborhood;
	private JTextField textFieldNeighborhood;
	private JLabel lblCity;
	private JTextField textFieldCity;
	private JLabel lblTelephone;
	private JTextField textFieldTelephone;
	private JLabel lblPostalCode;
	private JTextField textFieldPostalCode;
	private JLabel lblPeriod;
	private JTextField textFieldPeriod;
	
	private JButton btnIncluir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	
	private JRadioButton rdbtnActivity;
	private JButton btnSair;	
	
	private JLabel checkNome;
	private JLabel checkGenero;
	private JLabel checkTelefone;
	private JLabel checkIdade;
	private JLabel checkNumero;
	private JLabel checkEndereco;
	private JLabel checkCidade;
	private JLabel checkBairro;
	private JLabel checkCodigoPostal;
	private JLabel checkPeriodo;

	private boolean status = true; 
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunoGUI frame = new AlunoGUI();
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
	public AlunoGUI() {
		setTitle("Cadastro Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//-----------------------------------------------------------------//
		
		lblCodigo = new JLabel("Codigo");
		
		textFieldCodigo = new JTextField();
		
		textFieldCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				BuscarAluno();
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldNome.requestFocus();
				}
			}
		});
		
		textFieldCodigo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				BuscarAluno();
			}
		});
				
		//-----------------------------------------------------------------//	
		
		JLabel lblName = new JLabel("Nome:");
		
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
						textFieldGender.requestFocus();
					}						
				}
			}
		});
		textFieldNome.setColumns(10);
		
		//-----------------------------------------------------------------//	
		
		JLabel lblGender = new JLabel("Genero:");
		
		textFieldGender = new JTextField();
		textFieldGender.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if( verificaDigitacaoGenero() ) {
					textFieldGender.requestFocus();
				} else {
					digitacaoGeneroValido();
				}
			}
		});
		
		textFieldGender.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {					
					if( verificaDigitacaoGenero() ) {
						textFieldGender.requestFocus();
					} else {
						digitacaoGeneroValido();
						textFieldAge.requestFocus();
					}	
				}
			}
		});
		textFieldGender.setColumns(10);
		
		//-----------------------------------------------------------------//	
		
		JLabel lblIdade = new JLabel("Idade");
		
		textFieldAge = new JTextField();
		textFieldAge.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if( verificaDigitacaoIdade() ) {
					textFieldAge.requestFocus();
				} else {
					digitacaoIdadeValido();
				}
			}
		});
		
		textFieldAge.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if( verificaDigitacaoIdade() ) {
						textFieldAge.requestFocus();
					} else {
						digitacaoIdadeValido();
						textFieldTelephone.requestFocus();
					}					
				}
			}
		});
		textFieldAge.setColumns(10);
		
		//-----------------------------------------------------------------//	
		
		lblAdress = new JLabel("Endereço:");
		
		textFieldAdress = new JTextField();
		textFieldAdress.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if( verificaDigitacaoEndereco() ) {
					textFieldAdress.requestFocus();
				} else {
					digitacaoEnderecoValido();
				}
			}
		});
		
		textFieldAdress.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if( verificaDigitacaoEndereco() ) {
						textFieldAdress.requestFocus();
					} else {
						digitacaoEnderecoValido();
						textFieldNumber.requestFocus();
					}					
				}
			}
		});
		textFieldAdress.setColumns(10);
		
		//-----------------------------------------------------------------//	
		
		lblNumber = new JLabel("Numero:");
		
		textFieldNumber = new JTextField();
		textFieldNumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if( verificaDigitacaoNumero() ) {
					textFieldNumber.requestFocus();
				} else {
					digitacaoNumeroValido();
				}
			}
		});
		
		textFieldNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if( verificaDigitacaoNumero() ) {
						textFieldNumber.requestFocus();
					} else {
						digitacaoNumeroValido();
						textFieldNeighborhood.requestFocus();
					}					
				}
			}
		});
		textFieldNumber.setColumns(10); 
		
		//-----------------------------------------------------------------//	
		
		lblNeighborhood = new JLabel("Bairro:");
		
		textFieldNeighborhood = new JTextField();
		textFieldNeighborhood.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if( verificaDigitacaoBairro() ) {
					textFieldNeighborhood.requestFocus();
				} else {
					digitacaoBairroValido();
				}
			}
		});
		
		textFieldNeighborhood.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if( verificaDigitacaoBairro() ) {
						textFieldNeighborhood.requestFocus();
					} else {
						digitacaoBairroValido();
						textFieldCity.requestFocus();
					}						
				}
			}
		});
		textFieldNeighborhood.setColumns(10);
		
		//-----------------------------------------------------------------//	
		
		lblCity = new JLabel("Cidade:");
		
		textFieldCity = new JTextField();
		textFieldCity.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if( verificaDigitacaoCidade() ) {
					textFieldCity.requestFocus();
				} else {
					digitacaoCidadeValido();
				}
			}
		});
		
		textFieldCity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if( verificaDigitacaoBairro() ) {
						textFieldCity.requestFocus();
					} else {
						digitacaoCidadeValido();
						textFieldPostalCode.requestFocus();
					}					
				}
			}
		});
		textFieldCity.setColumns(10);
		
		//-----------------------------------------------------------------//	
		
		lblTelephone = new JLabel("Telefone:");
		
		textFieldTelephone = new JTextField();
		textFieldTelephone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if( verificaDigitacaoTelefone() ) {
					textFieldTelephone.requestFocus();
				} else {
					digitacaoTelefoneValido();
				}
			}
		});
		
		textFieldTelephone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if( verificaDigitacaoTelefone() ) {
						textFieldTelephone.requestFocus();
					} else {
						digitacaoTelefoneValido();
						textFieldAdress.requestFocus();
					}						
				}
			}
		});
		textFieldTelephone.setColumns(10);
		
		//-----------------------------------------------------------------//	
		
		lblPostalCode = new JLabel("Codigo Postal:");
		
		textFieldPostalCode = new JTextField();
		textFieldPostalCode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if( verificaDigitacaoCodigoPostal() ) {
					textFieldPostalCode.requestFocus();
				} else {
					digitacaoCodigoPostalValido();
				}
			}
		});
		
		textFieldPostalCode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if( verificaDigitacaoCodigoPostal() ) {
						textFieldPostalCode.requestFocus();
					} else {
						digitacaoCodigoPostalValido();
						textFieldPeriod.requestFocus();
					}						
				}
			}
		});
		textFieldPostalCode.setColumns(10);
		
		//-----------------------------------------------------------------//	
		
		lblPeriod = new JLabel("Periodo:");
		
		textFieldPeriod = new JTextField();
		textFieldPeriod.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if( verificaDigitacaoPeriodo() ) {
					textFieldPeriod.requestFocus();
				} else {
					digitacaoPeriodoValido();
				}
			}
		});
		
		textFieldPeriod.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if( verificaDigitacaoPeriodo() ) {
						textFieldPeriod.requestFocus();
					} else {
						digitacaoPeriodoValido();
						rdbtnActivity.requestFocus();
					}						
				}
			}
		});
		textFieldPeriod.setText("");
		textFieldPeriod.setColumns(10);
		
		//-----------------------------------------------------------------//	
		
		rdbtnActivity = new JRadioButton("Ativo");
		
		rdbtnActivity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnIncluir.requestFocus();
				}
			}
		});
		
		//-----------------------------------------------------------------//		
		
		btnIncluir = new JButton("Incluir");
		btnIncluir.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/application_form_add.png")));
		
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				IncluirAluno();
			}
		});
		
		//-----------------------------------------------------------------//	
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/application_form_edit.png")));
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AlterarAluno();
			}
		});
		
		//-----------------------------------------------------------------//
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/application_form_delete.png")));
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ExcluirAluno();
			}
		});
		
		//-----------------------------------------------------------------//
		
		btnSair = new JButton("Sair");		
		btnSair.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/sair.png")));
		
		//-----------------------------------------------------------------//
		
		textFieldCodigo.setText("");
		textFieldCodigo.setColumns(10);
		
		//-----------------------------------------------------------------//
		
		checkNome = new JLabel("");
		checkNome.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		checkGenero = new JLabel("");
		checkGenero.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		checkTelefone = new JLabel("");
		checkTelefone.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		checkIdade = new JLabel("");
		checkIdade.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		checkNumero = new JLabel("");
		checkNumero.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		checkEndereco = new JLabel("");
		checkEndereco.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		checkCidade = new JLabel("");
		checkCidade.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		checkBairro = new JLabel("");
		checkBairro.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		checkCodigoPostal = new JLabel("");
		checkCodigoPostal.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		checkPeriodo = new JLabel("");
		checkPeriodo.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		//-----------------------------------------------------------------//	
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAdress)
								.addComponent(lblNeighborhood)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblCodigo)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblGender)
										.addComponent(lblName))))
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, 590, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textFieldNeighborhood, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(checkBairro, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblCity)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldCity, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textFieldGender, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(checkGenero, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
											.addGap(32)
											.addComponent(lblIdade)
											.addGap(18)
											.addComponent(textFieldAge, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(checkIdade, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
											.addGap(10)
											.addComponent(lblTelephone))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(textFieldAdress, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(checkEndereco, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
									.addGap(17)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(textFieldTelephone, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNumber)
											.addGap(18)
											.addComponent(textFieldNumber, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPostalCode)
								.addComponent(btnIncluir))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(btnAlterar)
									.addGap(18)
									.addComponent(btnExcluir))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textFieldPostalCode, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(checkCodigoPostal, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addGap(23)
									.addComponent(lblPeriod)
									.addGap(18)
									.addComponent(textFieldPeriod, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(checkPeriodo, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
									.addComponent(rdbtnActivity)
									.addGap(14))
								.addComponent(btnSair))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(checkNome, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkTelefone, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkNumero, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkCidade, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(15))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCodigo))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkNome))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(textFieldGender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGender))
							.addComponent(checkGenero, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(checkIdade, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(textFieldTelephone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblTelephone)
									.addComponent(checkTelefone, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblIdade)
									.addComponent(textFieldAge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(5)))
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdress)
						.addComponent(textFieldAdress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumber)
						.addComponent(checkNumero, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkEndereco, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNeighborhood)
						.addComponent(textFieldNeighborhood, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkCidade, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBairro, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCity))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPostalCode)
						.addComponent(textFieldPostalCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPeriod)
						.addComponent(textFieldPeriod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnActivity)
						.addComponent(checkCodigoPostal, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkPeriodo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(58)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSair)
						.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExcluir))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		
		//-----------------------------------------------------------------//
		
		contentPane.setLayout(gl_contentPane);
		createEvents();
		
		limpaTextoCampo();
		
		desabilitaCheckCampo();
	}

	//-----------------------------------------------------------------//
	
	private void createEvents() {
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	//-------------------------Incluir--------------------------------//
	//-----------------------------------------------------------------//
	
	private void IncluirAluno() {
		
		Integer toReturn = 0;
				
		Aluno aluno  = PegarDadosAluno();
		//System.out.println(aluno.toString());

		AlunoService alunoservice = new AlunoService();
				
		toReturn = alunoservice.save(aluno);
		
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
			
			aluno = new Aluno();
		}
	
	}
	
	//-------------------------Alterar---------------------------------//	
	//-----------------------------------------------------------------//
	
	protected void AlterarAluno() {
		
		Integer toReturn = 0;
		
		Aluno aluno  = PegarDadosAluno();
		
		AlunoService alunoservice = new AlunoService();
		
		alunoservice.update(aluno);	
						
		toReturn = alunoservice.update(aluno);
		
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
			
			aluno = new Aluno();
		}
	}	
	
	//-------------------------Excluir---------------------------------//
	//-----------------------------------------------------------------//
	
	protected void ExcluirAluno() {
		
		Integer toReturn = 0;
		
		Aluno aluno  = PegarDadosAluno();
				
		AlunoService alunoservice = new AlunoService();
		
		toReturn = alunoservice.delete(aluno);
		
		if ( toReturn == VariaveisProjeto.ERRO_EXCLUSAO ) {
			showMensagem("Erro na Exclusão do Registro, verifique com seu administrador!",
					   	 "Erro",JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.EXCLUSAO_REALIZADA) {
			showMensagem("Exclusão do Registro realizada com sucesso!",
					     "OK",JOptionPane.OK_OPTION);
			limpaTextoCampo();
			aluno = new Aluno();
		}
	}
	
	//-------------------------Show Mensagem---------------------------//
	//-----------------------------------------------------------------//

	private void showMensagem(String mensagem, String status, int option ) {
		JOptionPane.showMessageDialog(null, mensagem, status, option );
	}
		
	//-----------------------------------------------------------------//	
	//------------------------------NOME-------------------------------//
	
	private void digitacaoNomeValido() {
		status = true;
		mudaStatusCheckNome();
		checkNome.setVisible(true);
		textFieldGender.requestFocus();
	}
	
	//-----------------------------------------------------------------//	
	
	private boolean verificaDigitacaoNome() {
				
		if(VariaveisProjeto.digitacaoCampo(textFieldNome.getText())) {
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
			checkNome.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			checkNome.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		}		
	}
		
	//-----------------------------------------------------------------//	
	//------------------------------Gender-----------------------------//
	
	private void digitacaoGeneroValido() {
		
		status = true;		
		mudaStatusCheckGenero();
		checkGenero.setVisible(true);
		textFieldAge.requestFocus();
	}
	
	//-----------------------------------------------------------------//	
	
	private boolean verificaDigitacaoGenero() {
				
		if(VariaveisProjeto.digitacaoCampo(textFieldGender.getText())) {
			status = false;
			mudaStatusCheckGenero();
			return true;
		}		
		return false;
	}
	
	//-----------------------------------------------------------------//	
	
	private void mudaStatusCheckGenero() {
		
		checkGenero.setVisible(true);
		
		if(status == false) {
			checkGenero.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			checkGenero.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		}		
	}
			
	//-----------------------------------------------------------------//	
	//------------------------------Age--------------------------------//
	
	private void digitacaoIdadeValido() {
		status = true;
		mudaStatusCheckIdade();
		checkIdade.setVisible(true);
		textFieldTelephone.requestFocus();
	}
	
	//-----------------------------------------------------------------//	
	
	private boolean verificaDigitacaoIdade() {
				
		if(VariaveisProjeto.digitacaoCampo(textFieldAge.getText())) {
			status = false;
			mudaStatusCheckIdade();
			return true;
		}		
		return false;
	}
	
	//-----------------------------------------------------------------//	
	
	private void mudaStatusCheckIdade() {
		
		checkIdade.setVisible(true);
		
		if(status == false) {
			checkIdade.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			checkIdade.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		}		
	}
	
	//-----------------------------------------------------------------//	
	//------------------------------Telephone--------------------------//
	
	private void digitacaoTelefoneValido() {
		status = true;
		mudaStatusCheckTelefone();
		checkTelefone.setVisible(true);
		textFieldAdress.requestFocus();
	}
	
	//-----------------------------------------------------------------//	
	
	private boolean verificaDigitacaoTelefone() {
				
		if(VariaveisProjeto.digitacaoCampo(textFieldTelephone.getText())) {
			status = false;
			mudaStatusCheckTelefone();
			return true;
		}		
		return false;
	}
	
	//-----------------------------------------------------------------//	
	
	private void mudaStatusCheckTelefone() {
		
		checkTelefone.setVisible(true);
		
		if(status == false) {
			checkTelefone.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			checkTelefone.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		}		
	}
	
	//-----------------------------------------------------------------//	
	//------------------------------Adress-----------------------------//
	
	private void digitacaoEnderecoValido() {
		status = true;
		mudaStatusCheckEndereco();
		checkEndereco.setVisible(true);
		textFieldNumber.requestFocus();
	}
	
	//-----------------------------------------------------------------//	
	
	private boolean verificaDigitacaoEndereco() {
				
		if(VariaveisProjeto.digitacaoCampo(textFieldAdress.getText())) {
			status = false;
			mudaStatusCheckEndereco();
			return true;
		}		
		return false;
	}
	
	//-----------------------------------------------------------------//	
	
	private void mudaStatusCheckEndereco() {
		
		checkEndereco.setVisible(true);
		
		if(status == false) {
			checkEndereco.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			checkEndereco.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		}		
	}
	
	//-----------------------------------------------------------------//	
	//------------------------------Number-----------------------------//
	
	private void digitacaoNumeroValido() {
		status = true;
		mudaStatusCheckNumero();
		checkNumero.setVisible(true);
		textFieldNeighborhood.requestFocus();
	}
	
	//-----------------------------------------------------------------//	
	
	private boolean verificaDigitacaoNumero() {
				
		if(VariaveisProjeto.digitacaoCampo(textFieldNumber.getText())) {
			status = false;
			mudaStatusCheckNumero();
			return true;
		}		
		return false;
	}
	
	//-----------------------------------------------------------------//	
	
	private void mudaStatusCheckNumero() {
		
		checkNumero.setVisible(true);
		
		if(status == false) {
			checkNumero.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			checkNumero.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		}		
	}
	
	//-----------------------------------------------------------------//	
	//------------------------------Neighborhood-----------------------//
	
	private void digitacaoBairroValido() {
		status = true;
		mudaStatusCheckBairro();
		checkBairro.setVisible(true);
		textFieldCity.requestFocus();
	}
	
	//-----------------------------------------------------------------//	
	
	private boolean verificaDigitacaoBairro() {
				
		if(VariaveisProjeto.digitacaoCampo(textFieldNeighborhood.getText())) {
			status = false;
			mudaStatusCheckBairro();
			return true;
		}		
		return false;
	}
	
	//-----------------------------------------------------------------//	
	
	private void mudaStatusCheckBairro() {
		
		checkBairro.setVisible(true);
		
		if(status == false) {
			checkBairro.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			checkBairro.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		}		
	}
	
	//-----------------------------------------------------------------//	
	//------------------------------City-------------------------------//
	
	private void digitacaoCidadeValido() {
		status = true;
		mudaStatusCheckCidade();
		checkCidade.setVisible(true);
		textFieldPostalCode.requestFocus();
	}
	
	//-----------------------------------------------------------------//	
	
	private boolean verificaDigitacaoCidade() {
				
		if(VariaveisProjeto.digitacaoCampo(textFieldCity.getText())) {
			status = false;
			mudaStatusCheckCidade();
			return true;
		}		
		return false;
	}
	
	//-----------------------------------------------------------------//	
	
	private void mudaStatusCheckCidade() {
		
		checkCidade.setVisible(true);
		
		if(status == false) {
			checkCidade.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			checkCidade.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		}		
	}
	
	//-----------------------------------------------------------------//	
	//------------------------------PostalCode-------------------------//
	
	private void digitacaoCodigoPostalValido() {
		status = true;
		mudaStatusCheckCodigoPostal();
		checkCodigoPostal.setVisible(true);
		textFieldPeriod.requestFocus();
	}
	
	//-----------------------------------------------------------------//	
	
	private boolean verificaDigitacaoCodigoPostal() {
				
		if(VariaveisProjeto.digitacaoCampo(textFieldPostalCode.getText())) {
			status = false;
			mudaStatusCheckCodigoPostal();
			return true;
		}		
		return false;
	}
	
	//-----------------------------------------------------------------//	
	
	private void mudaStatusCheckCodigoPostal() {
		
		checkCodigoPostal.setVisible(true);
		
		if(status == false) {
			checkCodigoPostal.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			checkCodigoPostal.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		}		
	}
	
	//-----------------------------------------------------------------//	
	//------------------------------period-----------------------------//
	
	private void digitacaoPeriodoValido() {
		status = true;
		mudaStatusCheckPeriodo();
		checkPeriodo.setVisible(true);
		rdbtnActivity.requestFocus();
	}
	
	//-----------------------------------------------------------------//	
	
	private boolean verificaDigitacaoPeriodo() {
				
		if(VariaveisProjeto.digitacaoCampo(textFieldPeriod.getText())) {
			status = false;
			mudaStatusCheckPeriodo();
			return true;
		}		
		return false;
	}
	
	//-----------------------------------------------------------------//	
	
	private void mudaStatusCheckPeriodo() {
		
		checkPeriodo.setVisible(true);
		
		if(status == false) {
			checkPeriodo.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			checkPeriodo.setIcon(new ImageIcon(AlunoGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		}		
	}
	
	//-----------------------------------------------------------------//
	//-----------------------------------------------------------------//
	
	private void desabilitaCheckCampo() {
				
		checkNome.setVisible(false);		
		checkGenero.setVisible(false); 		
		checkTelefone.setVisible(false); 		
		checkIdade.setVisible(false);		
		checkNumero.setVisible(false); 
		checkEndereco.setVisible(false);		
		checkCidade.setVisible(false); 
		checkBairro.setVisible(false);		
		checkCodigoPostal.setVisible(false);		
		checkPeriodo.setVisible(false); 
		
	}
	
	//-----------------------------------------------------------------//
	
	private void BuscarAluno(){
		
		Aluno aluno = new Aluno();
		AlunoService alunoservice = new AlunoService();
		
		if(VariaveisProjeto.digitacaoCampo(textFieldCodigo.getText())) {
			textFieldCodigo.requestFocus();
			return;
		}
		
		Integer id = Integer.valueOf(textFieldCodigo.getText()); 
		
		aluno = alunoservice.findById(id);		
		
		aluno.setName(textFieldNome.getText());
		aluno.setGender(textFieldGender.getText());	
		aluno.setAge(textFieldAge.getColumns());		
		aluno.setAdress(textFieldAdress.getText());		
		aluno.setNumber(textFieldNumber.getColumns());		
		aluno.setNeighborhood(textFieldNeighborhood.getText());			
		aluno.setCity(textFieldCity.getText());				
		aluno.setTelephone(textFieldTelephone.getColumns());			
		aluno.setPostal_code(textFieldPostalCode.getColumns());			
		aluno.setPeriod(textFieldPeriod.getText());
		
		
		if(aluno.isActivity()) {
			rdbtnActivity.setSelected(true);
		} 
		
	}
	
	//-----------------------------------------------------------------//
	
	public Aluno PegarDadosAluno() {
		
		Aluno aluno = new Aluno();
		
		if(!"".equals(textFieldCodigo.getText())) {
			aluno.setIdAluno(Integer.valueOf(textFieldCodigo.getText()));
		}
		
		aluno.setIdAluno(VariaveisProjeto.convertToInteger(textFieldCodigo.getText()));
		aluno.setName(textFieldNome.getText());
		aluno.setGender(textFieldGender.getText());	
		aluno.setAge(textFieldAge.getColumns());		
		aluno.setAdress(textFieldAdress.getText());		
		aluno.setNumber(textFieldNumber.getColumns());		
		aluno.setNeighborhood(textFieldNeighborhood.getText());			
		aluno.setCity(textFieldCity.getText());				
		aluno.setTelephone(textFieldTelephone.getColumns());			
		aluno.setPostal_code(textFieldPostalCode.getColumns());			
		aluno.setPeriod(textFieldPeriod.getText());
		
		if(rdbtnActivity.isSelected()) {
			aluno.setActivity(true);
		} else{
			aluno.setActivity(false);
		}
		
		return aluno;
	}
	
	//-----------------------------------------------------------------//
	
	private void limpaTextoCampo() {
		
		textFieldCodigo.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldNome.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldGender.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldAge.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldAdress.setText(VariaveisProjeto.LIMPA_CAMPO);		
		textFieldNumber.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldNeighborhood.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldCity.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldTelephone.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldPostalCode.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldPeriod.setText(VariaveisProjeto.LIMPA_CAMPO);		
		rdbtnActivity.setSelected(false);
		
	}
	
}
