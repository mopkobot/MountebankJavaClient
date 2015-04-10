package domain;

public enum HttpProtocol {
    HTTPS("https"), SMTP("smtp"), TCP("tcp"), HTTP("http");
    private String formattedName;

    private HttpProtocol(String formattedName) {
        this.formattedName = formattedName;
    }

    public String getFormattedName() {
        return formattedName;
    }
}
