package com.academia.view.personal;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

import com.academia.estrutura.util.VariaveisProjeto;
import com.academia.model.models.Personal;
import com.academia.model.service.PersonalService;
import com.academia.view.dadosusuario.usuario.TabelaUsuarioModel;
import com.academia.view.dadosusuario.usuario.UsuarioGUI;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TabelaPersonal extends JInternalFrame {

	private static final long serialVersionUID = 7127097297692857692L;
	
	private JPanel contentPane;
	private JLabel lblPesquisar;
	private JTextField textFieldNome;
	private JButton btnPesquisar;
	private JTable tabelaPersonal;
	private JScrollPane scrollPane;
	private JLabel lblPaginabox;
	private JComboBox<String> comboBox;
	private JPanel panel;
	private JButton btnPrimeiro;
	private JButton btnAnterior;
	private JButton btnProximo;
	private JButton btnUltimo;
	private JLabel lblPagina;
	private JLabel lblInicio;
	private JLabel lblDe;
	private JLabel lblFinal;
	private JButton btnIncluir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnSair;
	
	private static final int CODIGO = 0;
	private static final int NOME = 1;
	private static final int GENERO = 2;
	private static final int IDADE = 3;
	private static final int ENDERECO = 4;
	private static final int NUMERO = 5;
	private static final int BAIRRO = 6;
	private static final int CIDADE = 7;
	private static final int TELEFONE = 8;
	private static final int CODIGOPOSTAL = 9;
	private static final int PERIODO = 10;
	private static final int CREF = 11;
	
	private Integer totalData = 0;
	private Integer defaultPagina = 5;
	private Integer totalPagina = 1;
	private Integer numeroPagina = 1;
	private JLabel lblNewLabel_1;
	private JLabel totalRegistros;
	
	private TabelaPersonalModel tabelaPersonalModel;
	private TableRowSorter<TabelaPersonalModel> sortTabelaPersonal;	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabelaPersonal frame = new TabelaPersonal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TabelaPersonal() {
		initComponents();
	   // iniciaPaginacao(); 		
	}
	
	public void initComponents() {
		
		setTitle("Cadastro de Personal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//-----------------------------------------------------------------//		
		
		lblPesquisar = new JLabel("Pesquisar:");
		
		textFieldNome = new JTextField();
		textFieldNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
	             String filtro = textFieldNome.getText();
	             filtraNomePersonal(filtro);                
				
			}
		});
		
		textFieldNome.setColumns(10);
		
		//-----------------------------------------------------------------//		
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnPesquisar.setIcon(new ImageIcon(TabelaPersonal.class.getResource("/com/academia/estrutura/imagens/search.png")));
		btnPesquisar.setToolTipText("Pesquisar Usuario");
		btnPesquisar.setMnemonic(KeyEvent.VK_P);
		
		//-----------------------------------------------------------------//		
		
		scrollPane = new JScrollPane();
		
		//-----------------------------------------------------------------//		
		
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
		
		panel = new JPanel();
		
		//-----------------------------------------------------------------//		
		
		btnPrimeiro = new JButton("");
		btnPrimeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroPagina = 1;
				iniciaPaginacao();
			}
		});
		
		btnPrimeiro.setIcon(new ImageIcon(TabelaPersonal.class.getResource("/com/academia/estrutura/imagens/go-first.png")));
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
		
		btnAnterior.setIcon(new ImageIcon(TabelaPersonal.class.getResource("/com/academia/estrutura/imagens/go-previous.png")));
		btnAnterior.setToolTipText("Pagina Anterior\r\n");
		
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
		
		btnProximo.setIcon(new ImageIcon(TabelaPersonal.class.getResource("/com/academia/estrutura/imagens/go-next.png")));
		btnProximo.setToolTipText("Proxima Pagina\r\n");
		
		//-----------------------------------------------------------------//		
		
		btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroPagina = totalPagina;
				iniciaPaginacao();
			}
		});
		
		btnUltimo.setIcon(new ImageIcon(TabelaPersonal.class.getResource("/com/academia/estrutura/imagens/go-last.png")));
		btnUltimo.setToolTipText("Ultima Pagina\r\n");
		
		//-----------------------------------------------------------------//		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 234, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnPrimeiro, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAnterior, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnProximo, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnUltimo, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 47, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnUltimo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnProximo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAnterior, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPrimeiro, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		panel.setLayout(gl_panel);
		
		//-----------------------------------------------------------------//		
		
		lblPagina = new JLabel("Pagina:");
		
		lblInicio = new JLabel("10");
		
		lblDe = new JLabel("de");
		
		lblFinal = new JLabel("50");
		
		//-----------------------------------------------------------------//		
		
		btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incluirPersonal();
				iniciaPaginacao();
			}
			
		});
		
		btnIncluir.setIcon(new ImageIcon(TabelaPersonal.class.getResource("/com/academia/estrutura/imagens/book_previous.png")));
		btnIncluir.setMnemonic(KeyEvent.VK_I);
		
		//-----------------------------------------------------------------//		
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarPersonal();
				iniciaPaginacao();
			}
		});
		
		btnAlterar.setIcon(new ImageIcon(TabelaPersonal.class.getResource("/com/academia/estrutura/imagens/book_next.png")));
		btnAlterar.setMnemonic(KeyEvent.VK_A);
		
		//-----------------------------------------------------------------//		
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(TabelaPersonal.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		btnExcluir.setMnemonic(KeyEvent.VK_E);
		
		//-----------------------------------------------------------------//		
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setIcon(new ImageIcon(TabelaPersonal.class.getResource("/com/academia/estrutura/imagens/saida.png")));
		btnSair.setMnemonic(KeyEvent.VK_S);
		
		//-----------------------------------------------------------------//		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPaginabox, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(157)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
							.addGap(124)
							.addComponent(lblPagina, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblInicio, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblDe, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblFinal))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 773, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblPesquisar, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, 572, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPesquisar)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPagina)
							.addComponent(lblInicio)
							.addComponent(lblDe)
							.addComponent(lblFinal))
						.addComponent(lblPaginabox))
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		panel.setLayout(gl_panel);
		
		tabelaPersonal = new JTable();
		scrollPane.setViewportView(tabelaPersonal);		
	}
	
	//-----------------------------------------------------------------//		
	
	protected void filtraNomePersonal(String filtro) {
		RowFilter<TabelaPersonalModel, Object> rowFilter = null;
		try {
			rowFilter = RowFilter.regexFilter(filtro);
		} catch(PatternSyntaxException e) {
			return;
		}
		sortTabelaPersonal.setRowFilter(rowFilter);
	}
	
	//-----------------------------------------------------------------//		

	protected void alterarPersonal() {
		if ( tabelaPersonal.getSelectedRow() != -1 && tabelaPersonal.getSelectedRow() < tabelaPersonalModel.getRowCount()) {
			int linha = tabelaPersonal.getSelectedRow();
			PersonalGUI personal = new PersonalGUI(new JFrame(), true, tabelaPersonal, tabelaPersonalModel, linha, VariaveisProjeto.ALTERACAO);
			personal.setLocationRelativeTo(null);
			personal.setVisible(true);
		}
		
	}
	
	//-----------------------------------------------------------------//		

	private void incluirPersonal() {
		PersonalGUI personal = new PersonalGUI(new JFrame(), true, tabelaPersonal, tabelaPersonalModel, 0, VariaveisProjeto.INCLUSAO);
		personal.setLocationRelativeTo(null);
		personal.setResizable(false);
		personal.setVisible(true);
	}

	//-----------------------------------------------------------------//
	
	public JTable getTable() {
		return tabelaPersonal;
	}
	
	//-----------------------------------------------------------------//		
	
		private void iniciaPaginacao() {
		      
		totalData = buscaTotalRegistroPersonal();
		
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
			
		tabelaPersonalModel = new TabelaPersonalModel();
		
		tabelaPersonalModel.setListaPersonal(carregaListaPersonal(numeroPagina, defaultPagina));
		
		tabelaPersonal.setModel(tabelaPersonalModel);
		
		tabelaPersonal.setFillsViewportHeight(true);
		
		tabelaPersonal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tabelaPersonalModel.fireTableDataChanged();
		
		sortTabelaPersonal = new TableRowSorter<TabelaPersonalModel>(tabelaPersonalModel);
		
		tabelaPersonal.setRowSorter(sortTabelaPersonal);				
			
		tabelaPersonal.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);		
		
		tabelaPersonal.getColumnModel().getColumn(CODIGO).setWidth(11);
		tabelaPersonal.getColumnModel().getColumn(NOME).setWidth(100);
		tabelaPersonal.getColumnModel().getColumn(GENERO).setWidth(100);
		tabelaPersonal.getColumnModel().getColumn(IDADE).setWidth(100);
		tabelaPersonal.getColumnModel().getColumn(ENDERECO).setWidth(100);
		tabelaPersonal.getColumnModel().getColumn(NUMERO).setWidth(100);
		tabelaPersonal.getColumnModel().getColumn(BAIRRO).setWidth(100);
		tabelaPersonal.getColumnModel().getColumn(CIDADE).setWidth(100);
		tabelaPersonal.getColumnModel().getColumn(TELEFONE).setWidth(100);
		tabelaPersonal.getColumnModel().getColumn(CODIGOPOSTAL).setWidth(100);
		tabelaPersonal.getColumnModel().getColumn(PERIODO).setWidth(100);	
		tabelaPersonal.getColumnModel().getColumn(CREF).setWidth(100);
		
		lblInicio.setText(String.valueOf(numeroPagina));
		lblFinal.setText(String.valueOf(totalPagina));
		totalRegistros.setText(String.valueOf(totalData));
		
		//-----------------------------------------------------------------//
		 
	}
		
	//-----------------------------------------------------------------//		
	
	private List<Personal> carregaListaPersonal(Integer numeroPagina, Integer defaultPagina) {

		PersonalService personalService = new PersonalService();

		List<Personal> listaPersonal  = new ArrayList<Personal>();
		
		listaPersonal = personalService.listPersonalPaginacao( ( defaultPagina * (numeroPagina - 1 )), defaultPagina);
		
		return listaPersonal;
	}

	//-----------------------------------------------------------------//		
	
	private Integer buscaTotalRegistroPersonal() {
		
		Integer totalRegistro = 0;
		
		PersonalService personalService = new PersonalService();
		
		totalRegistro = personalService.countTotalRegister();
		
		return totalRegistro;
	}
}
