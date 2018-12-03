package cn.tomxin.jiandan_house.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * 支持城市表
 */
@Data
@Table(name = "city")
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int not null COMMENT '城市id'")
    private int id;

    @Column(columnDefinition = "varchar(10) COMMENT '城市名称'")
    private String cityName;

    @Column(columnDefinition = "varchar(1000) COMMENT '豆瓣链接'")
    private String douBanUrl;

}
