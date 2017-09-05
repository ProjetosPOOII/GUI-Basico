package siscom.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author tatuapu
 */
public class Comanda implements Serializable {
    private Mesa mesa;
    private ArrayList<ItemComanda> produtos = new ArrayList<ItemComanda>();
    
    /* Método construtor da classe <b>Comanda</b>
     @param objeto Mesa
    */
    public Comanda(Mesa mesa){
         this.mesa = mesa;         
    }
    public Mesa getMesa(){
        return this.mesa;
    }
    public ArrayList<ItemComanda> getItensComanda(){
        return this.produtos;
    }
    public void addItemComanda(ItemComanda item){
        this.produtos.add(item);
    }
    public void delItemComanda(ItemComanda item){
        this.produtos.remove(item);
    }
    public void delItemComanda(int index){
        this.produtos.remove(index);
    }
    public void limparComanda(){
        this.produtos.clear();
    }
    public int getQtdItens(){
        return this.produtos.size();
    }
    public Double getValorTotalComanda(){
        Double total=0.0;
        for(ItemComanda ic:produtos){
            total+=ic.getTotalItemComanda();
        }
        return total;
    }
    

}
