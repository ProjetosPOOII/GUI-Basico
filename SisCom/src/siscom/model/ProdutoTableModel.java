package siscom.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ProdutoTableModel extends AbstractTableModel {

	private ArrayList<Produto> dados;
	private String[] colunas = {"Id","Nome", "Preco"};
	
	public ProdutoTableModel() {
		dados = new ArrayList<Produto>();
	}
	public ArrayList<Produto> getProdutos(){
		return dados;
	}
	public void addRow(Produto p) {
		dados.add(p);
		fireTableDataChanged();//força um refresh da tabela
	}
	
	public void removeRow(int linha) {
		dados.remove(linha);
		fireTableRowsDeleted(linha, linha);
	}
	
	public String getColumnName(int col) {
		return this.colunas[col];
	}
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return dados.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch(coluna) {
			case 0: return this.dados.get(linha).getIdProduto();
			case 1: return this.dados.get(linha).getNomeProduto();
			case 2: return this.dados.get(linha).getPrecoProduto();
		}
		return null;
	}

}
