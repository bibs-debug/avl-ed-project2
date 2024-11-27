# Projeto AVL Tree e Binary Search Tree (BST) - Análise de Dados do Bolsa Família

## Descrição do Projeto

Este projeto visa modelar dados relacionados ao número de beneficiários do programa Bolsa Família utilizando **Árvores Binárias de Busca (BST)** e **Árvores AVL**. O objetivo é realizar análises de desempenho entre essas estruturas e executar operações comuns de manipulação de dados, garantindo eficiência e balanceamento automático na árvore AVL.

### Objetivos Alinhados com ODS 1 (Erradicação da Pobreza)
Este trabalho está alinhado com o **Objetivo de Desenvolvimento Sustentável 1: Erradicação da Pobreza**, ao analisar dados críticos que auxiliam no entendimento e distribuição dos recursos do programa Bolsa Família.

---

## Funcionalidades Implementadas

### Estruturas de Dados:
- **Binary Search Tree (BST)**:
  - Inserção de dados.
  - Busca de elementos.
  - Travessias:
    - Pré-Ordem.
    - Em-Ordem.
    - Pós-Ordem.
  - Altura da árvore.
- **AVL Tree**:
  - Funcionalidades herdadas da BST.
  - Balanceamento automático após inserções e remoções.
  - Rotações:
    - Simples (direita e esquerda).
    - Duplas (direita-esquerda e esquerda-direita).

---

## Operações Realizadas

- **Análise de dados**:
  - Inserção de dados sobre beneficiários do Bolsa Família por município.
  - Pesquisa por município, número de famílias, e renda per capita.
  - Comparação de eficiência entre BST e AVL Tree em operações comuns.

- **Relatórios**:
  - Listagem de beneficiários em ordem crescente e decrescente.
  - Estatísticas de distribuição de renda e número de famílias por município.
  - Verificação de balanceamento da AVL Tree em grandes volumes de dados.

---

## Arquitetura do Projeto

### Classes Principais

#### **`BinarySearchTree`**
- Responsável por:
  - Estruturação básica da árvore binária de busca.
  - Implementação das operações de inserção, busca e remoção.
  - Métodos de travessia (pré-ordem, em-ordem, pós-ordem).

#### **`AVLTree`**
- Extende a `BinarySearchTree`.
- Adiciona:
  - Balanceamento automático via rotações.
  - Atualização de fatores de balanceamento dos nós.

#### **`Node`**
- Estrutura de um nó individual da árvore.
- Contém:
  - Chave de identificação (ID do município).
  - Dados associados (número de famílias, renda per capita, etc.).
  - Ponteiros para os filhos esquerdo e direito.

---

## Estrutura de Arquivos

```plaintext
avl-ed-project2/
├── src/
│   ├── BinarySearchTree.java
│   ├── AVLTree.java
│   ├── Node.java
│   ├── Main.java
│   └── Utils.java
├── resources/
│   └── dataset/
├──    └── dataset_2020_cleaned.csv
├── README.md
└── LICENSE
