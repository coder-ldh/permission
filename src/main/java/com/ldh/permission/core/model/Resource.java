package com.ldh.permission.core.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 资源表
 * </p>
 *
 * @author ldh
 * @since 2018-12-17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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
	@TableField("resource_name")
	private String resourceName;
	/**
	 * 父节点ID
	 */
	@TableField("parent_id")
	private Long parentId;
	/**
	 * 0为删除1为正常
	 */
	private Integer status;
	/**
	 * 权限
	 */
	private String permission;
	/**
	 * 是否是付费资源（0为1为付费资源）
	 */
	private Integer pay;
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
}
