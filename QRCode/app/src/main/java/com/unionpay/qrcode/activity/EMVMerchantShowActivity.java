package com.unionpay.qrcode.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.util.Hashtable;

/**
 * @author lenovo
 */
public class EMVMerchantShowActivity extends AppCompatActivity {

    /**
     * 显示二维码的ImageView
     */
    ImageView qrView;
    Bitmap bitmapView;

    TextView transactionCurrency;
    TextView merchantName;
    TextView transcationCurrency1;
    int w, h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commercical1);

        //进入页面后高亮
        Window window = getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.screenBrightness = 1.0f;
        window.setAttributes(lp);

        Toolbar toolbar = findViewById(R.id.toolbar2);
        toolbar.setTitle(getResources().getString(R.string.emv_merchant_title));
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();//返回
            }
        });

        qrView = findViewById(R.id.qrcode);

        DisplayMetrics dm = getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        transactionCurrency = findViewById(R.id.transactioncurrency);
        merchantName = findViewById(R.id.merchantname);
        String ss = getIntent().getStringExtra("transactionCurrency");
        ss = ss.substring(ss.length() - 6, ss.length()).replace(")", "");
        transactionCurrency.setText(String.format("%s: %s", getResources().getString(R.string.currency_code), ss));
        merchantName.setText(String.format("%s:%s", getResources().getString(R.string.merchant_name1), getIntent().getStringExtra("merchantname")));
        transcationCurrency1 = findViewById(R.id.transactioncurrency1);
        transcationCurrency1.setText(String.format("%s:%s", getResources().getString(R.string.currency_code1), getIntent().getStringExtra("币种代码:")));
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) qrView.getLayoutParams();
        params.height = height / 2;
        qrView.setLayoutParams(params);
        h = height / 2;
        w = width;

        String test = "00020101021229300012D156000000000510A93FO3230Q31270012D1560000000103071234567520441115303156540523.725502015802CN5914BEST TRANSPORT6007BEIJING6233030412340603***0708A60086670902ME64200002ZH0104最佳运输0202北京91320016A0112233449988770708123456786304D90E";
        test = getIntent().getStringExtra("result");
        createQRcodeImage(test);
        Bitmap QRbmp = ((BitmapDrawable) (qrView).getDrawable()).getBitmap();
        Bitmap logo = BitmapFactory.decodeResource(getResources(), R.drawable.unionpay);
        bitmapView = addLogo(QRbmp, logo);
        qrView.setImageBitmap(addLogo(QRbmp, logo));
    }

    public void createQRcodeImage(String url) {
        qrView = findViewById(R.id.qrcode);
        try {
            //判断URL合法性
            if (url == null || "".equals(url) || url.length() < 1) {
                return;
            }
            Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            //图像数据转换，使用了矩阵转换
            BitMatrix bitMatrix = new QRCodeWriter().encode(url, BarcodeFormat.QR_CODE, w, h, hints);
            int[] pixels = new int[w * h];
            //下面这里按照二维码的算法，逐个生成二维码的图片，
            //两个for循环是图片横列扫描的结果
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    if (bitMatrix.get(x, y)) {
                        pixels[y * w + x] = 0xff000000;
                    } else {
                        pixels[y * w + x] = 0xffffffff;
                    }
                }
            }
            //生成二维码图片的格式，使用ARGB_8888
            Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, w, 0, 0, w, h);
            //显示到我们的ImageView上面
            qrView.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    private static Bitmap addLogo(Bitmap src, Bitmap logo) {
        //如果原二维码为空，返回空
        if (src == null) {
            return null;
        }
        //如果logo为空，返回原二维码
        if (src == null || logo == null) {
            return src;
        }

        //这里得到原二维码bitmap的数据
        int srcWidth = src.getWidth();
        int srcHeight = src.getHeight();
        //logo的Width和Height
        int logoWidth = logo.getWidth();
        int logoHeight = logo.getHeight();

        //同样如果为空，返回空
        if (srcWidth == 0 || srcHeight == 0) {
            return null;
        }
        //同样logo大小为0，返回原二维码
        if (logoWidth == 0 || logoHeight == 0) {
            return src;
        }

        //中间图片的大小是二维码的六分之一
        float scaleFactor = srcWidth * 1.0f / 6 / logoWidth;
        Bitmap bitmap = Bitmap.createBitmap(srcWidth, srcHeight, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(bitmap);
            canvas.drawBitmap(src, 0, 0, null);
            canvas.scale(scaleFactor, scaleFactor, srcWidth / 2, srcHeight / 2);
            canvas.drawBitmap(logo, (srcWidth - logoWidth) / 2, (srcHeight - logoHeight) / 2, null);
            canvas.save(Canvas.ALL_SAVE_FLAG);
            canvas.restore();
        } catch (Exception e) {
            bitmap = null;
            e.getStackTrace();
        }
        return bitmap;
    }
}