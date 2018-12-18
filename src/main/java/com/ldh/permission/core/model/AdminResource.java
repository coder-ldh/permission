package com.ldh.permission.core.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 用户资源表
 * </p>
 *
 * @author ldh
 * @since 2018-12-17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
