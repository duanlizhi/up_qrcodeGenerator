package com.unionpay.qrcode.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.unionpay.qrcode.emvutil.consumer.*;

/**
 * @author Lenovo
 */
public class EMVConsumerParaActivity extends AppCompatActivity {

    FloatingActionButton btGenerate;

    boolean flag = true;

    EditText adfEditText;
    EditText panEditText;
    EditText dateEditText;
    EditText serviceCodeEditText;
    EditText discretionaryEditText;
    EditText applicationLabelEditText;
    EditText cardholderNameEditText;
    EditText languagePreferenceEditText;
    EditText issuerUrlEditText;
    EditText versionNumberEditText;
    EditText takenIdEditText;
    EditText paymentAccountEditText;
    EditText lastPanEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_consumer);

        Toolbar toolbar = findViewById(R.id.toolbar1);
        toolbar.setTitle(getResources().getString(R.string.emv_consumer));
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        init();

        btGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("".equals(adfEditText.getText().toString()) || "".equals(panEditText.getText().toString())) {
                    Toast.makeText(EMVConsumerParaActivity.this, getResources().getString(R.string.notfull_notice), Toast.LENGTH_SHORT).show();
                } else {
                    String result = formatMessage();
                    if (flag) {
                        Intent intent = new Intent(EMVConsumerParaActivity.this, EMVConsumerShowActivity.class);
                        intent.putExtra("result", result);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    public void init() {
        btGenerate = findViewById(R.id.generate_consumer_button);
        adfEditText = findViewById(R.id.adf_edittext);
        panEditText = findViewById(R.id.pan_edittext);
        dateEditText = findViewById(R.id.date_edittext);
        serviceCodeEditText = findViewById(R.id.service_code_edittext);
        discretionaryEditText = findViewById(R.id.discretionary_edittext);
        applicationLabelEditText = findViewById(R.id.application_label_edittext);
        cardholderNameEditText = findViewById(R.id.cardholder_name_edittext);
        languagePreferenceEditText = findViewById(R.id.language_preference_edittext);
        issuerUrlEditText = findViewById(R.id.issuer_url_edittext);
        versionNumberEditText = findViewById(R.id.version_number_edittext);
        takenIdEditText = findViewById(R.id.taken_id_edittext);
        paymentAccountEditText = findViewById(R.id.payment_account_edittext);
        lastPanEditText = findViewById(R.id.last_pan_edittext);
    }

    /**
     * 处理edittext里的消息，拼成需要的字符串
     */
    public String formatMessage() {
        QRCode code = new QRCode();
        code.set("61", "4F", adfEditText.getText().toString());
        if ("".equals(dateEditText.getText().toString()) && "".equals(serviceCodeEditText.getText().toString())
                && "".equals(discretionaryEditText.getText().toString())) {
            flag = true;
            //这里说明输入的是pan码（5A域）
            code.set("61", "5A", panEditText.getText().toString());
        } else if (!"".equals(dateEditText.getText().toString()) && !"".equals(serviceCodeEditText.getText().toString())
                && !"".equals(discretionaryEditText.getText().toString())) {
            flag = true;
            //这里是track 2码 （57域）
            String s = panEditText.getText().toString() + "D"
                    + dateEditText.getText().toString() + serviceCodeEditText.getText().toString()
                    + discretionaryEditText.getText().toString() + "F";
            code.set("61", "57", s);
        } else {
            //到这里说明不符合规范，track2码没有填完整
            flag = false;
            Toast.makeText(this, getResources().getString(R.string.emv_consumer_notice1), Toast.LENGTH_LONG).show();
        }
        if (adfEditText.getText().toString().length() < 10 || adfEditText.getText().toString().length() > 32) {
            flag = false;
            Toast.makeText(this, getResources().getString(R.string.emv_consumer_notice2), Toast.LENGTH_SHORT).show();
        } else if ((takenIdEditText.getText().toString().length() != 6) && !"".equals(takenIdEditText.getText().toString())) {
            flag = false;
            Toast.makeText(this, getResources().getString(R.string.emv_consumer_notice3), Toast.LENGTH_SHORT).show();
        }
        //下面直接拼其他的
        if (!"".equals(applicationLabelEditText.getText().toString())) {
            code.set("61", "50", Base64Util.stringToHexAscii(applicationLabelEditText.getText().toString()));
        }
        if (!"".equals(cardholderNameEditText.getText().toString())) {
            code.set("61", "5F20", Base64Util.stringToHexAscii(cardholderNameEditText.getText().toString()));
        }
        if (!"".equals(languagePreferenceEditText.getText().toString())) {
            code.set("61", "5F2D", Base64Util.stringToHexAscii((languagePreferenceEditText.getText().toString())));
        }
        if (!"".equals(issuerUrlEditText.getText().toString())) {
            code.set("61", "5F50", Base64Util.stringToHexAscii(issuerUrlEditText.getText().toString()));
        }
        if (!"".equals(versionNumberEditText.getText().toString())) {
            code.set("61", "9F08", versionNumberEditText.getText().toString());
        }
        if (!"".equals(takenIdEditText.getText().toString())) {
            code.set("61", "9F19", takenIdEditText.getText().toString());
        }
        if (!"".equals(paymentAccountEditText.getText().toString())) {
            code.set("61", "9F24", Base64Util.stringToHexAscii(paymentAccountEditText.getText().toString()));
        }
        if (!"".equals(lastPanEditText.getText().toString())) {
            code.set("61", "9F25", lastPanEditText.getText().toString());
        }
        String result = code.doCompose();
        return Base64Util.converte(result);
    }
}
