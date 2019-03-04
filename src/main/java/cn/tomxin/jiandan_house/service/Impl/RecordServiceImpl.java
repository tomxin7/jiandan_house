package cn.tomxin.jiandan_house.service.Impl;

import cn.tomxin.jiandan_house.entity.ListParam;
import cn.tomxin.jiandan_house.entity.Record;
import cn.tomxin.jiandan_house.repository.RecordRepository;
import cn.tomxin.jiandan_house.service.RecordService;
import cn.tomxin.jiandan_house.util.BeanUtil;
import cn.tomxin.jiandan_house.util.HttpClientHelper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Value("${mail.delevop_id}")
    private String delevopId;

    @Value("${mail.account}")
    private String account;

    @Value("${mail.password}")
    private String password;

    @Value("${mail.templet_code}")
    private String templetCode;
    /**
     * 通过openId查询记录列表
     *
     * @param openId
     * @return
     */
    @Override
    public Page<Record> findAllByOpenId(String openId, ListParam listParam) {

        //分页获取
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = new PageRequest(listParam.getPageNum(), listParam.getPageSize(), sort);
        Page<Record> records = recordRepository.findAllByOpenId(openId, pageable);
        return records;
    }

    @Override
    public Record save(Record record) {
        record.setStatus(1);
        record.setCreateTime(LocalDateTime.now());
        return recordRepository.save(record);
    }



    @Override
    public Record update(Record record) {
        if (record.getId() == null) {
            throw new RuntimeException("record_id 不能为空");
        }

        Record locRecord = recordRepository.findRecordById(record.getId());
        if (locRecord == null) {
            throw new RuntimeException("record不存在");
        }

        //合并属性
        record = BeanUtil.mergeObject(record, locRecord);

        return recordRepository.save(record);
    }

    /**
     * 保存并发送消息
     * @param record
     * @return
     */
    @Override
    public Record saveAndSendMessage(Record record) {
        //插入数据
        record = this.save(record);

        if ("微信".equals(record.getRemindType())){
            sendWXMessage(record);
        }
        if ("邮箱".equals(record.getRemindType())){
            sendMailMessage(record);
        }

        return record;
    }

    @Override
    public List<Record> findAllByCreateTime(LocalDateTime now) {
        return recordRepository.findAllByCreateTimeLessThanEqualAndStatus(now,1);
    }

    /**
     * 发送微信
     * @param record
     */
    private void sendWXMessage(Record record){
        String message = "您的任务["+ record.getCityName() + "-" + record.getKeyWord() + "]已经成功启动，系统监控到合适房源后会给您发送提醒，任务结束前请不要取关本服务号，祝您生活愉快";
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
        mailTemplate.put("templet_code", templetCode);
        mailTemplate.put("receiver", record.getRemind());
        mailTemplate.put("mail_subject", "简单服务开启成功");
        mailTemplate.put("delevop_id", delevopId);

        JSONObject templetData = new JSONObject();
        templetData.put("task", "[" + record.getCityName() + "-" + record.getKeyWord() + "]") ;
        templetData.put("url", "http://house.jiandan.live/info.html?id=db7d5388-30b9-11e9-b905-005056c00008");

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


