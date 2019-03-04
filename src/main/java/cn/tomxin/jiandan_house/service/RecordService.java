package cn.tomxin.jiandan_house.service;

import cn.tomxin.jiandan_house.entity.ListParam;
import cn.tomxin.jiandan_house.entity.Record;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RecordService {

    Page<Record> findAllByOpenId(String openId, ListParam listParam);

    Record save(Record record);

    Record update(Record record) throws Exception;

    Record saveAndSendMessage(Record record);

    List<Record> findAllByCreateTime(LocalDateTime now);
}
