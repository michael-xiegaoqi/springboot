package demo.controller;

/**
 * Created by Administrator on 2016/10/11.
 */

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import demo.service.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhengyunfei on 2016/9/2.
 */
@RestController
@Api(value = "2:产品API", description = "产品接口", produces = "application/json")
public class FundController {
    @Autowired
    UserMapper userMapper;
    @ApiOperation(httpMethod = "GET", value = "1：基金详情(<font color='blue'>release</font>)",position = 3,notes = "接口地址:/api/fund/findById<br>请求参数:<br>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code><table>" +
            "<th >参数</th><th>参数名称</th><th>是否为空</th><th>备注</th>" +
            "<tr><td >id</td><td>基金ID</td><td>否</td><td>基金ID</td></tr></table>" +
            "<br>返回说明:<br>" +
            "<table  >" +
            "<th >字段</th><th>备注</th>" +
            "<tr><td>currency</td><td>基金币种</td></tr>" +
            "<tr><td>duration</td><td>存续期</td></tr>" +
            "<tr><td>expectedReturn</td><td>预期收益率</td></tr>" +
            "<tr><td>managementFee</td><td>管理费</td></tr>" +
            "<tr><td>priorityYield</td><td>优先收益率</td></tr>" +
            "<tr><td>rateStartDate</td><td>募集开始日期</td></tr>" +
            "<tr><td>reateEndDate</td><td>募集结束日期</td></tr>" +
            "<tr><td>ratingMoney</td><td>剩余金额</td></tr>" +
            "<tr><td>fundTypeName</td><td>基金类型</td></tr>" +
            "<tr><td>fundSize</td><td>基金规模</td></tr>" +
            "<tr><td>fundMode</td><td>出资方式</td></tr>" +
            "<tr><td>toRaise</td><td>已募集金额</td></tr>" +
            "<tr><td>rateStatus</td><td>募集状态:0募集结束1正在募集中</td></tr>" +
            "<tr><td>desc</td><td>简介</td></tr>" +
            "<tr><td>fundByname</td><td>简称</td></tr>" +
            "<tr><td>fundName</td><td>名称</td></tr>" +
            "<tr><td>rate</td><td>募集进度</td></tr>" +
            "<tr><td>investmentField</td><td>投资领域</td></tr>" +
            "<table></code></pre></div>")
    @ResponseBody
    @RequestMapping(value = "/api/fund/findById", method = RequestMethod.GET)
    public String create(@RequestParam String id) {
      return "{\n" +
              "    \"message\":\"成功\",\n" +
              "    \"data\":{\n" +
              "        \"currency\":\"人民币\",\n" +
              "        \"duration\":\"3+4\",\n" +
              "        \"expectedReturn\":\"25%\",\n" +
              "        \"managementFee\":\"2%\",\n" +
              "        \"priorityYield\":\"第一步: 向LP及普通合伙人分配本金； 第二步: 向LP分配8%的优先收益； 第三步: 如仍有剩余，向GP回拨优先受益； 第四步: 将剩余收益中的20%分配给GP，80%分配给LP\",\n" +
              "        \"rateStartDate\":\"1467302400\",\n" +
              "        \"ratingMoney\":\"14000\",\n" +
              "        \"fundTypeName\":\"股权投资基金\",\n" +
              "        \"reateEndDate\":\"1501430400\",\n" +
              "        \"fundSize\":\"4亿\",\n" +
              "        \"fundMode\":\"非一次性出资\",\n" +
              "        \"fundType\":\"9901\",\n" +
              "        \"toRaise\":\"26000万\",\n" +
              "        \"rateStatus\":1,\n" +
              "        \"desc\":\"上市公司为基石投资人，行业内项目资源丰富，增加项目退出渠道\",\n" +
              "        \"url\":\"http://www.pestreet.cn/c/freemarker/upload/img/20160707/20160707102149dffd.jpg\",\n" +
              "        \"capitalContribution\":\"500万\",\n" +
              "        \"recommended\":\"资源整合\",\n" +
              "        \"fundId\":\"deeb77c9-fff1-4092-9de7-a4b2de04b00a\",\n" +
              "        \"fundByname\":\"TMT+大消费产业基金\",\n" +
              "        \"fundName\":\"TMT+大消费产业基金\",\n" +
              "        \"investmentField\":\"TMT,大消费产业基金\",\n" +
              "        \"rate\":65\n" +
              "    },\n" +
              "    \"code\":0\n" +
              "}\n" ;
    }


