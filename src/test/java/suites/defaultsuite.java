package suites;

import Tests.CalculationTest;
import Tests.SavingCalculatorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CalculationTest.class,
        SavingCalculatorTest.class
})
public class defaultsuite {
}