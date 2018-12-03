package cn.tomxin.jiandan_house.entity;

import lombok.Getter;
import lombok.Setter;

/**
  * @Description: 分页获取
  * @author: tomxin(221360)
  * @date: 2018/11/30 11:24
  * @Version 1.0
 **/
@Getter
@Setter
public class ListParam {
    /**
     * 当前页
     */
    private int pageNum = 0;

    /**
     * 数据长度
     */
    private int pageSize = 10;
}
