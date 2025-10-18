public class Main {
    public static void main(String[] args) {
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();

        arvore.inserir(".-", 'A');
        arvore.inserir("-...", 'B');
        arvore.inserir("-.-.", 'C');
        arvore.inserir("...", 'S');
        arvore.inserir("---", 'O');

    }
}
