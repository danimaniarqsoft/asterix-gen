package com.danimaniarqsoft.asterix.commands;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.danimaniarqsoft.asterix.core.operations.AbstractCommandOperation;
import com.danimaniarqsoft.asterix.domain.AsterixContext;
import com.danimaniarqsoft.asterix.util.AbstractTest;

@Slf4j
public class SelectOneMenuCommandTest extends AbstractTest {

    @Autowired
    @Qualifier("selectOneMenuOperation")
    private AbstractCommandOperation operation;
    @Autowired
    private SelectOneMenuCommand cmd;

    @BeforeTest
    public void beforeTest() {
        String testPath = System.getProperty("user.dir");
        System.setProperty("user.dir", testPath);
    }

    @Test(dataProvider = "asterixContext")
    public void selectOneMenuSimple(AsterixContext context) throws IOException {
        cmd.selectOneMenuSimple(context.getDomainElement(),
                context.getMbTarget());
    }
}
