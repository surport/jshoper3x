package com.jshop.service;

import com.jshop.entity.GoodsTwocodeRpT;

public interface GoodsTwocodeRelationshipTService {
	/**
	 * 
	 * @param qrcode
	 * @return
	 */
	public int addGoodsQRCode(GoodsTwocodeRpT qrcode);
	/**
	 * 根据goodsid查询信息
	 * @param goodsid
	 * @return
	 */
	public GoodsTwocodeRpT findGoodsQRCodeByGoodsid(String goodsid);
	/**
	 * 根据goodsid修改二维码路径
	 * @param goodsqrcode
	 * @return
	 */
	public  int updateGoodsQRCode(String goodsid,String twocodepath);

}
