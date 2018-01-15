
package com.pg_community_android.base;


import com.androidnetworking.error.ANError;

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the CommonView type that wants to be attached with.
 */
public interface CommonPresenter<V extends CommonView> {

    void onAttach(V mvpView);

    void onDetach();

    void handleApiError(ANError error);

    void setUserAsLoggedOut();
}
