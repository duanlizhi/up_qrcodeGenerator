package com.unionpay.qrcode.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.common.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author 主界面
 */
public class MainActivity extends AppCompatActivity {

    /**
     * 扫一扫的返回结果的标识码
     */
    private final int REQUEST_CODE_SCAN = 111;

    Button btCommercial;
    Button btScan;
    Button btConsumer;
    Button btTranfer;
    Button btCarsh;
    Button btPre;

    /**
     * 需要申请的权限的数组
     */
    String[] permissions = new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE};
    List<String> mPermissionList = new ArrayList<>();


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.language, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_chinese:
                changeAppLanguage(Locale.SIMPLIFIED_CHINESE);
                break;
            case R.id.action_english:
                changeAppLanguage(Locale.ENGLISH);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_main);

        //标题栏设置
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("QR code");
        setSupportActionBar(toolbar);

        btCommercial = findViewById(R.id.bt_commercial);
        btScan = findViewById(R.id.bt_scan);
        btConsumer = findViewById(R.id.bt_consumer);
        btTranfer = findViewById(R.id.bt_unionpay_tranfer);
        btCarsh = findViewById(R.id.bt_unionpay_takecrash);
        btPre = findViewById(R.id.bt_unionpay_pre);

        //银联码仿真页面
        btPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UnionPayQRcodeActivity.class);
                startActivity(intent);
            }
        });
        //NETS静态二维码
        btCarsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NetsQrcodeParaActivity.class);
                startActivity(intent);
            }
        });
        // NETS SGQR
        btTranfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SGNetsQrcodeParaActivity.class);
                startActivity(intent);
            }
        });
        // EMV商户码按钮
        btCommercial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EMVMerchantParaActivity.class);
                startActivity(intent);
            }
        });
        // 扫一扫按钮
        btScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //申请两个权限,启动扫一扫需要相机权限和存储权限
                initPermission();
            }
        });
        //emv持卡人码
        btConsumer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EMVConsumerParaActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                gotoScan();
            } else {
                Toast.makeText(this, "无法打开", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * 跳转到扫一扫
     */
    private void gotoScan() {
        Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE_SCAN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {
                String content = data.getStringExtra(Constant.CODED_CONTENT);
                //content里面是扫到的内容，下面写处理逻辑
                Toast.makeText(MainActivity.this, content, Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * 申请运行时权限
     */
    private void initPermission() {
        mPermissionList.clear();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                //添加还未授予的权限,mPermissionList存放的是待申请的权限
                mPermissionList.add(permission);
            }
        }
        if (mPermissionList.size() > 0) {
            // 有权限没有通过，需要申请
            ActivityCompat.requestPermissions(this, permissions, 1);
        } else {
            //申请完所有权限后的跳转
            gotoScan();
        }
    }

    /**
     * 更改应用语言
     *
     * @param locale 地区、语言
     */
    public void changeAppLanguage(Locale locale) {
        //解决webview失效的问题
        new WebView(getApplicationContext()).destroy();
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        Configuration configuration = getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLocale(locale);
        } else {
            configuration.locale = locale;
        }
        getResources().updateConfiguration(configuration, metrics);
        //重新启动Activity
        Intent intent = new Intent(this, MainActivity.class);
        Toast.makeText(this, "切换完成（Switching completed）", Toast.LENGTH_SHORT).show();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
