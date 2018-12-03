package cn.tomxin.jiandan_house.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QQInfo {
    /**
     * token
     */
    private String accessToken;

    /**
     * openId
     */
    private String openId;

    /**
     * appId
     */
    private String appId;
}
