package library.carpool;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;


import library.carpool.util.DBOperator;

public class MainActivity extends Activity implements OnClickListener
{
    Button registerBtn,loginBtn;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);// super refers to the superclass method oncreate,used for access
        setContentView(R.layout.welcome); // this is setting the page content currently to the welcome page
        //the welcome page has two buttons which are register and login button
        registerBtn=(Button)this.findViewById(R.id.register_btn);
        registerBtn.setOnClickListener(this);
        loginBtn=(Button)this.findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(this);
        //copy database file
        try{
            DBOperator.copyDB(getBaseContext());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void onClick(View v)
    {
        int id=v.getId();
        if (id==R.id.register_btn){
            Intent intent = new Intent(this, RegisterActivity.class);
            this.startActivity(intent);

        }else if (id==R.id.login_btn){
            Intent intent = new Intent(this, LoginActivity.class);
            this.startActivity(intent);
        }

    }
}
