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
		if(posicio < 0 || posicio > this.getNElements()) {
			return false;
		} else if (posicio == 0) {
			Node aux = this.primer;
			this.primer = new Node(valor);
			this.primer.setNext(aux);
		} else {
			int i = 0;
			Node aux = this.primer;
			Node anterior = null;
			while(i < posicio) {
				anterior = aux;
				aux = aux.getNext();
				i++;
			}
			anterior.setNext(new Node(valor));
			anterior.getNext().setNext(aux);
		}
		return true;
	}
	public boolean eliminaValor(int posicio) {
		if(this.primer == null) {
			return false;
		} else if(posicio < 0 || posicio >= this.getNElements()) {
			return false;
		} else if(posicio == 0) {
			this.primer = primer.getNext();
			return true;
		}else {
			Node aux = this.primer;
			Node anterior = null;
			int i = 0;
			while(i < posicio) {
				anterior = aux;
				aux = aux.getNext();
				i++;
			}
			anterior.setNext(aux.getNext());
			return true;
		}

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
