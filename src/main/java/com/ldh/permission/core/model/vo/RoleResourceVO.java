package com.ldh.permission.core.model.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 角色资源表
 * </p>
 *
 * @author ldh
 * @since 2018-12-17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResourceVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户角色ID
     */
	private Long roleResourceId;
    /**
     * 角色ID
     */
	private Long roleId;
    /**
     * 资源ID
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
