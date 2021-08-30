package vonneumann;

public interface Memoria {

    int Read(int e) throws InvalidAddress;

    void Write(int e, int p) throws InvalidAddress;
}
