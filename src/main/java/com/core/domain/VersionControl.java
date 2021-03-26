package com.core.domain;

import com.core.common.base.BaseDomain;
import lombok.Builder;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wangj
 * @version 1.0
 * @Title: User
 * @Package com.core.domain
 * @Description: TODO
 * @date 2020/3/13 23:47
 */
@Entity
@Data
@Builder
@Table(name = "version_control")
public class VersionControl extends BaseDomain {

    /**
     *  device  (设备字段，返回安卓或者ios) string
     */
    private String  device;
    /**
     *   (版本字段，int 类型，整数方便判断大小)int
     */
    private String  versionCode;

    /**
     *  (功能开关接口，0或者1)string
     */
    private String switchTag;
    /**
     *  (apk 下载地址)string
     */
    private String url;

    /**
     *  (新版本更新内容)string
     */
    private String content;
    /**
     * (版本版号)string
     */
    private String  versionNumber;
}
