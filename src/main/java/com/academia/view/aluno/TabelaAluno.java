package com.academia.view.aluno;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

import com.academia.estrutura.util.VariaveisProjeto;
import com.academia.model.models.Aluno;
import com.academia.model.service.AlunoService;
import com.academia.view.dadosusuario.usuario.TabelaUsuarioModel;
import com.academia.view.dadosusuario.usuario.UsuarioGUI;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
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

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TabelaAluno extends JInternalFrame {

	private static final long serialVersionUID = 1871536401235088878L;
	
	private JPanel contentPane;
	private JLabel lblPesquisar;
	private JTextField textFieldNome;
	private JTable tabelaAluno;
	private JButton btnPesquisar;
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
	
	private Integer totalData = 0;
	private Integer defaultPagina = 5;
	private Integer totalPagina = 1;
	private Integer numeroPagina = 1;
	private JLabel totalRegistros;
	
	private TabelaAlunoModel tabelaAlunoModel;
	private TableRowSorter<TabelaAlunoModel> sortTabelaAluno;	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabelaAluno frame = new TabelaAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TabelaAluno() {
		initComponents();
	   // iniciaPaginacao(); 		
	}

	public void initComponents() {
		setTitle("Cadastro de Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 525);
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
	             filtraNomeAluno(filtro); 			
			}
		});		
		
		textFieldNome.setColumns(10);
		
		//-----------------------------------------------------------------//
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPesquisar.setIcon(new ImageIcon(TabelaAluno.class.getResource("/com/academia/estrutura/imagens/search.png")));
		btnPesquisar.setToolTipText("Pesquisar Usuario");
		btnPesquisar.setMnemonic(KeyEvent.VK_P);
		
		//-----------------------------------------------------------------//		
		
		scrollPane = new JScrollPane();
		
		//-----------------------------------------------------------------//		
		
		lblPaginabox = new JLabel("Paginas:");
		lblPaginabox.setToolTipText("Total de Usuarios mostradas por Pagina");
		
		//-----------------------------------------------------------------//		
		
		panel = new JPanel();
		
		comboBox = new JComboBox<String>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				iniciaPaginacao();
			}
		});
		
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"5", "10", "15", "20"}));
		comboBox.setToolTipText("");
		
			
		//-----------------------------------------------------------------//		
		
		btnPrimeiro = new JButton("");
		btnPrimeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroPagina = 1;
				iniciaPaginacao();
			}
		});
		
		btnPrimeiro.setIcon(new ImageIcon(TabelaAluno.class.getResource("/com/academia/estrutura/imagens/go-first.png")));
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
		
		btnAnterior.setIcon(new ImageIcon(TabelaAluno.class.getResource("/com/academia/estrutura/imagens/go-previous.png")));
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
		
		btnProximo.setIcon(new ImageIcon(TabelaAluno.class.getResource("/com/academia/estrutura/imagens/go-next.png")));
		btnProximo.setToolTipText("Proxima Pagina\r\n");
		
		//-----------------------------------------------------------------//		
		
		btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroPagina = totalPagina;
				iniciaPaginacao();
			}
		});
		
		btnUltimo.setIcon(new ImageIcon(TabelaAluno.class.getResource("/com/academia/estrutura/imagens/go-last.png")));
		btnUltimo.setToolTipText("Ultima Pagina\r\n");
		
		//-----------------------------------------------------------------//		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
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
				incluirAluno();
				iniciaPaginacao();
			}
			
		});
		
		btnIncluir.setIcon(new ImageIcon(TabelaAluno.class.getResource("/com/academia/estrutura/imagens/book_previous.png")));
		btnIncluir.setMnemonic(KeyEvent.VK_I);
		
		//-----------------------------------------------------------------//		
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarAluno();
				iniciaPaginacao();
			}
		});
		
		btnAlterar.setIcon(new ImageIcon(TabelaAluno.class.getResource("/com/academia/estrutura/imagens/book_next.png")));
		btnAlterar.setMnemonic(KeyEvent.VK_A);
		
		//-----------------------------------------------------------------//		
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(TabelaAluno.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		btnExcluir.setMnemonic(KeyEvent.VK_E);
		
		//-----------------------------------------------------------------//		
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnSair.setIcon(new ImageIcon(TabelaAluno.class.getResource("/com/academia/estrutura/imagens/iconFechar.png")));
		btnSair.setMnemonic(KeyEvent.VK_S);
		
		//-----------------------------------------------------------------//		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPaginabox, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(166)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
							.addGap(79)
							.addComponent(lblPagina, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblInicio, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDe, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblFinal, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 773, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblPesquisar, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, 588, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPesquisar))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPaginabox)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPagina)
							.addComponent(lblInicio)
							.addComponent(lblDe)
							.addComponent(lblFinal)))
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		tabelaAluno = new JTable();
		scrollPane.setViewportView(tabelaAluno);
		contentPane.setLayout(gl_contentPane);		
	}	
	
	//-----------------------------------------------------------------//		
	
	protected void filtraNomeAluno(String filtro) {
		RowFilter<TabelaAlunoModel, Object> rowFilter = null;
		try {
			rowFilter = RowFilter.regexFilter(filtro);
		} catch(PatternSyntaxException e) {
			return;
		}
		sortTabelaAluno.setRowFilter(rowFilter);
	}
	
	//-----------------------------------------------------------------//		

	protected void alterarAluno() {
		if ( tabelaAluno.getSelectedRow() != -1 && tabelaAluno.getSelectedRow() < tabelaAlunoModel.getRowCount()) {
			int linha = tabelaAluno.getSelectedRow();
			AlunoGUI aluno = new AlunoGUI(new JFrame(), true, tabelaAluno, tabelaAlunoModel, linha, VariaveisProjeto.ALTERACAO);
			aluno.setLocationRelativeTo(null);
			aluno.setVisible(true);
		}		
	}
	
	//-----------------------------------------------------------------//		

	private void incluirAluno() {
		AlunoGUI aluno = new AlunoGUI(new JFrame(), true, tabelaAluno, tabelaAlunoModel, 0, VariaveisProjeto.INCLUSAO);
		aluno.setLocationRelativeTo(null);
		aluno.setResizable(false);
		aluno.setVisible(true);
	}
	
	//-----------------------------------------------------------------//		
	
	private void iniciaPaginacao() {
	      
		totalData = buscaTotalRegistroAluno();
		
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
			
		tabelaAlunoModel = new TabelaAlunoModel();
		
		tabelaAlunoModel.setListaAluno(carregaListaAluno(numeroPagina, defaultPagina));
		
		tabelaAluno.setModel(tabelaAlunoModel);
		
		tabelaAluno.setFillsViewportHeight(true);
		
		tabelaAluno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tabelaAlunoModel.fireTableDataChanged();
		
		sortTabelaAluno = new TableRowSorter<TabelaAlunoModel>(tabelaAlunoModel);
		
		tabelaAluno.setRowSorter(sortTabelaAluno);				
			
		tabelaAluno.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);		
		
		tabelaAluno.getColumnModel().getColumn(CODIGO).setWidth(11);
		tabelaAluno.getColumnModel().getColumn(NOME).setWidth(100);
		tabelaAluno.getColumnModel().getColumn(GENERO).setWidth(100);
		tabelaAluno.getColumnModel().getColumn(IDADE).setWidth(100);
		tabelaAluno.getColumnModel().getColumn(ENDERECO).setWidth(100);
		tabelaAluno.getColumnModel().getColumn(NUMERO).setWidth(100);
		tabelaAluno.getColumnModel().getColumn(BAIRRO).setWidth(100);
		tabelaAluno.getColumnModel().getColumn(CIDADE).setWidth(100);
		tabelaAluno.getColumnModel().getColumn(TELEFONE).setWidth(100);
		tabelaAluno.getColumnModel().getColumn(CODIGOPOSTAL).setWidth(100);
		tabelaAluno.getColumnModel().getColumn(PERIODO).setWidth(100);		
		
		lblInicio.setText(String.valueOf(numeroPagina));
		lblFinal.setText(String.valueOf(totalPagina));
		totalRegistros.setText(String.valueOf(totalData));
		
		//-----------------------------------------------------------------//
		 
	}
	
	//-----------------------------------------------------------------//		
	
	private List<Aluno> carregaListaAluno(Integer numeroPagina, Integer defaultPagina) {

		AlunoService alunoService = new AlunoService();

		List<Aluno> listaAluno  = new ArrayList<Aluno>();
		
		listaAluno = alunoService.listAlunoPaginacao( ( defaultPagina * (numeroPagina - 1 )), defaultPagina);
		
		return listaAluno;
	}
		
	
	//-----------------------------------------------------------------//		
	
	private Integer buscaTotalRegistroAluno() {
		
		Integer totalRegistro = 0;
		
		AlunoService alunoService = new AlunoService();
		
		totalRegistro = alunoService.countTotalRegister();
		
		return totalRegistro;
	}
	
	//-----------------------------------------------------------------//		
	
	public JTable getTable() {
		return tabelaAluno;
	}
	
}
