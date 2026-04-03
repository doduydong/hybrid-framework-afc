package commons;

import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VerificationFailureStore extends HashMap<ITestResult, List<Throwable>> {
    private VerificationFailureStore() {
        super();
    }

    public static VerificationFailureStore getFailures() {
        if (failures == null) {
            failures = new VerificationFailureStore();
        }
        return failures;
    }

    public List<Throwable> getFailuresForTest(ITestResult result) {
        List<Throwable> exceptions = get(result);
        return exceptions == null ? new ArrayList<Throwable>() : exceptions;
    }

    public void addFailureForTest(ITestResult result, Throwable throwable) {
        List<Throwable> exceptions = getFailuresForTest(result);
        exceptions.add(throwable);
        put(result, exceptions);
    }

    private static final long serialVersionUID = 1L;
    private static VerificationFailureStore failures;
}
