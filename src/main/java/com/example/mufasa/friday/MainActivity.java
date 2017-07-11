package com.example.mufasa.friday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lstView;


    String[]schools={"UoN","KU","JKUAT","Egerton","USIU","KeMu","KCA","TUK","Zetech","Moi"};

    String[]mottos={"Elimu ni Nguvu",
            "Enhancing Lives",
            "Technology for Life",
            "Agriculture staff",
            "Rich kids",
            "Fellowshippers",
            "Accounting geeks",
            "Tech geeks",
            "Media geeks",
            "Eldoret pride"};

    int[]logos={R.drawable.uon,
            R.drawable.ku,
            R.drawable.jkuat,
            R.drawable.egerton,
            R.drawable.usiu,
            R.drawable.kemu,
            R.drawable.kca,
            R.drawable.tuk,
            R.drawable.zetech,
            R.drawable.moii,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstView=(ListView)findViewById(R.id.lstView);


        List<HashMap<String,String>> aList= new ArrayList<HashMap<String, String>>();

            for (int i=0;i<10;i++){
                HashMap<String,String> hashMap= new HashMap<String, String>();
                hashMap.put("header",schools[i]);
                hashMap.put("subheader",mottos[i]);
                hashMap.put("logo",Integer.toString(logos[i]));

                aList.add(hashMap);

                //keys used in the hashmap above
                String[]from={"logo","header","subheader"};

                //the correspondents for the keys in the support layout xml file
                int[]to={R.id.img,R.id.heading,R.id.subheading};

                SimpleAdapter adapter= new SimpleAdapter(getApplicationContext(),aList,R.layout.listview_layout,from,to);

                lstView.setAdapter(adapter);

                lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        if (i==0){
                            Toast.makeText(MainActivity.this, "University of Nairobi", Toast.LENGTH_SHORT).show();
                        }else   if (i==1){
                            Toast.makeText(MainActivity.this, "Kenyatta University", Toast.LENGTH_SHORT).show();
                        }else if (i==2){
                            Toast.makeText(MainActivity.this, "Jomo Kenyatta University of Agriculture and Technology", Toast.LENGTH_SHORT).show();
                        }else if (i==3){
                            Toast.makeText(MainActivity.this, "Egerton University", Toast.LENGTH_SHORT).show();
                        }else if (i==4){
                            Toast.makeText(MainActivity.this, "United States International University", Toast.LENGTH_SHORT).show();
                        }else   if (i==5){
                            Toast.makeText(MainActivity.this, "Kenya Methodist University", Toast.LENGTH_SHORT).show();
                        }else if (i==6){
                            Toast.makeText(MainActivity.this, "Kenya Certified Accounting University", Toast.LENGTH_SHORT).show();

                        }else if (i==7){
                            Toast.makeText(MainActivity.this, "Technical University of Kenya", Toast.LENGTH_SHORT).show();
                        }else if (i==8){
                            Toast.makeText(MainActivity.this, "Zetech University", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this, "Moi University", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

    }
}
