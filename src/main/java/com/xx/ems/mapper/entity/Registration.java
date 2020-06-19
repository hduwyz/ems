package com.xx.ems.mapper.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 加减分登记表
 * </p>
 *
 * @author wangyz
 * @since 2020-06-18
 */
public class Registration implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long uerId;

    /**
     * 分数
     */
    private BigDecimal score;

    /**
     * 加减分类型：1-加分 2-减分
     */
    private Integer type;

    /**
     * 加班原因
     */
    private String reason;

    /**
     * 时间区间
     */
    private String timeInterval;

    /**
     * 时长
     */
    private BigDecimal duration;

    /**
     * 工作内容
     */
    private String content;

    /**
     * 输出成果
     */
    private String output;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUerId() {
        return uerId;
    }

    public void setUerId(Long uerId) {
        this.uerId = uerId;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Registration{" +
        "id=" + id +
        ", uerId=" + uerId +
        ", score=" + score +
        ", type=" + type +
        ", reason=" + reason +
        ", timeInterval=" + timeInterval +
        ", duration=" + duration +
        ", content=" + content +
        ", output=" + output +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
