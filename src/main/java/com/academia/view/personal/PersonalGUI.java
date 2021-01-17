package com.academia.view.personal;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.academia.estrutura.util.VariaveisProjeto;
import com.academia.model.models.Personal;
import com.academia.model.service.PersonalService;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class PersonalGUI extends JFrame {

	private static final long serialVersionUID = 2190619453341927627L;
	
	private JPanel contentPane;
	private JLabel lblCodigo;
	private JTextField textFieldCodigo;
	private JTextField textFieldName;
	private JTextField textFieldAge;
	private JTextField textFieldAdress;
	private JTextField textFieldNumber;
	private JTextField textFieldNeightbornhood;
	private JTextField textFieldCity;
	private JTextField textFieldTelephone;
	private JTextField textFieldCodePost;
	private JTextField textFieldGender;
	private JTextField textFieldPeriod;
	private JTextField textFieldCref;
	private JRadioButton rdbtnActivity;
	
	private JButton btnIncluir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnSair;
	
	private JLabel checkNome;
	private JLabel checkIdade;
	private JLabel CheckTelefone;
	private JLabel checkGenero;
	private JLabel checkNumero;
	private JLabel checkCodigoPostal;
	private JLabel checkBairro;
	private JLabel checkCidade;
	private JLabel checkEndereco;
	private JLabel checkCref;
	private JLabel checkPeriodo;
		
	private boolean status = true; 

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalGUI frame = new PersonalGUI();
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
	public PersonalGUI() {
		setTitle("Cadastro Personal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//-----------------------------------------------------------------//
		
		lblCodigo = new JLabel("Codigo");
		
		textFieldCodigo = new JTextField();
		
		textFieldCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				BuscarPersonal();
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldName.requestFocus();
				}
			}
		});
		
		textFieldCodigo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				BuscarPersonal();
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
						textFieldAge.requestFocus();
					}										
				}
			}
		});
		textFieldName.setColumns(10);
		
		//-----------------------------------------------------------------//
		
		JLabel lblAge = new JLabel("Idade:");
		
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
		textFieldAge.setText("");
		textFieldAge.setColumns(10);
		
		//-----------------------------------------------------------------//
		
		JLabel lblAdress = new JLabel("Endereço:");
		
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
		
		JLabel lblNumberl = new JLabel("Numero:");
		
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
						textFieldNeightbornhood.requestFocus();
					}					
				}
			}
		});
		textFieldNumber.setColumns(10);
		
		//-----------------------------------------------------------------//
		
		JLabel lblNeightbornhood = new JLabel("Bairro:");
		
		textFieldNeightbornhood = new JTextField();
		textFieldNeightbornhood.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if( verificaDigitacaoBairro() ) {
					textFieldNeightbornhood.requestFocus();
				} else {
					digitacaoBairroValido();
				}
			}
		});
		
		textFieldNeightbornhood.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if( verificaDigitacaoBairro() ) {
						textFieldNeightbornhood.requestFocus();
					} else {
						digitacaoBairroValido();
						textFieldCity.requestFocus();
					}						
				}
			}
		});
		textFieldNeightbornhood.setColumns(10);
		
		//-----------------------------------------------------------------//
		
		JLabel lblCity = new JLabel("Cidade:");
		
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
						textFieldCodePost.requestFocus();
					}					
				}
			}
		});
		textFieldCity.setColumns(10);
		
		//-----------------------------------------------------------------//
		
		JLabel lblTelephone = new JLabel("Telefone:");
		
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
						textFieldGender.requestFocus();
					}						
				}
			}
		});
		textFieldTelephone.setColumns(10);
		
		//-----------------------------------------------------------------//
		
		JLabel lblPostalCode = new JLabel("Codigo Postal:");
		
		textFieldCodePost = new JTextField();
		textFieldCodePost.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if( verificaDigitacaoCodigoPostal() ) {
					textFieldCodePost.requestFocus();
				} else {
					digitacaoCodigoPostalValido();
				}
			}
		});
		
		textFieldCodePost.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if( verificaDigitacaoCodigoPostal() ) {
						textFieldCodePost.requestFocus();
					} else {
						digitacaoCodigoPostalValido();
						textFieldPeriod.requestFocus();
					}					
				}
			}
		});
		textFieldCodePost.setColumns(10);
		
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
						textFieldAdress.requestFocus();
					}
					
				}
			}
		});
		textFieldGender.setColumns(10);
		
		//-----------------------------------------------------------------//
		
		JLabel lblPeriod = new JLabel("Periodo:");
		
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
						textFieldCref.requestFocus();
					}					
				}
			}
		});
		textFieldPeriod.setText("");
		textFieldPeriod.setColumns(10);
		
		//-----------------------------------------------------------------//
		
		JLabel lblCref = new JLabel("CREF:");
		
		textFieldCref = new JTextField();
		textFieldCref.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if( verificaDigitacaoCref() ) {
					textFieldCref.requestFocus();
				} else {
					digitacaoCrefValido();
				}
			}
		});
		
		textFieldCref.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if( verificaDigitacaoCref() ) {
						textFieldCref.requestFocus();
					} else {
						digitacaoCrefValido();
						rdbtnActivity.requestFocus();
					}						
				}
			}
		});
		
		textFieldCref.setText("");
		textFieldCref.setColumns(10);
		
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
		btnIncluir.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/application_form_add.png")));
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IncluirPersonal();
			}
		});
		
		//-----------------------------------------------------------------//
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/application_form_edit.png")));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarPersonal();
			}
		});
		
		//-----------------------------------------------------------------//
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/application_form_delete.png")));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcluirPersonal();
			}
		});
		
		//-----------------------------------------------------------------//
		
		btnSair = new JButton("Sair");		 
		btnSair.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/sair.png")));
		
		//-----------------------------------------------------------------//
		
		checkNome = new JLabel("");
		checkNome.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		checkIdade = new JLabel("");
		checkIdade.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		CheckTelefone = new JLabel("");
		CheckTelefone.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		checkGenero = new JLabel("");
		checkGenero.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		checkNumero = new JLabel("");
		checkNumero.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		checkCodigoPostal = new JLabel("");
		checkCodigoPostal.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		checkBairro = new JLabel("");
		checkBairro.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		checkCidade = new JLabel("");
		checkCidade.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		checkEndereco = new JLabel("");
		checkEndereco.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		checkCref = new JLabel("");
		checkCref.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		checkPeriodo = new JLabel("");
		checkPeriodo.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		
		//-----------------------------------------------------------------//	
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCodigo)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNeightbornhood)
								.addComponent(lblCity)
								.addComponent(lblPeriod)
								.addComponent(lblAdress)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblAge, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(btnIncluir))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(9)
											.addComponent(btnAlterar)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(btnExcluir))
										.addComponent(textFieldCity, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE))
									.addGap(4)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(checkCidade, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblPostalCode)
											.addGap(12)
											.addComponent(textFieldCodePost, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
											.addGap(6))
										.addComponent(btnSair)))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textFieldName)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(textFieldAge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(checkIdade, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
										.addGap(12)
										.addComponent(lblTelephone)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textFieldTelephone, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
										.addGap(8)
										.addComponent(CheckTelefone, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblGender)
										.addGap(18)
										.addComponent(textFieldGender))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(textFieldNeightbornhood, Alignment.LEADING)
											.addComponent(textFieldAdress, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(checkEndereco, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblNumberl)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(textFieldNumber, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
											.addComponent(checkBairro, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
									.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textFieldPeriod, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(checkPeriodo, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
									.addGap(47)
									.addComponent(lblCref)
									.addGap(18)
									.addComponent(textFieldCref, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(checkCref, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(checkNumero, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
									.addComponent(checkGenero, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
									.addComponent(checkNome, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
									.addComponent(checkCodigoPostal, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
								.addComponent(rdbtnActivity))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigo)
						.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(checkNome)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(34)
							.addComponent(lblName)))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblAge)
							.addComponent(textFieldAge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(textFieldTelephone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblGender)
							.addComponent(textFieldGender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(checkIdade, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(checkGenero, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblTelephone))
						.addComponent(CheckTelefone, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdress, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldAdress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkNumero, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumberl)
						.addComponent(checkEndereco, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNeightbornhood)
						.addComponent(textFieldNeightbornhood, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBairro, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblCity)
									.addComponent(textFieldCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblPostalCode)
									.addComponent(textFieldCodePost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(checkCidade, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblPeriod)
										.addComponent(textFieldPeriod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldCref, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(rdbtnActivity)
										.addComponent(checkCref, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCref))
									.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnSair)
										.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnExcluir)
										.addComponent(btnAlterar))
									.addGap(54))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(checkPeriodo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(checkCodigoPostal, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
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
	
	//-------------------------Incluir---------------------------------------//
	//-----------------------------------------------------------------------//
	
	private void IncluirPersonal() {
		
		Integer toReturn = 0;
		
		Personal personal  = PegarDadosPersonal();
		//System.out.println(personal.toString());

		PersonalService personalservice = new PersonalService();
		
		personalservice.save(personal);
		
		toReturn = personalservice.save(personal);
		
		//-----------------------------------------------------------------//
		
		if( toReturn == VariaveisProjeto.NOME ) {
			status = false;
			mudaStatusCheckNome();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}	
		if( toReturn == VariaveisProjeto.GENERO ) {
			status = false;
			mudaStatusCheckGenero();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}	
		if( toReturn == VariaveisProjeto.IDADE ) {
			status = false;
			mudaStatusCheckIdade();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}	
		if( toReturn == VariaveisProjeto.ENDERECO ) {
			status = false;
			mudaStatusCheckEndereco();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}	
		if( toReturn == VariaveisProjeto.NUMERO ) {
			status = false;
			mudaStatusCheckNumero();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}	
		if( toReturn == VariaveisProjeto.BAIRRO ) {
			status = false;
			mudaStatusCheckBairro();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}	
		if( toReturn == VariaveisProjeto.CIDADE ) {
			status = false;
			mudaStatusCheckCidade();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}	
		if( toReturn == VariaveisProjeto.TELEFONE ) {
			status = false;
			mudaStatusCheckTelefone();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}	
		if( toReturn == VariaveisProjeto.CODIGO_POSTAL ) {
			status = false;
			mudaStatusCheckTelefone();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}	
		if( toReturn == VariaveisProjeto.PERIODO ) {
			status = false;
			mudaStatusCheckPeriodo();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}	
		if( toReturn == VariaveisProjeto.CREF) {
			status = false;
			mudaStatusCheckCref();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}	
		
		//-----------------------------------------------------------------//
		
		if ( toReturn == VariaveisProjeto.ERRO_ALTERACAO ) {
			showMensagem("Erro na alteração do Registro, verifique com seu administrador!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		if ( toReturn == VariaveisProjeto.ERRO_ALTERACAO) {
			showMensagem("alteração do Registro realizada com sucesso!", "OK", JOptionPane.OK_OPTION);
			
			limpaTextoCampo();
			
			personal = new Personal();
		}
	}
	
	//-------------------------Alterar---------------------------------//
	//-----------------------------------------------------------------//
	
	protected void AlterarPersonal() {
		
		Integer toReturn = 0;
		
		Personal personal  = PegarDadosPersonal();
		
		PersonalService personalservice = new PersonalService();
		
		personalservice.update(personal);	
		
		toReturn = personalservice.update(personal);	
		
		//-----------------------------------------------------------------//
		
		if( toReturn == VariaveisProjeto.NOME ) {
			status = false;
			mudaStatusCheckNome();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}	
		if( toReturn == VariaveisProjeto.GENERO ) {
			status = false;
			mudaStatusCheckGenero();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}	
		if( toReturn == VariaveisProjeto.IDADE ) {
			status = false;
			mudaStatusCheckIdade();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}	
		if( toReturn == VariaveisProjeto.ENDERECO ) {
			status = false;
			mudaStatusCheckEndereco();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}	
		if( toReturn == VariaveisProjeto.NUMERO ) {
			status = false;
			mudaStatusCheckNumero();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}	
		if( toReturn == VariaveisProjeto.BAIRRO ) {
			status = false;
			mudaStatusCheckBairro();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}	
		if( toReturn == VariaveisProjeto.CIDADE ) {
			status = false;
			mudaStatusCheckCidade();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}	
		if( toReturn == VariaveisProjeto.TELEFONE ) {
			status = false;
			mudaStatusCheckTelefone();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}	
		if( toReturn == VariaveisProjeto.CODIGO_POSTAL ) {
			status = false;
			mudaStatusCheckTelefone();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}	
		if( toReturn == VariaveisProjeto.PERIODO ) {
			status = false;
			mudaStatusCheckPeriodo();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}	
		if( toReturn == VariaveisProjeto.CREF) {
			status = false;
			mudaStatusCheckCref();
			showMensagem("Erro na Digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}				
		
		//-----------------------------------------------------------------//
		
		if ( toReturn == VariaveisProjeto.ERRO_ALTERACAO ) {
			showMensagem("Erro na alteração do Registro, verifique com seu administrador!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		if ( toReturn == VariaveisProjeto.ALTERACAO_REALIZADA) {
			showMensagem("alteração do Registro realizada com sucesso!", "OK", JOptionPane.OK_OPTION);
			
			limpaTextoCampo();
			
			personal = new Personal();
		}
		
		limpaTextoCampo();
	}	
	
	//-------------------------Excluir---------------------------------//
	//-----------------------------------------------------------------//
	
	protected void ExcluirPersonal() {
		
		Integer toReturn = 0;
		
		Personal personal  = PegarDadosPersonal();
		
		PersonalService personalservice = new PersonalService();		
				
		toReturn = personalservice.delete(personal);
		
		if ( toReturn == VariaveisProjeto.ERRO_EXCLUSAO ) {
			showMensagem("Erro na Exclusão do Registro, verifique com seu administrador!",
					   	 "Erro",JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.EXCLUSAO_REALIZADA) {
			showMensagem("Exclusão do Registro realizada com sucesso!",
					     "OK",JOptionPane.OK_OPTION);
			limpaTextoCampo();
			personal = new Personal();
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
		textFieldAge.requestFocus();
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
			checkNome.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			checkNome.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
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
			checkGenero.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			checkGenero.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
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
			checkIdade.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			checkIdade.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		}		
	}
	
	//-----------------------------------------------------------------//	
	//------------------------------Telephone--------------------------//
	
	private void digitacaoTelefoneValido() {
		status = true;
		mudaStatusCheckTelefone();
		CheckTelefone.setVisible(true);
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
		
		CheckTelefone.setVisible(true);
		
		if(status == false) {
			CheckTelefone.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			CheckTelefone.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
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
			checkEndereco.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			checkEndereco.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		}		
	}
	
	//-----------------------------------------------------------------//	
	//------------------------------Number-----------------------------//
	
	private void digitacaoNumeroValido() {
		status = true;
		mudaStatusCheckNumero();
		checkNumero.setVisible(true);
		textFieldNeightbornhood.requestFocus();
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
			checkNumero.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			checkNumero.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/imagens/ok.png")));
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
				
		if(VariaveisProjeto.digitacaoCampo(textFieldNeightbornhood.getText())) {
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
			checkBairro.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			checkBairro.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/imagens/ok.png")));
		}		
	}
	
	//-----------------------------------------------------------------//	
	//------------------------------City-------------------------------//
	
	private void digitacaoCidadeValido() {
		status = true;
		mudaStatusCheckCidade();
		checkCidade.setVisible(true);
		textFieldCodePost.requestFocus();
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
			checkCidade.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			checkCidade.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
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
				
		if(VariaveisProjeto.digitacaoCampo(textFieldCodePost.getText())) {
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
			checkCodigoPostal.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			checkCodigoPostal.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		}		
	}
	
	//-----------------------------------------------------------------//	
	//------------------------------period-----------------------------//
	
	private void digitacaoPeriodoValido() {
		status = true;
		mudaStatusCheckPeriodo();
		checkPeriodo.setVisible(true);
		textFieldCref.requestFocus();
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
			checkPeriodo.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			checkPeriodo.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		}		
	}
		
	//-----------------------------------------------------------------//	
	//------------------------------period-----------------------------//
	
	private void digitacaoCrefValido() {
		status = true;
		mudaStatusCheckCref();
		checkCref.setVisible(true);
		rdbtnActivity.requestFocus();
	}
	
	//-----------------------------------------------------------------//	
	
	private boolean verificaDigitacaoCref() {
				
		if(VariaveisProjeto.digitacaoCampo(textFieldCref.getText())) {
			status = false;
			mudaStatusCheckCref();
			return true;
		}		
		return false;
	}
	
	//-----------------------------------------------------------------//	
	
	private void mudaStatusCheckCref() {
		
		checkCref.setVisible(true);
		
		if(status == false) {
			checkCref.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		} else {
			checkCref.setIcon(new ImageIcon(PersonalGUI.class.getResource("/com/academia/estrutura/imagens/ok.png")));
		}		
	}
	
	//-----------------------------------------------------------------//	
	//-----------------------------------------------------------------//		
		
	private void desabilitaCheckCampo() {
		
		checkNome.setVisible(false);		
		checkIdade.setVisible(false);		
		CheckTelefone.setVisible(false);		
		checkGenero.setVisible(false);		
		checkNumero.setVisible(false);		 
		checkCodigoPostal.setVisible(false);		
		checkBairro.setVisible(false);		
		checkCidade.setVisible(false);		
		checkEndereco.setVisible(false);		
		checkCref.setVisible(false);		 
		checkPeriodo.setVisible(false);		 
		
	}
	
	//-----------------------------------------------------------------//
	
	private void BuscarPersonal(){
		
		Personal personal = new Personal();
		PersonalService personalservice = new PersonalService();
		
		if(VariaveisProjeto.digitacaoCampo(textFieldCodigo.getText())) {
			textFieldCodigo.requestFocus();
			return;
		}
		
		Integer id = Integer.valueOf(textFieldCodigo.getText()); 
		
		personal = personalservice.findById(id);		
		
		personal.setName(textFieldName.getText());
		personal.setAge(textFieldAge.getColumns());
		personal.setAdress(textFieldAdress.getText());
		personal.setNumber(textFieldNumber.getColumns());
		personal.setNeighborhood(textFieldNeightbornhood.getText());		
		personal.setCity(textFieldCity.getText());		
		personal.setTelephone(textFieldTelephone.getColumns());		
		personal.setCodeposte(textFieldCodePost.getColumns());
		personal.setGender(textFieldGender.getText());		
		personal.setPeriod(textFieldPeriod.getText());
		personal.setCref(textFieldCref.getText());	
		
		
		if(personal.isActivity()) {
			rdbtnActivity.setSelected(true);
		} 
		
	}
	
	//-----------------------------------------------------------------//
	
	public Personal PegarDadosPersonal() {
		
		Personal personal = new Personal();
		
		if(!"".equals(textFieldCodigo.getText())) {
			personal.setIdpersonal(Integer.valueOf(textFieldCodigo.getText()));
		}
		
		personal.setIdpersonal(VariaveisProjeto.convertToInteger(textFieldCodigo.getText()));
		personal.setName(textFieldName.getText());
		personal.setAge(textFieldAge.getColumns());
		personal.setAdress(textFieldAdress.getText());
		personal.setNumber(textFieldNumber.getColumns());
		personal.setNeighborhood(textFieldNeightbornhood.getText());		
		personal.setCity(textFieldCity.getText());		
		personal.setTelephone(textFieldTelephone.getColumns());		
		personal.setCodeposte(textFieldCodePost.getColumns());
		personal.setGender(textFieldGender.getText());		
		personal.setPeriod(textFieldPeriod.getText());
		personal.setCref(textFieldCref.getText());		
		
		if(rdbtnActivity.isSelected()) {
			personal.setActivity(true);
		} else{
			personal.setActivity(false);
		}
		
		return personal;
	}
	
	//-----------------------------------------------------------------//
	
	private void limpaTextoCampo() {
		
		textFieldCodigo.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldName.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldGender.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldAge.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldAdress.setText(VariaveisProjeto.LIMPA_CAMPO);		
		textFieldNumber.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldNeightbornhood.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldCity.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldTelephone.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldCodePost.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldPeriod.setText(VariaveisProjeto.LIMPA_CAMPO);	
		textFieldCref.setText(VariaveisProjeto.LIMPA_CAMPO);	
		rdbtnActivity.setSelected(false);

	}
}
