package com.academia.view.aluno;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.academia.model.models.Aluno;
import com.academia.model.models.Atividade;
import com.academia.model.models.PrintJasperReport;
import com.academia.model.service.AlunoService;
import com.academia.model.service.relatorios.JasperReportsService;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class RelAluno extends JDialog {

	private static final long serialVersionUID = 6769122061092332505L;
	
	private final JPanel contentPanel = new JPanel();

	public RelAluno(JFrame frame, boolean modal) {
		
		super(frame, modal);
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						imprimeRelatorioPorLista();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void imprimeRelatorioPorLista() {
		AlunoService AlunoService = new AlunoService();
		PrintJasperReport printJasperReport = new PrintJasperReport();
		JasperReportsService jasperReportsService = new JasperReportsService();

	    List<Aluno> listaAluno = AlunoService.findAll();
		
		printJasperReport.setFile("rel_aluno");
		printJasperReport.setCollection(listaAluno);
		setVisible(false);
		jasperReportsService.generateListReports(printJasperReport);
	}

}
