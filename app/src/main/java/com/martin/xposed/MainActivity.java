package com.martin.xposed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * <p>
 * Package Name:com.martin.xposed
 * </p>
 * <p>
 * Class Name:MainActivity
 * <p>
 * Description:
 * </p>
 *
 * @Author Martin
 * @Version 1.0 2019/1/29 3:23 PM Release
 * @Reviser: 
 * @Modification Time:2019/1/29 3:23 PM
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, toastMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String toastMessage() {
        return "按钮未被劫持";
    }

}
