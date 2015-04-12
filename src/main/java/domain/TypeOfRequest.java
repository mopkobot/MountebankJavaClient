package domain;

public enum TypeOfRequest {
    HTTPS("https"), SMTP("smtp"), TCP("tcp"), HTTP("http");
    private String formattedName;

    private TypeOfRequest(String formattedName) {
        this.formattedName = formattedName;
    }

    public String getFormattedName() {
        return formattedName;
    }
}
