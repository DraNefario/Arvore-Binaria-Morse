public class ArvoreBinariaMorse {
    No raiz;

    public ArvoreBinariaMorse() {
        raiz = new No('\0');
    }

    public void inserir(String morse, char simbolo){
        No atual = raiz;
        for (int i = 0; i < morse.length(); i++) {
            char s = morse.charAt(i);
            if(s == '.'){
                if(atual.getEsquerdo() == null){
                    atual.setEsquerdo(new No('\0'));
                }
                atual = atual.getEsquerdo();
            }else if(s == '-'){
                if(atual.getDireito() == null){
                    atual.setDireito(new No('\0'));
                }
                atual = atual.getDireito();
            }
        }
        atual.setSimbolo(simbolo);
    }

    public char buscar(String morse){
        No atual = raiz;
        for (int i = 0; i < morse.length(); i++) {
            char s = morse.charAt(i);
            if(s == '.'){
                if(atual.getEsquerdo() == null){
                    return '\0';
                }
                atual = atual.getEsquerdo();
            }else if(s == '-'){
                if(atual.getDireito() == null){
                    return '\0';
                }
                atual = atual.getDireito();
            }
        }
        return atual.getSimbolo();
    }

    public void remover(String morse){
        No atual = raiz;

        for (int i = 0; i < morse.length(); i++) {
            char s = morse.charAt(i);

            if(s == '.'){
                atual =  atual.getEsquerdo();
            } else if (s == '-') {
                atual = atual.getDireito();
            }

            if (atual == null){
                return;
            }
        }
        atual.setSimbolo('\0');
    }

    public void exibirMorse(String morse){
        exibirRecursivo(raiz, "");
    }

    public void exibirRecursivo(No no, String caminho){
        if(no == null){
            return;
        }

        if(no.getSimbolo() != '\0'){
            System.out.println("[" + caminho + "] " + no.getSimbolo());
        }

        exibirRecursivo(no.getEsquerdo(), caminho + ".");
        exibirRecursivo(no.getDireito(), caminho + "-");
    }
}
