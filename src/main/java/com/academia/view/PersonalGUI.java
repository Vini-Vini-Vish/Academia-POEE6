package com.academia.view;

import java.awt.BorderLayout; 
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.academia.estrutura.util.VariaveisProjeto;
import com.academia.model.models.Personal;
import com.academia.model.models.Usuario;
import com.academia.model.service.PersonalService;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
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

public class PersonalGUI extends JFrame {

	private static final long serialVersionUID = 2190619453341927627L;
	
	private JPanel contentPane;
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
	private JLabel lblCodigo;
	private JTextField textFieldCodigo;

	/**
	 * Launch the application.
	 */
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
		setBounds(100, 100, 782, 453);
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
		
		textFieldName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldAge.requestFocus();
				}
			}
		});
		textFieldName.setColumns(10);
		
		//-----------------------------------------------------------------//
		
		JLabel lblAge = new JLabel("Idade:");
		
		textFieldAge = new JTextField();
		
		textFieldAge.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldTelephone.requestFocus();
				}
			}
		});
		textFieldAge.setText("");
		textFieldAge.setColumns(10);
		
		//-----------------------------------------------------------------//
		
		JLabel lblAdress = new JLabel("Endereço:");
		
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
		
		JLabel lblNumberl = new JLabel("Numero:");
		
		textFieldNumber = new JTextField();
		
		textFieldNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldNeightbornhood.requestFocus();
				}
			}
		});
		textFieldNumber.setColumns(10);
		
		//-----------------------------------------------------------------//
		
		JLabel lblNeightbornhood = new JLabel("Bairro:");
		
		textFieldNeightbornhood = new JTextField();
		
		textFieldNeightbornhood.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldCity.requestFocus();
				}
			}
		});
		textFieldNeightbornhood.setColumns(10);
		
		//-----------------------------------------------------------------//
		
		JLabel lblCity = new JLabel("Cidade:");
		
		textFieldCity = new JTextField();
		
		textFieldCity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldCodePost.requestFocus();
				}
			}
		});
		textFieldCity.setColumns(10);
		
		//-----------------------------------------------------------------//
		
		JLabel lblTelephone = new JLabel("Telefone:");
		
		textFieldTelephone = new JTextField();
		
		textFieldTelephone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldGender.requestFocus();
				}
			}
		});
		textFieldTelephone.setColumns(10);
		
		//-----------------------------------------------------------------//
		
		JLabel lblPostalCode = new JLabel("Codigo Postal:");
		
		textFieldCodePost = new JTextField();
		
		textFieldCodePost.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldPeriod.requestFocus();
				}
			}
		});
		textFieldCodePost.setColumns(10);
		
		//-----------------------------------------------------------------//
		
		JLabel lblGender = new JLabel("Genero:");
		
		textFieldGender = new JTextField();
		
		textFieldGender.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldAdress.requestFocus();
				}
			}
		});
		textFieldGender.setColumns(10);
		
		//-----------------------------------------------------------------//
		
		JLabel lblPeriod = new JLabel("Periodo:");
		
		textFieldPeriod = new JTextField();
		
		textFieldPeriod.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldCref.requestFocus();
				}
			}
		});
		textFieldPeriod.setText("");
		textFieldPeriod.setColumns(10);
		
		//-----------------------------------------------------------------//
		
		JLabel lblCref = new JLabel("CREF:");
		
		textFieldCref = new JTextField();
		
		textFieldCref.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					rdbtnActivity.requestFocus();
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
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IncluirPersonal();
			}
		});
		
		//-----------------------------------------------------------------//
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarPersonal();
			}
		});
		
		//-----------------------------------------------------------------//
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcluirPersonal();
			}
		});
		
		//-----------------------------------------------------------------//
		
		btnSair = new JButton("Sair");		
		
		//-----------------------------------------------------------------//	
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCodigo)
							.addContainerGap())
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
							.addGap(17)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(textFieldCity, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGap(1)
													.addComponent(btnAlterar)
													.addGap(18)
													.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGap(47)
													.addComponent(lblPostalCode)
													.addGap(18)
													.addComponent(textFieldCodePost, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
												.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
											.addComponent(textFieldName)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(textFieldAge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(35)
												.addComponent(lblTelephone)
												.addGap(18)
												.addComponent(textFieldTelephone, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
												.addGap(51)
												.addComponent(lblGender)
												.addGap(18)
												.addComponent(textFieldGender))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
													.addComponent(textFieldNeightbornhood, Alignment.LEADING)
													.addComponent(textFieldAdress, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
												.addGap(29)
												.addComponent(lblNumberl)
												.addGap(18)
												.addComponent(textFieldNumber))
											.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(250)
											.addComponent(lblCref)
											.addGap(18)
											.addComponent(textFieldCref, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
											.addGap(18)
											.addComponent(rdbtnActivity)))
									.addGap(43))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textFieldPeriod, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))))
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
							.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(34)
							.addComponent(lblName)))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAge)
						.addComponent(textFieldAge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelephone)
						.addComponent(textFieldTelephone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGender)
						.addComponent(textFieldGender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdress, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldAdress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumberl)
						.addComponent(textFieldNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNeightbornhood)
						.addComponent(textFieldNeightbornhood, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCity)
						.addComponent(textFieldCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCodePost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPostalCode))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPeriod)
						.addComponent(textFieldPeriod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCref)
						.addComponent(textFieldCref, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnActivity))
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSair)
						.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAlterar)
						.addComponent(btnExcluir))
					.addGap(54))
		);
		
		//-----------------------------------------------------------------//
		
		contentPane.setLayout(gl_contentPane);
		createEvents();
	}
	
	//-----------------------------------------------------------------//
	
	private void createEvents() {
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	//-----------------------------------------------------------------------//
	
	private void IncluirPersonal() {
		
		Personal personal  = PegarDadosPersonal();
		//System.out.println(personal.toString());

		PersonalService personalservice = new PersonalService();
		
		personalservice.save(personal);
		
		limpaTextoCampo();
	}
	
	//-----------------------------------------------------------------//
	
	protected void AlterarPersonal() {
		
		Personal personal  = PegarDadosPersonal();
		PersonalService personalservice = new PersonalService();
		
		personalservice.update(personal);		
	}	
	
	//-----------------------------------------------------------------//
	
	protected void ExcluirPersonal() {
		
		Personal personal  = PegarDadosPersonal();
		
		PersonalService personalservice = new PersonalService();
		
		personalservice.save(personal);
		
		personalservice.delete(personal);
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
		rdbtnActivity.setText(VariaveisProjeto.LIMPA_CAMPO);

	}
}
