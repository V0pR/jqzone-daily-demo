package com.core.domain;

import com.core.common.base.BaseDomain;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author v0pr
 */
@Entity
@Data
@Builder
@Table(name = "user_feed_back")
public class UserFeedBack extends BaseDomain {

    /**
     * （用户id，前端给用户随机生成一个唯一的md5值）string
     */
    private String uid;

    /**
     *  (反馈标题)string
     */
    private String title;
    /**
     * （反馈内容）string
     */
    private String content;
    /**
     * (联系方式，字符串类型，可能是邮箱，微信号，QQ号等等，不做判断，甚至可以不填)string
     */
    private String tall;
}
