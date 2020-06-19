package com.xx.ems.mapper.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 上周工作总结及本周工作计划
 * </p>
 *
 * @author wangyz
 * @since 2020-06-18
 */
public class WorkContent implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
      private Long id;

    /**
     * 期次id
     */
    private Long periodId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 上周工作内容
     */
    private String lastWeekContent;

    /**
     * 输出成果
     */
    private String output;

    /**
     * 所用工时
     */
    private Integer workday;

    /**
     * 本周工作内容
     */
    private String thisWeekContent;

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

    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLastWeekContent() {
        return lastWeekContent;
    }

    public void setLastWeekContent(String lastWeekContent) {
        this.lastWeekContent = lastWeekContent;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public Integer getWorkday() {
        return workday;
    }

    public void setWorkday(Integer workday) {
        this.workday = workday;
    }

    public String getThisWeekContent() {
        return thisWeekContent;
    }

    public void setThisWeekContent(String thisWeekContent) {
        this.thisWeekContent = thisWeekContent;
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
        return "WorkContent{" +
        "id=" + id +
        ", periodId=" + periodId +
        ", userId=" + userId +
        ", lastWeekContent=" + lastWeekContent +
        ", output=" + output +
        ", workday=" + workday +
        ", thisWeekContent=" + thisWeekContent +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
