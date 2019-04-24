package com.unionpay.qrcode.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.unionpay.qrcode.otherutil.ConstantString;
import com.unionpay.qrcode.emvutil.EMVModel;
import com.unionpay.qrcode.qrlistener.QrOnItemSelectedListener;

/**
 * @author Lenovo
 */
public class SGNetsQrcodeParaActivity extends AppCompatActivity {

    Spinner merchantCodeSpinner;
    Spinner convenienceTypeSpinner;
    Spinner languagePreferenceSpinner;
    QrOnItemSelectedListener testSystemAdapter;
    TextView convenienceTagTextview;
    EditText convenienceTagEditview;
    TextView convenienceTagTextview1;
    EditText convenienceTagEditview1;
    FloatingActionButton generateButton;
    EditText merchantCodeEdittext;
    EditText transactionAmountEdit;
    CheckBox additionCheckBox;
    CheckBox languageCheckBox;
    EditText merchantNameEdittext;
    EditText billNumberEdittext;
    EditText phoneNumberEdittext;
    EditText merchantTagEdittext;
    EditText loyaltyNumberEdittext;
    EditText referenceTagEdittext;
    EditText customerTagEdittext;
    EditText terminalTagEdittext;
    EditText purposeEdittext;
    EditText addressEdittext;
    EditText customerPhoneNumberEdittext;
    EditText emailEdittext;
    EditText lpMerchantNameEdittext;
    EditText lpMerchantCityEdittext;
    EditText uenEdittext;
    EditText expiryDateEdittext;
    EditText merchantIdEdittext;
    EditText terminalIdEditText;
    LinearLayout additionLayout;
    LinearLayout languageLayout;

    HandleString tHandler;

