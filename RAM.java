// von Neumann Básico
// PSCF - PUCPR (Prof. Luiz Lima)

package vonneumann;

class InvalidAddress extends Exception {
	private final int ender;

	public InvalidAddress(int e) {
		this.ender = e;
	}

	@Override
	public String toString() {
		return "Endereço " + ender + " é inválido!";
	}
}

public class RAM implements Memoria {
	private int tam = 0;
	final private int[] mem;

	public RAM(int k) {
		tam = (int) Math.pow(2, k);
		mem = new int[tam];
	}

	public int Read(int e) throws InvalidAddress {
		if (EhValido(e))
			return mem[e];
		else
			throw new InvalidAddress(e);
	}

	public void Write(int e, int p) throws InvalidAddress {
		if (EhValido(e))
			mem[e] = p;
		else
			throw new InvalidAddress(e);
	}

	private boolean EhValido(int e) {
		return (e >= 0 && e < tam);
	}
}
