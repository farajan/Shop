package com.example.oem.shop;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;

public class HomeActivity extends AppCompatActivity {

    private ImageButton mLists, mGroups, mFriends, mMyList;
    private FirebaseAuth mAuth;
    private TextView mUser_login;

    private void initImageButtons() {
        mLists = (ImageButton)findViewById(R.id.lists_img_btn);
        mGroups = (ImageButton)findViewById(R.id.groups_img_btn);
        mFriends = (ImageButton)findViewById(R.id.friends_img_btn);
        mMyList = (ImageButton)findViewById(R.id.my_list_img_btn);
    }

    private void clickImageButtons() {
        mLists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lists = new Intent(getApplicationContext(), ListsActivity.class);
                startActivity(lists);
            }
        });

        mGroups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent groups = new Intent(getApplicationContext(), GroupsActivity.class);
                startActivity(groups);
            }
        });

        mFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent friends = new Intent(getApplicationContext(), FriendsActivity.class);
                startActivity(friends);
            }
        });

        mMyList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myList = new Intent(getApplicationContext(), MyListActivity.class);
                startActivity(myList);
            }
        });
    }

    private void initActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_logo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initImageButtons();
        clickImageButtons();
        initActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        mAuth= FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {

            menu.findItem(R.id.user).setTitle(mAuth.getCurrentUser().getEmail());

        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
