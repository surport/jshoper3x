package com.jshop.action.backstage.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.jshop.action.backstage.authority.UserRoleMAction;
import com.jshop.action.backstage.base.InitTAction;
import com.jshop.action.backstage.base.SendSystemEmail;
import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.MD5Code;
import com.jshop.action.backstage.tools.Serial;
import com.jshop.action.backstage.tools.StaticString;
import com.jshop.action.backstage.tools.Validate;
import com.jshop.entity.FunctionM;
import com.jshop.entity.OrderT;
import com.jshop.entity.UserT;
import com.jshop.service.GlobalParamService;
import com.jshop.service.UserRoleMService;
import com.jshop.service.UsertService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.TemplateException;
@Namespace("")
@ParentPackage("jshop")
public class UserTAction extends ActionSupport {
	private UsertService usertService;
	private Serial serial;
	private InitTAction initTAction;
	private UserRoleMService userRoleMService;
	private UserRoleMAction userRoleMAction;
	private GlobalParamService globalParamService;
	private UserT bean = new UserT();
	private String param;
	private List<UserT> user = new ArrayList<UserT>();
	private List rows = new ArrayList();
	private int rp;
	private int page = 1;
	private int total = 0;
	private HttpServletResponse response;
	private HttpServletRequest request;
	private String goingToURL;
	private String userid;
	private String username;
	private String realname;
	private String email;
	private String telno;
	private String mobile;
	private String question;
	private String answer;
	private String password;
	private String userstate;
	private Date postingcount;
	private String section;
	private String position;
	private String groupid;
	private String parttime1;
	private String parttime2;
	private String parttime3;
	private String qq;
	private String sinaweibo;
	private String state;
	private String uid;
	private String rolemname;
	private String rolemid;
	private String headpath;
	private String weixin;
	private String newpassword;
	private String message;
	private String query;//text
	private String qtype;//select
	private String sortname;//排序字段
	private String sortorder;//排序方式
	private String roleid;
	private boolean slogin = false;
	private boolean sucflag;
	private boolean sauthority;
	private String baseurl;
	@JSON(serialize = false)
	public GlobalParamService getGlobalParamService() {
		return globalParamService;
	}

	public void setGlobalParamService(GlobalParamService globalParamService) {
		this.globalParamService = globalParamService;
	}

	@JSON(serialize = false)
	public UserRoleMAction getUserRoleMAction() {
		return userRoleMAction;
	}

	public void setUserRoleMAction(UserRoleMAction userRoleMAction) {
		this.userRoleMAction = userRoleMAction;
	}

	@JSON(serialize = false)
	public UserRoleMService getUserRoleMService() {
		return userRoleMService;
	}

	public void setUserRoleMService(UserRoleMService userRoleMService) {
		this.userRoleMService = userRoleMService;
	}
	@JSON(serialize = false)
	public InitTAction getInitTAction() {
		return initTAction;
	}

	public void setInitTAction(InitTAction initTAction) {
		this.initTAction = initTAction;
	}

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	@JSON(serialize = false)
	public UsertService getUsertService() {
		return usertService;
	}

	public void setUsertService(UsertService usertService) {
		this.usertService = usertService;
	}

