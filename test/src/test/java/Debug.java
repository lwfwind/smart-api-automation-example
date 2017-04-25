package test.java;

import com.qa.framework.bean.TestCase;
import com.qa.framework.core.DataManager;
import com.qa.framework.core.ParamValueProcessor;
import com.qa.framework.core.TestBase;
import com.qa.framework.library.httpclient.HttpMethod;
import com.qa.framework.mock.IMockServer;
import com.qa.framework.testnglistener.TestResultListener;
import com.qa.framework.verify.Verify;
import org.testng.annotations.*;

@Listeners({TestResultListener.class})
public class Debug extends TestBase {

    private IMockServer mockServer = null;

    @BeforeSuite(alwaysRun = true)
    public void beforeClass() throws IllegalAccessException, InstantiationException {
        mockServer = new MockServer();
        mockServer.startServer();
        mockServer.settingRules();
    }

    @AfterSuite(alwaysRun = true)
    public void afterClass() {
        if (mockServer != null) {
            mockServer.stopServer();
        }
    }

    @Test(dataProviderClass = DataManager.class, dataProvider = "data")
    public void debug(TestCase testCase, String url, String httpMethod) {
        ParamValueProcessor.processTestData(testCase);
        String content = HttpMethod.request(url, testCase.getHeaders(), testCase.getParams(), httpMethod, testCase.isStoreCookie(), testCase.isUseCookie());
        Verify.verifyResult(testCase, content);
        ParamValueProcessor.processAfter(testCase);
    }

    /*xmlName:需要运行的xml文件名
    * xmlDataName:需要运行的testdata的名称
    * 不写Testdata的名称运行整个xml接口文件*/
    @BeforeTest(alwaysRun = true)
    public void before() {
        String xmlName = "get";
        String xmlDataName = "getMethod";
        DataManager.setXmlName(xmlName);
        if (!xmlDataName.equalsIgnoreCase("")) {
            DataManager.setXmlDataName(xmlDataName);
        }
    }
}




