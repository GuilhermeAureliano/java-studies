package saga;
/**
 * Interface que representa um produto do sistema.
 * @author Guilherme Aureliano - 119210371
 *
 */
public interface Produto extends Comparable <Produto> {
	
	double getPreco();
	
	void setPreco(double novoValor);
	
	String getNome();
}
