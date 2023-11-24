package behavioral_patterns.chain_of_responsibility.middleware;

public class RequestLimitMiddleware extends Middleware {
    private int requestPerMinute;
    private int request;
    private long currentTime;

    public RequestLimitMiddleware(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }

    @Override
    public boolean check(String email, String password) {
        if (System.currentTimeMillis() > currentTime + 60_000) {
            request = 0;
            currentTime = System.currentTimeMillis();
        }

        request++;

        if (request > requestPerMinute) {
            System.out.println("Привышено максимальное число попыток!");
            System.exit(1);
        }
        return checkNext(email, password);
    }
}
