package com.afaqy.service.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

class AssumptionsDemo {

    private final Calculator calculator = new Calculator();

    @Test
    void testOnlyOnDeveloperWorkstation() {
        Assumptions.assumeTrue("local".equals(System.getenv("AFAQY_ENVIRONMENT")));
        // remainder of test
    }

    @Test
    void testOnlyOnCiServer() {
        Assumptions.assumeTrue("CI".equals(System.getenv("AFAQY_ENVIRONMENT")),
                () -> "Aborting test: not on CI server");
        // remainder of test
    }

    @Test
    void testInAllEnvironments() {
        Assumptions.assumingThat("CI".equals(System.getenv("ENV")), () -> {
            // perform these assertions only on the CI server
            Assertions.assertEquals(2, calculator.divide(4, 2));
        });

        // perform these assertions in all environments
        Assertions.assertEquals(42, calculator.multiply(6, 7));
    }

}
