package com.ldh.permission.core.model.po;


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
 * @since 2018-12-17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminPO implements Serializable {

    private static final long serialVersionUID = 1L;

	private Long adminId;
	private String userName;
	private Date updateTime;
	private Date createTime;
}
