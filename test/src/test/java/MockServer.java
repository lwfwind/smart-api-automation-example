package test.java;

import com.qa.framework.mock.IMockServer;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Cookie;
import org.mockserver.model.Header;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import java.util.concurrent.TimeUnit;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;


public class MockServer implements IMockServer {

    private ClientAndServer mockServer;

    public void startServer() {
        mockServer = startClientAndServer(1081);
    }

    public void settingRules() {
        mockServer
                .when(
                        new HttpRequest()
                                .withMethod("POST")
                                .withPath("/login")
                                .withBody("username=13636426195&password=bddeaa7037632c856a6b83e4037f314a")
                )
                .respond(
                        new HttpResponse()
                                .withStatusCode(200)
                                .withHeaders(
                                        new Header("Content-Type", "application/json; charset=utf-8"),
                                        new Header("Cache-Control", "no-store, no-cache, must-revalidate, post-check=0, pre-check=0"),
                                        new Header("Set-Cookie", "PHPSESSID=9alb81bkiav0nffo0r8m9vf5s3; path=/")
                                )
                                .withBody("{errorCode:200,errorMsg:\"登录成功\"}")
                                .withDelay(TimeUnit.MILLISECONDS, 100)
                );
        mockServer
                .when(
                        new HttpRequest()
                                .withMethod("GET")
                                .withPath("/getMethod")
                                .withQueryStringParameter("parameter1","201")
                                .withQueryStringParameter("parameter2","7936160")
                                .withCookies(
                                        new Cookie("PHPSESSID", "9alb81bkiav0nffo0r8m9vf5s3")
                                )
                )
                .respond(
                        new HttpResponse()
                                .withStatusCode(200)
                                .withHeaders(
                                        new Header("Content-Type", "application/json; charset=utf-8"),
                                        new Header("Cache-Control", "no-store, no-cache, must-revalidate, post-check=0, pre-check=0")
                                )
                                .withBody("{\"errorCode\":\"200或者201\",\"errorMsg\":\"\\u7ea6\\u8bfe\\u6210\\u529f\"}")
                                .withDelay(TimeUnit.MILLISECONDS, 100)
                );

        mockServer
                .when(
                        new HttpRequest()
                                .withMethod("POST")
                                .withPath("/postMethod")
                                .withBody("parameter1=200&parameter2=7936160")
                                .withCookies(
                                        new Cookie("PHPSESSID", "9alb81bkiav0nffo0r8m9vf5s3")
                                )
                )
                .respond(
                        new HttpResponse()
                                .withStatusCode(200)
                                .withHeaders(
                                        new Header("Content-Type", "application/json; charset=utf-8"),
                                        new Header("Cache-Control", "no-store, no-cache, must-revalidate, post-check=0, pre-check=0")
                                )
                                .withBody("{\n" +
                                        " \"api\": \"mtop.film.mtoporderapi.getticketdetail\",\n" +
                                        " \"data\": {\n" +
                                        "  \"returnCode\": \"0\",\n" +
                                        "  \"returnValue\": {\n" +
                                        "   \"activities\": [\n" +
                                        "    {\n" +
                                        "     \"activityExtType\": \"0\",\n" +
                                        "     \"activitySeatCount\": \"1\",\n" +
                                        "     \"activityTitle\": \"爆米花\",\n" +
                                        "     \"joinCount\": \"0\",\n" +
                                        "     \"joinLimit\": \"1\",\n" +
                                        "     \"saleInfo\": \"爆米花\",\n" +
                                        "     \"seatLimit\": \"2\"\n" +
                                        "    }\n" +
                                        "   ],\n" +
                                        "   \"aliPayUrl\": \"http://maliprod.stable.alipay.net/w/trade_pay.do?refer=tbc&alipay_trade_no=2017031021001001550200320620&s_id=16783887b5de51cccad970eb0693509c\",\n" +
                                        "   \"alipayOrderId\": \"2017031021001001550200320620\",\n" +
                                        "   \"alipayServiceUrl\": \"https://h5.m.taobao.com/alicare/index.html?from=tpp_detail&bu=tpp\",\n" +
                                        "   \"alwaysGO\": \"true\",\n" +
                                        "   \"amount\": \"1700\",\n" +
                                        "   \"bizType\": \"SEAT\",\n" +
                                        "   \"buyerPhone\": \"13913913999\",\n" +
                                        "   \"cinemaAdr\": \"黄浦区打浦桥\",\n" +
                                        "   \"cinemaId\": \"11095105\",\n" +
                                        "   \"cinemaName\": \"大地新电商测试影院\",\n" +
                                        "   \"cinemaPhone\": \"021-888888888\",\n" +
                                        "   \"cinemaPhones\": [\n" +
                                        "    {\n" +
                                        "     \"areaCode\": \"021\",\n" +
                                        "     \"phoneNumber\": \"888888888\",\n" +
                                        "     \"phoneString\": \"021-888888888\"\n" +
                                        "    }\n" +
                                        "   ],\n" +
                                        "   \"codes\": [\n" +
                                        "    {\n" +
                                        "     \"code\": \"14014307\",\n" +
                                        "     \"name\": \"取票号\"\n" +
                                        "    }\n" +
                                        "   ],\n" +
                                        "   \"displayOrder\": [\n" +
                                        "    \"1\"\n" +
                                        "   ],\n" +
                                        "   \"easterEggsCount\": \"2\",\n" +
                                        "   \"easterEggsInfo\": \"两个彩蛋，错过不要\",\n" +
                                        "   \"fullTicketStatus\": \"USED\",\n" +
                                        "   \"gmtCreate\": \"1489138968\",\n" +
                                        "   \"hallName\": \"2号厅\",\n" +
                                        "   \"instruction\": \"1、请提前到达影院现场，找到自助取票机，打印纸质电影票，完成取票。\\n2、如现场自助取票机无法打印电影票，请联系影院工作人员处理。\\n3、凭打印好的纸质电影票，检票入场观影。\\n\",\n" +
                                        "   \"machineName\": \"\",\n" +
                                        "   \"noSmsTip\": \"是否购票成功以淘票票为准，短信仅供参考\",\n" +
                                        "   \"nowTime\": \"1489386505\",\n" +
                                        "   \"overallStatus\": \"USED\",\n" +
                                        "   \"partnerCode\": \"dadinew\",\n" +
                                        "   \"payDate\": \"1489139000\",\n" +
                                        "   \"payEndTime\": \"1489139861\",\n" +
                                        "   \"poster\": \"i4/TB1tNb3XXXXXXasXXXXXXXXXXXX_.jpg\",\n" +
                                        "   \"providerName\": \"大地影院\",\n" +
                                        "   \"refundDetail\": {\n" +
                                        "    \"cinemaCanQueryPrintingStatus\": \"true\",\n" +
                                        "    \"refundCount\": \"3\",\n" +
                                        "    \"refundExceptionCode\": \"0\",\n" +
                                        "    \"refundReasons\": {\n" +
                                        "     \"1\": \"买错了（如买错影院、场次、座位）\",\n" +
                                        "     \"8\": \"计划有变/没时间看/去不了\",\n" +
                                        "     \"64\": \"影院原因（放映机坏了、场次取消了）\",\n" +
                                        "     \"512\": \"买贵了\",\n" +
                                        "     \"1073741824\": \"其他\"\n" +
                                        "    },\n" +
                                        "    \"refundUserRightAmount\": \"1360\",\n" +
                                        "    \"refundUserRightAmountComfirmAlert\": \"退票无忧将退实付票价的80%，退票时请核对金额\",\n" +
                                        "    \"refundUserRightAmountPercentTips\": \"开场前可退实付票价的80%\",\n" +
                                        "    \"refundUserRightCount\": \"0\",\n" +
                                        "    \"refundUserRightDesc\": \"未取票开场前可退实付票价的80%（我的会员特权）\",\n" +
                                        "    \"refundUserRightSalesGoodDesc\": \"(￥17.0X80%)退实付票价的80%\",\n" +
                                        "    \"refundUserRightUrl\": \"http://h5.waptest.taobao.com/app/moviemember/pages/member/rights-detail-returnticket.html?level=V3\",\n" +
                                        "    \"refundable\": \"false\",\n" +
                                        "    \"saleRefundable\": \"false\",\n" +
                                        "    \"supplierRefundDesc\": \"1、仅标有【退票】标识的影院支持退票\\n2、未取票时开场前支持退票（时间以各家影院为准），万达有部分场次不支持退票，在确认订单页支付时会有说明已选购场次是否支持退换票\\n3、每个用户每月（自然月）最多能申请3次退票，同一账号、手机号、移动设备视为同一用户\\n4、仅支持整订单退票，暂不支持分座位退票\\n5、 如果购买了小食，暂不支持退换，放映结束前可继续使用\\n6、如果购票参加了特惠活动，退票后，不可再参加该活动\\n7、如果购票使用了兑换券，暂不支持退票；如果购票使用了代金券，退票时不退还代金券\\n8、退款将在1-10个工作日内原路退回到你的支付账户\",\n" +
                                        "    \"syncRefund\": \"false\"\n" +
                                        "   },\n" +
                                        "   \"refundFee\": \"1700\",\n" +
                                        "   \"refundable\": \"false\",\n" +
                                        "   \"saleGoods\": \"爆米花\",\n" +
                                        "   \"scheduleRefundable\": \"false\",\n" +
                                        "   \"seatInfo\": [\n" +
                                        "    \"4排7座\"\n" +
                                        "   ],\n" +
                                        "   \"servicePhone\": \"0571-88157838\",\n" +
                                        "   \"showEndTime\": \"1489148580\",\n" +
                                        "   \"showH5Url\": \"http://wapp.waptest.taobao.com/app/movie/pages/index/show-detail.html?showid=129346948&hasbuybtn=false\",\n" +
                                        "   \"showId\": \"129346948\",\n" +
                                        "   \"showTime\": \"1489141200\",\n" +
                                        "   \"tbOrderId\": \"210922809409525\",\n" +
                                        "   \"ticketNumber\": \"1\",\n" +
                                        "   \"title\": \"魔兽\",\n" +
                                        "   \"version\": \"国语 英语 3D\"\n" +
                                        "  }\n" +
                                        " },\n" +
                                        " \"ret\": [\n" +
                                        "  \"SUCCESS::调用成功\"\n" +
                                        " ],\n" +
                                        " \"v\": \"5.0\"\n" +
                                        "}")
                                .withDelay(TimeUnit.MILLISECONDS, 100)
                );
    }

    public void stopServer() {
        mockServer.stop();
    }
}
