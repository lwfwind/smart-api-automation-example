package test.java;

import com.qa.framework.config.PropConfig;
import com.qa.framework.library.sms.sendMessage;
import com.qa.framework.testnglistener.ICustomTestListener;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestListener implements ICustomTestListener {
    private static Logger logger=Logger.getLogger(TestListener.class);

    @Override
    public void onStart(ITestContext testContext) {

    }

    @Override
    public void onTestFailure(ITestResult tr) {

    }

    @Override
    public void onTestSkipped(ITestResult tr) {

    }

    @Override
    public void onTestStart(ITestResult tr) {

    }

    @Override
    public void onTestSuccess(ITestResult tr) {

    }

    @Override
    public void onFinish(ITestContext testContext)  {
        if (PropConfig.isSendMsg()) {
            logger.info("测试用例测试完成");
            List<String> failedTestNames = new ArrayList<>();
            for (ITestResult failedTest : testContext.getFailedTests().getAllResults()) {
                logger.info("failedTest = " + failedTest.getName());
                failedTestNames.add(failedTest.getName());
            }
            if (!failedTestNames.isEmpty()) {
                String content = "本次测试未通过用例如下：\n";
                List<String> mobiles = new ArrayList<>();
                mobiles.add("13758196793");
                for (String failedName : failedTestNames) {
                    content = content + failedName + "\n";
                }
                logger.info(content);
                try {
                    sendMessage.sendMsg(mobiles, content);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
