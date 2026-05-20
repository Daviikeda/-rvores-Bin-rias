public class ArvoreBinaria {

    No raiz;

    public ArvoreBinaria() {
        this.raiz = new No(null);
        System.out.println("Árvore binária criada.");
    }

// ITERATIVO

    public void inserirIterativo(Integer conteudo){
        No novoNo = new No(conteudo);
            if(this.raiz.getConteudo() == null) {
                this.raiz = novoNo;
            } else {
                No aux = this.raiz;
                while (true) {
                    if (aux.getConteudo() > novoNo.getConteudo()) {
                        // investigar para esquerda
                        if (aux.getEsquerda() == null) {
                            aux.setEsquerda(novoNo);
                            return;
                        } else {
                            aux = aux.getEsquerda();
                        }
                    } else if (aux.getConteudo() == novoNo.getConteudo()) {
                        System.out.println("Não é possível informar nós repetidos. Esse nó já existe na árvore.");
                        return;
                    } else {
                        // investigar para a direita
                        if (aux.getDireita() == null) {
                            aux.setDireita(novoNo);
                            return;
                        } else {
                            aux = aux.getDireita();
                        }
                    }
                }

            }
    }

    public void preOrdem(No noAtual) {
        System.out.println(noAtual.getConteudo());
        if (noAtual.getEsquerda() != null) {
            preOrdem(noAtual.getEsquerda());
        }
        if (noAtual.getDireita() != null) {
            preOrdem(noAtual.getDireita());
        }
    }

    private void emOrdem(No noAtual) {
        if (noAtual.getEsquerda() != null) {
            emOrdem(noAtual.getEsquerda());
        }
        System.out.println(noAtual.getConteudo());
        if (noAtual.getDireita() != null) {
            emOrdem(noAtual.getDireita());
        }
    }

    private void posOrdem(No noAtual) {
        if (noAtual.getEsquerda() != null) {
            posOrdem(noAtual.getEsquerda());
        }
        if (noAtual.getDireita() != null) {
            posOrdem(noAtual.getDireita());
        }
        System.out.println(noAtual.getConteudo());
    }

    public void exibir(String percurso, No noAtual) {
        switch (percurso) {
            case "Pre":
                preOrdem(noAtual);
                break;

            case "Em":
                emOrdem(noAtual);
                break;

            case "Pos":
                posOrdem(noAtual);
                break;
        }
    }

// RECURSIVO

    public void inserirRecursivo(No novoNo, No atual) {

        if (atual.getConteudo() == null) {
            atual.setConteudo(novoNo.getConteudo());
            return;
        }

        if (atual.getConteudo() > novoNo.getConteudo()) {

            if (atual.getEsquerda() == null) {
                atual.setEsquerda(novoNo);
            } else {
                inserirRecursivo(novoNo, atual.getEsquerda());
            }

        } else if (atual.getConteudo().equals(novoNo.getConteudo())) {

            return;

        } else {

            if (atual.getDireita() == null) {
                atual.setDireita(novoNo);
            } else {
                inserirRecursivo(novoNo, atual.getDireita());
            }
        }
    }

    public void inserir(No novoNo) {
        if (estaVazio()) {
            this.raiz = novoNo;
        } else {
            inserirRecursivo(novoNo, this.raiz);
        }
    }

    private boolean estaVazio() {
        return this.raiz == null || this.raiz.getConteudo() == null;
    }

    public boolean procurarElemento(Integer raiz, No var2) {
        if (this.raiz.getConteudo() == null) {
            System.out.println("Raiz está vazia");
        } else {
            if (raiz.equals(var2.getConteudo())) {
                return true;
            }

            if (var2.getEsquerda() != null) {
                this.procurarElemento(raiz, var2.getEsquerda());
            }

            if (var2.getDireita() != null) {
                this.procurarElemento(raiz, var2.getDireita());
            }
        }

        return false;
    }

    public void removerElemento(Integer NoAtual) {
        this.raiz = this.removerRecursivo(this.raiz, NoAtual);
    }

    private No removerRecursivo(No raiz, Integer var1) {
        if (raiz != null && raiz.getConteudo() != null) {
            if (var1 < raiz.getConteudo()) {
                raiz.setEsquerda(this.removerRecursivo(raiz.getEsquerda(), var1));
                return raiz;
            } else if (var1 > raiz.getConteudo()) {
                raiz.setDireita(this.removerRecursivo(raiz.getDireita(), var1));
                return raiz;
            } else if (raiz.getEsquerda() == null && raiz.getDireita() == null) {
                return null;
            } else if (raiz.getEsquerda() == null) {
                return raiz.getDireita();
            } else if (raiz.getDireita() == null) {
                return raiz.getEsquerda();
            } else {
                No var2 = this.NoMenor(raiz.getDireita());
                raiz.setConteudo(var2.getConteudo());
                raiz.setDireita(this.removerRecursivo(raiz.getDireita(), var2.getConteudo()));
                return raiz;
            }
        } else {
            return raiz;
        }
    }

    private No NoMenor(No var1) {
        No var2;
        for(var2 = var1; var2.getEsquerda() != null; var2 = var2.getEsquerda()) {
        }
        return var2;
    }
}
