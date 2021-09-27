package lab_04_guilherme_aureliano;

/**
 * Classe que lança exceções em determinados casos.
 * @author Guilherme Aureliano - 119210371
 *
 */

public class GuiUtil {
	
	/**
	 * Verifica se a entrada é vazia, lançando uma mensagem caso seja.
	 * @param valor A entrada a ser verificada
	 * @param mensagem A mensagem a ser lançada
	 */
	public static void verificaStringVazia(String valor, String mensagem) {
		if (valor.trim().isEmpty()) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
	/**
	 * Verifica se a entrada é nula, lançando uma mensagem caso seja.
	 * @param valor A entrada a ser verificada
	 * @param mensagem A mensagem a ser lançada
	 */
	public static void verificaStringNull(String valor, String mensagem) {
		if(valor == null) {
			throw new NullPointerException(mensagem);
		}
	}
}
