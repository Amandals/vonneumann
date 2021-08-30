package vonneumann;

class Cache implements Memoria {
    int tamanho_cache;
    Memoria ram;
    int[] lista_cache;
    int inicio = 0;
    boolean modificada = false;

    public Cache(int tam, Memoria memoria) {
        this.tamanho_cache = tam;
        this.ram = memoria;
        this.lista_cache = new int[tam];
    }

    public int Read(int endereco) throws InvalidAddress {
        if ((endereco >= inicio) & (endereco < (inicio + tamanho_cache))) {
            int posicao = endereco - inicio;
            return lista_cache[posicao];
        } else {
            if (modificada) {
                for (int i = 0; i < tamanho_cache; ++i) {
                    ram.Write((i + inicio), lista_cache[i]);
                }
            }
            for (int i = 0; i < tamanho_cache; ++i) {
                lista_cache[i] = ram.Read(endereco + i);
            }
            inicio = endereco;
            return lista_cache[endereco - inicio];
        }

    }

    public void Write(int endereco, int palavra) throws InvalidAddress {
        if ((endereco >= inicio) & (endereco < (inicio + tamanho_cache))) {
            int posicao = endereco - inicio;
            lista_cache[posicao] = palavra;
        } else {
            if (modificada) {
                for (int i = 0; i < tamanho_cache; ++i) {
                    ram.Write((i + inicio), lista_cache[i]);
                }
            }
            for (int i = 0; i < tamanho_cache; ++i) {
                lista_cache[i] = ram.Read(endereco + i);
            }
            inicio = endereco;
            lista_cache[endereco - inicio] = palavra;
        }
        modificada = true;
    }
}
