package commons;

import java.nio.file.FileSystems;

public class GlobalConstants {

    public static final String USER_URL = "https://live.techpanda.org/";
    public static final String ADMIN_URL = "https://live.techpanda.org/index.php/backendlogin/";

    public static final long LONG_TIMEOUT = 10;
    public static final long TWO_SECONDS = 2;
    public static final long ONE_SECOND = 1;

    public static final String SEPARATOR = FileSystems.getDefault().getSeparator();
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String UPLOAD_FILES_FOLDER_PATH = PROJECT_PATH + SEPARATOR + "uploadFiles" + SEPARATOR;
}
