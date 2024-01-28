class Compilador {

    public static void main(String[] args) {
        try {
            AnaliseLexica anLex = new AnaliseLexica(args[0]);

            Parser as = new Parser(anLex);
            ArvoreSintatica arv = as.parseProg();

            CodeGen backend = new CodeGen();
            String codigo = backend.geraCodigo(arv);
            System.out.println(codigo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
