package com.jshop.dao;

import java.util.List;

import com.jshop.entity.UserRoleM;

public interface UserRoleMDao {

	/**
	 * 增加用户和角色关系
	 * 
	 * @param urm
	 */
	public void addUserRoleM(UserRoleM urm);

	/**
	 * 根据用户id删除角色
	 * 
	 * @param roleid
	 */
	public int delUserRoleM(String userid);

	/**
	 * 根据userid获取用户角色
	 * 
	 * @param userid
	 * @return
	 */
	public List<UserRoleM> findUserRoleMByuserid(String userid);

}
