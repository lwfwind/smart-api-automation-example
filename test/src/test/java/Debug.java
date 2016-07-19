package test.java;

import com.qa.framework.bean.TestData;
import com.qa.framework.core.DataManager;
import com.qa.framework.core.TestBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2016/7/8.
 */
public class Debug extends TestBase {

    @Test(dataProviderClass = DataManager.class, dataProvider = "data")
    public void debug(TestData testData, String url, String httpMethod) {
        processSetupResultParam(testData);
        String content = request(url, testData.getParams(), httpMethod, testData.isStoreCookie(), testData.isUseCookie());
        verifyResult(testData, content);
    }

    /*xmlName:需要运行的xml文件名
    * xmlDataName:需要运行的testdata的名称
    * 不写Testdata的名称运行整个xml接口文件*/
    @BeforeTest(alwaysRun = true)
    public void Pretreatment() {
        String xmlName = "demo";
        String xmlDataName = "mock";
        DataManager.setXmlName(xmlName);
        if (!xmlDataName.equalsIgnoreCase("")) {
            DataManager.setXmlDataNmae(xmlDataName);
        }
    }
}




