package ro.pub.cs.systems.eim.lab03.phonedialer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class PhoneDialerActivit extends AppCompatActivity {

    private TextView phoneTextView;
    private ButtonListener buttonClickListener = new ButtonListener();
    private backspaceButtonListener backspaceButtonClickListener = new backspaceButtonListener();
    private CallImageButtonListener callImageButtonClickListener = new CallImageButtonListener();
    private HangupImageButtonListener hangupImageButtonClickListener = new HangupImageButtonListener();
    private Button button;
    private ImageButton backspaceButton;
    private ImageButton callButton;
    private ImageButton hangupButton;
    final public static int PERMISSION_REQUEST_CALL_PHONE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        phoneTextView = (TextView)findViewById(R.id.textView);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(buttonClickListener);
        button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(buttonClickListener);
        button = (Button)findViewById(R.id.button3);
        button.setOnClickListener(buttonClickListener);
        button = (Button)findViewById(R.id.button4);
        button.setOnClickListener(buttonClickListener);
        button = (Button)findViewById(R.id.button5);
        button.setOnClickListener(buttonClickListener);
        button = (Button)findViewById(R.id.button6);
        button.setOnClickListener(buttonClickListener);
        button = (Button)findViewById(R.id.button7);
        button.setOnClickListener(buttonClickListener);
        button = (Button)findViewById(R.id.button8);
        button.setOnClickListener(buttonClickListener);
        button = (Button)findViewById(R.id.button9);
        button.setOnClickListener(buttonClickListener);
        button = (Button)findViewById(R.id.button10);
        button.setOnClickListener(buttonClickListener);
        button = (Button)findViewById(R.id.button11);
        button.setOnClickListener(buttonClickListener);
        button = (Button)findViewById(R.id.button12);
        button.setOnClickListener(buttonClickListener);
        backspaceButton = (ImageButton)findViewById(R.id.imageButton5);
        backspaceButton.setOnClickListener(backspaceButtonClickListener);
        callButton = (ImageButton)findViewById(R.id.imageButton3);
        callButton.setOnClickListener(callImageButtonClickListener);
        hangupButton = (ImageButton)findViewById(R.id.imageButton4);
        hangupButton.setOnClickListener(hangupImageButtonClickListener);
    }
    protected class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if(phoneTextView.getText().toString().equals("Enter number"))
                phoneTextView.setText(((Button)view).getText().toString());
            else
                phoneTextView.setText(phoneTextView.getText().toString() +
                                        ((Button)view).getText().toString());
        }
    }

    protected class backspaceButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if(phoneTextView.getText().toString().equals("Enter number"))
                phoneTextView.setText("");
            else {
                String phoneNumber = phoneTextView.getText().toString();
                if (phoneNumber.length() > 0) {
                    phoneNumber = phoneNumber.substring(0, phoneNumber.length() - 1);
                    phoneTextView.setText(phoneNumber);
                }
            }
        }
    }

    private class CallImageButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (ContextCompat.checkSelfPermission(PhoneDialerActivit.this, Manifest.permission.CALL_PHONE)
                                                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                        PhoneDialerActivit.this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        PERMISSION_REQUEST_CALL_PHONE);
            } else {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + phoneTextView.getText().toString()));
                startActivity(intent);
            }
        }
    }

    private class HangupImageButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }

}