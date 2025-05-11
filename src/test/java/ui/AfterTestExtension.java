package ui;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import utils.AllureSteps;

public class AfterTestExtension implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext context) {
        if (context.getExecutionException().isPresent()) {
            AllureSteps.screenshot();
            AllureSteps.sourceCode();
        }
    }
}
