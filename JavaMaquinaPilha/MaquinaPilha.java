import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class MaquinaPilha {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso correto: java MaquinaPilha arquivoDeEntrada");
            return;
        }

        try {
            String codigo = lerCodigo(args[0]);
            int resultado = executarCodigo(codigo);
            System.out.println("Resultado da execução: " + resultado);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Erro durante a execução: " + e.getMessage());
        }
    }

    private static String lerCodigo(String arquivo) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(arquivo));
        StringBuilder codigo = new StringBuilder();
        String linha;
        while ((linha = reader.readLine()) != null) {
            codigo.append(linha).append("\n");
        }
        reader.close();
        return codigo.toString();
    }

    private static int executarCodigo(String codigo) {
        Stack<Integer> pilha = new Stack<>();
        String[] instrucoes = codigo.split("\n");

        for (String instrucao : instrucoes) {
            String[] partes = instrucao.split(" ");

            for (String parte : partes) {
                if (!parte.isEmpty()) {
                    if (parte.equals("PUSH")) {
                        // Empilha o próximo número na pilha
                        pilha.push(Integer.parseInt(partes[1]));
                    } else if (parte.equals("SUM")) {
                        // Desempilha dois números, soma e empilha o resultado
                        int op2 = pilha.pop();
                        int op1 = pilha.pop();
                        pilha.push(op1 + op2);
                    } else if (parte.equals("MULT")) {
                        // Desempilha dois números, multiplica e empilha o resultado
                        int op2 = pilha.pop();
                        int op1 = pilha.pop();
                        pilha.push(op1 * op2);
                    } else if (parte.equals("SUB")) {
                        // Desempilha dois números, subtrai e empilha o resultado
                        int op2 = pilha.pop();
                        int op1 = pilha.pop();
                        pilha.push(op1 - op2);
                    } else if (parte.equals("DIV")) {
                        // Desempilha dois números, divide e empilha o resultado
                        int op2 = pilha.pop();
                        int op1 = pilha.pop();
                        if (op2 == 0) {
                            throw new ArithmeticException("Divisão por zero");
                        }
                        pilha.push(op1 / op2);
                    }
                }
            }
        }

        if (pilha.size() != 1) {
            throw new RuntimeException("Erro durante a execução: pilha não contém um único resultado");
        }

        return pilha.pop();
    }
}
