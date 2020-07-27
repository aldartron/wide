package co.wide.auth.common;

/**
 * Обсудить единую форму ответа
 * это один из вариантов
 */
public class ServerResponse<T> {
    private ResponseTO response;
    private String message;
    private T body;

    public enum ResponseTO {
        SUCCESS, AUTH_FAIL, ERROR, AND_SO_SO
    }

}
