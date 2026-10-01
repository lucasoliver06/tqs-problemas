import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NodeTest {

	@Test
	void testNode() {
		Node node = new Node();
		assertNull(node.getNext());
		assertEquals(-1, node.getValor());
	}
	@Test
	void testNodeInt() {
		Node node = new Node(7);
		assertEquals(7, node.getValor());
	}
	@Test
	void testSetValor() {
		Node node = new Node();
		node.setValor(5);
		assertEquals(5, node.getValor());
	}
	@Test
	void testGetNext() {
		Node node = new Node();
		assertNull(node.getNext());
	}
	@Test
	void testSetNext() {
		Node node = new Node(7);
		node.setNext(new Node(9));
		
		assertEquals(9, node.getNext().getValor());
	}
}
