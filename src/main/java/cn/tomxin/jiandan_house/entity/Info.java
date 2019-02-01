package cn.tomxin.jiandan_house.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Table(name = "info")
@Entity
public class Info {
    @Id
    @GenericGenerator(name="idGenerator", strategy="uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator="idGenerator")
    @Column(columnDefinition = "varchar(50) not null COMMENT '记录id'")
    private String id;

    @Column(columnDefinition = "varchar(100) COMMENT '用户id'")
    @JsonIgnore
    private String openId;

    @Column(columnDefinition = "varchar(100) COMMENT '用户名'")
    private String userName;

    @Column(columnDefinition = "varchar(100) COMMENT '任务'")
    private String task;

    @Column(columnDefinition = "varchar(50) COMMENT '添加时间'")
    private String createTime;

    @Column(columnDefinition = "varchar(5000) COMMENT '内容'")
    private String content;
}
