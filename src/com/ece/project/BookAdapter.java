package com.ece.project;

import java.util.ArrayList;
import java.util.List;


import com.ece.project.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

///---------------------------------------------------BookAdapter class-----------------------------------------------------///
///----------------------------This will be used to adapt the Book to a content of the ListView-----------------------------///

public class BookAdapter extends BaseAdapter {

	private List<Book> database;																			// This will contain a list of Book object from the SecondActivity.
	private LayoutInflater inflater;																		// This will contain the layout of the SecondActivity.
	private ArrayList<BookAdapterListener> mListListener = new ArrayList<BookAdapterListener>();		// This will contain the ArrayList of the listeners from each Book.
	
	// Constructor.
	public BookAdapter(Context context, List<Book> database) {
		this.inflater = LayoutInflater.from(context);														// This will set the inflater and the layout of the SecondActivity.
		this.database = database;																			// This will set the list of Book as the same as from the SecondActivity.
	}
	
	// To get the size of the list of Book. It will not be used further.
	@Override
	public int getCount() {
		return this.database.size();
	}

	// To get an Book of the list. It will not be used further.
	@Override
	public Book getItem(int location) {
		return database.get(location);
	}

	// To get the id of an Book from its location.
	@Override
	public long getItemId(int location) {
		return location;
	}

	// Note this is a short class inside the class. It will just be used to avoid screen flashing.
	
	private class ViewHolder {
		TextView textViewN;
		TextView textViewS;
	}
	
	// To get the view that we want in the ListView.
	@Override
	public View getView(final int location, View convertView, ViewGroup parent) {
		ViewHolder holder;
		
		if(convertView == null) {																			// If the converter doesn't exist.
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.itembook, null);										// This will create a simple layout defined in itembook.xml
			convertView.setTag(holder);																		// This will transmit the tag of the converter to the holder for later use.
		}
		else {																								// If the converter already exist.
			holder = (ViewHolder) convertView.getTag();														// This will transmit the tag of the converter to the holder for later use.
		}
		
		holder.textViewN = (TextView)convertView.findViewById(R.id.textViewN);								// This will set the name of the book as the first line of the layout.
		holder.textViewN.setText(database.get(location).getName());
		holder.textViewS = (TextView)convertView.findViewById(R.id.textViewS);								// This will set the link of the book as the second line of the layout.
		holder.textViewS.setText(database.get(location).getLink());	

		holder.textViewS.setTag(location);																	// This will get the location of the view in the ListView we are using.
		holder.textViewS.setOnClickListener(new OnClickListener() {											// This will set the listener on that view.
			public void onClick(View v) {
				Integer location = (Integer)v.getTag();
				sendListener(database.get(location), location);
			}
		});
		
		return convertView;
	}

	// Note that this is a short interface inside the class. It will be used by SecondActivity to implement its onClickBook function.
	public interface BookAdapterListener {
		public void onClickBook(Book art, int location);
	}
	
	// To add a listener to the list of listeners.
	public void addListener(BookAdapterListener bookListener) {
        mListListener.add(bookListener);
    }
	
	// To send to all listener which one is used.
    private void sendListener(Book art, int location) {
        for(int i = mListListener.size()-1; i >= 0; i--)
        	mListListener.get(i).onClickBook(art, location);
    }
    
}
