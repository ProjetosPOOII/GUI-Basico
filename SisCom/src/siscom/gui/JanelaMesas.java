package siscom.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import siscom.model.*;

public class JanelaMesas extends JFrame {
	JTable tabela;
	JTextField tQtdLugares;
	JTextField tNroMesa;
	
	public JanelaMesas() {
		super("Gerenciamento de Mesas");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel painel = new JPanel();
		BorderLayout borda = new BorderLayout();
		painel.setLayout(borda);
		
		JToolBar bar = new JToolBar();
		bar.setFloatable(false);
		JLabel lMesa = new JLabel("Mesa: ");
		bar.add(lMesa);
		tNroMesa = new JTextField(15);
		bar.add(tNroMesa);
		JLabel lQtdLugares = new JLabel("Qtd Lugares:");
		bar.add(lQtdLugares);
		tQtdLugares = new JTextField(15);
		bar.add(tQtdLugares);
		
		JButton bMais = new JButton(" + ");
		JButton bMenos = new JButton(" - ");
		bar.add(bMais);
		bar.add(bMenos);
		
		painel.add("North",bar);
		
		//criando a tabela
		tabela = new JTable();
		MesaTableModel modelo = new MesaTableModel();
		tabela.setModel(modelo);
		
		JScrollPane barraRolagem = new JScrollPane(tabela);
		painel.add("Center", barraRolagem);
		
		setContentPane(painel);
		
		//definindo eventos dos botões
		bMais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bMaisAction();
			}
		});
		bMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bMenosAction();
			}
		});
		carregaDados();
	}
	public void bMaisAction() {
		MesaTableModel modelo = (MesaTableModel) this.tabela.getModel();
		modelo.addRow(new Mesa(Integer.parseInt(tNroMesa.getText()),Integer.parseInt(tQtdLugares.getText())));
		salvarDados();
	}
	public void bMenosAction() {
		MesaTableModel modelo = (MesaTableModel) this.tabela.getModel();
		modelo.removeRow(tabela.getSelectedRow());
		salvarDados();
	}
	

	public void salvarDados() {
		MesaDados dados =new MesaDados();
		MesaTableModel modelo = (MesaTableModel) tabela.getModel();		
		dados.salvaMesasAtivas(modelo.getMesas());
	}
	public void carregaDados() {
		MesaDados dados =new MesaDados();
		MesaTableModel modelo = new MesaTableModel();
		for(Mesa m:dados.recuperaMesasAtivas()) {
			modelo.addRow(m);
		}
		tabela.setModel(modelo);
	}
}
