package constants;

public class FrameworkConstants {
	
	 private FrameworkConstants() {
	    }

	    public static final String REPORT_PATH =
	            System.getProperty("user.dir")
	            + "/reports/";

	    public static final String SCREENSHOT_PATH =
	            System.getProperty("user.dir")
	            + "/screenshots/";

	    public static final String REPORT_NAME = "Scientific Calculator Automation Report";

	    public static final String DOCUMENT_TITLE = "Automation Execution Report";

	    public static final String TESTER = "Shailesh";

	    public static final String ENVIRONMENT = "QA";

	    public static final String CHROME = "chrome";

	    public static final String FIREFOX = "firefox";

	    public static final String EDGE = "edge";

	    public static final String FAILED_SCREENSHOT_PATH = "/screenshots/failures/";

	    public static final int RETRY_COUNT = 2;

		public static final int COUNTER = 20;

}
