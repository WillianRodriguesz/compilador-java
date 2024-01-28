class Parser {

    AnaliseLexica scanner;

    Parser(AnaliseLexica s) {
        scanner = s;
    }

    ArvoreSintatica parseProg() throws Exception {
        ArvoreSintatica resultado = Exp();
        Token tokenCorrente = scanner.getNextToken();
        if (tokenCorrente.token != TokenType.EOF)
            throw new Exception("Estava esperando: EOF");

        return resultado;
    }

    Exp Exp() throws Exception {
        Exp exp1, exp2;
        Token tokenCorrente = scanner.getNextToken();

        if (tokenCorrente.token == TokenType.NUM) {
            return new Num(Integer.parseInt(tokenCorrente.lexema + ""));
        }

        if (tokenCorrente.token == TokenType.APar) {
            exp1 = Exp();
            if (exp1 == null) {
                throw new Exception("Não encontrei expressão!");
            }

            Operador op = Op();

            // Ajuste: Se não encontrarmos um operador, assumimos uma operação de multiplicação
            if (op == null) {
                //scanner.ungetNextToken(tokenCorrente);
                op = new Mult(null, null);
                
            }

            exp2 = Exp();
            if (exp2 == null) {
                throw new Exception("Não encontrei expressão!");
            }

            tokenCorrente = scanner.getNextToken();
            if (tokenCorrente.token != TokenType.FPar) {
                // Ajuste: Devemos desfazer a leitura do próximo token se não for um fecha parênteses
                //scanner.ungetNextToken(tokenCorrente);
                throw new Exception("Estava esperando: )");
            }

            op.arg1 = exp1;
            op.arg2 = exp2;
            return op;
        } else {
            throw new Exception("Estava esperando: ( ou <NUM>");
        }
    }

    Operador Op() throws Exception {
		Token tokenCorrente = scanner.getNextToken();
		switch (tokenCorrente.token) {
			case SOMA:
				return new Soma(null, null);
			case SUB:
				return new Sub(null, null);
			case MULT:
				return new Mult(null, null);
			case DIV:
				return new Div(null, null);
			default:
		}
		return null;
	}
}
