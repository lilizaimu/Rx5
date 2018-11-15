package com.airlook.kwapp.rx5.model;

/**
 * 登录结果model
 * Created by LL on 2018/7/12/012.
 */

public class LoginResultModel {


    /**
     * parentUserId : null
     * userId : 186142084363849728
     * userType : 3
     * loginToken : 32656ffaa85b46289bcee71b4e38db69
     * loginName : ll
     * mobile : 12345678999
     * userName : null
     * telephone : null
     * email : null
     * userPicUrl : null
     * roleType : 0
     * role : 0
     * accountType : 0
     * identityStatus : 0
     * identityName : null
     * identityRemit : 0
     * accountAuth : true
     * menuList : null
     * nickName : null
     * gender : 0
     * birthDate :
     */

    private boolean accountAuth;
    private Integer accountType;
    private String birthDate;
    private String email;
    private Integer gender;
    private String identityName;
    private Integer identityRemit;
    private Integer identityStatus;
    private String loginName;
    private String loginToken;
    private String mobile;
    private String nickName;
    private String parentUserId;
    private Integer role;
    private Integer roleType;
    private String telephone;
    private String userId;
    private String userName;
    private String userPicUrl;
    private Integer userType;
    private String personalBelongToCompanyName;
    private boolean appRegisterFlag;   //以前是否注册过
    private boolean appHasPwdFlag;     //是否设置了密码
    private int faceRecognFlag;      //是否进行了人脸识别

    public int getFaceRecognFlag() {
        return faceRecognFlag;
    }

    public void setFaceRecognFlag(int faceRecognFlag) {
        this.faceRecognFlag = faceRecognFlag;
    }

    public String getPersonalBelongToCompanyName() {
        return personalBelongToCompanyName;
    }

    public void setPersonalBelongToCompanyName(String personalBelongToCompanyName) {
        this.personalBelongToCompanyName = personalBelongToCompanyName;
    }

    public boolean isAppRegisterFlag() {
        return appRegisterFlag;
    }

    public void setAppRegisterFlag(boolean appRegisterFlag) {
        this.appRegisterFlag = appRegisterFlag;
    }

    public boolean isAppHasPwdFlag() {
        return appHasPwdFlag;
    }

    public void setAppHasPwdFlag(boolean appHasPwdFlag) {
        this.appHasPwdFlag = appHasPwdFlag;
    }

    public boolean isAccountAuth() {
        return accountAuth;
    }

    public void setAccountAuth(boolean accountAuth) {
        this.accountAuth = accountAuth;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdentityName() {
        return identityName;
    }

    public void setIdentityName(String identityName) {
        this.identityName = identityName;
    }

    public Integer getIdentityRemit() {
        return identityRemit;
    }

    public void setIdentityRemit(Integer identityRemit) {
        this.identityRemit = identityRemit;
    }

    public Integer getIdentityStatus() {
        return identityStatus;
    }

    public void setIdentityStatus(Integer identityStatus) {
        this.identityStatus = identityStatus;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(String parentUserId) {
        this.parentUserId = parentUserId;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPicUrl() {
        return userPicUrl;
    }

    public void setUserPicUrl(String userPicUrl) {
        this.userPicUrl = userPicUrl;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}
