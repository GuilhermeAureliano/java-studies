package lab_02_guilherme_aureliano;

/**
 * Representação de uma conta de laboratório. A partir dela, poderemos ter acesso aos
 * atributos e métodos da conta individualmente.
 * @author Guilherme Aureliano - 119210371
 *
 */

public class ContaLaboratorio {
	/**
	 * Atributos que representam a cota padrão em inteiros, cota consumida em inteiros, nome do laboratório e saída
	 * da cota padrão que no formato de um inteiro.
	 */
	private int cota;
	private int cotaConsumida;
	private String nomeLaboratorio;
	private int cota_padrao_laboratorio;
	/**
	 * Constrói uma conta de laboratório.
	 * Só há um paramêtro que é o nome do laboratório, significando que a cota padrão seja 2000mb.
	 * @param nomeLaboratorio Recebe o nome do laboratório que deseja cadastrar.
	 */
	ContaLaboratorio (String nomeLaboratorio) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota_padrao_laboratorio = 2000;
		this.cota = 2000;
	}
	/**
	 * Também constrói uma conta de laboratório, porém, recebe dois paramêtros.
	 * @param nomeLaboratorio O nome do laboratório que deseja cadastrar.
	 * @param cota A cota padrão que o laboratório suporta, podendo ser diferente de 2000mb.
	 */

	ContaLaboratorio (String nomeLaboratorio, int cota) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = cota;
		this.cota_padrao_laboratorio = cota;
	}
	
	/**
	 * Diminui o valor passado no parâmetro da cota padrão, ou seja, consumindo.
	 * @param mbytes Valor que será diminuido da cota padrão.
	 */
	public void consomeEspaco(int mbytes) {
		this.cota -= mbytes;
		this.cotaConsumida += mbytes;
	}
	
	/**
	 * Recebe um valor que será liberado(excluído) da cota padrão.
	 * @param mbytes Valor que será liberado na cota padrão.
	 */
	public void liberaEspaco(int mbytes) {
		this.cota += mbytes;
		this.cotaConsumida -= mbytes;
	}
	
	/**
	 * Verifica se ainda tem espaço de armazenado na cota padrão. 
	 * @return Um valor booleano indicando se a cota está no limite ou não.
	 */
	public boolean atingiuCota() {
		if (this.cota <= 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Exibe o nome do laboratório, a cota consumida e a cota padrão do sistema.
	 * @return Uma String com o nome do laboratório, cota consumida e a cota padrão do sistema.
	 */
	public String toString() {
		return nomeLaboratorio + " " + cotaConsumida + "/" + cota_padrao_laboratorio;
	}
}
