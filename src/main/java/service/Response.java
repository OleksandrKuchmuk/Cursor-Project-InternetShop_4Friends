package service;

public class Response<T> {
    private final T value;
    private final boolean isSuccessful;
    private final String message;

    public Response(T value, boolean isSuccessful, String message) {
        this.value = value;
        this.isSuccessful = isSuccessful;
        this.message = message;
    }

    public T getValue() {
        return this.value;
    }

    public boolean isSuccessful() {
        return this.isSuccessful;
    }

    public String getMessage() {
        return this.message;
    }

    public String toString() {
        return "Response{value=" + this.value + ", isSuccessful=" + this.isSuccessful + ", message='" + this.message + "'}";
    }
}
