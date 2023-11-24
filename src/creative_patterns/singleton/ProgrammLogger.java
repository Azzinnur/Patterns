package creative_patterns.singleton;

public class ProgrammLogger {
    private static volatile ProgrammLogger programmLogger;
    private static StringBuffer logfile = new StringBuffer("This is new log file. \n\n");

    public static synchronized ProgrammLogger getProgrammLogger() {
        if(programmLogger != null) {
            return programmLogger;
        }
        synchronized (ProgrammLogger.class) {
            if (programmLogger == null) {
                programmLogger = new ProgrammLogger();
            }
            return programmLogger;
        }
    }

    private ProgrammLogger() {}

    public void addLogInfo(String logInfo){
        synchronized (ProgrammLogger.class) {
            logfile.append(logInfo).append("\n");
        }
    }

    public void showLogFile(){
        System.out.println(logfile);
    }
}
