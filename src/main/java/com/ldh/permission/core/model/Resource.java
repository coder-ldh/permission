package com.ldh.permission.core.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;

/**
 * <p>
 * 资源表
 * </p>
 *
 * @author ldh
 * @since 2018-12-17
 */
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资源ID
     */
	@TableId(value="resource_id", type= IdType.AUTO)
	private Long resourceId;
    /**
     * 资源名称
     */
	private String name;
    /**
     * 所属层级
     */
	private Integer level;
    /**
     * 父节点ID
     */
	@TableField("parent_id")
	private Long parentId;
    /**
     * 路径
     */
	private String url;
    /**
     * 资源全路径
     */
	@TableField("full_url")
	private String fullUrl;
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


	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFullUrl() {
		return fullUrl;
	}

	public void setFullUrl(String fullUrl) {
		this.fullUrl = fullUrl;
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
		return "Resource{" +
			"resourceId=" + resourceId +
			", name=" + name +
			", level=" + level +
			", parentId=" + parentId +
			", url=" + url +
			", fullUrl=" + fullUrl +
			", updateTime=" + updateTime +
			", createTime=" + createTime +
			"}";
	}
}
