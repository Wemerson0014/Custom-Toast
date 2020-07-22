package com.estudo.customtoast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int SUCCESS = 1;
    private static final int WARNING = 0;
    private static final int ERROR = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_success).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(SUCCESS, getString(R.string.text_success));
            }
        });
        findViewById(R.id.button_warning).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(WARNING, getString(R.string.text_warning));
            }
        });
        findViewById(R.id.button_error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(ERROR, getString(R.string.text_error));
            }
        });
    }

    private void showToast(int type, String message) {
        ViewGroup view = findViewById(R.id.container_toast);
        View v = getLayoutInflater().inflate(R.layout.custom_toast, view);

        switch (type) {
            case SUCCESS:
                v.setBackground(ContextCompat.getDrawable(this, R.drawable.toast_success));
                break;
            case WARNING:
                v.setBackground(ContextCompat.getDrawable(this, R.drawable.toast_warning));
                break;
            case ERROR:
                v.setBackground(ContextCompat.getDrawable(this, R.drawable.toast_error));
                break;

            default:
                throw new IllegalStateException(getString(R.string.type_error));
        }

        TextView txtMessage = v.findViewById(R.id.txt_message);
        txtMessage.setText(message);

        Toast toast = new Toast(this);
        toast.setView(v);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }
}