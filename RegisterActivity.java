package library.carpool;

/**
 * Created by gautami on 3/21/2016.
 */
        import java.util.ArrayList;
        import java.util.List;
        import android.os.Bundle;
        import android.app.Activity;
        import android.content.Intent;
        import android.view.View;
        import android.view.Window;
        import android.view.WindowManager;
        import android.widget.CheckBox;
        import android.widget.RadioButton;

public class RegisterActivity extends Activity {


    private RadioButton femaleRadioButton;
    private RadioButton maleRadioButton;

    private String gender;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hide title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //hide status bar
        int flag=WindowManager.LayoutParams.FLAG_FULLSCREEN;
        this.getWindow().setFlags(flag, flag);

        setContentView(R.layout.register);
        initialize();
    }

    private void initialize(){
        femaleRadioButton=(RadioButton) findViewById(R.id.radio_female);
        maleRadioButton=(RadioButton) findViewById(R.id.radio_male);
        femaleRadioButton.setChecked(true);
    }

    private void setGender(){
        if(femaleRadioButton.isChecked()){
            gender="Female";
        }else if(maleRadioButton.isChecked()){
            gender="Male";
        }
    }

    public void submit(View view){
        setGender();

        //set the data which you want to transfer into next activity(layout)
        Bundle bundle=new Bundle();
        bundle.putString("gender", gender);
        Intent intent=new Intent(RegisterActivity.this,RegisterDisplay.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

