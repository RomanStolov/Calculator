// Для облегчения восприятия кода выделил методы в отдельный класс
class Tasks {
    /* Метод для проверки введенной строки на:
     *           - ошибочный ввод римских и арабских символов одновременно;
     *           - ошибочный ввод недопустимого кол-во операторов более одного или их полное отсутствие;
     *           - ошибочный ввод недопустимых символов;
     *           - ошибочный ввод оператора в начале и в конце строки.
     */
    void chekInputString(String input) throws ExceptionCalc {
        String charsOk = "0123456789IVX/*-+";
        String rimChars = "IVX";
        String arabChars = "0123456789";
        String operandChars = "/*-+";
        int countRimChar = 0;
        int countArabChar = 0;
        int countOperands = 0;
        for (int i = 0; i < input.length(); i++) {
            char charFromInput = input.charAt(i);
            // Проверка в методе на наличие недопустимых символов
            if (charsOk.indexOf(charFromInput) < 0) {
                throw new ExceptionCalc("Исключение. Ошибка ввода! Введены недопустимые символы в строке!");
            }
            // Проверка в методе на ошибку ввода оператора в начале и в конце строки
            if ((operandChars.indexOf(charFromInput) >= 0 && i == 0) || (operandChars.indexOf(charFromInput) >= 0 && i == (input.length() - 1))) {
                throw new ExceptionCalc("Исключение. Ошибка ввода! Оператор не может быть введен в начале или в конце строки!");
            }
            // Подсчет в методе числа римских символов, арабских символов, операторов
            if (rimChars.indexOf(charFromInput) >= 0) {
                countRimChar++;
            } else if (arabChars.indexOf(charFromInput) >= 0) {
                countArabChar++;
            } else if (operandChars.indexOf(charFromInput) >= 0) {
                countOperands++;
            }
            // Проверка в методе на количество операторов больше одного
            if (countOperands > 1) {
                throw new ExceptionCalc("Исключение. Ошибка ввода! Введено больше одного оператора в строке!");
            }
            // Проверка в методе на одновременное наличие римских и арабских символов в строке
            if (countArabChar > 0 && countRimChar > 0) {
                throw new ExceptionCalc("Исключение. Ошибка вода! Введены римские и арабские символы в строке!");
            }

        }
        // Проверка в методе на отсутствие оператора в строке
        if (countOperands == 0) {
            throw new ExceptionCalc("Исключение. Ошибка ввода! Нет ни одного оператора в строке!");
        }
        // Все проверки пройдены
    }

    // Метод для конвертации римских чисел в арабские
    int convertRimToArab(String substring) {
        return switch (substring) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> 0;
        };
    }

    // Метод для конвертации арабских чисел в римские
    String convertArabToRim(int a) {
        if (a == 100) {
            return "C";
        } else {
            int edinici = a % 10;
            int desyatki = (a - edinici) / 10;
            String subresult1 = switch (desyatki) {
                case 1 -> "X";
                case 2 -> "XX";
                case 3 -> "XXX";
                case 4 -> "XL";
                case 5 -> "L";
                case 6 -> "LX";
                case 7 -> "LXX";
                case 8 -> "LXXX";
                case 9 -> "IC";
                default -> "";
            };
            String subresult2 = switch (edinici) {
                case 1 -> "I";
                case 2 -> "II";
                case 3 -> "III";
                case 4 -> "IV";
                case 5 -> "V";
                case 6 -> "VI";
                case 7 -> "VII";
                case 8 -> "VIII";
                case 9 -> "IX";
                default -> "";
            };
            return subresult1 + subresult2;
        }
    }
}
