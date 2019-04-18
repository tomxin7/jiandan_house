package cn.tomxin.jiandan_house.service;

import cn.tomxin.jiandan_house.entity.Record;
import cn.tomxin.jiandan_house.util.HttpClientHelper;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
public class ScheduleCloseUserTask {

    @Autowired
    private RecordService recordService;

    @Value("${mail.delevop_id}")
    private String delevopId;

    @Value("${mail.account}")
    private String account;

    @Value("${mail.password}")
    private String password;

    /**
     * 每天中午十二点，查出20天前设置的人，关闭任务
     */
    @Scheduled(cron="0 0 12 * * ?")   //每天中午十二点触发
    public void task() throws Exception {
        List<Record> recordList = recordService.findAllByCreateTime(LocalDateTime.now().plusDays(-20));
        //对关闭的人发送消息
        for (Record record : recordList){

            if ("微信".equals(record.getRemindType())){
                try{
                    sendWXMessage(record);
                    record.setStatus(0);
                    recordService.update(record);
                }catch (Exception e){
                    log.error("微信发送失败");
                }
            }
            if ("邮箱".equals(record.getRemindType())){
                try{
                    sendMailMessage(record);
                    record.setStatus(0);
                    recordService.update(record);
                }catch (Exception e){
                    log.error("邮件发送失败");
                }
            }
        }
    }

    /**
     * 发送微信
     * @param record
     */
    private void sendWXMessage(Record record) throws UnsupportedEncodingException {
        String message = "您的任务["+ record.getCityName() + "-" + record.getKeyWord() + "]已经超过20天，系统为节省资源将会停止任务，如果需要继续监控，请重新添加任务，祝您生活愉快";
        message  = java.net.URLEncoder.encode(message,   "utf-8");
        String url = "http://wxmsg.dingliqc.com/send?msg={msg}&userIds={userid}";
        url = url.replace("{msg}",message);
        url = url.replace("{userid}",record.getRemind());

        HttpClientHelper.get(url);

    }


    /**
     * 发送邮件
     * @param record
     */
    private void sendMailMessage(Record record){
        String url = "http://api.keminl.cn/g/api/1d26212ab2b4bf4a703fa889a86b365c/SendMailByTemplet";
        JSONObject mailTemplate = new JSONObject();
        mailTemplate.put("templet_code", "house_overtime");
        mailTemplate.put("receiver", record.getRemind());
        mailTemplate.put("mail_subject", "简单服务已经超期");
        mailTemplate.put("delevop_id", delevopId);

        JSONObject templetData = new JSONObject();
        templetData.put("task", "[" + record.getCityName() + "-" + record.getKeyWord() + "]") ;

        JSONObject smtpConfig = new JSONObject();
        smtpConfig.put("host", "smtp.qq.com");
        smtpConfig.put("port", 587);
        smtpConfig.put("account", account);
        smtpConfig.put("password", password);
        smtpConfig.put("display_name", "简单提醒");

        mailTemplate.put("templet_data", templetData);
        mailTemplate.put("smtp_config", smtpConfig);

        HttpClientHelper.postForJson(url, mailTemplate);
    }
}
