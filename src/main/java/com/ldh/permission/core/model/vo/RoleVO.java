package com.ldh.permission.core.model.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author ldh
 * @since 2018-12-17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleVO implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	private Long roleId;
	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 0为删除1为正常
	 */
	private Integer status;
	/**
	 * 部门ID
	 */
	private Long departmentId;
	/**
	 * 金主ID
	 */
	private Long partnerId;
	/**
	 * 修改者
	 */
	private Long updateBy;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 新增者
	 */
	private Long createBy;
	/**
	 * 新增时间
	 */
	private Date createTime;
}
