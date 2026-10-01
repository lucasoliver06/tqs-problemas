import static org.junit.jupiter.api.Assertions.fail;

public class Llista {
	
	public boolean afegirUltim(int valor) {
		if(primer == null) {
			Node node = new Node(valor);
			primer = node;
		}
		else {
			Node actual = primer;
			while(actual.getNext() != null) {
				actual = actual.getNext();
			}
			actual.setNext(new Node(valor));
		}
		return true;
	}
	
	
	public boolean insertarValor(int posicio, int valor) {
		return false;
	}
	public boolean eliminaValor(int posicio)
	{
		return false;
	}
	
	public int getValor(int posicio) {
		if(posicio < 0 || posicio >= getNElements()) {
			return -1;
		}
		Node actual = primer;
		for(int i = 0; i < posicio; i++) {
			actual = actual.getNext();
			}
		return actual.getValor();
	}
	
	
	
	public boolean esBuida() { 
		return primer == null;
	}
	
	
	public int getNElements()
	{
		int contador = 0;
		Node actual = primer;
		while(actual != null) {
			contador++;
			actual = actual.getNext();
		}
		return contador;
	}
	
	private Node primer;
}
