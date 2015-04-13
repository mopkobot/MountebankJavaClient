package tcp;

public enum TcpMode {
    TEXT("text"), BINARY("binary");
    private String text;

    private TcpMode(String text) {
        this.text = text;
    }

    public String getFormattedName() {
        return text;
    }
}
