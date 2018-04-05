package com.example.android.automata;

import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity  {

    int counter = 1;

    //CustomGrid adapter;
    static int colum = 2;

    public static GridView gridview;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        adapter = new CustomGrid(MainActivity.this);
//        gridview = (GridView) findViewById(R.id.gridview);
//
//        gridview.setNumColumns(2);
//
//        gridview.setAdapter(adapter);
//    }
//
//
//    public class CustomGrid extends BaseAdapter {
//        private Context mContext;
//        CustomGrid adgg;
//        int mNumColumns = 2;
//        private Random rand = new Random();
//        GridView gg;
//        int color = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
//        float alfa = 0.1f;
//        int rand_ind = rand.nextInt((2 * 2) - 0) + 0;
//
//        public CustomGrid(Context c) {
//            mContext = c;
//            // this.Imageid = Imageid;
//            // this.web = web;
//        }
//
//        @Override
//        public int getCount() {
//            // TODO Auto-generated method stub
//            return mNumColumns * mNumColumns;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            // TODO Auto-generated method stub
//            return null;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            // TODO Auto-generated method stub
//            return 0;
//        }
//
//        @Override
//        public View getView(final int position, View convertView, ViewGroup parent) {
//            // TODO Auto-generated method stub
//
//            View gridView;
//
//            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View grid = new View(mContext);
//            grid = inflater.inflate(R.layout.layout, null);
//            final View imageView = (ImageView) grid.findViewById(R.id.image_grid);
//
//            if (convertView == null) {
//                if (position == rand_ind) {
//                    imageView.setBackgroundColor(getColorWithAlpha(color, alfa));
//                } else {
//                    imageView.setBackgroundColor(color);
//                }
//            } else {
//                grid = (View) convertView;
//            }
//
//            grid.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//
//
//                    if (position == rand_ind) {
//
//                        // Correct postion click time if condition occur..........
//
//
//                        if (counter == 2) {
//                            mNumColumns = mNumColumns + 1;
//                            alfa = alfa + 0.1f;
//                        } else if (counter == 6) {
//                            mNumColumns = mNumColumns + 1;
//                            alfa = alfa + 0.08f;
//                        } else if (counter == 8) {
//                            mNumColumns = mNumColumns + 1;
//                            alfa = alfa + 0.1f;
//                        } else if (counter == 12) {
//                            mNumColumns = mNumColumns + 1;
//                            alfa = alfa + 0.1f;
//                        } else if (counter == 14) {
//                            mNumColumns = mNumColumns + 1;
//                            alfa = alfa + 0.1f;
//                        } else if (counter == 16) {
//                            mNumColumns = mNumColumns + 1;
//                            alfa = alfa + 0.1f;
//                        } else if (counter == 18) {
//                            mNumColumns = mNumColumns + 1;
//                            alfa = alfa + 0.05f;
//                        } else if (counter >= 18) {
//                            // mNumColumns = mNumColumns + 1;
//                            alfa = 0.8f;
//
//                        }
//
//                        gridview.setNumColumns(mNumColumns);
//                        gridview.setAdapter(adapter);
//                        adapter.notifyDataSetChanged();
//
//                        rand_ind = rand.nextInt((mNumColumns * mNumColumns) - 0) + 0;
//
//                    } else {
//
//                        // Here code for nagative click............ whem click
//                        // nagative at time geanarate this code.........
//                    }
//                }
//            });
//
//            return grid;
//        }
//
//        public int getColorWithAlpha(int color, float ratio) {
//            int newColor = 0;
//            int alpha = Math.round(Color.alpha(color) * ratio);
//            int r = Color.red(color);
//            int g = Color.green(color);
//            int b = Color.blue(color);
//            newColor = Color.argb(alpha, r, g, b);
//            return newColor;
//        }
//    }
//
//    @Override
//    public void onClick(View v) {
//    }
}

