package com.academia.view.dadosusuario.usuario;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

import com.academia.estrutura.util.VariaveisProjeto;
import com.academia.model.models.user.Usuario;
import com.academia.model.service.UsuarioService;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.ItemEvent;

public class TabelaUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1960507399838165929L;
		
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable tabelaUsuario;
	private JButton btnIncluir;
	private JButton btnAlterar;
	private JButton brnExcluir;
	private JButton btnSair;
	private JPanel panel;
	private JButton btnPrimeiro;
	private JButton btnAnterior;
	private JButton btnProximo;
	private JButton btnUltimo;
	private JLabel lblNewLabel;
	private JComboBox<String> comboBox;
	private JLabel lblPesquisar;
	private JTextField textFieldNome;
	private JButton btnPesquisar;
	private JLabel lblPagina;
	private JLabel lblInicio;
	private JLabel lblde;
	private JLabel lblfinal;
	
	private static final int CODIGO = 0;
	private static final int NOME = 1;
	private static final int EMAIL = 2;
	
	private Integer totalData = 0;
	private Integer defaultPagina = 5;
	private Integer totalPagina = 1;
	private Integer numeroPagina = 1;
	private JLabel lblNewLabel_1;
	private JLabel totalRegistros;
	
	private TabelaUsuarioModel tabelaUsuarioModel;
	private TableRowSorter<TabelaUsuarioModel> sortTabelaUsuario;
	private JButton btnRelatorio;
	
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
		initComponents();
	   // iniciaPaginacao(); 		
	}
	
	public void initComponents() {
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1084, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		
		//-----------------------------------------------------------------//		

		btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incluirUsuario();
				iniciaPaginacao();
			}
			
		});
		btnIncluir.setMnemonic(KeyEvent.VK_I);
		btnIncluir.setIcon(new ImageIcon(TabelaUsuario.class.getResource("/com/academia/estrutura/imagens/book_previous.png")));
		
		//-----------------------------------------------------------------//		

		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarUsuario();
				iniciaPaginacao();
			}
		});
		btnAlterar.setMnemonic(KeyEvent.VK_A);
		btnAlterar.setIcon(new ImageIcon(TabelaUsuario.class.getResource("/com/academia/estrutura/imagens/book_next.png")));
		
		//-----------------------------------------------------------------//		

		brnExcluir = new JButton("Excluir");
		brnExcluir.setMnemonic(KeyEvent.VK_E);
		brnExcluir.setIcon(new ImageIcon(TabelaUsuario.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		
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
		
		lblNewLabel = new JLabel("Página:");
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"5", "10", "15", "20"}));
		comboBox.setSelectedIndex(0);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				iniciaPaginacao();
			}
		});
		
		//-----------------------------------------------------------------//		

		lblPesquisar = new JLabel("Pesquisar:");
		
		textFieldNome = new JTextField();
		textFieldNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
	             String filtro = textFieldNome.getText();
	             filtraNomeUsuario(filtro);                
				
			}
		});
		textFieldNome.setColumns(10);
				
		//-----------------------------------------------------------------//	
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPesquisar.setMnemonic(KeyEvent.VK_P);
		btnPesquisar.setToolTipText("Pesquisar usuário cadastrado");
		btnPesquisar.setIcon(new ImageIcon(TabelaUsuario.class.getResource("/com/academia/estrutura/imagens/search.png")));
		
		//-----------------------------------------------------------------//		
		
		lblPagina = new JLabel("Página ");
		
		lblInicio = new JLabel("10");
		
		lblde = new JLabel("de");
		
		lblfinal = new JLabel("50");
		
		lblNewLabel_1 = new JLabel("total de Registros:");
		
		totalRegistros = new JLabel("");
		
		btnRelatorio = new JButton("Imprime Relatorio");
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelUsuario relUsuario = new RelUsuario(new JFrame(), true);
				relUsuario.setLocationRelativeTo(null);				
				relUsuario.setVisible(true);
			}
		});
		btnRelatorio.setIcon(new ImageIcon(TabelaUsuario.class.getResource("/com/academia/estrutura/imagens/book_open.png")));
		
		//-----------------------------------------------------------------//		

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
									.addGap(112)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(52)
									.addComponent(lblPagina)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblInicio)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblde)
									.addPreferredGap(ComponentPlacement.UNRELATED))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(btnIncluir)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnAlterar)
									.addGap(18)
									.addComponent(brnExcluir)
									.addGap(69)
									.addComponent(btnRelatorio)
									.addGap(201)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblfinal)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_1)
									.addGap(39)
									.addComponent(totalRegistros))
								.addComponent(btnSair)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblPesquisar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFieldNome, GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnPesquisar))
						.addComponent(scrollPane))
					.addGap(27))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPesquisar)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisar))
					.addGap(22)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel))
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnIncluir)
								.addComponent(btnAlterar)
								.addComponent(brnExcluir)
								.addComponent(btnRelatorio)
								.addComponent(btnSair)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(totalRegistros)
							.addComponent(lblPagina)
							.addComponent(lblInicio, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblde)
							.addComponent(lblfinal)
							.addComponent(lblNewLabel_1)))
					.addGap(19))
		);
		
		//-----------------------------------------------------------------//		

		btnPrimeiro = new JButton("");
		btnPrimeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroPagina = 1;
				iniciaPaginacao();
			}
		});
		btnPrimeiro.setToolTipText("Primeiro");
		btnPrimeiro.setIcon(new ImageIcon(TabelaUsuario.class.getResource("/com/academia/estrutura/imagens/go-first.png")));
		
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
		btnAnterior.setToolTipText("Anterior");
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
		btnProximo.setToolTipText("Próximo");
		btnProximo.setIcon(new ImageIcon(TabelaUsuario.class.getResource("/com/academia/estrutura/imagens/go-next.png")));
		
		//-----------------------------------------------------------------//		

		btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroPagina = totalPagina;
				iniciaPaginacao();
			}
		});
		btnUltimo.setToolTipText("Último");
		btnUltimo.setIcon(new ImageIcon(TabelaUsuario.class.getResource("/com/academia/estrutura/imagens/go-last.png")));
		
		//-----------------------------------------------------------------//		

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnPrimeiro)
					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
					.addComponent(btnAnterior)
					.addGap(18)
					.addComponent(btnProximo)
					.addGap(18)
					.addComponent(btnUltimo)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAnterior)
						.addComponent(btnProximo)
						.addComponent(btnUltimo)
						.addComponent(btnPrimeiro))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		//-----------------------------------------------------------------//		

		tabelaUsuario = new JTable();
		scrollPane.setViewportView(tabelaUsuario);
		contentPane.setLayout(gl_contentPane);
	}
	
	//-----------------------------------------------------------------//		
	
	protected void filtraNomeUsuario(String filtro) {
		RowFilter<TabelaUsuarioModel, Object> rowFilter = null;
		try {
			rowFilter = RowFilter.regexFilter(filtro);
		} catch(PatternSyntaxException e) {
			return;
		}
		sortTabelaUsuario.setRowFilter(rowFilter);
	}

	//-----------------------------------------------------------------//		

	protected void alterarUsuario() {
		if ( tabelaUsuario.getSelectedRow() != -1 && tabelaUsuario.getSelectedRow() < tabelaUsuarioModel.getRowCount()) {
			int linha = tabelaUsuario.getSelectedRow();
			UsuarioGUI usuario = new UsuarioGUI(new JFrame(), true, tabelaUsuario, tabelaUsuarioModel, linha, VariaveisProjeto.ALTERACAO);
			usuario.setLocationRelativeTo(null);
			usuario.setVisible(true);
		}
		
	}

	//-----------------------------------------------------------------//		

	private void incluirUsuario() {
		UsuarioGUI usuario = new UsuarioGUI(new JFrame(), true, tabelaUsuario, tabelaUsuarioModel, 0, VariaveisProjeto.INCLUSAO);
		usuario.setLocationRelativeTo(null);
        usuario.setResizable(false);
		usuario.setVisible(true);
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
		lblfinal.setText(String.valueOf(totalPagina));
		totalRegistros.setText(String.valueOf(totalData));
		
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

	//-----------------------------------------------------------------//		
	
	public JTable getTable() {
		return tabelaUsuario;
	}
}
