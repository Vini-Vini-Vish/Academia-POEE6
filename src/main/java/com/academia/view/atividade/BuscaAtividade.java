package com.academia.view.atividade;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

import com.academia.model.models.Atividade;
import com.academia.model.models.user.Departamento;
import com.academia.model.service.AtividadeService;
import com.academia.model.service.DepartamentoService;
import com.academia.view.dadosusuario.departamento.BuscarDepartamento;
import com.academia.view.dadosusuario.departamento.TabelaDepartamentoModel;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BuscaAtividade extends JDialog {

	private static final long serialVersionUID = -8743379645921420999L;

	private static final int CODIGO = 0;
	private static final int NOME = 1;
	private static final int DESCRICAO = 2;

	private final JPanel contentPanel = new JPanel();
	private JLabel lblPesquisaAtividade;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JButton btnInserirAtividade;

	private TabelaAtividadeModel tabelaAtividadeModel;
	private TableRowSorter<TabelaAtividadeModel> sortTabelaAtividade;
	private List<Atividade> listaAtividade;

	private Integer codigoAtividade;
	private String nomeAtividade;
	private boolean selectAtividade;
	private JTable tableAtividade;
	
//	public static void main(String[] args) {
//		try {
//			BuscaAtividade dialog = new BuscaAtividade();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public BuscaAtividade(JFrame frame, boolean modal) {
		super(frame, modal);
		initComponents();
		setResizable(false);
		iniciarDados();
	}

	private void iniciarDados() {
		listaAtividade = new ArrayList<Atividade>();
	}

	public void initComponents() {

		setBounds(100, 100, 910, 512);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		lblPesquisaAtividade = new JLabel("Pesquisar Atividade:");

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String filtro = textField.getText();
				filtraNomeAtividade(filtro);
			}
		});

		textField.setColumns(10);

		scrollPane = new JScrollPane();

		btnInserirAtividade = new JButton("Cadastrar Atividade");
		btnInserirAtividade.setMnemonic(KeyEvent.VK_C);
		btnInserirAtividade.setIcon(new ImageIcon(
				BuscarDepartamento.class.getResource("/com/academia/estrutura/imagens/book_previous.png")));

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_contentPanel.createSequentialGroup().addContainerGap(39, Short.MAX_VALUE).addGroup(gl_contentPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addComponent(btnInserirAtividade)
								.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(scrollPane, Alignment.LEADING)
										.addGroup(gl_contentPanel.createSequentialGroup()
												.addComponent(lblPesquisaAtividade).addGap(18).addComponent(textField,
														GroupLayout.PREFERRED_SIZE, 690, GroupLayout.PREFERRED_SIZE)))
								.addGap(39)))));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(27)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPesquisaAtividade))
						.addGap(34)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnInserirAtividade).addContainerGap(38, Short.MAX_VALUE)));

		tableAtividade = new JTable();
		tabelaAtividadeModel = new TabelaAtividadeModel();

		tabelaAtividadeModel.setListaAtividade(carregarListaAtividade());
		tableAtividade.setModel(tabelaAtividadeModel);
		scrollPane.setViewportView(tableAtividade);

		tableAtividade.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sortTabelaAtividade = new TableRowSorter<TabelaAtividadeModel>(tabelaAtividadeModel);
		tableAtividade.setRowSorter(sortTabelaAtividade);
		tableAtividade.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		scrollPane.setViewportView(tableAtividade);

		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						selecionaAtividade();
					}
				});
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setSelectAtividade(false);
					}
				});
				
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	protected void selecionaAtividade() {
		if ( tableAtividade.getSelectedRow() != -1 && 
			 tableAtividade.getSelectedRow() < tabelaAtividadeModel.getRowCount() ) {
			 setCodigoAtividade(Integer.valueOf(tableAtividade.getValueAt(tableAtividade.getSelectedRow(), CODIGO).toString()));
			 setNomeAtividade(tableAtividade.getValueAt(tableAtividade.getSelectedRow(), NOME).toString());
			 setSelectAtividade(true);
			 dispose();
		} else {
			setSelectAtividade(false);	
		}		
	}
	
	private List<Atividade> carregarListaAtividade() {
		AtividadeService atividadeService = new AtividadeService();
		return atividadeService.findAll();
	}
	
	private void filtraNomeAtividade(String filtro) {
		RowFilter<TabelaAtividadeModel, Object> rowFilter = null;
		try {
			rowFilter = RowFilter.regexFilter(filtro);
		} catch(PatternSyntaxException e) {
			return;
		}
		sortTabelaAtividade.setRowFilter(rowFilter);		
	}
	
	public Integer getCodigoAtividade() {
		return codigoAtividade;
	}

	public void setCodigoAtividade(Integer codigoAtividade) {
		this.codigoAtividade = codigoAtividade;
	}

	public String getNomeAtividade() {
		return nomeAtividade;
	}

	public void setNomeAtividade(String nomeAtividade) {
		this.nomeAtividade = nomeAtividade;
	}
	
	public boolean isSelectAtividade() {
		return selectAtividade;
	}

	public void setSelectAtividade(boolean selectAtividade) {
		this.selectAtividade = selectAtividade;
	}	
}
