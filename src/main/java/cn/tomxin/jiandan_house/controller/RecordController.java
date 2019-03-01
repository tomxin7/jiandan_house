package cn.tomxin.jiandan_house.controller;

import cn.tomxin.jiandan_house.entity.ListParam;
import cn.tomxin.jiandan_house.entity.Record;
import cn.tomxin.jiandan_house.service.RecordService;
import cn.tomxin.jiandan_house.util.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 记录控制器
 * @author: tomxin
 * @date: 2018/11/27 15:18
 * @Version 1.0
 **/

@RestController
@RequestMapping(value = "/v0.1/record")
public class RecordController {

    @Autowired
    private RecordService recordService;


    /**
     * 添加记录
     * @param
     * @return
     */
    @PostMapping
    public Record save(@RequestBody Record record, HttpServletRequest request) throws Exception {
        //从request中提取openId
        String openId = JwtToken.getUserOpenId(request);
        record.setOpenId(openId);

        //把中文逗号替换为英文
        record.setKeyWord(record.getKeyWord().replace("，",","));

        record = recordService.saveAndSendMessage(record);

        return record;
    }

    /**
     * 修改记录
     * @param record
     * @return
     * @throws Exception
     */
    @PutMapping(value = "/{id}")
    public Record update(@RequestBody Record record,@PathVariable(value = "id") String id) throws Exception {
        record.setId(id);
        return recordService.update(record);
    }

    /**
     * 查询记录
     * @param listParam
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping
    public Page<Record> list(ListParam listParam, HttpServletRequest request) throws Exception {

        //从request中提取openId
        String openId = JwtToken.getUserOpenId(request);

        return recordService.findAllByOpenId(openId ,listParam);
    }

}
