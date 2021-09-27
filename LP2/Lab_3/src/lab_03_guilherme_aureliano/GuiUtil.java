package lab_03_guilherme_aureliano;
/**
 * 
 * @author Guilherme Aureliano - 119210371
 * Classe responsável por lançar exceções se as entradas forem vazias ou nulas.
 */
public class GuiUtil {
	/**
	 *  Verifica se a entrada foi vazia, e lança uma exceção com uma mensagem caso seja vazia.
	 * @param valor Valor que será verificado
	 * @param mensagem Mensagem que será lançada
	 */
	public static void entradaVazia(String valor, String mensagem) {
		if (valor.trim().isEmpty()) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
	/**
	 * Verifica se a entrada foi nula e lança uma exceção com uma mensagem caso seja nula.
	 * @param valor Valor que será verificado
	 * @param mensagem Mensagem que será lançada
	 */
	public static void entradaNula(String valor, String mensagem) {
		if (valor == null) {
			throw new NullPointerException(mensagem);
		}
	}
}
