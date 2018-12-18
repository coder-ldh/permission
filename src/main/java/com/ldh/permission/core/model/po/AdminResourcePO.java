package com.ldh.permission.core.model.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

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
public class AdminResourcePO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private Long adminResourceId;
    /**
     * adminID
     */
	private Long adminId;
    /**
     * resourceID
     */
	private Long resourceId;
    /**
     * 修改时间
     */
	private Date updateTime;
    /**
     * 新增时间
     */
	private Date createTime;
}
