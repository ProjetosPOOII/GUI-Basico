package siscom.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ProdutoDados {
    public void salvaProdutosAtivos(ArrayList<Produto> produtos){
        try{
            FileOutputStream arquivoGrav = new FileOutputStream("produtosAtivos.dat");
            ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);

	    //Grava o objeto mesas no arquivo
	    objGravar.writeObject(produtos);
	    objGravar.flush();

	    objGravar.close();
	    arquivoGrav.flush();

	    arquivoGrav.close();
	}catch(Exception e){
            e.printStackTrace();
	}
    }
    public ArrayList<Produto> recuperaProdutosAtivos(){
        ArrayList<Produto> produtoRecovered = null;
        try{
            //Carrega o arquivo
            FileInputStream arquivoLeitura = new FileInputStream("produtosAtivos.dat");

            //Classe responsavel por recuperar os objetos do arquivo
            ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura);
            produtoRecovered = (ArrayList<Produto>) objLeitura.readObject();
            objLeitura.close();
            arquivoLeitura.close();
	}catch(Exception e){
            e.printStackTrace();
	}
        return produtoRecovered;
    }
}