	@JSON(serialize = false)
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@JSON(serialize = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JSON(serialize = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@JSON(serialize = false)
	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	@JSON(serialize = false)
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getUserstate() {
		return userstate;
	}

	public void setUserstate(String userstate) {
		this.userstate = userstate;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
	
	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getParttime1() {
		return parttime1;
	}

	public void setParttime1(String parttime1) {
		this.parttime1 = parttime1;
	}

	public String getParttime2() {
		return parttime2;
	}

	public void setParttime2(String parttime2) {
		this.parttime2 = parttime2;
	}

	public String getParttime3() {
		return parttime3;
	}

	public void setParttime3(String parttime3) {
		this.parttime3 = parttime3;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String getGoingToURL() {
		return goingToURL;
	}

	public void setGoingToURL(String goingToURL) {
		this.goingToURL = goingToURL;
	}

	public UserT getBean() {
		return bean;
	}

	public void setBean(UserT bean) {
		this.bean = bean;
	}

	public List<UserT> getUser() {
		return user;
	}

	public void setUser(List<UserT> user) {
		this.user = user;
	}

	@JSON(name = "rows")
	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public int getRp() {
		return rp;
	}

	public void setRp(int rp) {
		this.rp = rp;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public String getSortorder() {
		return sortorder;
	}

	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getBaseurl() {
		return baseurl;
	}

	public void setBaseurl(String baseurl) {
		this.baseurl = baseurl;
	}
	public String getRolemname() {
		return rolemname;
	}

	public void setRolemname(String rolemname) {
		this.rolemname = rolemname;
	}

	public String getRolemid() {
		return rolemid;
	}

	public void setRolemid(String rolemid) {
		this.rolemid = rolemid;
	}

	public Date getPostingcount() {
		return postingcount;
	}

	public void setPostingcount(Date postingcount) {
		this.postingcount = postingcount;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getSinaweibo() {
		return sinaweibo;
	}

	public void setSinaweibo(String sinaweibo) {
		this.sinaweibo = sinaweibo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getHeadpath() {
		return headpath;
	}

	public void setHeadpath(String headpath) {
		this.headpath = headpath;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public boolean isSauthority() {
		return sauthority;
	}

	public void setSauthority(boolean sauthority) {
		this.sauthority = sauthority;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}


	/**
	 * 验证登陆
	 */
	@Action(value = "checklogin", results = { @Result(name = "json", type = "json", params = { "includeProperties", "slogin" }) })
	public String checklogin() {
		UserT admin = (UserT) ActionContext.getContext().getSession().get(StaticString.BACK_USER_SESSION_KEY);
		if (admin!=null) {
			this.setSlogin(false);
			return "json";
		} else {

			this.setSlogin(true);
			return "json";
		}
	}
	
	
	@Action(value = "checkAuthorityException", results = { @Result(name = "json", type = "json", params = { "includeProperties", "sauthority" }) })
	public String checkAuthorityException(){
		String authorityE=(String) ActionContext.getContext().getSession().get(StaticString.AUTHORITYEXCEPTION);
		if(authorityE!=null){
			if(StaticString.ONE.equals(authorityE)){
				this.setSauthority(true);
				ActionContext.getContext().getSession().remove(StaticString.AUTHORITYEXCEPTION);
				return "json";
			}
		}else{
			this.setSauthority(false);
			return "json";
		}
		return "json";
	}


	/**
	 * 管理员登陆
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Action(value = "adminlogin", results = { @Result(name = "success", type = "redirect", location = "/admin/index.jsp?session=${param}"), @Result(name = "input", type = "redirect", location = "/admin/login.jsp?msg=${param}") })
	public String adminlogin() throws Exception {
		if(StringUtils.isBlank(this.getUsername())){
			this.setParam(StaticString.ONE);
			return INPUT;
		}
		if(StringUtils.isBlank(this.getPassword())){
			this.setParam(StaticString.ONE);
			return INPUT;
		}
		MD5Code md5 = new MD5Code();
		UserT user = new UserT();
		user.setUsername(username);
		user.setPassword(md5.getMD5ofStr(password));
		//user.setState(StaticString.THREE);//超级管理员
		user = this.getUsertService().login(user);
		if (user != null) {
			ActionContext.getContext().getSession().put(StaticString.BACK_USER_SESSION_KEY, user);
			this.setParam(md5.getMD5ofStr(user.getUserid()));
			ActionContext.getContext().getSession().put(StaticString.BACK_SESSION_KEY, param);
			//获取默认主题
			this.getInitTAction().InitDefaultThemeT();
			//收集权限信息并放入内存
			List<FunctionM> userfunctionlist = this.getUserRoleMAction().findUserRoleFunctionList(user.getUserid());
			//List<FunctionM>allfunctionlist=this.getUserRoleMAction().findAllFunctionM();
			ActionContext.getContext().getSession().put(StaticString.USERROLEFUNCTION, userfunctionlist);
			//ActionContext.getContext().getSession().put(BaseTools.ALLROLEFUNCTION, allfunctionlist);
			//获取前5条需要发货的订单信息
			List<OrderT>listOrderTs=this.getInitTAction().findNewestOrders();
			ActionContext.getContext().getSession().put(StaticString.NEWESTORDERS, listOrderTs);
			return SUCCESS;
		}
		this.setParam(StaticString.ONE);
		return INPUT;
	}

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Action(value = "findAllUsert", results = { @Result(name = "json", type = "json") })
	public String findAllUsert() {
		if(StaticString.SC.equals(this.getQtype())){
			finddefaultAllUserT();
		}else{
			if(StringUtils.isBlank(this.getQtype())){
				return "json";
			}else{
				return "json";
			}
		}
		return "json";
	}

	private void finddefaultAllUserT() {
		int currentPage = page;
		int lineSize = rp;
		total=this.getUsertService().countfindAllUsert();
		List<UserT>list=this.getUsertService().findAllUsert(currentPage, lineSize);
		if(!list.isEmpty()){
			processUserList(list);
		}
	}

	private void processUserList(List<UserT> list) {
		for (Iterator it = list.iterator(); it.hasNext();) {
			UserT u = (UserT) it.next();
			if (StaticString.ONE.equals(u.getState())) {
				u.setState(StaticString.NORMALUSER);
			}
			if (StaticString.TWO.equals(u.getState())) {
				u.setState(StaticString.MANAGERUSER);
			}
			if (StaticString.THREE.equals(u.getState())) {
				u.setState(StaticString.SUPERMANAGER);
			}
			if (StaticString.ZERO.equals(u.getUserstate())) {
				u.setUserstate(StaticString.USERSTATEUNACTIVE);
			}
			if (StaticString.ONE.equals(u.getUserstate())) {
				u.setUserstate(StaticString.USERSTATEACTIVE);
			}
			Map<String,Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", u.getUserid());
			cellMap.put("cell", new Object[] { 
					u.getUsername(), 
					u.getRealname(), 
					u.getEmail(),
					u.getMobile(),
					u.getRolemname(),
					u.getState(),
					u.getUserstate(),
					"<a id='edituser' href='user.jsp?operate=edit&folder=user&userid="+u.getUserid()+"' name='edituser'>[编辑]</a>"
					});
			rows.add(cellMap);
		}
		
	}

	/**
	 * 管理员增加用户
	 * 
	 * @return
	 */
	@Action(value = "saveUserT", results = { @Result(name = "json", type = "json") })
	public String saveUserT() {
		if(StringUtils.isNotBlank(this.getUsername())&&StringUtils.isNotBlank(this.getPassword())&&StringUtils.isNotBlank(this.getEmail())){
			MD5Code md5 = new MD5Code();
			UserT u = new UserT();
			u.setUsername(this.getUsername().trim());
			u.setEmail(this.getEmail().trim());
			u = this.getUsertService().checkUserByUsername(u);
			if (u != null) {
				this.setMessage("用户已经存在");//表示用户已经存在
				return "json";
			} else {
				u = new UserT();
				u.setUsername(this.getUsername().trim());
				u.setEmail(this.getEmail().trim());
				u = this.getUsertService().checkUserByEmail(u);
				if (u != null) {
					this.setMessage("用户邮箱已经存在");//表示用户邮箱存在
					return "json";
				}
				UserT user = new UserT();
				user.setUserid(this.getSerial().Serialid(Serial.USER));
				user.setUid(md5.getMD5ofStr(user.getUserid()));
				user.setUsername(this.getUsername().trim());
				user.setRealname(this.getRealname().trim());
				user.setEmail(this.getEmail().trim());
				user.setTelno(null);
				user.setMobile(this.getMobile().trim());
				user.setQuestion(this.getQuestion().trim());
				user.setAnswer(this.getAnswer().trim());
				user.setPassword(md5.getMD5ofStr(this.getPassword().trim()));//默认密码6个1
				user.setUserstate(this.getUserstate());
				user.setPostingcount(0);
				user.setSection(StaticString.EMPTY);
				user.setPosition(StaticString.EMPTY);
				user.setGroupid(StaticString.EMPTY);
				user.setParttime1(StaticString.EMPTY);
				user.setParttime2(StaticString.EMPTY);
				user.setParttime3(StaticString.EMPTY);
				user.setQq(this.getQq().trim());
				user.setState(this.getState());
				user.setRolemid(StaticString.ZERO);
				user.setRolemname(StaticString.EMPTY);
				user.setHeadpath(this.getHeadpath().trim());
				user.setCreatorid(BaseTools.adminCreateId());
				user.setCreatetime(BaseTools.systemtime());
				user.setUpdatetime(user.getCreatetime());
				if (this.getUsertService().save(user) > 0) {
					this.setSucflag(true);
					return "json";
				}
				return "json";
			}
		}
		this.setMessage("邮箱，用户名，密码必须填写");
		return "json";
		
	}
	/**
	 * 更新系统用户
	 * @return
	 */
	@Action(value = "updateUserT", results = { @Result(name = "json", type = "json") })
	public String updateUserT(){
		if(StringUtils.isBlank(this.getUserid())){
			return "json";
		}
		bean=this.getUsertService().findById(this.getUserid());
		bean.setRealname(this.getRealname());
		bean.setMobile(this.getMobile());
		bean.setQq(this.getQq());
		bean.setWeixin(this.getWeixin());
		bean.setSinaweibo(this.getSinaweibo());
		bean.setHeadpath(this.getHeadpath());
		bean.setEmail(this.getEmail());
		bean.setQuestion(this.getQuestion());
		bean.setAnswer(this.getAnswer());
		bean.setUserstate(this.getUserstate());
		bean.setState(this.getState());
		bean.setUpdatetime(BaseTools.systemtime());
		this.getUsertService().updateUserT(bean);
		this.setSucflag(true);
		return "json";
	}
	
	/**
	 * 根据用户id获取用户信息
	 * 
	 * @return
	 */
	@Action(value = "findUserById", results = { @Result(name = "json", type = "json") })
	public String findUserById() {
		if (StringUtils.isNotBlank(this.getUserid())) {
			bean = this.getUsertService().findById(this.getUserid());
			if (bean != null) {
				bean.setHeadpath(BaseTools.getBasePath()+bean.getHeadpath());
				this.setSucflag(true);
				return "json";
			}
		}
		return "json";
	}

	/**
	 *管理员更新用户信息，不包含密码等安全信息
	 * 
	 * @return
	 */
	@Action(value = "UpdateUserTunpwd", results = { @Result(name = "json", type = "json") })
	public String UpdateUserTunpwd() {
		this.checklogin();
		if (!this.isSlogin()) {
			UserT user = new UserT();
			user.setUserid(this.getUserid());
			user.setUsername(this.getUsername().trim());
			user.setEmail(this.getEmail().trim());
			user.setUserstate(this.getUserstate());
			user.setState(this.getState());
			if(this.getUsertService().updateUserTunpwd(user)>0){
				this.setSucflag(true);
				return "json";
			}
		}
		this.setSucflag(false);
		return "json";
	}

	/**
	 * 管理员批量删除用户
	 * 
	 * @return
	 */
	@Action(value = "DelUsert", results = { @Result(name = "json", type = "json") })
	public String DelUsert() {
		if (Validate.StrNotNull(this.getUserid())) {
			String[] list = this.getUserid().trim().split(",");
			if (this.getUsertService().delUser(list) > 0) {
				return "json";
			}
			return "json";
		}
		return "json";
	}

	/**
	 * 更改管理员密码
	 * 
	 * @return
	 */
	@Action(value = "UpdateUserMember", results = { @Result(name = "json", type = "json") })
	public String UpdateUserMember() {
		this.checklogin();
		if (!this.isSlogin()) {
			if (this.CheckUser()) {
				MD5Code md5 = new MD5Code();
				UserT user = new UserT();
				user.setUserid(this.getUserid().trim());
				user.setUsername(this.getUsername().trim());
				user.setPassword(md5.getMD5ofStr(this.getNewpassword().trim()));
				this.getUsertService().updateUserMember(user);
				return "json";
			}
		}
		return "json";
	}

	/**
	 * 修改管理员密码，判断数据库是否存在
	 * 
	 * @return
	 */
	public boolean CheckUser() {
		this.checklogin();
		if (!this.isSlogin()) {
			MD5Code md5 = new MD5Code();
			UserT user = new UserT();
			user.setUsername(this.getUsername().trim());
			user.setPassword(md5.getMD5ofStr(this.getPassword().trim()));
			UserT userlist = this.getUsertService().usert(user);
			if (userlist != null) {
				return true;
			} else {
				return false;
			}

		}
		return true;
	}

	/**
	 * 发送激活邮件
	 * 
	 * @param user
	 * @throws IOException
	 * @throws TemplateException
	 * @throws javax.mail.MessagingException
	 */
//	@Action(value = "sendeMail", results = { @Result(name = "json", type = "json") })
//	public String sendeMail() throws IOException, TemplateException, javax.mail.MessagingException {
//		this.findUserById();
//		if (beanlist.getUserstate().equals("1")) {
//			this.setSlogin(false);
//			return "json";
//		} else {
//			sendSystemEmail.sendTextMail(beanlist);
//			this.setSlogin(true);
//			return "json";
//		}
//	}

	@Action(value = "updateUserbyuserstate", results = { @Result(name = "json", type = "json") })
	public String updateUserbyuserstate() {
		if (StringUtils.isNotBlank(this.getUserid())) {
			UserT user = new UserT();
			user = this.getUsertService().findById(this.getUserid());
			if (user != null) {
				if (user.getUserstate().equals("0")) {
					this.setSucflag(false);
					return "json";
				} else {
					user.setUserstate(this.getUserstate());
					this.getUsertService().updateUserstate(user);

					this.setSucflag(true);
					return "json";
				}
			}
			this.setSucflag(false);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}

	/**
	 * 更新用户表中后台管理者的权限标记，后期可能全面启用写死的userstate模式改成此模式
	 * @return
	 */
	@Action(value = "updateUserRoleMByuserid", results = { @Result(name = "json", type = "json") })
	public String updateUserRoleMByuserid(){
		if(Validate.StrNotNull(this.getUserid())&&Validate.StrNotNull(this.getRoleid())&&Validate.StrNotNull(this.getRolemname())){
			if(this.getUsertService().updateUserRoleMByuserid(this.getUserid(),this.getRoleid(), this.getRolemname())>0){
				this.setSucflag(true);
				return "json";
			}
		}
		return "json";
	}

	/**
	 * 后台登出
	 */
	@Action(value = "adminlogout", results = { @Result(name = "json", type = "json") })
	public String adminlogout() {
		ActionContext.getContext().getSession().remove(StaticString.BACK_USER_SESSION_KEY);
		ActionContext.getContext().getSession().remove(StaticString.USERROLEFUNCTION);
		ActionContext.getContext().getSession().remove(StaticString.BACK_SESSION_KEY);
		return "json";

	}


}