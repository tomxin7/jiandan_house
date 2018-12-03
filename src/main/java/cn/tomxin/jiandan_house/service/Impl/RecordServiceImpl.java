package cn.tomxin.jiandan_house.service.Impl;

import cn.tomxin.jiandan_house.entity.ListParam;
import cn.tomxin.jiandan_house.entity.Record;
import cn.tomxin.jiandan_house.repository.RecordRepository;
import cn.tomxin.jiandan_house.service.RecordService;
import cn.tomxin.jiandan_house.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordRepository recordRepository;


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
        record.setCreateTime(new Date());
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
}


