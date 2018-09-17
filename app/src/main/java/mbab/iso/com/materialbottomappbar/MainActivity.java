package mbab.iso.com.materialbottomappbar;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private BottomAppBar bar;
    private Switch aSwitch;
    private boolean fbModeCenter = true;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    fab.hide();
                }else{
                    fab.show();
                }
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fbModeCenter){
                    bar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
                    fbModeCenter = false;
                }else{
                    bar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
                    fbModeCenter = true;
                }
            }
        });


        bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarMensaje("BB MENU");
            }
        });




    }

    public boolean addPhoto(MenuItem item){
        mostrarMensaje("ADD PHOTO");
        return true;
    }

    public boolean search(MenuItem item){
        mostrarMensaje("SEARCH");
        return true;
    }

    private void mostrarMensaje(String mensaje){
        Toast.makeText(getBaseContext(),mensaje,Toast.LENGTH_SHORT).show();
    }

    private void init() {
        this.bar = findViewById(R.id.bar);
        setSupportActionBar(bar);
        this.aSwitch = findViewById(R.id.switch1);
        this.fab = findViewById(R.id.fab);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_bbar, menu);
        return true;
    }




}
