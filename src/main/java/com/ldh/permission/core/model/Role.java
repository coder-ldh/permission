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
 * 角色表
 * </p>
 *
 * @author ldh
 * @since 2018-12-17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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
	 * 0为删除1为正常
	 */
	private Integer status;
	/**
	 * 部门ID
	 */
	@TableField("department_id")
	private Long departmentId;
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
}
