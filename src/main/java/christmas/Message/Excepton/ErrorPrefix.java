package christmas.Message.Excepton;

enum ErrorPrefix {
    ERROR_PREFIX("[ERROR] ");

    private String message;

    ErrorPrefix(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
