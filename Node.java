public class Node {
	private int valor;
	private Node next;

	public Node() {
		this.valor = -1;
	}

	public Node(int v) {
		this.valor = v;
	}
	
	public void setValor(int v) {
		this.valor = v;
	}

	public Node getNext() {
		return this.next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getValor() { 
        return this.valor;
    }
}