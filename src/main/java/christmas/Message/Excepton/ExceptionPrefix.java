package christmas.Message.Excepton;

enum ExceptionPrefix {
    ERROR_PREFIX("[ERROR] ");

    private String prompt;

    ExceptionPrefix(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }
}
