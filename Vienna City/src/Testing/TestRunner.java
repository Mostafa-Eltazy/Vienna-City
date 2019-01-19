package Testing;

import java.util.List;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args) throws Exception {

        // Run the test
        Result result = JUnitCore.runClasses(TestClass.class);
        
        // Get all failures
        List<Failure> failures = result.getFailures();
        // Print out failures (if any)
        for (int i = 0; i < failures.size(); i++) {
            System.out.println(failures.get(i).toString());
        }
        // Check for the final status of the test class
        if (result.wasSuccessful())
        {
            System.out.println("All test cases have passed successfully.");
        }
        else {
            System.out.println(result.getFailureCount() + " out of " + result.getRunCount() + " test cases have failed");
        }
        
    }
}
