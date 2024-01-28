class CodeGen {

    // Método geraCodigo removido

    // Novo método que executa diretamente a árvore sintática e retorna o resultado
    int executaCodigo(ArvoreSintatica arv) {
        return executaCodigo2(arv);
    }

    // Método recursivo para executar a árvore sintática
    private int executaCodigo2(ArvoreSintatica arv) {
        if (arv instanceof Mult)
            return executaCodigo2(((Mult) arv).arg1) * executaCodigo2(((Mult) arv).arg2);

        if (arv instanceof Soma)
            return executaCodigo2(((Soma) arv).arg1) + executaCodigo2(((Soma) arv).arg2);

        if (arv instanceof Sub)
            return executaCodigo2(((Sub) arv).arg1) - executaCodigo2(((Sub) arv).arg2);

        if (arv instanceof Div)
            return executaCodigo2(((Div) arv).arg1) / executaCodigo2(((Div) arv).arg2);

        if (arv instanceof Num)
            return ((Num) arv).num;

        return 0;
    }
}
