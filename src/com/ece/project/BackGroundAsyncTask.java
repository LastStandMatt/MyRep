package com.ece.project;


import com.ece.project.R;
import android.os.AsyncTask;

///------------------------------------------------------Background Task------------------------------------------------------///
///------------------Here is the class to have a background task that will run without annoying the UI thread-----------------///

public class BackGroundAsyncTask extends AsyncTask<String, Book, String> {
	
	private int mCount;																					// This will be used to contain the counter from the MainAcitvity.
	private SecondActivity SA;																			// This will be used to contain the SecondActivity to recover resources and functions from it.
	
	// Constructor.
	public BackGroundAsyncTask(SecondActivity SecAc, int mCountSecondAc) {		
		super();
		this.SA = SecAc;																				// Note here that we take the text from the parameter.
		this.mCount = mCountSecondAc;																	// Note here that we take the counter from the parameter.
	}
	
	// Main function of the background task.It will be executed in the background to let the UI thread running.
	@Override
	protected String doInBackground(String... params) {												
		
		try {										
		if (mCount == 0)																				// If no checkbox is checked.
			publishProgress(new Book(this.SA.getResources().getString(R.string.book_not_found), ""));
		else
		{
			if (mCount >= 2048)																			// If "others" is checked.
			{
				mCount-=2048;																			// This will decrease the counter to avoid computation problems.										
				publishProgress(new Book(this.SA.getResources().getString(R.string.book12), this.SA.getResources().getString(R.string.book12url)));
			}
			if (mCount >= 1024)																			// If "Encyclopedie" is checked (if this is not the first element to print).
			{
				mCount-=1024;
				publishProgress(new Book(this.SA.getResources().getString(R.string.book11), this.SA.getResources().getString(R.string.book11url)));
			}
			if (mCount >= 512) 																			// If "Historique" is checked.
			{
				mCount-=512;
				publishProgress(new Book(this.SA.getResources().getString(R.string.book10), this.SA.getResources().getString(R.string.book10url)));
			}
			if (mCount >= 256) 																			// If "Horreur" is checked.
			{
				mCount-=256;
				publishProgress(new Book(this.SA.getResources().getString(R.string.book9), this.SA.getResources().getString(R.string.book9url)));
			}
			if (mCount >= 128) 																			// If "Romantique" is checked.
			{
				mCount-=128;
				publishProgress(new Book(this.SA.getResources().getString(R.string.book8), this.SA.getResources().getString(R.string.book8url)));
			}
			if (mCount >= 64)  																			// If "Politique" is checked.
			{
				mCount-=64;
				publishProgress(new Book(this.SA.getResources().getString(R.string.book7), this.SA.getResources().getString(R.string.book7url)));
			}
			if (mCount >= 32) 																			// If "Educatif" is checked.
			{
				mCount-=32;
				publishProgress(new Book(this.SA.getResources().getString(R.string.book6), this.SA.getResources().getString(R.string.book6url)));
			}
			if (mCount >= 16) 																			// If "Science-fiction" is checked.
			{
				mCount-=16;
				publishProgress(new Book(this.SA.getResources().getString(R.string.book5), this.SA.getResources().getString(R.string.book5url)));
			}
			if (mCount >= 8) 																			// If "Fantastique" is checked.
			{
				mCount-=8;
				publishProgress(new Book(this.SA.getResources().getString(R.string.book4), this.SA.getResources().getString(R.string.book4url)));
			}
			if (mCount >= 4) 																			// If "Policier" is checked.
			{
				mCount-=4;
				publishProgress(new Book(this.SA.getResources().getString(R.string.book3), this.SA.getResources().getString(R.string.book3url)));
			}
			if (mCount >= 2) 																			// If "Thriller" is checked.
			{
				mCount-=2;
				publishProgress(new Book(this.SA.getResources().getString(R.string.book2), this.SA.getResources().getString(R.string.book2url)));
			}
			if (mCount == 1) 																			// If "Littérature française" is checked.
			{
				mCount-=1;
				publishProgress(new Book(this.SA.getResources().getString(R.string.book1), this.SA.getResources().getString(R.string.book1url)));
			}
		}
		} catch (Exception e) {																			// If there is an error running the background task.
		e.printStackTrace();}
		return null;
	}
	
	// To update the ListView in the UI thread
	@Override
	protected void onProgressUpdate(Book... values) {													
		this.SA.addToListBook(values[0]);																// Calling of the addToListBook from the SecondActivity
		super.onProgressUpdate(values);
	}

}