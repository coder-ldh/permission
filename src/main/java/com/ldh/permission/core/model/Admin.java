package com.ldh.permission.core.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ldh
 * @since 2018-12-17
 */
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("admin_id")
	private Long adminId;
	@TableField("user_name")
	private String userName;
	@TableField("update_time")
	private Date updateTime;
	@TableField("create_time")
	private Date createTime;
}
