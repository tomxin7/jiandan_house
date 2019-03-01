package cn.tomxin.jiandan_house.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Table(name = "record")
@Entity
public class Record {

    @Id
    @GenericGenerator(name="idGenerator", strategy="uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator="idGenerator")
    @Column(columnDefinition = "varchar(32) not null COMMENT '记录id'")
    private String id;

    @Column(columnDefinition = "varchar(50) COMMENT '用户openId'")
    @JsonIgnore
    private String openId;

    @Column(columnDefinition = "varchar(10) COMMENT '城市名称'")
    private String cityName;

    @Column(columnDefinition = "TIMESTAMP COMMENT '添加时间'")
    private LocalDateTime createTime;

    @Column(columnDefinition = "varchar(100) COMMENT '关键字'")
    private String keyWord;

    @Column(columnDefinition = "varchar(10) COMMENT '提醒方式'")
    private String remindType;

    @Column(columnDefinition = "varchar(100) COMMENT '提醒地址'")
    private String remind;

    @Column(columnDefinition = "int COMMENT '状态'")
    private Integer status;
}
