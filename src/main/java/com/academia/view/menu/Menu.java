package com.academia.view.menu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.academia.main.Login;
import com.academia.view.aluno.TabelaAluno;
import com.academia.view.atividade.TabelaAtividade;
import com.academia.view.dadosusuario.usuario.TabelaUsuario;
import com.academia.view.personal.TabelaPersonal;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {
	
	private static final long serialVersionUID = -7288934016245956517L;
	
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu arquivo;
	private JMenuItem usuario;
	private JMenuItem aluno;
	private JMenuItem personal;
	
	private Login login;
	private JMenu sair;
	private JMenuItem sair_sistema;
	private JMenuItem atividade;

	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	
	public Menu(Login login) {
		this.login = login;
		initComponents();
	}
	
	private void initComponents() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 532);
		
		//-----------------------------------------------------------------//
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//-----------------------------------------------------------------//
		
		arquivo = new JMenu("Arquivo");
		menuBar.add(arquivo);
		
		//-----------------------------------------------------------------//
		
		usuario = new JMenuItem("Usuario");
		usuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaUsuario tabelaUsuario = new TabelaUsuario();
				contentPane.add(tabelaUsuario);
				tabelaUsuario.setVisible(true);
			}
		});
		
		arquivo.add(usuario);
		
		//-----------------------------------------------------------------//
		
		personal = new JMenuItem("Personal");
		personal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaPersonal tabelaPersonal = new TabelaPersonal();
				contentPane.add(tabelaPersonal);
				tabelaPersonal.setVisible(true);
			}
		});
		
		arquivo.add(personal);
		
		//-----------------------------------------------------------------//
		
		aluno = new JMenuItem("Aluno");
		aluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaAluno tabelaAluno = new TabelaAluno();
				contentPane.add(tabelaAluno);
				tabelaAluno.setVisible(true);
			}
		});
		
		arquivo.add(aluno);
		
		//-----------------------------------------------------------------//
		
		atividade = new JMenuItem("Atividade");
		atividade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaAtividade tabelaAtividade = new TabelaAtividade();
				contentPane.add(tabelaAtividade);
				tabelaAtividade.setVisible(true);
			}
		});
		
		arquivo.add(atividade);
		
		//-----------------------------------------------------------------//
		
		JMenuItem logout = new JMenuItem("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				login.setVisible(true);
				login.setLocationRelativeTo(null);
			}
		});
		
		arquivo.add(logout);
		
		//-----------------------------------------------------------------//
		
		sair = new JMenu("Sair ");
		menuBar.add(sair);
		
		//-----------------------------------------------------------------//
		
		sair_sistema = new JMenuItem("Sair");
		sair_sistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		sair.add(sair_sistema);
		
		//-----------------------------------------------------------------//
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 840, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 483, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}

}
