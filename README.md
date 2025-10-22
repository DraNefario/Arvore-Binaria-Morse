# Árvore Binária - Código Morse

**Instituição:** Pontifícia Universidade Católica do Paraná 

**Disciplina:** Resolução de Problemas Estruturados em Computação

**Tema:** Implementação de Árvore Binária para Codificação e Decodificação em Código Morse

**Professor:** Andrey Cabral Meira

**Alunos:**
- Danillo Gonçalves Camargo da Silva
- Guilherme Felippe Lazari
- Rodrigo Schiavinatto Plassmann
- Thomas Manussadjian Steinhausser

---

## Descrição Geral

Este projeto implementa uma **Árvore Binária** capaz de representar o **Código Morse**, permitindo **codificar e decodificar mensagens** conforme a estrutura de pontos e traços.  

A proposta é demonstrar o uso de **estruturas de dados não lineares** e **operações recursivas** para manipulação hierárquica de informações.

Cada **nó** da árvore representa uma letra ou número, e o **caminho da raiz até o nó** descreve o padrão Morse:

- Esquerda (.), ponto  
- Direita (-), traço  

---

## Funcionalidades

| Função | Descrição |
|--------|------------|
| **Criação da Árvore** | Gera a árvore binária completa com todas as letras e números em Código Morse. |
| **Inserção de Caracteres** | Insere novos caracteres na árvore conforme seu código Morse. |
| **Busca por Código Morse** | Retorna o caractere correspondente a um código Morse informado. |
| **Busca por Caractere** | Retorna o código Morse equivalente a uma letra ou número. |
| **Remoção** | Remove um caractere sem comprometer a estrutura da árvore. |
| **Exibição Hierárquica** | Mostra a árvore em formato textual estruturado no console. |
| **Exibição de Caminho** | Exibe o caminho de um código Morse específico e o caractere correspondente. |
| **Tradução Morse - Texto** | Converte uma sequência de pontos e traços em texto legível, reconhecendo palavras separadas por `/`. |
| **Tradução Texto - Morse** | Traduz texto comum (A–Z, 0–9) para o formato de código Morse, usando `/` para separar palavras. |

---
## Estrutura de Classes

### Classe `No`

Representa **cada nó da árvore binária** do código Morse.  
Cada nó armazena um valor (letra ou número) e possui ligações para os nós filho esquerdo e direito.

#### Atributos:
- **`String valor`** - caractere armazenado no nó (pode ser vazio `" "` quando o nó não representa nenhum símbolo).  
- **`No esquerdo`** - nó filho à esquerda (ponto `.`).  
- **`No direito`** - nó filho à direita (traço `-`).  

#### Métodos:
- **Construtor:** `No()`  
  Inicializa o nó com valor vazio e filhos nulos.

---

### Classe `ArvoreBinariaMorse`

Responsável por toda a **lógica da árvore binária** e pelas **operações de tradução**.  
É nesta classe que estão implementadas as funções de inserção, busca, remoção, exibição e tradução.

#### Atributos:
- **`No raiz`** — nó raiz da árvore binária.

#### Métodos Principais:

- **`ArvoreBinariaMorse()`**  
  Construtor que cria a árvore e automaticamente carrega todos os caracteres padrões (A–Z, 0–9).

- **`void inserir(String caractere, String codigoMorse)`**  
  Insere um caractere na árvore de acordo com o caminho do código Morse.  
  - `.` → esquerda  
  - `-` → direita  

- **`String buscarPorMorse(String codigoMorse)`**  
  Recebe um código Morse e retorna o caractere correspondente.  

- **`String buscarPorCaractere(String caractere)`**  
  Recebe uma letra ou número e retorna seu código Morse equivalente.  

- **`void remover(String codigoMorse)`**  
  Remove o valor de um nó correspondente ao código Morse informado (sem alterar os demais caminhos).

- **`void exibir()`**  
  Exibe toda a árvore no console, mostrando o caminho (`.` e `-`) e o valor de cada nó.  

- **`void exibirCaminho(String codigoMorse)`**  
  Mostra o caminho e o caractere correspondente a um código Morse específico.

- **`String traduzirMorseParaTexto(String linha)`**  
  Converte uma sequência Morse em texto legível.  
  - Símbolos separados por espaço (` `)  
  - Palavras separadas por `/`

- **`String traduzirTextoParaMorse(String texto)`**  
  Converte texto comum em código Morse, preservando espaços com o símbolo `/`.  

---

### Classe `Main`

Classe principal que contém o **menu interativo de execução**.  
É responsável por interagir com o usuário via console e chamar os métodos da `ArvoreBinariaMorse`.

---

#### Estrutura do Menu:
```
1) Traduzir (Morse → Texto ou Texto → Morse)
2) Exibir caminho de um código Morse
3) Remover um símbolo pelo código Morse
4) Exibir árvore (hierárquica)
5) Buscar código Morse de uma letra ou número
6) Converter palavra/frase para Morse
0) Sair
```

---

### Exemplo de saída de Tradução de Código Morse para Texto

<img width="616" height="112" alt="image" src="https://github.com/user-attachments/assets/5ea538e6-674a-4355-9261-7ed5897b27c4" />


### Exemplo de saída de Tradução de Texto para Código Morse

<img width="616" height="112" alt="image" src="https://github.com/user-attachments/assets/ee86c13f-5989-460c-92f2-0e25ff9870f6" />


---

### Fluxo de Funcionamento

- `Main`, utiliza a classe `ArvoreBinariaMorse` para realizar as operações de codificação, decodificação e exibição.  
- `ArvoreBinariaMorse`, executa as operações lógicas da árvore (inserção, busca, remoção, tradução). 
- `No`, representa os nós que formam a estrutura fundamental da árvore binária.

---

## Conclusão

O projeto demonstrou, de forma prática, a implementação de uma **estrutura de dados não linear, a Árvore Binária**, aplicada à representação e manipulação do **Código Morse** em Java.  

Através da árvore binária, foi possível compreender e visualizar o funcionamento de operações fundamentais como **inserção**, **busca**, **remoção** e **percursos recursivos**, explorando conceitos de hierarquia e lógica binária.  

Cada caminho da raiz até um nó final representa uma sequência de **pontos (.)** e **traços (-)**, permitindo a **codificação e decodificação** de letras e números conforme o padrão Morse.

#### O projeto atende os seguintes objetivos:
- Implementa uma **Árvore Binária** funcional representando o **Código Morse**.  
- Utiliza **recursividade** para percorrer e manipular os nós da árvore.  
- Permite **codificar** e **decodificar** mensagens entre texto e código Morse.  
