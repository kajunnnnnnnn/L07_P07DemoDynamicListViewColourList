package sg.edu.rp.c346.id20026955.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    EditText posNo;
    Button btnAdd;
    ListView lv;

    ArrayList<String> alColour;
    ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAddColour);
        posNo = findViewById(R.id.editTextNumber);
        lv = findViewById(R.id.lv);

        alColour = new ArrayList<>();
        alColour.add("Red");
        alColour.add("Orange");

        aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColour);

        lv.setAdapter(aa);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String colour = etElement.getText().toString();
                int pos = Integer.parseInt(posNo.getText().toString());
                alColour.add(pos, colour);
                aa.notifyDataSetChanged();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String colour = alColour.get(i);
                Toast.makeText(MainActivity.this, "" + alColour.get(i), Toast.LENGTH_SHORT).show();
                Log.d("LV click", colour);
            }
        });
    }
}