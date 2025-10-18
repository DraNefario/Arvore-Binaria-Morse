public class Main {
    public static void main(String[] args) {
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();

        arvore.inserir(".-", 'A');
        arvore.inserir("-...", 'B');
        arvore.inserir("-.-.", 'C');
        arvore.inserir("...", 'S');
        arvore.inserir("---", 'O');


        System.out.println("Estrutura da arvore:");
        arvore.exibirMorse();

        System.out.println("\nBusca individual:");
        System.out.println("... = " + arvore.buscar("..."));  // S
        System.out.println("--- = " + arvore.buscar("---"));  // O
    }
}
