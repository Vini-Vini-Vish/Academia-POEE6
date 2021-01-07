package com.academia.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.academia.model.models.Aluno;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlunoGUI extends JFrame {

	private JPanel contentPane;
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

	/**
	 * Launch the application.
	 */
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblName = new JLabel("Nome:");
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		
		JLabel lblGender = new JLabel("Genero:");
		
		textFieldGender = new JTextField();
		textFieldGender.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade");
		
		textFieldAge = new JTextField();
		textFieldAge.setColumns(10);
		
		lblAdress = new JLabel("Endereço:");
		
		textFieldAdress = new JTextField();
		textFieldAdress.setColumns(10);
		
		lblNumber = new JLabel("Numero:");
		
		textFieldNumber = new JTextField();
		textFieldNumber.setColumns(10);
		
		lblNeighborhood = new JLabel("Bairro:");
		
		textFieldNeighborhood = new JTextField();
		textFieldNeighborhood.setColumns(10);
		
		lblCity = new JLabel("Cidade:");
		
		textFieldCity = new JTextField();
		textFieldCity.setColumns(10);
		
		lblTelephone = new JLabel("Telefone:");
		
		textFieldTelephone = new JTextField();
		textFieldTelephone.setColumns(10);
		
		lblPostalCode = new JLabel("Codigo Postal:");
		
		textFieldPostalCode = new JTextField();
		textFieldPostalCode.setColumns(10);
		
		lblPeriod = new JLabel("Periodo:");
		
		textFieldPeriod = new JTextField();
		textFieldPeriod.setText("");
		textFieldPeriod.setColumns(10);
		
		rdbtnActivity = new JRadioButton("Ativo");
		
		//-----------------------------------------------------------------//		
		btnIncluir = new JButton("Incluir");
		
		btnAlterar = new JButton("Alterar");
		
		btnExcluir = new JButton("Excluir");
		
		btnSair = new JButton("Sair");		
		//-----------------------------------------------------------------//	
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblName)
								.addComponent(lblGender)
								.addComponent(lblAdress)
								.addComponent(lblNeighborhood))
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, 590, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textFieldNeighborhood, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
									.addGap(40)
									.addComponent(lblCity)
									.addGap(18)
									.addComponent(textFieldCity, 223, 223, 223))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldAdress, GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(textFieldGender, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
											.addGap(43)
											.addComponent(lblIdade)
											.addGap(27)
											.addComponent(textFieldAge, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
											.addGap(52)
											.addComponent(lblTelephone)))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldTelephone, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNumber)
											.addGap(18)
											.addComponent(textFieldNumber, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPostalCode)
								.addComponent(btnIncluir))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnAlterar)
									.addGap(28)
									.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textFieldPostalCode, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addGap(65)
									.addComponent(lblPeriod)
									.addGap(18)
									.addComponent(textFieldPeriod, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
									.addComponent(rdbtnActivity)
									.addGap(75)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
					.addGap(61))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblGender)
						.addComponent(textFieldGender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblIdade)
							.addComponent(textFieldAge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(textFieldTelephone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblTelephone)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdress)
						.addComponent(textFieldAdress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumber)
						.addComponent(textFieldNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNeighborhood)
						.addComponent(textFieldNeighborhood, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCity)
						.addComponent(textFieldCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPostalCode)
						.addComponent(textFieldPostalCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPeriod)
						.addComponent(textFieldPeriod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnActivity))
					.addGap(58)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSair)
						.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExcluir)
						.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(112, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		createEvents();
	}
	
	private void createEvents() {
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	public Aluno PegarDadosAluno() {
		Aluno aluno = new Aluno();
		
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
	
}
