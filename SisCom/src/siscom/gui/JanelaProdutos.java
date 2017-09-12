package siscom.gui;

import java.awt.BorderLayout;

import javax.swing.*;

import siscom.model.Produto;
import siscom.model.ProdutoTableModel;

public class JanelaProdutos extends JFrame {
	JTable tabela;
	JTextField tNomeProduto;
	JTextField tPrecoProduto;
	private JButton bMais;
	private JButton bMenos;
	public JanelaProdutos() {
		super("Gerenciamento de Produtos");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel painel = new JPanel();
		BorderLayout borda = new BorderLayout();
		painel.setLayout(borda);
		
		JToolBar bar = new JToolBar();
		bar.setFloatable(false);
		
		JLabel lNomeProduto = new JLabel("Nome produto: ");
		bar.add(lNomeProduto);
		tNomeProduto = new JTextField(15);
		bar.add(tNomeProduto);
		JLabel lPrecoProduto = new JLabel("Preço: ");
		bar.add(lPrecoProduto);
		tPrecoProduto = new JTextField(15);
		bar.add(tPrecoProduto);
		
		bMais = new JButton(" + ");
        bMenos = new JButton(" - ");
        bar.add(bMais);
        bar.add(bMenos);
		
		painel.add("North", bar);
		
		//criando a tabela
		tabela = new JTable();
		ProdutoTableModel modelo = new ProdutoTableModel();
		tabela.setModel(modelo);
		
		painel.add("Center", tabela);
		
		setContentPane(painel);
		
		/* Ações dos botões   */
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
	protected void bMaisActionPerformed() {
		ProdutoTableModel modelo = (ProdutoTableModel) tabela.getModel();
		modelo.addRow(
				new Produto(
						tNomeProduto.getText(),
						Double.valueOf(tPrecoProduto.getText())
				)
		);
	}
	protected void bMenosActionPerformed() {
		ProdutoTableModel modelo = (ProdutoTableModel) tabela.getModel();
		modelo.removeRow(tabela.getSelectedRow());
	}
	
}
