package siscom.model;
import java.util.ArrayList;

import javax.swing.table.*;

public class MesaTableModel extends AbstractTableModel {
	
	private ArrayList<Mesa> dados;
	private String[] colunas = {"Número Mesa","Qtd Lugares"};
	
	public MesaTableModel() {
		this.dados = new ArrayList<Mesa>();
	}
	public void addRow(Mesa m) {
		this.dados.add(m);
		this.fireTableDataChanged();
	}
	public void removeRow(int linha) {
		this.dados.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}
	public String getColumnName(int col) {
		return this.colunas[col];
	}
	@Override
	public int getColumnCount() {
		return this.colunas.length;
	}

	@Override
	public int getRowCount() {
		return this.dados.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch(coluna) {
			case 0: return this.dados.get(linha).getNroMesa();
			case 1: return this.dados.get(linha).getQtdLugares();
		}
		return null;
	}

}
