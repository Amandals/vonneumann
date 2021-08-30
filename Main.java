// von Neumann Básico
// PSCF - PUCPR (Prof. Luiz Lima)

// ALTERE O PROGRAMA PRINCIPAL ABAIXO CONFORME
// INSTRUÇÕES FORNECIDAS NA AULA

package vonneumann;

public class Main {
	public static void main(String[] args) {

		IO io = new IO(System.out);
		RAM ram = new RAM(7);
		Cache cache = new Cache(8, ram);
		CPU cpu = new CPU(cache, io);
		try {
			final int start = 10;
			ram.Write(start, 118);
			ram.Write(start + 1, 130);
			cpu.Run(start);
		}

		catch (InvalidAddress e) {
			System.err.println("Erro: " + e);
		}
	}
}
