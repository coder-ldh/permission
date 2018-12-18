package com.ldh.permission.core.model.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author ldh
 * @since 2018-12-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentVO implements Serializable {

    private static final long serialVersionUID = 1L;

	private Long departmentId;
	/**
	 * 部门名称
	 */
	private String departmentName;
	/**
	 * 所属层级
	 */
	private Integer level;
	/**
	 * 0为删除1为正常
	 */
	private Integer status;
	private Long parentId;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 新增时间
	 */
	private Date createTime;
}
