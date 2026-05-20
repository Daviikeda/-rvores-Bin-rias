public class Main {

    public static void main(String[] args) {

        ArvoreBinaria elemento = new ArvoreBinaria();

        elemento.inserir(new No(25));
        elemento.inserir(new No(12));
        elemento.inserir(new No(38));
        elemento.inserir(new No(7));
        elemento.inserir(new No(18));
        elemento.inserir(new No(31));
        elemento.inserir(new No(44));

        elemento.exibir("Em", elemento.raiz);

        elemento.removerElemento(38);

        elemento.exibir("Em", elemento.raiz);
    }
}