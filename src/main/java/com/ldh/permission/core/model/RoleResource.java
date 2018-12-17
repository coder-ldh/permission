package com.ldh.permission.core.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 角色资源表
 * </p>
 *
 * @author ldh
 * @since 2018-12-17
 */
@TableName("role_resource")
public class RoleResource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户角色ID
     */
    @TableId("role_resource_id")
	private Long roleResourceId;
    /**
     * 角色ID
     */
	@TableField("role_id")
	private Long roleId;
    /**
     * 资源ID
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


	public Long getRoleResourceId() {
		return roleResourceId;
	}

	public void setRoleResourceId(Long roleResourceId) {
		this.roleResourceId = roleResourceId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
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
		return "RoleResource{" +
			"roleResourceId=" + roleResourceId +
			", roleId=" + roleId +
			", resourceId=" + resourceId +
			", updateTime=" + updateTime +
			", createTime=" + createTime +
			"}";
	}
}
