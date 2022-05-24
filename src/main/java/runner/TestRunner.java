package runner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static class Test_Runner {
        public static void main(String[] args) {
            Result result = JUnitCore.runClasses(Test.class);
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
            System.out.println("Result=="+result.wasSuccessful());
        }
    }
}
