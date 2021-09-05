package com.miniproject.griet_chef;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class BOOKINGS extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();


    public ArrayList<String> order_id = new ArrayList<>();
    public ArrayList<String> cust_id = new ArrayList<>();
    public ArrayList<String> order_list = new ArrayList<>();
    public ArrayList<String> total_quant = new ArrayList<>();

    Integer index=0;
    TextView tv2;
    ListView lv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookings);
        tv2 = findViewById(R.id.header);
        lv = findViewById(R.id.bookings);

        db.collection("bookings").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@javax.annotation.Nullable QuerySnapshot queryDocumentSnapshots, @javax.annotation.Nullable FirebaseFirestoreException e) {
                order_id.clear();
                for (DocumentSnapshot snapshot : queryDocumentSnapshots) {
                    cust_id.add(snapshot.getString("CUST_ID"));
                    order_list.add(snapshot.getString("ORDER_LIST"));
                    Double d = snapshot.getDouble("ORDER_ID");
                    int i = (int)Math.round(d);
                    String s = Integer.toString(i);
                    order_id.add(s);
                    Double d1 = snapshot.getDouble("TOTAL_ITEMS");
                    int i1 = (int)Math.round(d1);
                    String s1 = Integer.toString(i1);
                    total_quant.add(s1);
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_expandable_list_item_1,order_id);
                lv.setAdapter(adapter);
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position>=0)
                {
                    index = position;
                    Intent intent = new Intent(BOOKINGS.this,Details.class);
                    intent.putExtra("OID",order_id.get(position));
                    intent.putExtra("CID",cust_id.get(position));
                    intent.putExtra("OLIST",order_list.get(position));
                    intent.putExtra("TQ",total_quant.get(position));
                    startActivity(intent);
                }
            }
        });
    }
}





