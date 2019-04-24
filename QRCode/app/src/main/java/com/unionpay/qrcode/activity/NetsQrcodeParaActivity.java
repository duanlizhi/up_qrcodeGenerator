package com.unionpay.qrcode.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.apache.commons.lang3.StringUtils;

import com.unionpay.qrcode.netsutil.NetsModel;
import com.unionpay.qrcode.netsutil.NetsQR;

/**
 * @author Lenovo
 */
public class NetsQrcodeParaActivity extends AppCompatActivity {

    FloatingActionButton btGenerate;

    EditText etUen;
    EditText etExpiryDate;
    EditText etMerchantId;
    EditText etMerchantName;
    EditText etTerminalId;
    EditText etTransactionAmount;
    EditText etTransactionDate;
    EditText etTransactionMax;
    EditText etTransactionMin;
    EditText etTransactionId;
    RadioGroup rg, rg1, rg2;

    String versionNumber = "0";
    String qrForm = "Paper";
    String isEditable = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nets);
        init();

        Toolbar toolbar = findViewById(R.id.toolbar1);
        toolbar.setTitle("NETS Static QR Code");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButtonChecked = radioGroup.findViewById(i);
                versionNumber = radioButtonChecked.getText().toString();
            }
        });
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButtonChecked = radioGroup.findViewById(i);
                qrForm = radioButtonChecked.getText().toString();
            }
        });
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButtonChecked = radioGroup.findViewById(i);
                if ("是".equals(radioButtonChecked.getText().toString())) {
                    isEditable = "1";
                } else {
                    isEditable = "0";
                }
            }
        });

        btGenerate = findViewById(R.id.generate_button);
        btGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NetsModel model = new NetsModel();
                String result;
                boolean flag = true;
                if (etUen.getText().toString().equals("") || etExpiryDate.getText().toString().equals("") ||
                        etMerchantId.getText().toString().equals("") || etMerchantName.getText().toString().equals("") ||
                        etTerminalId.getText().toString().equals("")) {
                    flag = false;
                    Toast.makeText(NetsQrcodeParaActivity.this, getResources().getString(R.string.notfull_notice), Toast.LENGTH_SHORT).show();
                }
                if ((etTransactionMin.getText().toString().equals("") && !etTransactionMax.getText().toString().equals("")) ||
                        (etTransactionMax.getText().toString().equals("") && !etTransactionMin.getText().toString().equals(""))) {
                    flag = false;
                    Toast.makeText(NetsQrcodeParaActivity.this, getResources().getString(R.string.maxmin_notice), Toast.LENGTH_SHORT).show();
                }
                model.setUen(etUen.getText().toString());
                model.setVersion(versionNumber);
                model.setExpDate(etExpiryDate.getText().toString());
                model.setMerchantID(etMerchantId.getText().toString());
                model.setMerchantName(etMerchantName.getText().toString());
                model.setTerminalID(etTerminalId.getText().toString());
                String amount = etTransactionAmount.getText().toString();
                if (!amount.equals("")) {
                    amount = StringUtils.leftPad(String.valueOf(amount), 8, '0');
                }
                model.setTransactionAmount(amount);
                model.setTransactionTimes(etTransactionDate.getText().toString());
                model.setMinMaxValue(etTransactionMin.getText().toString() + etTransactionMax.getText().toString());
                model.setTransactionID(etTransactionId.getText().toString());
                model.setQualifier(isEditable);
                NetsQR netsqr = new NetsQR();
                result = netsqr.decode(model);
                if (flag) {
                    Intent intent = new Intent(NetsQrcodeParaActivity.this, NetsQrcodeShowActivity.class);
                    intent.putExtra("result", result);

                    startActivity(intent);
                }
            }
        });
    }

    public void init() {
        //初始化组件
        etUen = findViewById(R.id.uen_edittext);
        etExpiryDate = findViewById(R.id.expiry_date_edit);
        etMerchantId = findViewById(R.id.merchant_id_edit);
        etMerchantName = findViewById(R.id.merchant_name_edit);
        etTerminalId = findViewById(R.id.terminal_id_edittext);
        etTransactionAmount = findViewById(R.id.transaction_amount_edittext);
        etTransactionDate = findViewById(R.id.transaction_date_edittext);
        etTransactionMax = findViewById(R.id.transaction_max_edittext);
        etTransactionMin = findViewById(R.id.transaction_min_edittext);
        etTransactionId = findViewById(R.id.transaction_id_edittext);
        rg = findViewById(R.id.radio);
        rg1 = findViewById(R.id.radio1);
        rg2 = findViewById(R.id.radio2);
    }
}
