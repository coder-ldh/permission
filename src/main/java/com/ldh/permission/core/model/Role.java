package com.ldh.permission.core.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author ldh
 * @since 2018-12-17
 */
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	@TableId(value="role_id", type= IdType.AUTO)
	private Long roleId;
    /**
     * 角色名称
     */
	private String name;
    /**
     * 金主ID
     */
	@TableField("partner_id")
	private Long partnerId;
    /**
     * 修改者
     */
	@TableField("update_by")
	private Long updateBy;
    /**
     * 修改时间
     */
	@TableField("update_time")
	private Date updateTime;
    /**
     * 新增者
     */
	@TableField("create_by")
	private Long createBy;
    /**
     * 新增时间
     */
	@TableField("create_time")
	private Date createTime;


	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Role{" +
			"roleId=" + roleId +
			", name=" + name +
			", partnerId=" + partnerId +
			", updateBy=" + updateBy +
			", updateTime=" + updateTime +
			", createBy=" + createBy +
			", createTime=" + createTime +
			"}";
	}
}
