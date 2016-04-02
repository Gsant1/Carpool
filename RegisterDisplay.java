package library.carpool;

/**
 * Created by gautami on 4/1/2016.
 */

        import java.util.List;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.widget.TextView;

public class RegisterDisplay extends Activity {
    private TextView genderTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_display);

        initialize();
        setResult();
    }

    private void initialize(){
        genderTextView=(TextView) findViewById(R.id.textview_gender);
        }

    private void setResult(){
        //get the data comes from the first layout
        Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();
        String gender=(String) bundle.get("gender");
        genderTextView.setText(gender);
        }
}
