package com.jshop.dao;

import java.util.List;

import com.jshop.entity.VirtualShippingAddressT;

public interface VirtualShippingAddressTDao {

	/**
	 * 增加虚拟发货地址
	 * @param vsa
	 * @return
	 */
	public abstract int addVirtualShippingAddressT(VirtualShippingAddressT vsa);
	/**
	 * 根据发货地址id查询一系列发货地址（是否变更过地址等）
	 * @param virtualshippingaddressid
	 * @param state
	 * @return
	 */
	public abstract List<VirtualShippingAddressT>findVirtualShippingAddressTByIdAndState(String virtualshippingaddressid,String state);
	/**
	 * 根据订单号查询虚拟发货地址（邮箱和手机）
	 * @param state
	 * @param orderid
	 * @return
	 */
	public abstract List<VirtualShippingAddressT>findVirtualShippingAddressTByStateAndOrderid(String state,String orderid);
	/**
	 * 根据订单号变更发货地址状态
	 * @param orderid
	 * @param state
	 * @return
	 */
	public abstract int updateVirtualShippingAddressTByorderandstate(String orderid,String state);
	/**
	 * 根据订单号和发货状态获取发货地址，地址状态是最新的可用地址，state=1
	 * @param orderid
	 * @param state
	 * @return
	 */
	public abstract VirtualShippingAddressT findVirtualShippingAddressTByOrderidandstate(String orderid,String state);
	
	
	/**
	 * 批量删除虚拟收获地址
	 * @param strs
	 * @return
	 */
	public abstract int delVirtualShippingAddressT(String []strs);
	/**
	 * 更新虚拟收获地址
	 * @param vsa
	 * @return
	 */
	public abstract int updateVirtualShippingAddressT(VirtualShippingAddressT vsa);
	/**
	 * 获取所有虚拟收获地址
	 * @return
	 */
	public abstract List<VirtualShippingAddressT>findAllVirtualShippingAddressT();
	
	
}
