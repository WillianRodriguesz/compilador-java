# Compilador Didático e Máquina de Pilha 🚀

## Introdução

Este projeto implementa um compilador didático em Java, capaz de gerar instruções para uma máquina de pilha hipotética. Além disso, inclui uma Máquina de Pilha que executa as instruções geradas pelo compilador.

## Compilador Didático

### Compilação 🛠️
```bash
javac *.java
```
#### Verificação de Expressões

Verifique as expressões dentro dos arquivos de teste `teste` e `teste2`. Altere conforme necessário para fins de testes.
```bash
cat teste
```
### Execução 🚀
```bash
java Compilador teste2
```
Este comando compila os arquivos Java e executa o compilador didático com a expressão fornecida em "teste2" ou "teste".

## Máquina de Pilha

### Compilação da Máquina de Pilha 🛠️
```bash
javac *.java
```
### Geração do Código a partir do Compilador 🚀
```bash
java Compilador teste2 > codigoGerado
```
Gera o código a partir da árvore sintática gerada do compilador. Os arquivos com as expressões a serem alteradas são "teste" ou "teste2" para adicionar novas expressões e testar a máquina de pilha.

### Execução do Código Gerado 🚀
```bash
java MaquinaPilha codigoGerado
```
Isso deve gerar e executar as instruções da Máquina de Pilha para a expressão fornecida no teste2 ou teste.

Este projeto foi desenvolvido como parte da disciplina de Compiladores na área de Engenharia de Computação. Divirta-se explorando o fascinante mundo dos compiladores e máquinas de pilha! 🤖💻
