
package com.pg_community_android.data.network;


import com.pg_community_android.BuildConfig;

public final class ApiEndPoint {

    public static final String ENDPOINT_GOOGLE_LOGIN = BuildConfig.BASE_URL
            + "/588d14f4100000a9072d2943";
    public static final String ENDPOINT_FACEBOOK_LOGIN = BuildConfig.BASE_URL
            + "/588d14f4100000a9072d2943";

    public static final String ENDPOINT_SERVER_LOGIN = BuildConfig.BASE_URL
            + "api/users";


    private ApiEndPoint() {
        // This class is not publicly instantiable
    }

}
