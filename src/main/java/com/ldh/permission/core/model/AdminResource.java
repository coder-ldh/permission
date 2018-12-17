package com.ldh.permission.core.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户资源表
 * </p>
 *
 * @author ldh
 * @since 2018-12-17
 */
@TableName("admin_resource")
public class AdminResource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("admin_resource_id")
	private Long adminResourceId;
    /**
     * adminID
     */
	@TableField("admin_id")
	private Long adminId;
    /**
     * resourceID
     */
	@TableField("resource_id")
	private Long resourceId;
    /**
     * 修改时间
     */
	@TableField("update_time")
	private Date updateTime;
    /**
     * 新增时间
     */
	@TableField("create_time")
	private Date createTime;


	public Long getAdminResourceId() {
		return adminResourceId;
	}

	public void setAdminResourceId(Long adminResourceId) {
		this.adminResourceId = adminResourceId;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "AdminResource{" +
			"adminResourceId=" + adminResourceId +
			", adminId=" + adminId +
			", resourceId=" + resourceId +
			", updateTime=" + updateTime +
			", createTime=" + createTime +
			"}";
	}
}
