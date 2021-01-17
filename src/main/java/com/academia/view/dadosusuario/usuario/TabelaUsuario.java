package com.academia.view.dadosusuario.usuario;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class TabelaUsuario extends JFrame {

	private static final long serialVersionUID = 1960507399838165929L;
	
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable tabelaUsuario;
	private JButton btnIcluir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnSair;
	private JPanel panel;
	private JButton btnPrimeiro;
	private JButton btnAnterior;
	private JButton btnProximo;
	private JButton btnUltimo;
	private JLabel lblPaginabox;
	private JComboBox<String> comboBox;
	private JLabel lblPesquisar;
	private JTextField textField;
	private JButton btnPesquisar;
	private JLabel lblPagina;
	private JLabel lblPrmeiroValor;
	private JLabel lblDe;
	private JLabel lblValorFinal;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabelaUsuario frame = new TabelaUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TabelaUsuario() {
		setTitle("Lista de Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		
		//-----------------------------------------------------------------//		

		btnIcluir = new JButton("Incluir");
		btnIcluir.setMnemonic(KeyEvent.VK_I);
		btnIcluir.setIcon(new ImageIcon(TabelaUsuario.class.getResource("/com/academia/estrutura/imagens/book_previous.png")));
		
		//-----------------------------------------------------------------//		

		btnAlterar = new JButton("Alterar");
		btnAlterar.setMnemonic(KeyEvent.VK_A);
		btnAlterar.setIcon(new ImageIcon(TabelaUsuario.class.getResource("/com/academia/estrutura/imagens/book_next.png")));
		
		//-----------------------------------------------------------------//		

		btnExcluir = new JButton("Excluir");
		btnExcluir.setMnemonic(KeyEvent.VK_E);
		btnExcluir.setIcon(new ImageIcon(TabelaUsuario.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		
		//-----------------------------------------------------------------//		

		btnSair = new JButton("Sair");
		btnSair.setMnemonic(KeyEvent.VK_S);
		btnSair.setIcon(new ImageIcon(TabelaUsuario.class.getResource("/com/academia/estrutura/imagens/saida.png")));
		
		//-----------------------------------------------------------------//		

		panel = new JPanel();
		
		lblPaginabox = new JLabel("Paginas:");
		lblPaginabox.setToolTipText("Total de Usuarios mostradas por Pagina");
		
		//-----------------------------------------------------------------//		

		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"5", "10", "15", "20"}));
		comboBox.setToolTipText("");
		
		//-----------------------------------------------------------------//		

		lblPesquisar = new JLabel("Pesquisar:");
		
		textField = new JTextField();
		textField.setColumns(10);
				
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setMnemonic(KeyEvent.VK_P);
		btnPesquisar.setToolTipText("Pesquisar Usuario");
		btnPesquisar.setIcon(new ImageIcon(TabelaUsuario.class.getResource("/com/academia/estrutura/imagens/search.png")));
		
		//-----------------------------------------------------------------//		
		
		lblPagina = new JLabel("Pagina:");
		
		lblPrmeiroValor = new JLabel("10");
		
		lblDe = new JLabel("de");
		
		lblValorFinal = new JLabel("50");
		
		//-----------------------------------------------------------------//		

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblPaginabox)
							.addGap(18)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(63)
							.addComponent(lblPagina)
							.addGap(18)
							.addComponent(lblPrmeiroValor)
							.addGap(18)
							.addComponent(lblDe)
							.addGap(18)
							.addComponent(lblValorFinal)
							.addGap(86))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(lblPesquisar)
									.addGap(18)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(btnPesquisar))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 773, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnIcluir)
									.addGap(18)
									.addComponent(btnAlterar)
									.addGap(18)
									.addComponent(btnExcluir)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnSair)))
							.addGap(19))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPesquisar)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisar))
					.addGap(22)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblPaginabox)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSair)
								.addComponent(btnIcluir)
								.addComponent(btnAlterar)
								.addComponent(btnExcluir))
							.addGap(37))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPagina)
								.addComponent(lblPrmeiroValor)
								.addComponent(lblDe)
								.addComponent(lblValorFinal))
							.addContainerGap())))
		);
		
		//-----------------------------------------------------------------//		

		btnPrimeiro = new JButton("");
		btnPrimeiro.setIcon(new ImageIcon(TabelaUsuario.class.getResource("/com/academia/estrutura/imagens/go-first.png")));
		btnPrimeiro.setToolTipText("Primeira Pagina\r\n");
		
		//-----------------------------------------------------------------//		

		btnAnterior = new JButton("");
		btnAnterior.setToolTipText("Pagina Anterior\r\n");
		btnAnterior.setIcon(new ImageIcon(TabelaUsuario.class.getResource("/com/academia/estrutura/imagens/go-previous.png")));
		
		//-----------------------------------------------------------------//		

		btnProximo = new JButton("");
		btnProximo.setToolTipText("Proxima Pagina\r\n");
		btnProximo.setIcon(new ImageIcon(TabelaUsuario.class.getResource("/com/academia/estrutura/imagens/go-next.png")));
		
		//-----------------------------------------------------------------//		

		btnUltimo = new JButton("");
		btnUltimo.setToolTipText("Ultima Pagina\r\n");
		btnUltimo.setIcon(new ImageIcon(TabelaUsuario.class.getResource("/com/academia/estrutura/imagens/go-last.png")));
		
		//-----------------------------------------------------------------//		

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnPrimeiro)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAnterior)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnProximo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnUltimo)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAnterior)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnUltimo)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnProximo)
								.addComponent(btnPrimeiro))))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		//-----------------------------------------------------------------//		

		tabelaUsuario = new JTable();
		scrollPane.setViewportView(tabelaUsuario);
		contentPane.setLayout(gl_contentPane);
	}
}
