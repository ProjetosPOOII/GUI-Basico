package siscom.gui;

import java.awt.BorderLayout;

import javax.swing.*;

import siscom.model.ComandaTableModel;
import siscom.model.ItemComanda;
import siscom.model.Mesa;
import siscom.model.MesaComboBoxModel;
import siscom.model.MesaDados;
import siscom.model.Produto;
import siscom.model.ProdutoComboBoxModel;
import siscom.model.ProdutoDados;
import siscom.model.ProdutoTableModel;

public class JanelaPrincipal extends JFrame {
	private JComboBox cMesa;
	private JComboBox cProduto;
	private MesaComboBoxModel mesaComboBoxModel;
	private ProdutoComboBoxModel produtoComboModel;
	private JTable tabela;
	private JTextField tQtd;
	private MenuAplicacao menuAplicacao;

	public JanelaPrincipal() {
		super("Sistema Gerenciador de Comandas -v0.1.0");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel painel = new JPanel();
		BorderLayout borda = new BorderLayout();
		painel.setLayout(borda);
		
		//setando o menu da janela
		menuAplicacao =new MenuAplicacao();
		setJMenuBar(menuAplicacao);
		
		JToolBar bar = new JToolBar();
		bar.setFloatable(false);
		JLabel lMesa = new JLabel("Mesa: ");
		bar.add(lMesa);
		cMesa = new JComboBox<>();
		bar.add(cMesa);
		mesaComboBoxModel = new MesaComboBoxModel();
		cMesa.setModel(mesaComboBoxModel);
		
		JLabel lProduto = new JLabel("Produto :");
		bar.add(lProduto);
		cProduto = new JComboBox<>();
		bar.add(cProduto);
		produtoComboModel = new ProdutoComboBoxModel();
		cProduto.setModel(produtoComboModel);
		
		JLabel lQtd = new JLabel("Qtd:");
		bar.add(lQtd);
		tQtd = new JTextField(5);
		bar.add(tQtd);		
		
		JButton bMais = new JButton(" + ");
		JButton bMenos = new JButton(" - ");
		bar.add(bMais);
		bar.add(bMenos);
		
		painel.add("North",bar);
		
		//criando a tabela
		tabela = new JTable();
		ComandaTableModel modelo = new ComandaTableModel();
		tabela.setModel(modelo);
				
		JScrollPane barraRolagem = new JScrollPane(tabela);
		painel.add("Center", barraRolagem);
		
		setContentPane(painel);
		
		preencheComboBoxMesa();
		preencheComboBoxProduto();
		
		bMais.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				bMaisActionPerformed();
			}
		});
		bMenos.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				bMenosActionPerformed();
			}
		});
	}
	
	public void bMaisActionPerformed() {
		ComandaTableModel modelo = (ComandaTableModel) tabela.getModel();
		boolean checa = true;
		if(cMesa.getSelectedItem()== null) {
			JOptionPane.showMessageDialog(null, "Selecione uma mesa!");
			cMesa.requestFocus();
			checa =false;
		}else if(cProduto.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Selecione um produto!");
			cProduto.requestFocus();
			checa =false;
		}else if(tQtd.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Infome uma quantidade");
			tQtd.requestFocus();
			checa =false;
		}
		if(checa) {
			Mesa m = (Mesa) cMesa.getSelectedItem();
			Produto p = (Produto) cProduto.getSelectedItem();
			ItemComanda ic = new ItemComanda(p, Integer.parseInt(tQtd.getText()));
			modelo.addRow(m, ic);
		}
	}
	public void bMenosActionPerformed() {
		ComandaTableModel modelo = (ComandaTableModel) tabela.getModel();
		modelo.removeRow(tabela.getSelectedRow());
	}
	
	private void preencheComboBoxProduto() {
		ProdutoDados dados = new ProdutoDados();
		for(Produto p:dados.recuperaProdutosAtivos()) {
			produtoComboModel.addRow(p);
		}
	}


	public void preencheComboBoxMesa() {
		MesaDados dados = new MesaDados();
		for(Mesa m:dados.recuperaMesasAtivas()) {
			mesaComboBoxModel.addRow(m);
		}
	}
}
