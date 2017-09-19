/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscom.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author tatuapu
 */
public class MenuAplicacao extends JMenuBar {
    //private JMenuBar menuBar;
    private JMenu menuAplicacao, menuCadastro;
    private JMenuItem miSair, miCadastroMesa, miCadastroProduto;
    public JanelaMesas janelaMesas;
    public JanelaProdutos janelaProdutos;
    
    public MenuAplicacao(final JanelaPrincipal jP){
        
        menuAplicacao = new JMenu("Aplicação");
        menuAplicacao.setMnemonic('A');
        add(menuAplicacao);

        miSair = new JMenuItem("Sair");
        miSair.setMnemonic('S');
        menuAplicacao.add(miSair);
        
        menuCadastro = new JMenu("Cadastro");
        menuCadastro.setMnemonic('C');
        add(menuCadastro);
        
        miCadastroMesa = new JMenuItem("Mesas");
        miCadastroMesa.setMnemonic('M');
        menuCadastro.add(miCadastroMesa);
        
        miCadastroProduto = new JMenuItem("Produtos");
        miCadastroProduto.setMnemonic('P');
        menuCadastro.add(miCadastroProduto);

        
        miCadastroMesa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(janelaMesas == null){
                    janelaMesas = new JanelaMesas();
                }    
                //janelaMesas.setJanelaPrincipal(jP);
                janelaMesas.setVisible(true);
            }
        });
        
        miCadastroProduto.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if(janelaProdutos == null){
                    janelaProdutos = new JanelaProdutos();
                }    
                //janelaProdutos.setJanelaPrincipal(jP);
                janelaProdutos.setVisible(true);
            }
        });
        
        /*Evento do menuItem Sair*/
        miSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja Realmente Sair?");
                if (opcao == 0 || opcao == -1) {
                    System.exit(0);
                }
            }
        });
    }
    
}