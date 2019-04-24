package com.unionpay.qrcode.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.unionpay.qrcode.otherutil.ConstantString;
import com.unionpay.qrcode.emvutil.EMVModel;
import com.unionpay.qrcode.qrlistener.QrOnItemSelectedListener;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

/**
 * @author emv商户码，第一个界面，用于读取参数，生成emv二维码
 */
public class EMVMerchantParaActivity extends AppCompatActivity {

    Spinner systemSpinner;
    Spinner merchantCodeSpinner;
    Spinner transactionCurrencySpinner;
    Spinner convenienceTypeSpinner;
    Spinner countryCodeSpinner;
    Spinner languagePreferenceSpinner;
    RadioGroup rg;
    QrOnItemSelectedListener testSystemAdapter;
    TextView convenienceTagTextview;
    EditText convenienceTagEditview;
    TextView convenienceTagTextview1;
    EditText convenienceTagEditview1;
    FloatingActionButton generateButton;
    EditText merchantCodeEdittext;
    EditText transactionAmountEdit;
    EditText zipCodeEdittext;
    CheckBox additionCheckBox;
    CheckBox languageCheckBox;
    EditText merchantNameEdittext;
    EditText merchantCityEdittext;
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
    LinearLayout additionLayout;
    LinearLayout languageLayout;

    HandleString tHandler;

    LinearLayout dyLinearLayout;
    ArrayList<EditText> editTexts;
    ArrayList<Spinner> spinners;
    EditText editText;
    Spinner spinner;
    Button dyButton;
    Button dtButton2;

