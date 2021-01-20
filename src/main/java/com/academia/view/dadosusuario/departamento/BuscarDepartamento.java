package com.academia.view.dadosusuario.departamento;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

import com.academia.model.models.user.Departamento;
import com.academia.model.service.DepartamentoService;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;

public class BuscarDepartamento extends JDialog {

	private static final long serialVersionUID = -2707084845924067420L;

	private static final int CODIGO = 0;
	private static final int NOME = 1;

	private final JPanel contentPanel = new JPanel();
	private JLabel lblPesquisaDepartamento;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTable tableDepartamento;

	private TabelaDepartamentoModel tabelaDepartamentoModel;
	private TableRowSorter<TabelaDepartamentoModel> sortTabelaDepartamento;
	private List<Departamento> listaDepartamento;

	private Integer codigoDepartamento;
	private String nomeDepartamento;
	private boolean selectDepartamento;

	private JButton btnInserirDepartamento;

//	public static void main(String[] args) {
//		try {
//			BuscarDepartamento dialog = new BuscarDepartamento();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public BuscarDepartamento(JFrame frame, boolean modal) {
		super(frame, modal);
		initComponents();
		setResizable(false);
		iniciarDados();
	}
	
	private void iniciarDados(){
		listaDepartamento = new ArrayList<Departamento>();
	}

	private void initComponents() {
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 832, 523);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblPesquisaDepartamento = new JLabel("Pesquisar Departamento:");
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 String filtro = textField.getText();
	             filtraNomeDepartamento(filtro);
			}			
		});
		
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();

		btnInserirDepartamento = new JButton("Cadastrar Departamento");
		btnInserirDepartamento.setMnemonic(KeyEvent.VK_C);
		btnInserirDepartamento.setIcon(new ImageIcon(BuscarDepartamento.class.getResource("/com/academia/estrutura/imagens/book_previous.png")));
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(26).addGroup(gl_contentPanel
						.createParallelGroup(Alignment.LEADING).addComponent(btnInserirDepartamento)
						.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblPesquisaDepartamento, GroupLayout.PREFERRED_SIZE, 122,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 613, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 753,
								GroupLayout.PREFERRED_SIZE))
						.addContainerGap(27, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup().addGap(66)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblPesquisaDepartamento)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnInserirDepartamento)
				.addContainerGap(36, Short.MAX_VALUE)));

		tableDepartamento = new JTable();		
		tabelaDepartamentoModel = new TabelaDepartamentoModel();
		
		tabelaDepartamentoModel.setListaDepartamento(carregarListaDepartemento());
		tableDepartamento.setModel(tabelaDepartamentoModel);
		scrollPane.setViewportView(tableDepartamento);
		
		tableDepartamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sortTabelaDepartamento = new TableRowSorter<TabelaDepartamentoModel>(tabelaDepartamentoModel);
		tableDepartamento.setRowSorter(sortTabelaDepartamento);
		tableDepartamento.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
//		tableDepartamento.getColumnModel().getColumn(CODIGO).setWidth(11);
//		tableDepartamento.getColumnModel().getColumn(NOME).setWidth(100);
		
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						selecionaDepartamento();
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
						setSelectDepartamento(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	protected void selecionaDepartamento() {
		if ( tableDepartamento.getSelectedRow() != -1 && 
			 tableDepartamento.getSelectedRow() < tabelaDepartamentoModel.getRowCount() ) {
			 setCodigoDepartamento(Integer.valueOf(tableDepartamento.getValueAt(tableDepartamento.getSelectedRow(), CODIGO).toString()));
			 setNomeDepartamento(tableDepartamento.getValueAt(tableDepartamento.getSelectedRow(), NOME).toString());
			 setSelectDepartamento(true);
			 dispose();
		} else {
			setSelectDepartamento(false);	
		}		
	}
	
	private List<Departamento> carregarListaDepartemento() {
		DepartamentoService departamentoService = new DepartamentoService();
		return departamentoService.findAll();
	}
	
	private void filtraNomeDepartamento(String filtro) {
		RowFilter<TabelaDepartamentoModel, Object> rowFilter = null;
		try {
			rowFilter = RowFilter.regexFilter(filtro);
		} catch(PatternSyntaxException e) {
			return;
		}
		sortTabelaDepartamento.setRowFilter(rowFilter);		
	}
	
	public Integer getCodigoDepartamento() {
		return codigoDepartamento;
	}

	public void setCodigoDepartamento(Integer codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}

	public String getNomeDepartamento() {
		return nomeDepartamento;
	}

	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}
	
	public boolean isSelectDepartamento() {
		return selectDepartamento;
	}

	public void setSelectDepartamento(boolean selectDepartamento) {
		this.selectDepartamento = selectDepartamento;
	}

	
}
