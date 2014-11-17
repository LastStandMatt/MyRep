/* Special Thanks to "http://mickael-lt.developpez.com/tutoriels/android/personnaliser-listview/" 
 * and " http://blog.ace-dev.fr/2010/07/21/tutoriel-android-partie-6-les-listview/" 
 * which helped me a lot on using ListViews*/

package com.ece.project;

import com.ece.project.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

///-------------------------------------------------------Main Activity-------------------------------------------------------///

public class MainActivity extends Activity implements OnClickListener {

	// Constructor.
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);							// This prints the .xml view content.
		Button button= (Button) findViewById(R.id.button1);				// This will get the button from the .xml view table to use it.
        
		button.setOnClickListener(this) ;								// This will set the Activity as an implementation of the onClickListener of the button.
	}

	// Inflate the menu; this adds items to the action bar if it is present. This function will not be used.
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {						
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// To set the counter to know which checkbox is checked.
	public int setCount(CheckBox [] c) {								
		
		int mCount=0;
		if(c[1].isChecked())											// "frlitt" checkbox.
			mCount+=1;
		if(c[2].isChecked())											// "thriller" checkbox.
			mCount+=2;							
		if(c[3].isChecked())											// "detective" checkbox.
			mCount+=4;
		if(c[4].isChecked())											// "fantastic" checkbox.
			mCount+=8;
		if(c[5].isChecked())											// "sf" checkbox.
			mCount+=16;
		if(c[6].isChecked())											// "educative" checkbox.
			mCount+=32;
		if(c[7].isChecked())											// "politic" checkbox.
			mCount+=64;
		if(c[8].isChecked())											// "romantic" checkbox.
			mCount+=128;
		if(c[9].isChecked())											// "horror" checkbox.
			mCount+=256;
		if(c[10].isChecked())											// "historical" checkbox.
			mCount+=512;
		if(c[11].isChecked())											// "encyclopedia" checkbox.
			mCount+=1024;
		if(c[12].isChecked())											// "Others" checkbox.
			mCount+=2048;
		return mCount;
	}
	
	// To implements the OnClickListener (MainActivity here).
	@Override
	public void onClick(View v) {										
		CheckBox [] c = new CheckBox[13];
		c[1]=(CheckBox) findViewById(R.id.checkBox1);					// This will get the Checkboxes to be transmitted to the setCount function below.
		c[2]=(CheckBox) findViewById(R.id.checkBox2);
		c[3]=(CheckBox) findViewById(R.id.checkBox3);
		c[4]=(CheckBox) findViewById(R.id.checkBox4);
		c[5]=(CheckBox) findViewById(R.id.checkBox5);
        
		c[6]=(CheckBox) findViewById(R.id.checkBox6);
		c[7]=(CheckBox) findViewById(R.id.checkBox7);
		c[8]=(CheckBox) findViewById(R.id.checkBox8);
		c[9]=(CheckBox) findViewById(R.id.checkBox9);
		c[10]=(CheckBox) findViewById(R.id.checkBox10);
        
		c[11]=(CheckBox) findViewById(R.id.checkBox11);
		c[12]=(CheckBox) findViewById(R.id.checkBox12);
		int mCount=this.setCount(c);									// setCount function call.
		Intent mi1= new Intent(MainActivity.this, SecondActivity.class);// Intent to launch the SecondActivity.
		mi1.putExtra("id", mCount);										// This will put an extra content to the intent: the counter.
		startActivity(mi1);												// This will start the SecondActivity.
	}

}
