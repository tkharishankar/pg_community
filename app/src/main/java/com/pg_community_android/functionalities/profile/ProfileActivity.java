package com.pg_community_android.functionalities.profile;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.pg_community_android.R;
import com.pg_community_android.base.BaseActivity;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Hari on 1/16/18.
 */

public class ProfileActivity extends BaseActivity implements ProfileView ,DatePickerDialog.OnDateSetListener {

    @Inject
    ProfilePresenter<ProfileView> mPresenter;

    @BindView(R.id.name)
    EditText mNameEditText;

    @BindView(R.id.fatherName)
    EditText mFatherNameEditText;

    @BindView(R.id.motherName)
    EditText mMotherNameEditText;

    @BindView(R.id.phoneNumber)
    EditText mPhoneNumberEditText;

    @BindView(R.id.nativePlace)
    EditText mNativePlaceEditText;

    @BindView(R.id.nativeCity)
    EditText mNativeCityEditText;

    @BindView(R.id.currentCity)
    EditText mCurrentCityEditText;

    @BindView(R.id.currentState)
    EditText mCurrentStateEditText;

    @BindView(R.id.currentCountry)
    EditText mCurrentCountryEditText;

    @BindView(R.id.profile_layout)
    LinearLayout mProfilelayout;

    @BindView(R.id.mToolBar)
    public Toolbar mToolbar;


    @BindView(R.id.mBtnDate)
    Button mBtnDate;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(ProfileActivity.this);

        setSupportActionBar(mToolbar);

        getSupportActionBar().setTitle(getResources().getString(R.string.title_profile));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        populateProfileInfo();

        disableView();

        hideKeyboard();

    }

    @Override
    protected void setUp() {
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void populateProfileInfo() {
        mNameEditText.setText("Harishankar");
        mFatherNameEditText.setText("Kathirvel");
        mMotherNameEditText.setText("Jothimani");
        mPhoneNumberEditText.setText("+971554169711");
        mNativePlaceEditText.setText("Thudiyalur");
        mNativeCityEditText.setText("Coimbatore");
        mCurrentCityEditText.setText("Dubai");
        mCurrentStateEditText.setText("Dubai");
        mCurrentCountryEditText.setText("UAE");
    }


    private void disableView() {
        mNameEditText.setHintTextColor(getResources().getColor(R.color.colorAccent));
        mNameEditText.setTextColor(getResources().getColor(R.color.black));
        mFatherNameEditText.setHintTextColor(getResources().getColor(R.color.colorAccent));
        mFatherNameEditText.setTextColor(getResources().getColor(R.color.black));
        mMotherNameEditText.setHintTextColor(getResources().getColor(R.color.colorAccent));
        mMotherNameEditText.setTextColor(getResources().getColor(R.color.black));
        mPhoneNumberEditText.setHintTextColor(getResources().getColor(R.color.colorAccent));
        mPhoneNumberEditText.setTextColor(getResources().getColor(R.color.black));
        mNativePlaceEditText.setHintTextColor(getResources().getColor(R.color.colorAccent));
        mNativePlaceEditText.setTextColor(getResources().getColor(R.color.black));
        mNativeCityEditText.setHintTextColor(getResources().getColor(R.color.colorAccent));
        mNativeCityEditText.setTextColor(getResources().getColor(R.color.black));
        mCurrentCityEditText.setHintTextColor(getResources().getColor(R.color.colorAccent));
        mCurrentCityEditText.setTextColor(getResources().getColor(R.color.black));
        mCurrentStateEditText.setHintTextColor(getResources().getColor(R.color.colorAccent));
        mCurrentStateEditText.setTextColor(getResources().getColor(R.color.black));
        mCurrentCountryEditText.setHintTextColor(getResources().getColor(R.color.colorAccent));
        mCurrentCountryEditText.setTextColor(getResources().getColor(R.color.black));
        mNameEditText.setEnabled(false);
        mFatherNameEditText.setEnabled(false);
        mMotherNameEditText.setEnabled(false);
        mPhoneNumberEditText.setEnabled(false);
        mNativePlaceEditText.setEnabled(false);
        mNativeCityEditText.setEnabled(false);
        mCurrentCityEditText.setEnabled(false);
        mCurrentStateEditText.setEnabled(false);
        mCurrentCountryEditText.setEnabled(false);
    }

    private void enableView() {
        mNameEditText.setEnabled(true);
        mFatherNameEditText.setEnabled(true);
        mMotherNameEditText.setEnabled(true);
        mPhoneNumberEditText.setEnabled(true);
        mNativePlaceEditText.setEnabled(true);
        mNativeCityEditText.setEnabled(true);
        mCurrentCityEditText.setEnabled(true);
        mCurrentStateEditText.setEnabled(true);
        mCurrentCountryEditText.setEnabled(true);
    }

    @OnClick(R.id.mBtnDate)
    public void onDatePickerClick() {

        Calendar now = Calendar.getInstance();
        DatePickerDialog datepickerdialog = DatePickerDialog.newInstance(
                ProfileActivity.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        datepickerdialog.setThemeDark(true); //set dark them for dialog?
        datepickerdialog.vibrate(true); //vibrate on choosing date?
        datepickerdialog.dismissOnPause(true); //dismiss dialog when onPause() called?
        datepickerdialog.showYearPickerFirst(false); //choose year first?
        datepickerdialog.setAccentColor(getResources().getColor(R.color.colorAccent)); // custom accent color
        datepickerdialog.setTitle("Please select a date"); //dialog title
        datepickerdialog.show(getFragmentManager(), "Datepickerdialog"); //show dialog

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = dayOfMonth + "/" + (++monthOfYear) + "/" + year;
        mBtnDate.setText(date);
    }

}
