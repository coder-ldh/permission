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
 * 
 * </p>
 *
 * @author ldh
 * @since 2018-12-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value="department_id", type= IdType.AUTO)
	private Long departmentId;
	/**
	 * 部门名称
	 */
	@TableField("department_name")
	private String departmentName;
	/**
	 * 所属层级
	 */
	private Integer level;
	/**
	 * 0为删除1为正常
	 */
	private Integer status;
	@TableField("parent_id")
	private Long parentId;
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
