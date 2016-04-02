package library.carpool;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import library.carpool.constant.SQLCommand;
import library.carpool.util.DBOperator;


/**
 * Created by gautami on 3/21/2016.
 */
public class LoginActivity extends Activity implements OnClickListener
{

    Button login_cust_Btn, back_btn;
    EditText CustIdEdit, PwdEdit;




    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //copy database file
        try{
            DBOperator.copyDB(getBaseContext());
        }catch(Exception e){
            e.printStackTrace();
        }
        login_cust_Btn=(Button)this.findViewById(R.id.loginBtn); // loginBtn is the chcking for already registered customer and login_btn is for welcome page
        login_cust_Btn.setOnClickListener(this);
        CustIdEdit=(EditText)this.findViewById(R.id.cid_edittext);
        PwdEdit=(EditText)this.findViewById(R.id.password_edittext);
    }

    public void onClick(View v) {
        String sql = "";
        int id = v.getId();
        if (id == R.id.loginBtn) {
            //show query result
            DBOperator.getInstance().execSQL(SQLCommand.LOGIN_CHECK, this.getArgs(true));
            Toast.makeText(getBaseContext(), "Login successfully", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.goback_btn) {
            //Go back to main screen
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
        }
    }
    private String[] getArgs(boolean isLogin){
        String args[]=new String[4];
        //input customerid
        args[0] = CustIdEdit.getText().toString();
        //input password
        args[1] = PwdEdit.getText().toString();
        //what does this do?
        if (isLogin) args[3]="N";
        else args[3]="Y";
        return args;
    }
}

