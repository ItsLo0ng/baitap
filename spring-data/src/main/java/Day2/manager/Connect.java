package Day2.manager;

public class Connect {

    public void init() {
        System.out.println("Opening database connection...");
    }

    public void executeQuery(String sql) {
        System.out.println("Executing SQL: " + sql);
    }

    public void destroy() {
        System.out.println("Closing database connection...");
    }
}