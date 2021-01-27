package com.konasl.endtoendtest.model;

/**
 * Created by masum on 2/12/2016.
 */
public class UserInfo {

    public String  aspId
    public String name
    public String gender
    public String userName
    public String socialNo
    public String di
    public String ci
    public String nationality
    public String dob
    public String userId //mapUserId
    public String email
    public String mnoName
    public String msisdn
    public String verificationMethod
    public String activationId
    public String activationCode
    public String authTokenInfo
    public String userAgent
    public WalletInfo walletInfo

    public ArrayList<Integer> mandatoryTermsAndConditionsIdList = new ArrayList<Integer>()
    public ArrayList<Integer> optionalTermsAndConditionsIdList = new ArrayList<Integer>()
    //public List<ChangeDevicePar> changeDeviceParList = new ArrayList<ChangeDevicePar>()

    public String changeDeviceAuthCode
    public String verificationToken
    public String recommenderCode
    public String promotionCode
}
