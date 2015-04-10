package domain;

public enum HttpProtocol {
   HTTPS("http"), SMTP("smtp"), TCP("tcp"), HTTP("http");
   private String formattedName;

   private HttpProtocol(String formattedName) {
      this.formattedName = formattedName;
   }

   public String getFormattedName() {
      return formattedName;
   }
}