    /**
     * 商户类别
     */
    String merchantType;
    /**
     * 小费类型
     */
    String convenienceType;
    /**
     * 语言首选项
     */
    String languagePreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sgnets);

        Toolbar toolbar = findViewById(R.id.toolbar1);
        toolbar.setTitle("NETS-SGQR");

        //控件初始化
        init();

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        languageLayout.setVisibility(View.GONE);
        additionLayout.setVisibility(View.GONE);

        //商户类别
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ConstantString.merchantCode);
        testSystemAdapter = new QrOnItemSelectedListener(ConstantString.merchantCode, "3", tHandler);
        merchantCodeSpinner.setAdapter(adapter1);
        merchantCodeSpinner.setSelection(1);
        merchantCodeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                merchantType = ConstantString.merchantCode[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //小费类型
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ConstantString.convenienceType);
        convenienceTypeSpinner.setAdapter(adapter3);
        //设置小费选项下面的两个输入框是否可以输入
        convenienceTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                convenienceType = ConstantString.convenienceType[i];
                if (i == 0) {
                    convenienceTagTextview.setEnabled(false);
                    convenienceTagEditview.setEnabled(false);
                    convenienceTagTextview1.setEnabled(false);
                    convenienceTagEditview1.setEnabled(false);
                    convenienceTagEditview.setHint("--");
                    convenienceTagEditview1.setHint("--");
                } else if (i == 1) {
                    convenienceTagTextview.setEnabled(false);
                    convenienceTagEditview.setEnabled(false);
                    convenienceTagTextview1.setEnabled(false);
                    convenienceTagEditview1.setEnabled(false);
                    convenienceTagEditview.setHint("--");
                    convenienceTagEditview1.setHint("--");
                } else if (i == 2) {
                    convenienceTagTextview.setEnabled(true);
                    convenienceTagEditview.setEnabled(true);
                    convenienceTagTextview1.setEnabled(false);
                    convenienceTagEditview1.setEnabled(false);
                    convenienceTagEditview.setHint("");
                    convenienceTagEditview1.setHint("--");
                } else if (i == 3) {
                    convenienceTagTextview.setEnabled(false);
                    convenienceTagEditview.setEnabled(false);
                    convenienceTagTextview1.setEnabled(true);
                    convenienceTagEditview1.setEnabled(true);
                    convenienceTagEditview.setHint("--");
                    convenienceTagEditview1.setHint("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //语言首选项
        ArrayAdapter<String> adapter5 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ConstantString.penferenceLanguage);
        languagePreferenceSpinner.setAdapter(adapter5);
        languagePreferenceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                languagePreference = ConstantString.penferenceLanguage[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int flag = 0;
                    if ("".equals(merchantCodeEdittext.getText().toString()) || "选择商户类别（MCC码）".equals(merchantType)
                            || "".equals(merchantNameEdittext.getText().toString())) {
                        flag = 1;
                    }
                    EMVModel model = new EMVModel();
                    model.setSystemPayStr("51");
                    model.setMerchantCode(merchantCodeEdittext.getText().toString());
                    model.setIsActiveOrNot("静态码");
                    model.setMerchantType(merchantType);
                    model.setTransactionCurrency("702");
                    model.setTransactionAmount(transactionAmountEdit.getText().toString());
                    model.setConvenienceType(convenienceType);
                    model.setConvenienceNum1(convenienceTagEditview.getText().toString());
                    model.setConvenienceNum2(convenienceTagEditview1.getText().toString());
                    model.setCountryCode("SG");
                    model.setMerchantName(merchantNameEdittext.getText().toString());
                    model.setMerchantCity("SINGAPORE");
                    model.setZipCode("888333");
                    model.setBillNumber(billNumberEdittext.getText().toString());
                    model.setPhoneNumer(phoneNumberEdittext.getText().toString());
                    model.setMerchantTag(merchantTagEdittext.getText().toString());
                    model.setLoytNumber(loyaltyNumberEdittext.getText().toString());
                    model.setReferenceTag(referenceTagEdittext.getText().toString());
                    model.setCustomerPhoneNumber(customerPhoneNumberEdittext.getText().toString());
                    model.setTremialTag(terminalTagEdittext.getText().toString());
                    model.setPurposeTag(purposeEdittext.getText().toString());
                    model.setAddressTag(addressEdittext.getText().toString());
                    model.setCustomerTag(customerTagEdittext.getText().toString());
                    model.setEmailNumber(emailEdittext.getText().toString());
                    model.setLanguagePreference(languagePreference);
                    model.setLpMerchantName(lpMerchantNameEdittext.getText().toString());
                    model.setLpMerchantCity(lpMerchantCityEdittext.getText().toString());
                    tHandler = new HandleString(model);
                    if (flag == 0) {
                        Intent intent = new Intent(SGNetsQrcodeParaActivity.this, EMVMerchantShowActivity.class);
                        intent.putExtra("result", tHandler.doHandle(1, uenEdittext.getText().toString(),
                                expiryDateEdittext.getText().toString(), merchantIdEdittext.getText().toString(),
                                terminalIdEditText.getText().toString()));
                        intent.putExtra("transactionCurrency", "新加坡元,2");
                        intent.putExtra("币种代码:", "702");
                        intent.putExtra("merchantname", merchantNameEdittext.getText().toString());
                        startActivity(intent);
                    } else {
                        Toast.makeText(SGNetsQrcodeParaActivity.this, getResources().getString(R.string.notfull_notice), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //CheckBox初始化不展开
        initCheckBox();
    }

    public void init() {
        merchantCodeSpinner = findViewById(R.id.merchant_spinner);
        convenienceTypeSpinner = findViewById(R.id.convenience_type_spinner);
        convenienceTagTextview = findViewById(R.id.convenience_tag_textview);
        convenienceTagEditview = findViewById(R.id.convenience_tag_editview);
        convenienceTagTextview1 = findViewById(R.id.convenience_tag_textview1);
        convenienceTagEditview1 = findViewById(R.id.convenience_tag_editview1);
        convenienceTagEditview1.setInputType(EditorInfo.TYPE_CLASS_PHONE);
        convenienceTagEditview.setInputType(EditorInfo.TYPE_CLASS_PHONE);
        languagePreferenceSpinner = findViewById(R.id.language_preference_spinner);
        generateButton = findViewById(R.id.generate_button);
        merchantCodeEdittext = findViewById(R.id.sgqr_id_edittext);
        transactionAmountEdit = findViewById(R.id.transaction_amount_edit);
        transactionAmountEdit.setInputType(EditorInfo.TYPE_CLASS_PHONE);
        additionCheckBox = findViewById(R.id.addition_checkbox);
        languageCheckBox = findViewById(R.id.second_merchant_info_checkbox);
        languageLayout = findViewById(R.id.second_language_linearlayout);
        additionLayout = findViewById(R.id.addition_linearlayout);
        merchantNameEdittext = findViewById(R.id.merchant_name_edit);
        billNumberEdittext = findViewById(R.id.bill_number_edittext);
        phoneNumberEdittext = findViewById(R.id.pohone_number_edittext);
        merchantTagEdittext = findViewById(R.id.stroe_label_edittext);
        loyaltyNumberEdittext = findViewById(R.id.loyalty_number_edittext);
        referenceTagEdittext = findViewById(R.id.reference_label_edittext);
        customerTagEdittext = findViewById(R.id.customer_label_edittext);
        terminalTagEdittext = findViewById(R.id.terminal_label_edittext);
        purposeEdittext = findViewById(R.id.purpose_edittext);
        addressEdittext = findViewById(R.id.address_edittext);
        customerPhoneNumberEdittext = findViewById(R.id.phone_number_edittext);
        emailEdittext = findViewById(R.id.email_edittext);
        lpMerchantNameEdittext = findViewById(R.id.second_merchant_name_edittext);
        lpMerchantCityEdittext = findViewById(R.id.second_merchant_city_edittext);
        uenEdittext = findViewById(R.id.uen_edittext);
        expiryDateEdittext = findViewById(R.id.expiry_time_edittext);
        merchantIdEdittext = findViewById(R.id.merchant_id_edittext);
        terminalIdEditText = findViewById(R.id.terminal_id_edittext);
    }

    public void initCheckBox() {
        additionCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //没有被选中
                if (!isChecked) {
                    additionLayout.setVisibility(View.GONE);
                } else {
                    additionLayout.setVisibility(View.VISIBLE);
                }
            }
        });
        languageCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    languageLayout.setVisibility(View.GONE);
                } else {
                    languageLayout.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
