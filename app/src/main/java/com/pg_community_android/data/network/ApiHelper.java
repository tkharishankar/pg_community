
package com.pg_community_android.data.network;

import com.pg_community_android.data.network.model.LoginRequest;
import com.pg_community_android.data.network.model.LoginResponse;

import io.reactivex.Observable;

public interface ApiHelper {

    ApiHeader getApiHeader();

    Observable<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

    Observable<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Observable<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

}
