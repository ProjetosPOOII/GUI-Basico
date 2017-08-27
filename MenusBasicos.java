import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JFrame.*;
import static java.awt.BorderLayout.*;
import javax.swing.text.*;

public class MenusBasicos{
	
	public static void main(String[] args){
		JFrame janela = new JFrame("Sistema v.1.0");
		janela.setDefaultCloseOperation(EXIT_ON_CLOSE);		
		janela.setSize(300,200);

		//criando a barra de menu
		JMenuBar barraMenuPrincipal = new JMenuBar();

		//Criando menu que vai aparecer na barra de menu
		JMenu mArquivo = new JMenu("Arquivo");
		mArquivo.setMnemonic('A');
		barraMenuPrincipal.add(mArquivo);
		

		//Criando item de menu para um menu de primeiro nível
		JMenuItem miSair = new JMenuItem("Sair");
		miSair.setMnemonic(KeyEvent.VK_S);
		mArquivo.add(miSair);

		miSair.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.out.println("Saindo do Sistema");
				System.exit(0);//sair sem erros
			}
		});

		JMenu mNovo = new JMenu("Novo");
		barraMenuPrincipal.add(mNovo);

		JMenuItem miArquivo = new JMenuItem("Arquivo");
		mNovo.add(miArquivo);

		JMenu mAbrir = new JMenu("Abrir");
		barraMenuPrincipal.add(mAbrir);

		JMenu smArquivo = new JMenu("Arquivo");
		mAbrir.add(smArquivo);

		JMenuItem smiEmBranco = new JMenuItem("Em Branco");
		JMenu smiDeTemplate = new JMenu("De Template");

		smArquivo.add(smiEmBranco);
		smArquivo.add(smiDeTemplate);

		JMenuItem ssmiTemplate01 = new JMenuItem("Template 01");
		JMenuItem ssmiTemplate02 = new JMenuItem("Template 02");
		smiDeTemplate.add(ssmiTemplate01);
		smiDeTemplate.add(ssmiTemplate02);

		janela.setJMenuBar(barraMenuPrincipal);
		janela.setVisible(true);
	}
}