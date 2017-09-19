package siscom.gui;

import java.awt.BorderLayout;

import javax.swing.*;

import siscom.model.Mesa;
import siscom.model.MesaComboBoxModel;
import siscom.model.MesaDados;

public class JanelaPrincipal extends JFrame {
	private JComboBox cMesa;
	private JComboBox cProduto;
	private MesaComboBoxModel mesaComboBoxModel;

	public JanelaPrincipal() {
		super("Sistema Gerenciador de Comandas -v0.1.0");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel painel = new JPanel();
		BorderLayout borda = new BorderLayout();
		painel.setLayout(borda);
		
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
		
		
		JButton bMais = new JButton(" + ");
		JButton bMenos = new JButton(" - ");
		bar.add(bMais);
		bar.add(bMenos);
		
		painel.add("North",bar);
		
		preencheComboBoxMesa();
	}
	
	
	public void preencheComboBoxMesa() {
		MesaDados dados = new MesaDados();
		for(Mesa m:dados.recuperaMesasAtivas()) {
			mesaComboBoxModel.addRow(m);
		}
	}
}
