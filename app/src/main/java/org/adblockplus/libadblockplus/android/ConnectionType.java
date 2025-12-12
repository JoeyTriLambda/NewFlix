package org.adblockplus.libadblockplus.android;

import android.net.ConnectivityManager;

/* loaded from: classes2.dex */
public enum ConnectionType {
    WIFI("wifi") { // from class: org.adblockplus.libadblockplus.android.ConnectionType.1
        @Override // org.adblockplus.libadblockplus.android.ConnectionType
        public boolean isRequiredConnection(ConnectivityManager connectivityManager) {
            return connectivityManager.getActiveNetworkInfo().getType() == 1;
        }
    },
    WIFI_NON_METERED("wifi_non_metered") { // from class: org.adblockplus.libadblockplus.android.ConnectionType.2
        @Override // org.adblockplus.libadblockplus.android.ConnectionType
        public boolean isRequiredConnection(ConnectivityManager connectivityManager) {
            return connectivityManager.getActiveNetworkInfo().getType() == 1 && !connectivityManager.isActiveNetworkMetered();
        }
    },
    ANY("any") { // from class: org.adblockplus.libadblockplus.android.ConnectionType.3
        @Override // org.adblockplus.libadblockplus.android.ConnectionType
        public boolean isRequiredConnection(ConnectivityManager connectivityManager) {
            return true;
        }
    };

    private String value;

    public static ConnectionType findByValue(String str) {
        if (str == null) {
            return null;
        }
        for (ConnectionType connectionType : values()) {
            if (connectionType.getValue().equals(str)) {
                return connectionType;
            }
        }
        return null;
    }

    public String getValue() {
        return this.value;
    }

    public abstract boolean isRequiredConnection(ConnectivityManager connectivityManager);

    ConnectionType(String str) {
        this.value = str;
    }
}
