package net.iobb.tamago;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class ButtonActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button);
	}
	
	public void onStart() {
		super.onStart();
		int base = getIntent().getIntExtra("data", 0);
		LinearLayout container = (LinearLayout)findViewById(R.id.button_container);
		int c = container.getChildCount();
		for(int i = 0; i < c; i++) {
			LinearLayout line = (LinearLayout)container.getChildAt(i);
			for(int j = 0; j < line.getChildCount(); j++) {
				Button b = (Button)line.getChildAt(j);
				b.setText(String.format("%d", i * 3 + j + base));
				b.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						int base = Integer.parseInt(((Button)v).getText().toString());
						Intent intent = new Intent(ButtonActivity.this, ButtonActivity.class);
						intent.putExtra("data", base);
						startActivity(intent);
					}
				});
			}
		}
	}
}
