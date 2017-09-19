package siscom.model;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ProdutoComboBoxModel extends AbstractListModel implements ComboBoxModel {

	ArrayList<Produto> dados;
	private Produto selecionado;
	
	public ProdutoComboBoxModel() {
		dados = new ArrayList<Produto>();
	}	

	 public void addRow(Produto p) {
		 dados.add(p);
		 fireContentsChanged(p, 0, 0);
	 }
	
	@Override
	public Object getElementAt(int index) {
		return dados.get(index);
	}

	@Override
	public int getSize() {
		return dados.size();
	}

	@Override
	public Object getSelectedItem() {
		return this.selecionado;
	}

	@Override
	public void setSelectedItem(Object item) {
		Produto p = (Produto) item;
		this.selecionado = p;
	}

}
