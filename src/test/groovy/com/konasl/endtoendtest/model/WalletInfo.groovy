package com.konasl.endtoendtest.model

import java.security.PrivateKey
import java.security.PublicKey

/**
 * Created by masum on 2/12/2016.
 */
public class WalletInfo {
    public String walletPin
    public String paymentPin
    public String verificationData
    public String walletStatus

    public DeviceInfo deviceInfo
    public String deviceFingerPrint

    public PublicKey publicKey
    public PrivateKey privateKey
    public String csr
    public String certificate

    public String mobileKeyConf
    public String mobileKeyMac

    public String mpaId
    public String rnsMpaId
    public String rnsMsg
    public String rnsMsgType
    public String rnsMsgId
    public String authCode
    public String sessionId
    public String remMgtInfo
    public String recommenderCode
    public String rnsProviderType
    public String fcmId

    public String X_AUTH_TOKEN;
    public String REFRESH_TOKEN;

    public String sessionKeyConf
    public String sessionKeyMac
    public int valueC2M;
    public int valueM2C;

    public String token
    public String tokenExp

}
