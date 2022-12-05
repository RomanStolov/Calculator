// Исключение при ошибках для удобства контроля работы программы
class ExceptionCalc extends Exception {
    ExceptionCalc(String description) {

        super(description);

    }
}