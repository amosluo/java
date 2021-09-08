package com.amos.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 用户档案
 * </p>
 *
 * @author amos
 * @since 2021-08-06
 */
public class TblUserRecord implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户类型
     */
    private String userType;

    /**
     * 岗位角色
     */
    private TblRole userRole ;

    /**
     * 用户性别
     */
    private String userGender;

    /**
     * 所属部门
     */
    private TblDept userDept;

    /**
     * 职位
     */
    private Integer userJob;

    /**
     * 用户状态
     */
    private String userStatus;

    /**
     * 办公电话
     */
    private String officePhone;

    /**
     * 内线电话
     */
    private String innerPhone;

    /**
     * 移动电话
     */
    private String movePhone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 允许发送手机短信
     */
    private String isSendMsg;

    /**
     * 有效开始日期
     */
    private LocalDateTime startDate;

    /**
     * 有效结束日期
     */
    private LocalDateTime stopDate;

    /**
     * 出生日期
     */
    private LocalDateTime birthday;

    /**
     * 登陆ip规则
     */
    private String ipRule;

    /**
     * 入职日期
     */
    private LocalDateTime userHiredate;

    /**
     * 允许发送微信
     */
    private String isSendWchat;

    /**
     * 备注
     */
    private String remark;

    /**
     * 所属公司
     */
    private TblCompany company;

    /**
     * 是否部门管理者
     */
    private String isDeptAdmin;

    /**
     * 最后登陆时间
     */
    private LocalDateTime lastLoginDate;

    /**
     * 创建人
     */
    private String createPerson;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    private String token;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public TblRole getUserRole() {
        return userRole;
    }

    public void setUserRole(TblRole userRole) {
        this.userRole = userRole;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public TblDept getUserDept() {
        return userDept;
    }

    public void setUserDept(TblDept userDept) {
        this.userDept = userDept;
    }

    public Integer getUserJob() {
        return userJob;
    }

    public void setUserJob(Integer userJob) {
        this.userJob = userJob;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getInnerPhone() {
        return innerPhone;
    }

    public void setInnerPhone(String innerPhone) {
        this.innerPhone = innerPhone;
    }

    public String getMovePhone() {
        return movePhone;
    }

    public void setMovePhone(String movePhone) {
        this.movePhone = movePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIsSendMsg() {
        return isSendMsg;
    }

    public void setIsSendMsg(String isSendMsg) {
        this.isSendMsg = isSendMsg;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getStopDate() {
        return stopDate;
    }

    public void setStopDate(LocalDateTime stopDate) {
        this.stopDate = stopDate;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getIpRule() {
        return ipRule;
    }

    public void setIpRule(String ipRule) {
        this.ipRule = ipRule;
    }

    public LocalDateTime getUserHiredate() {
        return userHiredate;
    }

    public void setUserHiredate(LocalDateTime userHiredate) {
        this.userHiredate = userHiredate;
    }

    public String getIsSendWchat() {
        return isSendWchat;
    }

    public void setIsSendWchat(String isSendWchat) {
        this.isSendWchat = isSendWchat;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public TblCompany getCompany() {
        return company;
    }

    public void setCompany(TblCompany company) {
        this.company = company;
    }

    public String getIsDeptAdmin() {
        return isDeptAdmin;
    }

    public void setIsDeptAdmin(String isDeptAdmin) {
        this.isDeptAdmin = isDeptAdmin;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "TblUserRecord{" +
        "id=" + id +
        ", userName=" + userName +
        ", userPassword=" + userPassword +
        ", userType=" + userType +
        ", userRole=" + userRole +
        ", userGender=" + userGender +
        ", userDept=" + userDept +
        ", userJob=" + userJob +
        ", userStatus=" + userStatus +
        ", officePhone=" + officePhone +
        ", innerPhone=" + innerPhone +
        ", movePhone=" + movePhone +
        ", email=" + email +
        ", isSendMsg=" + isSendMsg +
        ", startDate=" + startDate +
        ", stopDate=" + stopDate +
        ", birthday=" + birthday +
        ", ipRule=" + ipRule +
        ", userHiredate=" + userHiredate +
        ", isSendWchat=" + isSendWchat +
        ", remark=" + remark +
        ", company=" + company +
        ", isDeptAdmin=" + isDeptAdmin +
        ", lastLoginDate=" + lastLoginDate +
        ", createPerson=" + createPerson +
        ", createDate=" + createDate +
        "}";
    }
}
