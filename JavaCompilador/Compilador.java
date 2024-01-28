class Compilador {

    public static void main(String[] args) {
        ArvoreSintatica arv = null;

        try {
            AnaliseLexica al = new AnaliseLexica(args[0]);
            Parser as = new Parser(al);

            arv = as.parseProg();

            // Agora chama o método executaCodigo em vez de geraCodigo
            CodeGen backend = new CodeGen();
            int resultado = backend.executaCodigo(arv);
            System.out.println("Resultado: " + resultado);

        } catch (Exception e) {
            System.out.println("Erro de compilação:\n" + e);
        }
    }
}
