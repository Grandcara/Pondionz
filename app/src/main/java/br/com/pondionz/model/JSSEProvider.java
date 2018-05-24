/*
 *  Copyright (C) https://github.com/plum-umd/android-intents/blob/master/TimeTracker/src/org/umd/timetracker/JSEEProvider.java
 *  Modified work Copyright 2016 Iago Alvarenga <iagodecastro@yahoo.com.br>
 *
 */

package br.com.pondionz.model;

/**
 * Created by Iago on 09/02/2016.
 */
/**
 * @author Alexander Y. Kleymenov
 * @version $Revision$
 */


import java.security.AccessController;
import java.security.Provider;

public final class JSSEProvider extends Provider {

    public JSSEProvider() {
        super("HarmonyJSSE", 1.0, "Harmony JSSE Provider");
        AccessController.doPrivileged(new java.security.PrivilegedAction<Void>() {
            public Void run() {
                put("SSLContext.TLS",
                        "org.apache.harmony.xnet.provider.jsse.SSLContextImpl");
                put("Alg.Alias.SSLContext.TLSv1", "TLS");
                put("KeyManagerFactory.X509",
                        "org.apache.harmony.xnet.provider.jsse.KeyManagerFactoryImpl");
                put("TrustManagerFactory.X509",
                        "org.apache.harmony.xnet.provider.jsse.TrustManagerFactoryImpl");
                return null;
            }
        });
    }
}