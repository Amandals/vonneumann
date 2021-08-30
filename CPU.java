// von Neumann Básico
// PSCF - PUCPR (Prof. Luiz Lima)

package vonneumann;

public class CPU {
	private final Memoria memoria;
	private final IO es;
	private int PC = 0;

	public CPU(Memoria memoria, IO es) {
		this.memoria = memoria;
		this.es = es;
	}

	public void Run(int ender) throws InvalidAddress {
		PC = ender;

		int regA = memoria.Read(PC++);
		int regB = memoria.Read(PC++);

		for (int i = regA; i <= regB; ++i) {
			memoria.Write(i, i - regA + 1);
			es.Output("\tcpu> " + i + " -> " + (i - regA + 1));
		}
	}
}