    String tranferTransactionCurrency;
    String tranferTransactionCurrency1;
    String tranferMerchantName;
    /**
     * 支付系统
     */
    String systemPayStr;
    /**
     * 商户类别
     */
    String merchantType;
    /**
     * 静态还是动态
     */
    String isActiveOrNot;
    /**
     * 交易货币
     */
    String transactionCurrency;
    /**
     * 小费类型
     */
    String convenienceType;
    /**
     * 国家编码
     */
    String countryCode;
    /**
     * 语言首选项
     */
    String languagePreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commercial);

        Toolbar toolbar = findViewById(R.id.toolbar1);
        toolbar.setTitle(getResources().getString(R.string.emv_merchant));

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
        //支付系统
        testSystemAdapter = new QrOnItemSelectedListener(ConstantString.paySystem, "1", tHandler);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ConstantString.paySystem);
        systemSpinner.setAdapter(adapter);
        systemSpinner.setSelection(14);
        systemSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                systemPayStr = ConstantString.paySystem[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

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

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButtonChecked = radioGroup.findViewById(i);
                isActiveOrNot = radioButtonChecked.getText().toString();
            }
        });

        //交易货币
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ConstantString.transactionCurrency);
        transactionCurrencySpinner.setAdapter(adapter2);
        testSystemAdapter = new QrOnItemSelectedListener(ConstantString.transactionCurrency, "4", tHandler);
        transactionCurrencySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                transactionCurrency = ConstantString.reTra[position];
                tranferTransactionCurrency = ConstantString.transactionCurrency[position];
                tranferTransactionCurrency1 = transactionCurrency;
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

        //国家码
        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ConstantString.countryCode);
        countryCodeSpinner.setAdapter(adapter4);
        countryCodeSpinner.setSelection(46);
        countryCodeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                countryCode = ConstantString.countryCode[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
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
                tranferMerchantName = merchantNameEdittext.getText().toString();
                int flag = 0;
                if ("".equals(merchantCodeEdittext.getText().toString()) || systemPayStr.equals("选择支付系统") || merchantType.equals("选择商户类别（MCC码）")
                        || transactionCurrency.equals("选择交易币种") || countryCode.equals("选择国家编码") || merchantNameEdittext.getText().toString().equals("")
                        || merchantCityEdittext.getText().toString().equals("")) {
                    flag = 1;
                }
                String polyStr = "";
                for (int i = 0; i < editTexts.size(); i++) {
                    if ("".equals(editTexts.get(i).getText().toString())) {
                        flag = 1;
                        break;
                    }
                    polyStr += systemPayStrs[i].substring(0, 2) + StringUtils.leftPad(String.valueOf(editTexts.get(i).getText().toString().length()), 2, '0') + editTexts.get(i).getText().toString();
                }
                Log.e("tagatgatag", polyStr);
                EMVModel model = new EMVModel();
                model.setSystemPayStr(systemPayStr);
                model.setMerchantCode(merchantCodeEdittext.getText().toString());
                model.setIsActiveOrNot(isActiveOrNot);
                model.setMerchantType(merchantType);
                model.setTransactionCurrency(transactionCurrency);
                model.setTransactionAmount(transactionAmountEdit.getText().toString());
                model.setConvenienceType(convenienceType);
                model.setConvenienceNum1(convenienceTagEditview.getText().toString());
                model.setConvenienceNum2(convenienceTagEditview1.getText().toString());
                model.setCountryCode(countryCode);
                model.setMerchantName(merchantNameEdittext.getText().toString());
                model.setMerchantCity(merchantCityEdittext.getText().toString());
                model.setZipCode(zipCodeEdittext.getText().toString());
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
                tHandler = new HandleString(model, polyStr);
                if (flag == 0) {
                    Intent intent = new Intent(EMVMerchantParaActivity.this, EMVMerchantShowActivity.class);
                    intent.putExtra("result", tHandler.doHandle());
                    intent.putExtra("transactionCurrency", tranferTransactionCurrency);
                    intent.putExtra("币种代码:", tranferTransactionCurrency1);
                    intent.putExtra("merchantname", tranferMerchantName);
                    startActivity(intent);
                } else {
                    Toast.makeText(EMVMerchantParaActivity.this, getResources().getString(R.string.notfull_notice), Toast.LENGTH_SHORT).show();
                }
            }
        });

        dyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addView();
            }
        });
        dtButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteView();
            }
        });

        //CheckBox初始化不展开
        initCheckBox();
    }

    public void init() {
        systemSpinner = findViewById(R.id.system_spinner);
        merchantCodeSpinner = findViewById(R.id.merchant_spinner);
        rg = findViewById(R.id.radio);
        transactionCurrencySpinner = findViewById(R.id.transaction_currency_spinner);
        convenienceTypeSpinner = findViewById(R.id.convenience_type_spinner);
        convenienceTagTextview = findViewById(R.id.convenience_tag_textview);
        convenienceTagEditview = findViewById(R.id.convenience_tag_editview);
        convenienceTagTextview1 = findViewById(R.id.convenience_tag_textview1);
        convenienceTagEditview1 = findViewById(R.id.convenience_tag_editview1);
        convenienceTagEditview1.setInputType(EditorInfo.TYPE_CLASS_PHONE);
        convenienceTagEditview.setInputType(EditorInfo.TYPE_CLASS_PHONE);
        countryCodeSpinner = findViewById(R.id.country_code_spinner);
        languagePreferenceSpinner = findViewById(R.id.language_preference_spinner);
        generateButton = findViewById(R.id.generate_button);
        merchantCodeEdittext = findViewById(R.id.merchant_code_edittext);
        transactionAmountEdit = findViewById(R.id.transaction_amount_edit);
        transactionAmountEdit.setInputType(EditorInfo.TYPE_CLASS_PHONE);
        zipCodeEdittext = findViewById(R.id.zip_code_edittext);
        zipCodeEdittext.setInputType(EditorInfo.TYPE_CLASS_PHONE);
        additionCheckBox = findViewById(R.id.addition_checkbox);
        languageCheckBox = findViewById(R.id.second_merchant_info_checkbox);
        languageLayout = findViewById(R.id.second_language_linearlayout);
        additionLayout = findViewById(R.id.addition_linearlayout);
        dyLinearLayout = findViewById(R.id.dy_linear);
        merchantNameEdittext = findViewById(R.id.merchant_name_edit);
        merchantCityEdittext = findViewById(R.id.merchant_city_edit);
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

        dyButton = findViewById(R.id.dy_button1);
        editTexts = new ArrayList<>();
        spinners = new ArrayList<>();
        dtButton2 = findViewById(R.id.dy_button2);
        systemPayStrs = new String[10];
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

    private int i = -1;
    private String[] systemPayStrs;

    public void addView() {
        editText = new EditText(this);
        spinner = new Spinner(this);
        i++;
        editText.setWidth(300);
        editText.setHeight(100);
        editText.setHint("商户码");
        editText.setTop(10);
        //只有一行
        editText.setSingleLine(true);
        //设置textview滚动事件的
        editText.setMovementMethod(LinkMovementMethod.getInstance());
        spinner.setMinimumWidth(300);
        spinner.setMinimumHeight(100);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ConstantString.paySystem);
        spinner.setAdapter(adapter);
        spinner.setSelection(14);
        spinner.setId(i);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //获得当前 的spinner
                Log.e("viewaaaaaa", parent.toString() + "  " + parent.getClass() + parent.getId());
                systemPayStrs[parent.getId()] = ConstantString.paySystem[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        editTexts.add(i, editText);
        spinners.add(i, spinner);
        dyLinearLayout.addView(spinner);
        dyLinearLayout.addView(editText);
    }

    public void deleteView() {
        if (i <= -1) {
            Toast.makeText(this, "无可删除项", Toast.LENGTH_SHORT).show();
        } else {
            EditText editText = editTexts.get(i);
            Spinner spinner = spinners.get(i);
            dyLinearLayout.removeView(editText);
            dyLinearLayout.removeView(spinner);
            editTexts.remove(i);
            spinners.remove(i);
            i--;
        }
    }
}
