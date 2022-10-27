package ua.com.javarush.parser_math_expression;


import java.util.*;

public class Test {
    public static void main(String[] args) {
        String expressionText = "122 - 34 - 3* (55 + 5* (3 - 2)) * 2";
        String expressionText2 = "-2+(-210)";
        List<Lexeme> lexemes = lexAnalyze(expressionText2);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        System.out.println(expr(lexemeBuffer));
        System.out.println(isValidBrackets(expressionText2));
        System.out.println(isValidMathematicalNotation(expressionText2));
    }

    public enum LexemeType {
        LEFT_BRACKET, RIGHT_BRACKET,
        OP_PLUS, OP_MINUS, OP_MUL, OP_DIV,
        NUMBER,
        EOF;
    }

    public static class Lexeme {
        LexemeType type;
        String value;

        public Lexeme(LexemeType type, String value) {
            this.type = type;
            this.value = value;
        }

        public Lexeme(LexemeType type, Character value) {
            this.type = type;
            this.value = value.toString();
        }
    }

    public static class LexemeBuffer {
        private int pos;

        public List<Lexeme> lexemes;

        public LexemeBuffer(List<Lexeme> lexemes) {
            this.lexemes = lexemes;
        }

        public Lexeme next() {
            return lexemes.get(pos++);
        }

        public void back() {
            pos--;
        }

        public int getPos() {
            return pos;
        }

        public List<Lexeme> getLexemes() {
            return lexemes;
        }
    }

    public static List<Lexeme> lexAnalyze(String expText) {
        if (isValidBrackets(expText) && isValidMathematicalNotation(expText)) {
            ArrayList<Lexeme> lexemes = new ArrayList<>();
            int pos = 0;
            while (pos < expText.length()) {
                char c = expText.charAt(pos);
                switch (c) {
                    case '(':
                        lexemes.add(new Lexeme(LexemeType.LEFT_BRACKET, c));
                        pos++;
                        continue;
                    case ')':
                        lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, c));
                        pos++;
                        continue;
                    case '+':
                        lexemes.add(new Lexeme(LexemeType.OP_PLUS, c));
                        pos++;
                        continue;
                    case '-':
                        lexemes.add(new Lexeme(LexemeType.OP_MINUS, c));
                        pos++;
                        continue;
                    case '*':
                        lexemes.add(new Lexeme(LexemeType.OP_MUL, c));
                        pos++;
                        continue;
                    case '/':
                        lexemes.add(new Lexeme(LexemeType.OP_DIV, c));
                        pos++;
                        continue;
                    default:
                        int countDot = 0;
                        if (c <= '9' && c >= '0') {
                            StringBuilder sb = new StringBuilder();
                            do {
                                sb.append(c);
                                pos++;
                                if (pos >= expText.length()) {
                                    break;
                                }
                                if (c == '.') {
                                    countDot++;
                                }

                                if (countDot >= 2) {
                                    return Collections.emptyList();
                                }
                                c = expText.charAt(pos);
                            } while (c <= '9' && c >= '0' || c == '.');
                            lexemes.add(new Lexeme(LexemeType.NUMBER, sb.toString()));
                        } else {
                            if (c != ' ') {
                                return Collections.emptyList();
                            }
                            pos++;
                        }
                }
            }
            lexemes.add(new Lexeme(LexemeType.EOF, ""));
            return lexemes;
        } else {
            return Collections.emptyList();
        }
    }

    public static double expr(LexemeBuffer lexemes) {
        if (!lexemes.getLexemes().isEmpty()) {
            Lexeme lexeme = lexemes.next();
            if (lexeme.type == LexemeType.EOF) {
                return 0;
            } else {
                lexemes.back();
                return plusminus(lexemes);
            }
        } else {
            return 0;
        }
    }

    public static double plusminus(LexemeBuffer lexemes) {
        double value = multdiv(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case OP_PLUS:
                    value += multdiv(lexemes);
                    break;
                case OP_MINUS:
                    value -= multdiv(lexemes);
                    break;
                case EOF:
                case RIGHT_BRACKET:
                    lexemes.back();
                    return value;
                default:
                    throw new RuntimeException("Unexpected token: " + lexeme.value
                            + " at position: " + lexemes.getPos());
            }
        }
    }

    public static double multdiv(LexemeBuffer lexemes) {
        double value = factor(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case OP_MUL:
                    value *= factor(lexemes);
                    break;
                case OP_DIV:
                    value /= factor(lexemes);
                    break;
                case EOF:
                case RIGHT_BRACKET:
                case OP_PLUS:
                case OP_MINUS:
                    lexemes.back();
                    return value;
                default:
                    throw new RuntimeException("Unexpected token: " + lexeme.value
                            + " at position: " + lexemes.getPos());
            }
        }
    }

    public static double factor(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        switch (lexeme.type) {
            case NUMBER:
                return Double.parseDouble(lexeme.value);
            case OP_MINUS:
                double value = factor(lexemes);
                return -value;
            case LEFT_BRACKET:
                value = plusminus(lexemes);
                lexeme = lexemes.next();
                if (lexeme.type != LexemeType.RIGHT_BRACKET) {
                    throw new RuntimeException("Unexpected token: " + lexeme.value
                            + " at position: " + lexemes.getPos());
                }
                return value;
            default:
                throw new RuntimeException("Unexpected token: " + lexeme.value
                        + " at position: " + lexemes.getPos());
        }
    }

    private static boolean isValidBrackets(String expression) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');

        Deque<Character> stack = new LinkedList<>();
        for (char c : expression.toCharArray()) {
            if (brackets.containsValue(c)) {
                stack.push(c);
            } else if (brackets.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != brackets.get(c)) {
                    return false;
                }
            }
        }
// в конце стек должен быть пустым
        return stack.isEmpty();
    }

    private static boolean isValidMathematicalNotation(String expression) {
        Map<Character, String> notations = new HashMap<>();
        notations.put('*', "Multiplication");
        notations.put('/', "Division");
        notations.put('+', "Plus");
        notations.put('-', "Minus");

        char[] array = expression.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (notations.containsKey(array[i])) {
                if (array[i + 1] == '*' || array[i + 1] == '/' || array[i + 1] == '+') {
                    return false;
                }
            }
        }
        return true;
    }
}
