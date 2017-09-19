package siscom.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ComandaTableModel extends AbstractTableModel{

	private ArrayList<Comanda> dados;
	private String[] colunas= {"Mesa","Qtd Produtos","R$ total"};
	
	public ComandaTableModel() {
		this.dados =new ArrayList<Comanda>();
	}
	
	public void addRow(Mesa mesa, ItemComanda ic) {
		int index = this.haveComanda(mesa);
		if(index<0) { //não existe comanda aberta
			Comanda com = new Comanda(mesa);
			com.addItemComanda(ic);
			this.dados.add(com);			
		}else {//existe comanda aberta
			this.dados.get(index).addItemComanda(ic);
		}
		this.fireTableDataChanged();
	}
	public int haveComanda(Mesa mesa) {
		int index = -1;
		for(int i=0;i<this.dados.size();i++) {
			if(this.dados.get(i).getMesa().getNroMesa()==mesa.getNroMesa())
				index =i;
		}
		return index;
	}
	
	public void removeRow(int linha) {
		this.dados.remove(linha);
		fireTableRowsDeleted(linha, linha);
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
			case 0 : return dados.get(linha).getMesa().getNroMesa();
			case 1 : return dados.get(linha).getQtdItens();
			case 2 : return dados.get(linha).getValorTotalComanda();
		}
		return null;
	}

}
