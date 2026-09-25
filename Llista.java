
public class Llista {
	public boolean afegirUltim(int valor);
	public boolean insertarValor(int posicio, int valor);
	public boolean eliminaValor(int posicio);
	public int getValor(int posicio);
	
	public boolean esBuida();
	public int getNElements();
	
	private Node primer;
}