    @ApiOperation(httpMethod = "GET", value = "2：基金详情点击更多(<font color='blue'>release</font>)",position = 2,notes = "该地址直接返回h5页面，所以直接调用url地址就行，需要传递基金产品id" )
    @ResponseBody
    @RequestMapping(value = "/api/fund/detail", method = RequestMethod.GET)
    public String detailMore(@RequestParam String id) {
        return "";
    }

    @ApiOperation(httpMethod = "POST", value = "3：募集结束点击更多(<font color='blue'>release</font>)",position = 2,notes = "<h4>传递参数</h4>" +
             "<div class=\"block response_body json\"><pre class=\"json\"><code><table>" +
            "<th >参数</th><th>参数名称</th><th>是否为空</th><th>备注</th>" +
            "<tr><td >id</td>" + "<td>pageNow</td><td>是</td><td>当前页码</td></tr>" +
            "<tr><td >id</td>" + "<td>pageSize</td><td>是</td><td>每页显示条数</td></tr>" +
            "<table></code></pre></div>"+
            "<div class=\"block response_body json\"><pre class=\"json\"><code>" +
            "<h4>有数据时返回数据参考</h4>"+
            "{\n" +
            "    \"data\": {\n" +
            "        \"RAISE_END\": [{\n" +
            "            \"fundId\": \"28e306c8-b617-4129-829b-4b4e7730f3c8\",\n" +
            "            \"fundByname\": \"人民币专项投资组合基金\",\n" +
            "            \"fundName\": \"清科人民币专项投资组合基金\",\n" +
            "            \"url\": \"http://www.pestreet.cn/c/freemarker/upload/img/20150924/2015092414441320150924(2).jpg\",\n" +
            "            \"rate\": 100,\n" +
            "            \"capitalContribution\": \"500万\",\n" +
            "            \"recommended\": \"收益稳定\",\n" +
            "            \"desc\": \"组合投资优秀的VC/PE基金，降低风险，保障收益\",\n" +
            "            \"rateStatus\": 0,\n" +
            "            \"duration\": \"1+7\",\n" +
            "            \"fundSize\": \"1亿\",\n" +
            "            \"remainingDays\": 311,\n" +
            "            \"expectedReturn\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"fundId\": \"b4c214c5-f18d-4235-b399-20cdca505542\",\n" +
            "            \"fundByname\": \"A股上市公司人民币定增基金\",\n" +
            "            \"fundName\": \"清科昊渤A股上市公司定增基金\",\n" +
            "            \"url\": \"http://www.pestreet.cn/c/freemarker/upload/img/20160517/20160517142801rjejrlr.jpg\",\n" +
            "            \"rate\": 100,\n" +
            "            \"capitalContribution\": \"500万\",\n" +
            "            \"recommended\": \"优质资产装入\",\n" +
            "            \"desc\": \"股票天然折价，未来有较大上升空间\",\n" +
            "            \"rateStatus\": 0,\n" +
            "            \"duration\": \"1.5+1\",\n" +
            "            \"fundSize\": \"1亿\",\n" +
            "            \"remainingDays\": 20,\n" +
            "            \"expectedReturn\": null\n" +
            "        }]\n" +
            "    },\n" +
            "    \"code\": 0,\n" +
            "    \"msg\": \"\"\n" +
            "}" +
            "</code></pre></div>"+
            "<div class=\"block response_body json\"><pre class=\"json\"><code>" +
            "<h4>无数据时返回数据参考</h4>"+
           "{\n" +
            "    \"data\": {\n" +
            "        \"RAISE_END\": []\n" +
            "    },\n" +
            "    \"code\": 1059,\n" +
            "    \"msg\": \"没有更多数据了\"\n" +
            "}"+
            "</code></pre></div>")

    @ResponseBody
    @RequestMapping(value = "/api/fund/raiseds", method = RequestMethod.POST)
    public String raisedMore(@RequestParam int pageNow,@RequestParam int pageSize) {
        return "";
    }
}
