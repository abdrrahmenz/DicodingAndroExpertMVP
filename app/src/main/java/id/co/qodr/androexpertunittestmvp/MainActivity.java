package id.co.qodr.androexpertunittestmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainView{

    private EditText edtWidth, edtHeight, edtLength;
    private TextView tvresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWidth = (EditText) findViewById(R.id.edt_width);
        edtHeight = (EditText) findViewById(R.id.edt_height);
        edtLength = (EditText) findViewById(R.id.edt_length);
        tvresult = (TextView) findViewById(R.id.tv_result);

        final MainPresenter presenter = new MainPresenter(this);

        Button btnCalculate = (Button) findViewById(R.id.btn_calculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String length = edtLength.getText().toString().trim();
                String width = edtWidth.getText().toString().trim();
                String height = edtHeight.getText().toString().trim();

                boolean isEmptyFields = false;

                if (TextUtils.isEmpty(length)){
                    isEmptyFields = true;
                    edtLength.setError("Field tidak boleh kosong");
                }
                if (TextUtils.isEmpty(width)){
                    isEmptyFields = true;
                    edtWidth.setError("Field tidak boleh kosong");
                }
                if (TextUtils.isEmpty(height)){
                    isEmptyFields = true;
                    edtHeight.setError("Field tidak boleh kosong");
                }
                if (!isEmptyFields){
                    double l = Double.parseDouble(length);
                    double w = Double.parseDouble(width);
                    double h = Double.parseDouble(height);

                    presenter.hitungVolume(l, w, h);
                }
            }
        });
    }

    @Override
    public void tampilVolume(MainModel model) {
        tvresult.setText(String.valueOf(model.getVolume()));
    }
}
