package com.academia.view.dadosusuario.usuario;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

import com.academia.model.models.user.Usuario;
import com.academia.model.service.UsuarioService;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class TabelaUsuario extends JInternalFrame {

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
	private JLabel lblInicio;
	private JLabel lblDe;
	private JLabel lblFinal;
	
	private static final int CODIGO = 0;
	private static final int NOME = 1;
	private static final int EMAIL = 2;
	
	private Integer totalData = 0;
	private Integer defaultPagina = 5;
	private Integer totalPagina = 1;
	private Integer numeroPagina = 1;
	private JLabel totalRegistros;
	
	private TabelaUsuarioModel tabelaUsuarioModel;
	private TableRowSorter<TabelaUsuarioModel> sortTabelaUsuario;
	
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
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnSair.setMnemonic(KeyEvent.VK_S);
		btnSair.setIcon(new ImageIcon(TabelaUsuario.class.getResource("/com/academia/estrutura/imagens/saida.png")));
		
		//-----------------------------------------------------------------//		

		panel = new JPanel();
		
		lblPaginabox = new JLabel("Paginas:");
		lblPaginabox.setToolTipText("Total de Usuarios mostradas por Pagina");
		
		//-----------------------------------------------------------------//		

		comboBox = new JComboBox<String>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				iniciaPaginacao();
			}
		});
		
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
		
		lblInicio = new JLabel("10");
		
		lblDe = new JLabel("de");
		
		lblFinal = new JLabel("50");
		
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
							.addComponent(lblInicio)
							.addGap(18)
							.addComponent(lblDe)
							.addGap(18)
							.addComponent(lblFinal)
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
								.addComponent(lblInicio)
								.addComponent(lblDe)
								.addComponent(lblFinal))
							.addContainerGap())))
		);
		
		//-----------------------------------------------------------------//		

		btnPrimeiro = new JButton("");
		btnPrimeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroPagina = 1;
				iniciaPaginacao();
			}
		});
		
		btnPrimeiro.setIcon(new ImageIcon(TabelaUsuario.class.getResource("/com/academia/estrutura/imagens/go-first.png")));
		btnPrimeiro.setToolTipText("Primeira Pagina\r\n");
		
		//-----------------------------------------------------------------//		

		btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numeroPagina > 1) {
					numeroPagina = numeroPagina - 1;
					iniciaPaginacao();
				}
			}
		});
		
		btnAnterior.setToolTipText("Pagina Anterior\r\n");
		btnAnterior.setIcon(new ImageIcon(TabelaUsuario.class.getResource("/com/academia/estrutura/imagens/go-previous.png")));
		
		//-----------------------------------------------------------------//		

		btnProximo = new JButton("");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( numeroPagina < totalPagina ) {
					numeroPagina = numeroPagina + 1;
					iniciaPaginacao();
				}
			}
		});
		
		btnProximo.setToolTipText("Proxima Pagina\r\n");
		btnProximo.setIcon(new ImageIcon(TabelaUsuario.class.getResource("/com/academia/estrutura/imagens/go-next.png")));
		
		//-----------------------------------------------------------------//		

		btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroPagina = totalPagina;
				iniciaPaginacao();
			}
		});
		
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
	
	//-----------------------------------------------------------------//		
	
	public JTable getTable() {
		return tabelaUsuario;
	}
	
	//-----------------------------------------------------------------//		
	
	private void iniciaPaginacao() {
	      
		totalData = buscaTotalRegistroUsuario();
		
		defaultPagina = Integer.valueOf(comboBox.getSelectedItem().toString());
		
		Double totalPaginasExistenes = Math.ceil(totalData.doubleValue() / defaultPagina.doubleValue());
	
		totalPagina = totalPaginasExistenes.intValue();
		
		if ( numeroPagina.equals(1)) {
			btnPrimeiro.setEnabled(false);
			btnProximo.setEnabled(false);
		} else {
			btnPrimeiro.setEnabled(true);
			btnProximo.setEnabled(true);
		}
		
		if ( numeroPagina.equals(totalPagina)) {
			btnUltimo.setEnabled(false);
			btnProximo.setEnabled(false);
		} else {
			btnUltimo.setEnabled(true);
			btnProximo.setEnabled(true);
		}
		
		if (numeroPagina > totalPagina ) {
			numeroPagina = 1;
		}
		
		//-----------------------------------------------------------------//
			
		tabelaUsuarioModel = new TabelaUsuarioModel();
		
		tabelaUsuarioModel.setListaUsuario(carregaListaUsuario(numeroPagina, defaultPagina));
		
		tabelaUsuario.setModel(tabelaUsuarioModel);
		
		tabelaUsuario.setFillsViewportHeight(true);
		
		tabelaUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tabelaUsuarioModel.fireTableDataChanged();
		
		sortTabelaUsuario = new TableRowSorter<TabelaUsuarioModel>(tabelaUsuarioModel);
		
		tabelaUsuario.setRowSorter(sortTabelaUsuario);		
		
			
		tabelaUsuario.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);		
		
		tabelaUsuario.getColumnModel().getColumn(CODIGO).setWidth(11);
		tabelaUsuario.getColumnModel().getColumn(NOME).setWidth(100);
		tabelaUsuario.getColumnModel().getColumn(EMAIL).setWidth(100);
		
		lblInicio.setText(String.valueOf(numeroPagina));
		lblFinal.setText(String.valueOf(totalPagina));
		totalRegistros.setText(String.valueOf(totalData));
		
		//-----------------------------------------------------------------//
		 
	}
	
	//-----------------------------------------------------------------//		
	
	private List<Usuario> carregaListaUsuario(Integer numeroPagina, Integer defaultPagina) {

		UsuarioService usuarioService = new UsuarioService();

		List<Usuario> listaUsuario  = new ArrayList<Usuario>();
		
		listaUsuario = usuarioService.listUsuarioPaginacao( ( defaultPagina * (numeroPagina - 1 )), defaultPagina);
		
		return listaUsuario;
	}
	
	//-----------------------------------------------------------------//		
	
	private Integer buscaTotalRegistroUsuario() {
		
		Integer totalRegistro = 0;
		
		UsuarioService usuarioService = new UsuarioService();
		
		totalRegistro = usuarioService.countTotalRegister();
		
		return totalRegistro;
	}
}
