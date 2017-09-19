package siscom.gui;

import java.awt.BorderLayout;

import javax.swing.*;

import siscom.model.Produto;
import siscom.model.ProdutoDados;
import siscom.model.ProdutoTableModel;

public class JanelaProdutos extends JFrame {
	JTable tabela;
	JTextField tNomeProduto;
	JTextField tPrecoProduto;
	private JButton bMais;
	private JButton bMenos;
	private JButton bSalvar;
	private JButton bCarregar;
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
		
		//barra inferior
		JToolBar bar2 = new JToolBar();
		bSalvar = new JButton("Salvar");
		bar2.add(bSalvar);
		bCarregar = new JButton("Carregar");
		bar2.add(bCarregar);
		painel.add("South", bar2);
		
		//criando a tabela
		tabela = new JTable();
		ProdutoTableModel modelo = new ProdutoTableModel();
		tabela.setModel(modelo);
		
		bCarregarActionPerformed() ;
		
		JScrollPane barraRolagem = new JScrollPane(tabela);
		painel.add("Center", barraRolagem);
		
		setContentPane(painel);
		
		/* Ações dos botões   */
		bSalvar.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                    bSalvarActionPerformed();
            }
		});
		bCarregar.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                    bCarregarActionPerformed();
            }
		});
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
	protected void bCarregarActionPerformed() {
		ProdutoDados dados = new ProdutoDados();
		ProdutoTableModel modelo = new ProdutoTableModel();
		for(Produto p:dados.recuperaProdutosAtivos()) {
			modelo.addRow(p);
		}
		tabela.setModel(modelo);
	}
	protected void bSalvarActionPerformed() {
		ProdutoTableModel modelo = (ProdutoTableModel) tabela.getModel();
		ProdutoDados dados = new ProdutoDados();
		dados.salvaProdutosAtivos(modelo.getProdutos());
		JOptionPane.showMessageDialog(null, "Dados Salvos Com Suceso");
	}
	protected void bMaisActionPerformed() {
		ProdutoTableModel modelo = (ProdutoTableModel) tabela.getModel();
		modelo.addRow(
				new Produto(
						tNomeProduto.getText(),
						Double.valueOf(tPrecoProduto.getText())
				)
		);
		bSalvarActionPerformed();
	}
	protected void bMenosActionPerformed() {
		ProdutoTableModel modelo = (ProdutoTableModel) tabela.getModel();
		modelo.removeRow(tabela.getSelectedRow());
	}
	
}
