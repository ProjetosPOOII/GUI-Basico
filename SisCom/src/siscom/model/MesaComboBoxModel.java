package siscom.model;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class MesaComboBoxModel extends AbstractListModel implements ComboBoxModel {

	ArrayList<Mesa> dados;
	private Mesa selecionado;
	
	public MesaComboBoxModel() {
		dados = new ArrayList<Mesa>();
	}	

	 public void addRow(Mesa m) {
		 dados.add(m);
		 fireContentsChanged(m, 0, 0);
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
		Mesa m = (Mesa) item;
		this.selecionado = m;
	}

}
