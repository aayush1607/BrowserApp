package com.example.browser;

import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;

public class MainBrowse extends AppCompatActivity {

    EditText url;
    String str;
    ListView mylist;
    public ArrayList<String> titles;
    ArrayList<String> links;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_browse);

        titles = new ArrayList<String>();
        links = new ArrayList<String>();
        mylist = (ListView) findViewById(R.id.list);

        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                str = links.get(i);
                Intent intent = new Intent(MainBrowse.this, browse.class);
                intent.putExtra("str", str);
                startActivity(intent);
                setContentView(R.layout.activity_browse);
            }
        });
        //new ProcessInBack().execute();

    }

    public void browse(View view) {

        url = findViewById(R.id.url);


        if (view.getId() == R.id.chrom) {
            str = "https://www.google.com/";
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();

        } else if (view.getId() == R.id.cb) {
            str = "https://www.cricbuzz.com/";
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();

        } else if (view.getId() == R.id.search) {
            str = url.getText().toString();

            if (str.startsWith("www")) {
                str = "https://" + str;
            }
            if (str.isEmpty()) {
                Toast.makeText(this, "Nothing is written as url", Toast.LENGTH_LONG).show();
            }

            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
        } else if (view.getId() == R.id.duck) {
            str = "https://www.duckduckgo.com";
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
        } else if (view.getId() == R.id.insta) {
            str = "https://www.instagram.com";
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();

        } else if (view.getId() == R.id.amazon) {
            str = "https://www.amazon.com";
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
        } else if (view.getId() == R.id.fb) {
            str = "https://www.facebook.com";
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
        } else if (view.getId() == R.id.bing) {
            str = "https://www.bing.com";
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
        } else if (view.getId() == R.id.myntra) {
            str = "https://www.myntra.com";
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
        } else if (view.getId() == R.id.flip) {
            str = "https://www.flipkart.com";
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "something is wrong", Toast.LENGTH_LONG).show();
        }
        Intent intent = new Intent(this, browse.class);
        intent.putExtra("str", str);
        startActivity(intent);
        setContentView(R.layout.activity_browse);
    }

}

    /*
    // getting feeds
    public InputStream getInputStream(URL url) {
        try {
            return url.openConnection().getInputStream();
        } catch (IOException e) {
            return null;
        }

    }

    public class ProcessInBack extends AsyncTask<Integer, Void, Exception> {

        Exception exp = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Exception doInBackground(Integer... integers) {

            try {
                URL url = new URL("http://feeds.news24.com/articles/news24/TopStories/rss");

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(false);
                XmlPullParser xpp = factory.newPullParser();
                xpp.setInput(getInputStream(url), "UTF_8");
                boolean insideitem = false;
                int event = xpp.getEventType();
                while (event != XmlPullParser.END_DOCUMENT) {
                    if (event == XmlPullParser.START_TAG) {
                        if (xpp.getName().equalsIgnoreCase("item")) {
                            insideitem = true;
                        } else if (xpp.getName().equalsIgnoreCase("title")) {
                            if (insideitem) {
                                titles.add(xpp.nextText());
                            }
                        } else if (xpp.getName().equalsIgnoreCase("link")) {
                            if (insideitem) {
                                links.add(xpp.nextText());
                            }
                        } else if (event == XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("item")) {
                            insideitem = false;
                        }

                    }
                    event = xpp.next();
                }
            } catch (MalformedInputException e) {
                exp = e;
            } catch (XmlPullParserException e) {
                exp = e;
            } catch (IOException e) {
                exp = e;
            }


            return exp;
        }

        @Override
        protected void onPostExecute(Exception s) {
            super.onPostExecute(s);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(MainBrowse.this, android.R.layout.simple_list_item_1, titles);
            mylist.setAdapter(adapter);


        }
    }

}
    */