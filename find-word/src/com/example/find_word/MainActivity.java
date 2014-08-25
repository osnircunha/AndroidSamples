package com.example.find_word;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final GridView gridView = (GridView) findViewById(R.id.letter_grid);
        gridView.setAdapter(new LetterAdapter(getApplicationContext()));
        gridView.setOnTouchListener(new View.OnTouchListener() {
			
        	@Override
			public boolean onTouch(View v, MotionEvent event) {
	            float currentXPosition = event.getX();
	            float currentYPosition = event.getY();
	            int position = gridView.pointToPosition((int) currentXPosition, (int) currentYPosition);
	            if(event.getAction() == MotionEvent.ACTION_MOVE){
		            // Access text in the cell, or the object itself
		            System.out.println(gridView.getItemAtPosition(position));
	            }
	            return true;
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class LetterAdapter extends BaseAdapter{

    	private Context context;
    	
    	private Character[] letters = new Character[] {
    			'D','H','O','B','S','H','N','E','P','T','U',
    			'D','N','A','U','U','E','E','E','M','A','E',
    			'W','N','A','I','P','L','U','T','O','N','A',
    			'A','G','H','P','L','I','Z','O','O','E','R',
    			'R','D','E','I','H','C','T','M','N','W','T',
    			'F','H','Y','H','O','P','B','E','O','A','H',
    			'D','H','O','B','S','H','N','E','P','T','U',
    			'D','N','A','U','U','E','E','E','M','A','E',
    			'W','N','A','I','P','L','U','T','O','N','A',
    			'A','G','H','P','L','I','Z','O','O','E','R',
    			'R','D','E','I','H','C','T','M','N','W','T',
    			'D','H','O','B','S','H','N','E','P','T','U',
    			'D','N','A','U','U','E','E','E','M','A','E',
    			'W','N','A','I','P','L','U','T','O','N','A',
    			'A','G','H','P','L','I','Z','O','O','E','R'};
    	
    	public LetterAdapter(Context context) {
			this.context = context;
		}
    	
		@Override
		public int getCount() {
			return letters.length;
		}

		@Override
		public Object getItem(int arg0) {
			return letters[arg0];
		}

		@Override
		public long getItemId(int arg0) {
			return arg0;
		}

		@Override
		public View getView(int position, View view, ViewGroup viewGroup) {
			TextView textView;
			
			if(view == null){
				textView = new TextView(context);
			} else {
				textView = (TextView) view;
			}
			textView.setTag(position);
			textView.setText(String.valueOf(letters[position]));
			
			return textView;
		}
    }
    
}
