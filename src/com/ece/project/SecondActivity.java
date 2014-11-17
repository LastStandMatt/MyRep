package com.ece.project;

import java.util.ArrayList;
import java.util.List;

import com.ece.project.BackGroundAsyncTask;

import com.ece.project.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;
import android.content.Intent;
import android.net.Uri;


///------------------------------------------------------Second Activity------------------------------------------------------///

public class SecondActivity extends Activity implements com.ece.project.BookAdapter.BookAdapterListener{

	private List<Book> mListBook= new ArrayList<Book>();							// This list will be used to fill dynamically the ListView.
	
	// Constructor.
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);										// This prints the .xml view content.
		
		int mCountSecondAc=getIntent().getExtras().getInt("id");						// This will get the Extras from the intent.
		BackGroundAsyncTask bg = new BackGroundAsyncTask(this, mCountSecondAc);			// Background Task constructor. Note that it will use the TextView taken from above.
		bg.execute("");																	// Background Task execution.
		
		ListView lv= (ListView) findViewById(R.id.listView1);							// This will get the ListView from the layout.
		BookAdapter artAdapter = new BookAdapter (this, this.mListBook);			// This will fill the mListBook.	
		artAdapter.addListener(this);													// This will add the Listener or the different parts of the ListView.
		lv.setAdapter (artAdapter);														// This will fill the ListView.
	}

	// To get the list of selected book. It will not be used further.
    public List<Book> getListBook() {
        return this.mListBook;
    }
    
    // To add an Book object to the mListBook.
    public void addToListBook(Book book) {
    	this.mListBook.add(0,new Book(book.getName(), book.getLink()));
    }
    
    // Inflate the menu; this adds items to the action bar if it is present. This function will not be used.
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {												
		getMenuInflater().inflate(R.menu.second, menu);								
		return true;
	}

	// To implements the BookAdapterListener (SecondActivity here).
	@Override
	public void onClickBook(Book bo, int location) {
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(bo.getLink()));	// This will create an intent to launch the webbrowser.
		startActivity(browserIntent);														// This will launch the youtube.com page which contains the link.
	}

}
