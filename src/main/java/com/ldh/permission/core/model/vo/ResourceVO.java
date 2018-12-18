package com.ldh.permission.core.model.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

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
public class ResourceVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资源ID
     */
	private Long resourceId;
	/**
	 * 资源名称
	 */
	private String resourceName;
	/**
	 * 父节点ID
	 */
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
	private String fullUrl;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 新增时间
	 */
	private Date createTime;
}
