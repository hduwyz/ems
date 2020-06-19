package com.xx.ems.mapper.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author wangyz
 * @since 2020-06-18
 */
public class PermissionApi implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 菜单表id
     */
    private Integer permissionId;

    /**
     * 服务名
     */
    private String apiService;

    /**
     * 功能
     */
    private String apiAction;

    /**
     * 地址
     */
    private String apiPath;

    /**
     * 序号
     */
    private Integer apiOrder;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getApiService() {
        return apiService;
    }

    public void setApiService(String apiService) {
        this.apiService = apiService;
    }

    public String getApiAction() {
        return apiAction;
    }

    public void setApiAction(String apiAction) {
        this.apiAction = apiAction;
    }

    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
    }

    public Integer getApiOrder() {
        return apiOrder;
    }

    public void setApiOrder(Integer apiOrder) {
        this.apiOrder = apiOrder;
    }

    @Override
    public String toString() {
        return "PermissionApi{" +
        "id=" + id +
        ", permissionId=" + permissionId +
        ", apiService=" + apiService +
        ", apiAction=" + apiAction +
        ", apiPath=" + apiPath +
        ", apiOrder=" + apiOrder +
        "}";
    }
}
