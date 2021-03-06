package collagefinder.com.collegefinder.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import collagefinder.com.collegefinder.Constants;
import collagefinder.com.collegefinder.R;

public class HomeScreenActivity extends Activity {
    private TextView mtvSignin,mtvRegister;
    public static HomeScreenActivity mHomeScreenActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        mHomeScreenActivity = this;
        mtvSignin = (TextView) findViewById(R.id.tvSignin);
        mtvRegister = (TextView) findViewById(R.id.tvSignup);
        mtvSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreenActivity.this,LoginRegisterActivity.class);
                intent.putExtra(Constants.FROM,Constants.SIGN_IN);
                startActivity(intent);
            }
        });
        mtvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreenActivity.this,LoginRegisterActivity.class);
                intent.putExtra(Constants.FROM,Constants.REGISTER);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
