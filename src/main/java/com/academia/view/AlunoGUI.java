package com.academia.view;

import java.awt.BorderLayout; 
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
		
		textFieldNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if( verificaDigitacaoNome() ) {
						textFieldNome.requestFocus();
					} else {
						status = true;
						mudaStatusCheckNome();
						checkNome.setVisible(true);
						textFieldGender.requestFocus();
					}						
				}
			}
		});
		textFieldNome.setColumns(10);
		
		//-----------------------------------------------------------------//	
		
		JLabel lblGender = new JLabel("Genero:");
		
		textFieldGender = new JTextField();
		
		textFieldGender.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldAge.requestFocus();
				}
			}
		});
		textFieldGender.setColumns(10);
		
		//-----------------------------------------------------------------//	
		
		JLabel lblIdade = new JLabel("Idade");
		
		textFieldAge = new JTextField();
		
		textFieldAge.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldTelephone.requestFocus();
				}
			}
		});
		textFieldAge.setColumns(10);
		
		//-----------------------------------------------------------------//	
		
		lblAdress = new JLabel("Endereço:");
		
		textFieldAdress = new JTextField();
		
		textFieldAdress.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldNumber.requestFocus();
				}
			}
		});
		textFieldAdress.setColumns(10);
		
		//-----------------------------------------------------------------//	
		
		lblNumber = new JLabel("Numero:");
		
		textFieldNumber = new JTextField();
		
		textFieldNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldNeighborhood.requestFocus();
				}
			}
		});
		textFieldNumber.setColumns(10); 
		
		//-----------------------------------------------------------------//	
		
		lblNeighborhood = new JLabel("Bairro:");
		
		textFieldNeighborhood = new JTextField();
		
		textFieldNeighborhood.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldCity.requestFocus();
				}
			}
		});
		textFieldNeighborhood.setColumns(10);
		
		//-----------------------------------------------------------------//	
		
		lblCity = new JLabel("Cidade:");
		
		textFieldCity = new JTextField();
		
		textFieldCity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldPostalCode.requestFocus();
				}
			}
		});
		textFieldCity.setColumns(10);
		
		//-----------------------------------------------------------------//	
		
		lblTelephone = new JLabel("Telefone:");
		
		textFieldTelephone = new JTextField();
		
		textFieldTelephone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldAdress.requestFocus();
				}
			}
		});
		textFieldTelephone.setColumns(10);
		
		//-----------------------------------------------------------------//	
		
		lblPostalCode = new JLabel("Codigo Postal:");
		
		textFieldPostalCode = new JTextField();
		
		textFieldPostalCode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldPeriod.requestFocus();
				}
			}
		});
		textFieldPostalCode.setColumns(10);
		
		//-----------------------------------------------------------------//	
		
		lblPeriod = new JLabel("Periodo:");
		
		textFieldPeriod = new JTextField();
		
		textFieldPeriod.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					rdbtnActivity.requestFocus();
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
	
	//-----------------------------------------------------------------//
	
	private void IncluirAluno() {
		
		Aluno aluno  = PegarDadosAluno();
		//System.out.println(aluno.toString());

		AlunoService alunoservice = new AlunoService();
		
		alunoservice.save(aluno);
		
		limpaTextoCampo();
	}
	
	//-----------------------------------------------------------------//
	
	protected void AlterarAluno() {
		
		Aluno aluno  = PegarDadosAluno();
		AlunoService alunoservice = new AlunoService();
		
		alunoservice.update(aluno);		
		
		limpaTextoCampo();
	}	
	
	//-----------------------------------------------------------------//
	
	protected void ExcluirAluno() {
		
		Aluno aluno  = PegarDadosAluno();
		
		AlunoService alunoservice = new AlunoService();
		
		alunoservice.save(aluno);
		
		alunoservice.delete(aluno);
		
		limpaTextoCampo();
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
			checkNome.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			checkNome.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		}
		
	}
	
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
