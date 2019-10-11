package co.edu.javeriana.pica.frameworks.echo.resources;

public class Echo {

    private String message;
    private String time;

    public Echo(String message, String time) {
        this.message = message;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }
}
