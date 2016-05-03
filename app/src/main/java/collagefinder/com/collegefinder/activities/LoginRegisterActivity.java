package collagefinder.com.collegefinder.activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import collagefinder.com.collegefinder.Constants;
import collagefinder.com.collegefinder.R;
import collagefinder.com.collegefinder.fragments.RegisterFragment;
import collagefinder.com.collegefinder.fragments.SignInFragment;

public class LoginRegisterActivity extends Activity {
    FrameLayout mainFrame;
    private ImageView imgBack;
    private TextView mTvToolBar;
    public static LoginRegisterActivity mLoginRegisterActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        mLoginRegisterActivity = this;
        mainFrame = (FrameLayout) findViewById(R.id.mainFrame);
        imgBack = (ImageView) findViewById(R.id.imgback);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mLoginRegisterActivity.onBackPressed();
            }
        });
        if(getIntent().getExtras().getString(Constants.FROM).equals(Constants.SIGN_IN)){
            SignInFragment signInFragment = SignInFragment.newInstance(null,null);
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.mainFrame,signInFragment).commit();
            setToolBar("Sign In");
        }
        else if(getIntent().getExtras().getString(Constants.FROM).equals(Constants.REGISTER)){
            RegisterFragment registerFragment = RegisterFragment.newInstance(null, null);
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.mainFrame,registerFragment).commit();
            setToolBar("Register");
        }
    }
    public void setToolBar(String string){
        mTvToolBar = (TextView) findViewById(R.id.tvTitle);
        mTvToolBar.setText(string);
    }
    public void addFragment(Fragment fragment){
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.
                beginTransaction().
                replace(R.id.mainFrame,fragment).
                commit();
    }

    public void addFragmentBackStack(Fragment fragment){
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.
                beginTransaction().
                add(R.id.mainFrame,fragment).
                addToBackStack(null).
                commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_register, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
