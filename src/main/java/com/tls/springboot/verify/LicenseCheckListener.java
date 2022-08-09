package com.tls.springboot.verify;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
@Component
public class LicenseCheckListener implements ApplicationListener<ContextRefreshedEvent> {
	private static Logger logger = LogManager.getLogger(LicenseCheckListener.class);

    /**
     * Certificate subject
     */
    @Value("${license.subject}")
    private String subject;

    /**
     * Public key nickname
     */
    @Value("${license.publicAlias}")
    private String publicAlias;

    /**
     * Password to access public key library
     */
    @Value("${license.storePass}")
    private String storePass;

    /**
     * Certificate generation path
     */
    @Value("${license.licensePath}")
    private String licensePath;

    /**
     * Keystore store path
     */
    @Value("${license.publicKeysStorePath}")
    private String publicKeysStorePath;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //root application context has no parent
    	System.out.println("onApplicationEvent....");
        ApplicationContext context = event.getApplicationContext().getParent();
        if(context == null){
            if(StringUtils.isNotBlank(licensePath)){
                logger.info("++++++++ Start installing certificate ++++++++");

                LicenseVerifyParam param = new LicenseVerifyParam();
                param.setSubject(subject);
                param.setPublicAlias(publicAlias);
                param.setStorePass(storePass);
                param.setLicensePath(licensePath);
                param.setPublicKeysStorePath(publicKeysStorePath);

                LicenseVerify licenseVerify = new LicenseVerify();
                //Installation certificate
                licenseVerify.install(param);

                logger.info("++++++++ End of certificate installation ++++++++");
            }
        }
    }
}
