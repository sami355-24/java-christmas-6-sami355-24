package christmas.Message.Excepton;

enum ExceptionPrefix {
    ERROR_PREFIX("[ERROR] ");

    private String message;

    ExceptionPrefix(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
