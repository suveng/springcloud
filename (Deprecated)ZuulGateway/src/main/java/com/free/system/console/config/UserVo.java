package com.free.system.console.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:
 * @author suwenguang
 * @date 19-7-21
 * @version 1.0.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
	private String username;
	private String password;
}
