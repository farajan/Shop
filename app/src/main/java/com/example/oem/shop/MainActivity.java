package com.example.oem.shop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

//    private Button mSendData, mPrintData;
//    private EditText mData, mPrint;
//    private Integer counter = 0;
//    String out = "";
//    User mUser;
    public Button mLogin;

    public void init() {
        mLogin = (Button) findViewById(R.id.login);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(login);
            }
        });
    }

    public void isUserLogin() {
        int tmp = 1;
        if(tmp == 2) {
            Intent home = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(home);
        } else {
            Intent login = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(login);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        isUserLogin();

//        mSendData = (Button) findViewById(R.id.sendData);
//        mPrintData = (Button) findViewById(R.id.printData);
//        mData = (EditText) findViewById(R.id.data);
//        mPrint= (EditText) findViewById(R.id.print);
//        mUser = new User("1234", "Adam@kokot.cz", "www.pornhub.com");
//
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        final DatabaseReference myRef = database.getReference("test");
//
//        mSendData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myRef.child("id: "+(counter++).toString()).setValue(mData.getText().toString());
//            }
//        });
//
//        mPrintData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                myRef.addChildEventListener(new ChildEventListener() {
//                    @Override
//                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                        out += (String) dataSnapshot.getValue() + "\n";
//                    }
//
//                    @Override
//                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//                    }
//
//                    @Override
//                    public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//                    }
//
//                    @Override
//                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });
//                mPrint.setText(out);
//            }
//        });
    }
}
